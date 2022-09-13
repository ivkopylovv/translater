package com.kopylov.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class TranslationResultDetail {
    private Long id;
    private String sourceWord;
    private String translatedWord;
    private Long translationResultId;
}
