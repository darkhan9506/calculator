package com.zhursin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorApp {
    public static void main(String[] args) throws IOException {
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calculator calculator = new Calculator();
        int result = 0;
        while (true) {
            System.out.print("> ");
            final String line = reader.readLine();
            if (line.length() == 0) {
                System.out.println("пока!");
                break;
            }
            final Scanner scanner = new Scanner(line);
            final String leftNumber, operation, rightNumber;
            try {
                leftNumber = scanner.next();
                operation = scanner.next();
                rightNumber = scanner.next();
            } catch (NoSuchElementException ex) {
                System.err.println("syntax error");
                System.out.println();
                continue;
            }

            if (onlyDigits(leftNumber) && onlyDigits(rightNumber)) {
                result = calculator.calculateArabic(leftNumber, operation, rightNumber);
                System.out.println(result);
            } else {
                calculator.calculateRomans(leftNumber, operation, rightNumber);
            }
            System.out.println();
        }
    }
    public static boolean onlyDigits(String string) {
        String regex = "[0-9]+";

        Pattern p = Pattern.compile(regex);

        if (string == null) {
            return false;
        }

        Matcher m = p.matcher(string);
        return m.matches();
    }
}
