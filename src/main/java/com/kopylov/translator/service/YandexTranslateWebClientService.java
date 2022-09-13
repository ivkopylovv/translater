package com.kopylov.translator.service;

import java.util.List;

public interface YandexTranslateWebClientService {
    List<String> getTranslatedWords(String targetLanguageCode, List<String> sourceWords);
}
