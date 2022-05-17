package org.example;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {

    public enum INCLUDE { UPPERCASE, LOWERCASE, NUMBERS, SYMBOLS }
    private final StringBuilder PASSWORD = new StringBuilder();
    public PasswordGenerator(int length) {
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < length; i++) {
            n.append(randomLowercase(1));
            if (n.length() == length)
                break;
            n.append(randomUppercase(1));
            if (n.length() == length)
                break;
            n.append(randomSymbols(1));
            if (n.length() == length)
                break;
            n.append(randomNumbers(1));
            if (n.length() == length)
                break;
        }

        List<String> pas = Arrays.asList(n.toString().split(""));
        Collections.shuffle(pas);
        for (String letter : pas)
            PASSWORD.append(letter);
    }
    public PasswordGenerator(int length, INCLUDE include) {
        StringBuilder n = new StringBuilder();
        for (int i = 0; i < length; i++) {
            switch (include) {
                case UPPERCASE -> n.append(randomUppercase(1));
                case LOWERCASE -> n.append(randomLowercase(1));
                case NUMBERS ->  n.append(randomNumbers(1));
                case SYMBOLS -> n.append(randomSymbols(1));
            }
        }

        List<String> pas = Arrays.asList(n.toString().split(""));
        Collections.shuffle(pas);
        for (String letter : pas)
            PASSWORD.append(letter);
    }

    public String getP() {
        return PASSWORD.toString();
    }

    public String randomSymbols(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomBytesString = new String(array, StandardCharsets.UTF_8);

        StringBuilder r = new StringBuilder();
        for (int i = 0; i < randomBytesString.length(); i++) {
            char c = randomBytesString.charAt(i);
            if (((c >= '!' && c <= '/') ||
                    (c >= '<' && c <= '@') ||
                    (c >= '[' && c <= '`') ||
                    (c >= '{' && c <= '~'))
                    && (n > 0)) {
                r.append(c);
                n--;
            }
        }
        return r.toString();
    }

    public String randomNumbers(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);

        String randomBytesString = new String(array, StandardCharsets.UTF_8);

        StringBuilder r = new StringBuilder();
        for (int i = 0; i < randomBytesString.length(); i++) {
            char c = randomBytesString.charAt(i);
            if ((c >= '0' && c <= '9') && (n > 0)) {
                r.append(c);
                n--;
            }
        }
        return r.toString();
    }

    public String randomUppercase(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomBytesString = new String(array, StandardCharsets.UTF_8);
        StringBuilder r = new StringBuilder();

        for (int i = 0; i < randomBytesString.length(); i++) {
            char c = randomBytesString.charAt(i);
            if ((c >= 'A' && c <= 'Z') && (n > 0)) {
                r.append(c);
                n--;
            }
        }
        return r.toString();
    }

    public String randomLowercase(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomBytesString = new String(array, StandardCharsets.UTF_8);
        StringBuilder r = new StringBuilder();

        for (int i = 0; i < randomBytesString.length(); i++) {
            char c = randomBytesString.charAt(i);
            if ((c >= 'a' && c <= 'z') && (n > 0)) {
                r.append(c);
                n--;
            }
        }
        return r.toString();
    }
}
