# FTP Deep Dive
## Client Server Protocol zum Übertragen von Dateien übers Netzwerk 

- eine FTP Session besteht aus zwei Hauptkomponenten:
  - Control Kanal
  - Daten Kanal
- der Daten Kanal wird wiederum in zwei Kategorien unterteilt: Aktiv und Passiv (aus Sicht des Servers)
  Aktiv  -> Client öffnet einen Port und der Server verbindet sich darauf (Details folgen)
  Passiv -> Server öffnet einen Port und lauscht auf diesen (Details folgen)
