public class Kamel extends Lasttier {
    public Kamel(String name) {
        super(name);
        wasser = 200.0;
    }

    public double wasser;

    private void tinken() {
        wasser = 200.0;
        System.out.println(name + ": Trinken");
    }

    public void karwane() {
        wasser -= 80.0;
        System.out.println(name + ": Karawane mit " + ware + ". " + wasser + "l nach Ankunft.");


        if(wasser < 80.0) {
            tinken();
        }


    }
}
