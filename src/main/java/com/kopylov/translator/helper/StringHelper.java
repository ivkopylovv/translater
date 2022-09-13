package com.kopylov.translator.helper;

import lombok.NoArgsConstructor;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class StringHelper {
    public static List<String> splitString(String target, String regex) {
        return List.of(target.trim().split(regex));
    }

    public static String concatString(List<String> words) {
        return String.join(" ", words);
    }
}
