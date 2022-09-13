package com.kopylov.translator.constants;


import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ErrorMessage {
    public static final String SOURCE_STRING_IS_EMPTY = "Source String Is Empty";
    public static final String INCORRECT_TRANSLATION_OPTIONS = "Incorrect options format";
    public static final String YANDEX_SERVER_ERROR = "The Yandex Server Is Not Responding";
}
