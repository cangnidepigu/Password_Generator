package org.example;


/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useLower(true)
                .useUpper(true)
                .useNumbers(true)
                .useSymbols(true)
                .build();
        String militaryGradePassword = passwordGenerator.generate(15);
        System.out.println(militaryGradePassword);
    }
}
