import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class SSLClient {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 8443;

        try {
            // Erstellt eine SSL-Socket-Verbindung zum angegebenen Host und Port
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket(host, port);

            // Stream zum Senden einer Nachricht an den Server
            PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);
            writer.println("Hallo Server");

            // Stream zum Empfangen von Nachrichten vom Server
            BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
            String serverResponse = reader.readLine();
            System.out.println("Nachricht vom Server erhalten: " + serverResponse);

            sslSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}