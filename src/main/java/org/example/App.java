package org.example;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PasswordGenerator passwordGenerator = new PasswordGenerator(15);
        PasswordGenerator passwordGenerator1 = new PasswordGenerator(10, PasswordGenerator.INCLUDE.UPPERCASE);
        System.out.println(passwordGenerator.getP());
        System.out.println(passwordGenerator1.getP());
    }
}
