package util;

import java.util.Scanner;

public class InputUtil {
    /**
     * Field scanner
     * Sebagai helper agar lebih interaktif
     */
    private static Scanner sc = new Scanner(System.in);

    /**
     * Method input
     * param info
     * Untuk mendapatkan input dari user
     * @return string
     */
    public static String input(String info) {
        System.out.print(info + " : ");

        return sc.nextLine();
    }
}
