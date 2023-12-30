
![DALL·E 2023-12-18 14 27 59 - A conceptual illustration highlighting the security aspects of the DNS protocol  The image features a stylized representation of the DNS protocol in a](https://github.com/Soufiane1699/Network-Security/assets/65159180/8dbb1428-b914-4309-b2a1-ca4e510546cf)

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

## Host Datei unter Windows 
C:\Windows\System32\drivers\etc

## Öffentiche WHOIS Datenbanken
[who.is](https://who.is/)<br>
[whois.com](https://www.whois.com/whois/)<br>
[whois.domaintools.com](https://whois.domaintools.com/)<br>
[MxToolbox](https://mxtoolbox.com/)
