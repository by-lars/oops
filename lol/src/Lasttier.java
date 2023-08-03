public class Lasttier {
    /**
     * Klassenvariablen
     *
     * Speicherplatz innerhalb der Klasse
     */
    public String name;

    public String ware;


    public Lasttier(String name) {
        this.name = name;
    }

    public void beladen(String ware) {
        this.ware = ware;
    }
}
