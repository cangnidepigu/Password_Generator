package org.example;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!`~@#$%^&*()_-+=[]|,./?><";

    private final boolean useLower;
    private final boolean useUpper;
    private final boolean useNumbers;
    private final boolean useSymbols;

    public PasswordGenerator(PasswordGeneratorBuilder builder) {
        this.useLower = builder.useLower;
        this.useUpper = builder.useUpper;
        this.useNumbers = builder.useNumbers;
        this.useSymbols = builder.useSymbols;
    }

    public static class PasswordGeneratorBuilder {
        private boolean useLower;
        private boolean useUpper;
        private boolean useNumbers;
        private boolean useSymbols;

        public PasswordGeneratorBuilder() {
            this.useLower = false;
            this.useUpper = false;
            this.useNumbers = false;
            this.useSymbols = false;
        }

        public PasswordGeneratorBuilder useLower(boolean useLower) {
            this.useLower = useLower;
            return this;
        }
        public PasswordGeneratorBuilder useUpper(boolean useUpper) {
            this.useUpper = useUpper;
            return this;
        }
        public PasswordGeneratorBuilder useNumbers(boolean useNumbers) {
            this.useNumbers = useNumbers;
            return this;
        }
        public PasswordGeneratorBuilder useSymbols(boolean useSymbols) {
            this.useSymbols = useSymbols;
            return this;
        }

        public PasswordGenerator build() {
            return new PasswordGenerator(this);
        }
    }

    public String generate(int length) {
        StringBuilder superStrongPassword = new StringBuilder(length);
        Random random = new Random();

        List<String> categories = new ArrayList<>(4);
        if (useLower)
            categories.add(LOWERCASE);
        if (useUpper)
            categories.add(UPPERCASE);
        if (useNumbers)
            categories.add(NUMBERS);
        if (useSymbols)
            categories.add(SYMBOLS);

        for (int i = 0; i < length; i++) {
            String CharCategory = categories.get(random.nextInt(categories.size()));
            int position = random.nextInt(CharCategory.length());
            superStrongPassword.append(CharCategory.charAt(position));
        }
        return superStrongPassword.toString();
    }

}
