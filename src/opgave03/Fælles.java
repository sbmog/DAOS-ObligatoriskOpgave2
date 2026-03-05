package opgave03;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Fælles {
    private int global = 0;
    private Semaphore semaphore = new Semaphore(1);

    public void tagerRandomTid(int max) {
        Random random = new Random();
        int nyMax = Math.abs(random.nextInt()) % max + 1;

        for (int ydreIndeks = 0; ydreIndeks < nyMax; ydreIndeks++) {
            for (int indreIndeks = 0; indreIndeks < nyMax; indreIndeks++) {
                int temp = ydreIndeks + indreIndeks;
                temp -= indreIndeks;
            }
        }
    }

    public void kritiskSection(int max) {
        try {
            semaphore.acquire();

            int temp = global;
            tagerRandomTid(max);
            global = temp + 1;

            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getGlobal() {
        return global;
    }

    public void setGlobal(int global) {
        this.global = global;
    }
}
