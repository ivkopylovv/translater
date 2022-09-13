package com.kopylov.translator.mapper;

import com.kopylov.translator.entity.TranslationResult;
import com.kopylov.translator.entity.TranslationResultDetail;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class TranslationResultMapper {
    public static TranslationResult mapToTranslationResult(
            List<String> options, String ipAddress, Date requestDate) {
        return new TranslationResult()
                .setSourceLanguageCode(options.get(0))
                .setTargetLanguageCode(options.get(1))
                .setIpAddress(ipAddress)
                .setRequestDate(requestDate);
    }

    public static List<TranslationResultDetail> mapToTranslationResultDetails(
            List<String> sourceWords, List<String> translatedWords, Long resultId) {
        return IntStream.range(0, sourceWords.size())
                .mapToObj(i -> new TranslationResultDetail()
                        .setSourceWord(sourceWords.get(i))
                        .setTranslatedWord(translatedWords.get(i))
                        .setTranslationResultId(resultId))
                .collect(Collectors.toList());
    }
}
