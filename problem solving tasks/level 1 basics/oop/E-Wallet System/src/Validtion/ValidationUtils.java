package Validtion;

/** Provides validation checks for wallet account data. */
public class ValidationUtils {

        /** Checks that a username contains one or more alphabetic names of 3–10 letters. */
        public static boolean isUserNameValid(String userName) {
            if (userName == null || userName.isBlank()) {
                return false;
            }
            return userName.matches("[A-Za-z]{3,10}(?:\\s+[A-Za-z]{3,10})*");
        }

        /** Checks that a password has at least 8 characters, an uppercase letter, a digit, and a special character. */
        public static boolean isPasswordValid(String password) {
            if (password == null || password.length() < 8) {
                return false;
            }

            boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
            boolean hasDigit = password.chars().anyMatch(Character::isDigit);
            boolean hasSpecialCharacter = password.chars()
                    .anyMatch(character -> !Character.isLetterOrDigit(character));

            return hasUppercase && hasDigit && hasSpecialCharacter;
        }

        /** Checks whether a phone number matches an Egyptian mobile number format. */
        public static boolean isPhoneNumberValid(String phoneNumber) {
            if (phoneNumber == null) {
                return false;
            }

            String normalizedNumber = phoneNumber.replaceAll("[\\s()-]", "");
            return normalizedNumber.matches("(?:01[0125]\\d{8}|(?:\\+20|0020)1[0125]\\d{8})");
        }

        /** Checks that a balance is zero or greater. */
        public static boolean isBalanceValid(double balance) {
            return balance >= 0;
        }

        /** Checks that an age is between 15 and 75 years, inclusive. */
        public static boolean isAgeValid(float age) {
            return age >= 15 && age <= 75;
        }

}
