package opgave02;

public class Main {

    public static void main(String[] args) {
        Fælles fælles = new Fælles();

        Tråd tråd1 = new Tråd("tråd1", fælles, 0);
        Tråd tråd2 = new Tråd("tråd2", fælles, 1);

        tråd1.start();
        tråd2.start();

        try {
            tråd1.join();
            tråd2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Slutværdien af tæller: " + fælles.getGlobal());
    }
}
