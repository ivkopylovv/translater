package com.kopylov.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TranslationResultDetail {
    private Long id;
    private String sourceWord;
    private String translatedWord;
    private Long translationResultId;
}
