package com.kopylov.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TranslationResult {
    private Long id;
    private String sourceLanguageCode;
    private String targetLanguageCode;
    private Integer ipAddress;
    private Date requestDate;
}
