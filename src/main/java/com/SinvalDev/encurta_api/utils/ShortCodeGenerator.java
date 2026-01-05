package com.SinvalDev.encurta_api.utils;

import java.security.SecureRandom;

public class ShortCodeGenerator {
    private static final String CHARSET =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    private static final int CODE_LENGTH = 6;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generate() {
        StringBuilder code = new StringBuilder(CODE_LENGTH);

        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = RANDOM.nextInt(CHARSET.length());
            code.append(CHARSET.charAt(index));
        }

        return code.toString();
}
}
