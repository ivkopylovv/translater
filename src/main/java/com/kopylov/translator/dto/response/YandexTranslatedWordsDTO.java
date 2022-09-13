package com.kopylov.translator.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YandexTranslatedWordsDTO {
    private String text;
    private String detectedLanguageCode;
}
