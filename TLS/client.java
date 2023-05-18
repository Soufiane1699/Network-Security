import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class client {
    public static void main(String[] args) {
        String serverhost = "172.20.10.6";
        int port = 8443;

        try {
            // Phase 1: Load the truststore and create the SSL context
            System.setProperty("javax.net.ssl.trustStore", "mykey.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "mypassword");

            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(serverhost, port);

            // Phase 2: Perform the handshake
            sslSocket.startHandshake();

            // Phase 3: Communicate over the secure connection
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

            String clientMessage = "Ich bin ein Client!!";
            writer.println(clientMessage);

            String serverResponse = reader.readLine();
            System.out.println("Nachricht erhalten: " + serverResponse);

            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}