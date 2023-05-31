import java.util.Objects;

class Karteikarte{

    private String vorderseite;
    private String rueckseite;


    //Konstruktor
    public Karteikarte(String vorderseite, String rueckseite){
        this.vorderseite = vorderseite;
        this.rueckseite = rueckseite;
    }

    // c)
    public String toString() {
        return "Vorderseite: " + this.vorderseite + "\nRückseite: " + this.rueckseite;
    }

    //d)
    public boolean equals(Karteikarte other) {
        return (Objects.equals(this.vorderseite, other.vorderseite) && Objects.equals(this.rueckseite, other.rueckseite))
                || Objects.equals(this.vorderseite, other.rueckseite);
    }

    public static void main(String[] args) {
        Karteikarte k1 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k2 = new Karteikarte("kompakte Menge",
                "Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]");

        Karteikarte k3 = new Karteikarte("Eine Menge heißt _kompakt_, wenn sie abgeschlossen und beschränkt ist\n Beispiel: [0,1]", "kompakte Menge");

        Karteikarte k4 = new Karteikarte("Wilde Moehre",
                "Die Wilde Möhre ist ein Doldenblütler und ein Elternteil der Karotte.");

        System.out.println(k1);
        System.out.println(k1.equals(k2));
        System.out.println(k1.equals(k3));
        System.out.println(k1.equals(k4));
    }
}


/*
Antwort zu a)
toString() gibt eine String repräsentation des Objektes zurück
equals() vergleicht die Objekte (standardmäßig mit dem == operator, welche den hashCode vergleicht)
hashCode() numerische repräsentatio des Objektes, standardäßig ist dies die Speicheraddresse

Antwort zu b)
toString() + "@" + hashCode() wird geprinted
hashCode() ist standardmäßig die Speicheraddresse

Antwort zu d)
Standardmäßig ist equals() mit dem ==operator implementiert, welcher die Speicheraddressen der beiden Objekte vergleicht.

*/


/**
 * Aufgabe 3
 * a)
 *     static int nummer; // Klassenvariable
 *     -> von allen Instanzen der Klasse sichtbar
 *
 *     double laenge;     // Objektvariable
 *     -> nur von der jeweiligen Instanz sichtbar
 *
 *
 */