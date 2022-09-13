package com.kopylov.translator.service;


import java.util.List;

public interface TranslationResultService {
    void saveTranslateResult(
            List<String> sourceWords, List<String> translatedWords,
            List<String> translateOptions, String ipAddress);
}
