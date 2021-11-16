import java.util.*;
import java.util.regex.Pattern;

public class Task2 {
    private static final Pattern PHONE_FORMAT = Pattern.compile("([\\d]|[A-Z]){5,10}");
    private static final String INVALID_FORMAT_MESSAGE = "Phone number should be 5 to 10 long and should contain only digits and  English capital letters";

    public static final Map<Character, Character> lettersToDigits;
    static {
        Map<Character, Character> map = new HashMap<>();
        char curLetter = 'A';
        for (int i = 2 ; i <= 9 ; ++i) {
            int letterNumber = 3;
            char currentNumber = (char) (i + '0');
            if (i == 7 || i == 9) {
                letterNumber = 4;
            }
            for (int j = 0 ; j < letterNumber ; ++j) {
                map.put(curLetter, currentNumber);
                curLetter++;
            }
        }
        lettersToDigits = Collections.unmodifiableMap(map);
    }

    /*
    Write a program that converts a phone number
    with digits and/or letters  to digits only.

    Phone number sould be 5 to 10 long (otherwise exception).
    Phone number should contain only digits and  English capital letters (otherwise exception).

    Example: 800888TEST -> 8008888378, ITSATEST -> 48728378, 1NMBR -> 16627
     */
    public static String digitifyNumber(String phoneNumber) {
        Objects.requireNonNull(phoneNumber);
        validateFormat(phoneNumber);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < phoneNumber.length() ; ++i) {
            char cur = phoneNumber.charAt(i);
            if (Character.isDigit(cur)) stringBuilder.append(cur);
            else stringBuilder.append(lettersToDigits.get(cur));
        }
        return stringBuilder.toString();
    }


    private static void validateFormat(String phoneNumber) {
        if (!PHONE_FORMAT.matcher(phoneNumber).matches())
            throw new IllegalArgumentException(INVALID_FORMAT_MESSAGE);
    }
}
