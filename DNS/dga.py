import random
# Zum Generieren von pseudo Zufallszahlen

def generate_random_domain(startwert):
    # Initialisieren eines zufälligen Platzhalters um die Domain zu erstellen
    domain = ""
    characters = "abcdefghijklmopqrstuvwxyz"
    # Initialisieren des Zufallszahlengenerator
    random.seed(startwert)

    # Schleife die 10 zufällige Domains aus characters auswählt und der Domain hinzufügt
    for _ in range(10):
        domain += random.choice(characters)
        '''
        random.choice gibt ein zufälliges Element aus der nicht-leeren Sequenz in diesem Fall characters zurück
        dieser Rückgabewert von .choice wirt mit einer Domain konkadeniert
        '''
    return domain + ".com"

startwert = 12345
generate_domain = generate_random_domain(startwert)
print(f"Die zufällige Domain lautet: {generate_domain}")