
package com.ems.util;

import java.util.Scanner;

public class InputUtil {

    private final Scanner scanner;

    public InputUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt(String message) {

        while (true) {
            System.out.print(message);

            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }

            System.out.println(
                    "Invalid input. Please enter a valid integer.");

            scanner.nextLine();
        }
    }

    public double readDouble(String message) {

        while (true) {
            System.out.print(message);

            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }

            System.out.println(
                    "Invalid input. Please enter a valid number.");

            scanner.nextLine();
        }
    }

    public String readString(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }
}

