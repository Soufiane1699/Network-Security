// Implementierung von sicheren Netzwerkkommunikationen mit TLS/SSL
import javax.net.ssl.*;
// Lesen von Text aus einem Zeichen-Input-Stream
import java.io.BufferedReader;
//  Lesen von Byte-Streams
import java.io.InputStreamReader;
// Ausgabe von Zeichen und Zeichenketten
import java.io.PrintWriter;

/**
 * @author Soufiane
 * @version 1.0
 */

public class server {
    public static void main(String[] args) throws Exception {
        int port = 8443;
        try {
            /**
             * Phase 1: Laden des Keystore (.jks) und erstellen des SSL-Kontext
             */
            // Setzen der Systemeigenschaften für den KeyStore-Pfad und Passwort
            System.setProperty("javax.net.ssl.keyStore", "mykey.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "mypassword");

            // Erstellen einer Instanz der SSLServerSocketFactory fürs Erstellen von SSLServerSockets
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            // Erstellt einen SSLServerSocket, der auf dem angegebenen Port lauscht
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);

            System.out.println("Server is running on port " + port);

            while(true) {
                // Phase 2: Akzeptieren von Verbindungen und ausführen des Handshakes

                // Warten auf eingehende Verbindungen von Clients und anschließendes Akzeptieren
                SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

                // Phase 3: Kommunikation über eine sichere Verbindung
                BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
                // Erstellen eines PrintWriter, um Daten an den verbunden Client zu senden
                PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

                String clientMessage = reader.readLine();
                System.out.println("Nachricht vom Client erhalten: " + clientMessage);

                String serverResponse = "Hallo, Client";
                writer.println(serverResponse);

                sslSocket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

