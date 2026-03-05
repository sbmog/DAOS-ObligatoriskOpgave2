package opgave02;

import java.util.Random;

public class Fælles {
    private int global = 0;

    private boolean[] flag = new boolean[2];
    private int turn = 0;

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

    public void kritiskSection(int id, int max) {
        int andenId = 1 - id;

        flag[id] = true;
        turn = andenId;
        while (flag[andenId] && turn == andenId) ;

        int temp = global;
        tagerRandomTid(max);
        global = temp + 1;

        flag[id] = false;
    }

    public int getGlobal() {
        return global;
    }

}
