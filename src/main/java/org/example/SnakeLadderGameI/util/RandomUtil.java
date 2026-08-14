package org.example.SnakeLadderGameI.util;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomUtil {

    private RandomUtil() {
    }

    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static boolean randomBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }

    public static double randomDouble(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    public static <T> T randomElement(List<T> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("List cannot be empty");

        return list.get(randomInt(0, list.size() - 1));
    }
}