package opgave04;

import java.util.Random;

public class Fælles {
    private int global = 0;

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

    public synchronized void kritiskSection(int max) {
        int temp = global;
        tagerRandomTid(max);
        global = temp + 1;
    }

    public int getGlobal() {
        return global;
    }

    public void setGlobal(int global) {
        this.global = global;
    }
}
