package opgave01;

public class Tråd extends Thread {

    private String navn;
    private Fælles fælles;


    public Tråd(String navn, Fælles fælles) {
        this.navn = navn;
        this.fælles = fælles;
    }


    @Override
    public void run() {
        for (int indeks = 0; indeks < 100; indeks++) {
            fælles.kritiskSection(10);
            fælles.tagerRandomTid(10);
        }
        System.out.println(navn + " færdig.");
    }
}
