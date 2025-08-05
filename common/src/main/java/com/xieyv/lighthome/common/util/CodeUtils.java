package com.xieyv.lighthome.common.util;

import java.util.Random;

public class CodeUtils {
    public static String getRandomCode(int length) {
        StringBuilder code = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }

    private CodeUtils() {}
}
