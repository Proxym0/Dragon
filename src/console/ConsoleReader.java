package console;

import java.util.Scanner;

public class ConsoleReader {
    static final Scanner SCANNER = new Scanner(System.in);

    public static String readString() {
        return SCANNER.next();
    }

    public static int readInteger() {
        return SCANNER.nextInt();
    }
}

