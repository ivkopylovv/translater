package com.kopylov.translator.helper;

import com.kopylov.translator.constants.ErrorMessage;
import com.kopylov.translator.exception.IncorrectInputException;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class ValidateInputHelper {
    public static void checkTranslationRequest(String source, String options) {
        if (source.trim().length() <= 0) {
            throw new IncorrectInputException(ErrorMessage.SOURCE_STRING_IS_EMPTY);
        }

        if (options.length() > 5) {
            throw new IncorrectInputException(ErrorMessage.INCORRECT_TRANSLATION_OPTIONS);
        }

        if (options.length() != 5 || options.charAt(2) != '-') {
            throw new IncorrectInputException(ErrorMessage.INCORRECT_TRANSLATION_OPTIONS);
        }
    }
}
