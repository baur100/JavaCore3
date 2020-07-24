package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class TestDataApi {
    public static String rendomPetz(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
