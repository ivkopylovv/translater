package com.kopylov.translator.dao.impl;

import com.kopylov.translator.dao.TranslationResultDetailDAO;
import com.kopylov.translator.entity.TranslationResultDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TranslationResultDetailDAOImpl implements TranslationResultDetailDAO {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void saveAll(List<TranslationResultDetail> details) {
        for (TranslationResultDetail detail: details) {
            jdbcTemplate.update(
                    "INSERT INTO translation_result_details VALUES (?, ?, ?)",
                    detail.getSourceWord(),
                    detail.getTranslatedWord(),
                    detail.getTranslationResultId()
            );
        }
    }
}
