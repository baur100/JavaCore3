package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class TestData {
    public static String randomString(int length) {
        return RandomStringUtils.random(length, true, false);
    }
}
