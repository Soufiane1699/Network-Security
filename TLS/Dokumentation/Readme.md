## Transport Layer Security
- ist ein Sicherheitsprotokoll
- primärer Anwendungsfall ist die Verschlüsselung der Kommunikation zwischen Webanwendungen und Webservern
- TLS ist der Nachfolger von SSL
- kann auch zum Verschlüseln von E-Mails, Messaging-Apps und VoIP verwendet werden
- das TLS-Protokoll besteht aus drei Hauptkomponenten:
    - Verschlüsselung
    - Authentifizierung
    - Integritätssicherung

## Wie funktioniert TLS?
- auf dem Ursprungsserver wird ein Zertifikat erstellt und signiert
- das Zertifikat wird auf dem Server installiert
- der Server wird konfiguriert, um TLS zu verwenden
- die TLS-Verbindung wird mit dem TLS-Handshake-Protokoll initialisiert

## TLS-Handshake
- zwischen Client und Server wird eine TLS-Verbindung aufgebaut
- der Client sendet eine Anfrage an den Server
- der Server sendet sein Zertifikat an den Client
- der Client überprüft das Zertifikat
- der Client sendet eine Nachricht an den Server, die mit dem öffentlichen Schlüssel des Servers verschlüsselt ist
- der Server entschlüsselt die Nachricht mit seinem privaten Schlüssel
- der Client und der Server verwenden die symmetrischen Schlüssel, um die Nachrichten zu verschlüsseln und zu entschlüsseln
- während des Handshakes wird entschieden, welche Verschlüsselungsalgorithmen verwendet werden sollen, um die Daten zu verschlüsseln
- ebenfalls wird entschieden welche TLS-Version verwendet werden soll

## Authentifizierung
- bei jeder Verbindung authentifiziert 