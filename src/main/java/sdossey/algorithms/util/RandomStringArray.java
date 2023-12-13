package sdossey.algorithms.util;
import java.util.Random;

public class RandomStringArray {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";

    // Method to generate a single random string of a given length
    private static String generateRandomString(int length, Random random) {
        StringBuilder stringBuilder = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(index));
        }

        return stringBuilder.toString();
    }

    // Method to generate an array of random strings
    public static String[] generateRandomStringArray(int arraySize, int stringLength) {
        Random random = new Random();
        String[] randomStrings = new String[arraySize];

        for (int i = 0; i < arraySize; i++) {
            randomStrings[i] = generateRandomString(stringLength, random);
        }

        return randomStrings;
    }

}
