package Test;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] tempArr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[][] tempArr2 = new int[4][4];
        Random rand = new Random();
        for (int i = 0; i < tempArr1.length; i++) {
            int temp1 = tempArr1[i];
            int temp2 = rand.nextInt(tempArr1.length);
            tempArr1[i] = tempArr1[temp2];
            tempArr1[temp2] = temp1;
        }

        for (int i = 0; i < tempArr1.length; i++) {
            tempArr2[i / 4][i % 4] = tempArr1[i];
        }


        for (int[] ints : tempArr2) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
