// ermöglicht den Zugriff auf Klassen und Schnittstellen, die für die SSL-Kommunikation erforderlich sind
import javax.net.ssl.*;
// ermöglicht das Lesen und Schreiben von Daten über Streams
import java.io.*;
// Zugriff auf die KeyStore-Klasse mti der Schlüssel und Zertifikate gespeichert werden können
import java.security.KeyStore;
// ermöglicht das Laden und Analysieren von X.509-Zertifikaten
import java.security.cert.CertificateFactory;
// ermöglicht die Repräsentation eines X.509-Zertifiakts
import java.security.cert.X509Certificate;
// Zugriff auf PKCS8EncodedKeySpec-Klasse
import java.security.spec.PKCS8EncodedKeySpec;
// Zugriff auf die PrivateKey-Schnittstelle
import java.security.PrivateKey;
// Zugriff auf die KeyFactory-Klasse
import java.security.KeyFactory;
// ermöglichen den Zugriff auf Klassen und Methoden die das Arbeiten mit Dateien und Verzeichnissen in Java unterstützen
import java.nio.file.Files;
import java.io.File;

/**
 * @author Soufiane
 * @version 1.0
 */


public class x509_server {
    public static void main(String[] args) throws Exception {
        int port = 8443;

        try {
            String certPath = "certificate.crt";
            String privateKeyPath = "keystore.jks";
            String keyPassword = "password";

            // Zertifikate und privaten Schlüssel laden
            X509Certificate certificate = loadCertificate(certPath);
            PrivateKey privateKey = loadPrivateKey(privateKeyPath);

            // KeyStore mit Zertifikate und privatem Schlüssel erstellen
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(null, null);
            keyStore.setKeyEntry("alias", privateKey, keyPassword.toCharArray(), new java.security.cert.Certificate[]{certificate});

            // KeyManagerFactory initialisieren
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            keyManagerFactory.init(keyStore, keyPassword.toCharArray());

            // SSLContext initialisieren
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);

            // SSLServerSocket erstellen
            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            System.out.println("Server is running on: " + port);

            while(true) {
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);
                String clientMessage = reader.readLine();
                System.out.println("Nachricht vom Client erhalten: " + clientMessage);

                String serverResponse = "Hallo Client";
                writer.println(serverResponse);

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static X509Certificate loadCertificate(String certPath) throws Exception {
        FileInputStream fis = new FileInputStream(certPath);
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) cf.generateCertificate(fis);
        fis.close();
        return certificate;
    }

    private static PrivateKey loadPrivateKey(String privateKeyPath) throws Exception {
        byte[] keyBytes = Files.readAllBytes(new File(privateKeyPath).toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}