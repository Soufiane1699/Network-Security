Vier DNS-Server sind am Laden einer Webseite beteiligt
- DNS Recursor
- DNS-Stammserver
- TLD-Nameserver
- Autoritativer Nameserver 

## DNS-Recursor
- ist ein Server der Anfragen von Clientcomputern über Anwendungen wie Webbrowser empfängt
- Vermittler zwischen Client und DNS-Nameserver
- er beantwortet die DNS-Abfrage vom Client aus dem Cache oder sendet die Anfrage an einen Stamm-Nameserver weiter
- der DNS Recursor speichert die Informationen in seinem Cache 

## DNS-Stammserver
- Verwaltung des DNS ist als Hierarchie mit unterschiedlichen Bereichen oder "Zonen" strukturiert, wobei die Stammzone 
ganz oben ist
- Stammserver sind DNS-Nameserver die in der Stammzone laufen
- 13 IP-Adressen die von (Stamm-)Servern abgefangen werden 

## TLD-Nameserver
- verwaltet die Information zu allen Domain-Namen, die über die gleiche Erweiterung verfügen z.B. .com, .net

## Autoritativer Nameserver
- für gewöhnlich die letzte Station auf der Reise zu einer IP-Adresse
- enthält Informationen über den Domainnamen


| Opcode        | Bedeutung     |
| ------------- | ------------- |
| Query         |               |
| IQuery        |               |
| Status        |               |
| Notify        |               |
| Update        |               |
