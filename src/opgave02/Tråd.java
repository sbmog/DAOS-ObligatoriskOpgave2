package opgave02;

public class Tråd extends Thread {

    private String navn;
    private Fælles fælles;
    private int id;


    public Tråd(String navn, Fælles fælles, int id) {
        this.navn = navn;
        this.fælles = fælles;
        this.id = id;
    }


    @Override
    public void run() {
        for (int indeks = 0; indeks < 100; indeks++) {
            fælles.kritiskSection(id, 10);
            fælles.tagerRandomTid(10);
        }
        System.out.println(navn + " færdig.");
    }
}
