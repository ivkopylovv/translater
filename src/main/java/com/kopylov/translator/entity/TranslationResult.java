package com.kopylov.translator.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Getter
@Setter
public class TranslationResult {
    private Long id;
    private String sourceLanguageCode;
    private String targetLanguageCode;
    private String ipAddress;
    private Date requestDate;
}
