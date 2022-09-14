package util;

import java.security.SecureRandom;

public class ServiceUtil {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static SecureRandom securedRandom = new SecureRandom();


    private static final String DATA_FOR_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
    public static String generateARandomString() {
        StringBuilder sb = new StringBuilder();
        for(int counter = 1 ; counter < 100 ; counter++) {
            char randomChar = DATA_FOR_STRING.charAt(securedRandom.nextInt(DATA_FOR_STRING.length()));
            sb.append(randomChar);
        }
        return sb.toString();
    }
}
