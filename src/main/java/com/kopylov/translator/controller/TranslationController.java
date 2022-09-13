package com.kopylov.translator.controller;

import com.kopylov.translator.dto.request.TranslateStringDTO;
import com.kopylov.translator.dto.response.TranslatedStringDTO;
import com.kopylov.translator.helper.StringHelper;
import com.kopylov.translator.helper.ValidateInputHelper;
import com.kopylov.translator.service.TranslationResultService;
import com.kopylov.translator.service.YandexTranslateWebClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("translator/v1")
@RequiredArgsConstructor
public class TranslationController {
    private final TranslationResultService translationResultService;
    private final YandexTranslateWebClientService yandexTranslateWebClientService;

    @PostMapping()
    public ResponseEntity translateString(@RequestBody TranslateStringDTO dto, HttpServletRequest request) {
        String source = dto.getSourceString();
        String options = dto.getTranslationOptions();
        String ipAddress = request.getRemoteAddr();

        ValidateInputHelper.checkTranslationRequest(source, options);

        List<String> sourceWords = StringHelper.splitString(source, " ");
        List<String> splitOptions =  StringHelper.splitString(options, "-");

        List<String> translatedWords = yandexTranslateWebClientService
                .getTranslatedWords(splitOptions.get(1), sourceWords);
        translationResultService
                .saveTranslateResult(sourceWords, translatedWords, splitOptions, ipAddress);
        String resultText = StringHelper.concatString(translatedWords);

        return ResponseEntity.ok().body(new TranslatedStringDTO(resultText));
    }
}
