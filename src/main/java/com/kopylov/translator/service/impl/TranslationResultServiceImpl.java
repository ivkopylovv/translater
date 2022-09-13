package com.kopylov.translator.service.impl;

import com.kopylov.translator.dao.TranslationResultDAO;
import com.kopylov.translator.dao.TranslationResultDetailDAO;
import com.kopylov.translator.entity.TranslationResult;
import com.kopylov.translator.entity.TranslationResultDetail;
import com.kopylov.translator.helper.DateHelper;
import com.kopylov.translator.mapper.TranslationResultMapper;
import com.kopylov.translator.service.TranslationResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TranslationResultServiceImpl implements TranslationResultService {
    private final TranslationResultDAO translationResultDAO;
    private final TranslationResultDetailDAO translationResultDetailDAO;

    @Override
    public void saveTranslateResult(
            List<String> sourceWords, List<String> translatedWords,
            List<String> translateOptions, String ipAddress) {
        Date currentDate = DateHelper.getCurrentSQLDate();

        TranslationResult translationResult = TranslationResultMapper
                .mapToTranslationResult(translateOptions, ipAddress, currentDate);
        Long id = translationResultDAO.save(translationResult);

        List<TranslationResultDetail> translationResultDetails = TranslationResultMapper
                .mapToTranslationResultDetails(sourceWords, translatedWords, id);
        translationResultDetailDAO.saveAll(translationResultDetails);
    }
}
