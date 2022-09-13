package com.kopylov.translator.service.impl;

import com.kopylov.translator.constants.TranslateApi;
import com.kopylov.translator.dto.request.YandexTranslateTemplate;
import com.kopylov.translator.dto.response.YandexTranslatedWordsDTO;
import com.kopylov.translator.dto.response.YandexTranslationDTO;
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
        YandexTranslateTemplate template =
                new YandexTranslateTemplate(folderId, sourceWords, targetLanguageCode);
        WebClient client = WebClient.create(TranslateApi.YANDEX_API);

        YandexTranslationDTO result = client.post()
                .header(AUTHORIZATION, "Bearer " + token)
                .accept(APPLICATION_JSON)
                .body(BodyInserters.fromValue(template))
                .retrieve()
                .bodyToMono(YandexTranslationDTO.class)
                .block();

        return result.getTranslations().stream()
                .map(YandexTranslatedWordsDTO::getText)
                .collect(Collectors.toList());
    }
}
