package com.kopylov.translator.service.impl;

import com.kopylov.translator.constants.ErrorMessage;
import com.kopylov.translator.constants.TranslateApi;
import com.kopylov.translator.dto.request.YandexTranslateDTO;
import com.kopylov.translator.dto.response.YandexTranslateResultDTO;
import com.kopylov.translator.dto.response.YandexTranslatedWordDTO;
import com.kopylov.translator.exception.YandexTranslateApiException;
import com.kopylov.translator.service.YandexTranslateWebClientService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class YandexTranslateWebClientServiceImpl implements YandexTranslateWebClientService {
    @Value("${yandex.api.token}")
    private String token;

    @Value("${yandex.folder.id}")
    private String folderId;

    @Override
    public List<String> getTranslatedWords(String targetLanguageCode, List<String> sourceWords) {
        YandexTranslateDTO template =
                new YandexTranslateDTO(folderId, sourceWords, targetLanguageCode);
        WebClient client = WebClient.create(TranslateApi.YANDEX_API);

        YandexTranslateResultDTO result = client.post()
                .header(AUTHORIZATION, "Bearer " + token)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(template))
                .retrieve()
                .bodyToMono(YandexTranslateResultDTO.class)
                .blockOptional()
                .orElseThrow(() -> new YandexTranslateApiException(ErrorMessage.YANDEX_SERVER_ERROR));

        return result.getTranslations().stream()
                .map(YandexTranslatedWordDTO::getText)
                .collect(Collectors.toList());
    }
}
