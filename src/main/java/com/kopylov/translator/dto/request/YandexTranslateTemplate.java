package com.kopylov.translator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YandexTranslateTemplate {
    private String folderId;
    private List<String> texts;
    private String targetLanguageCode;
}
