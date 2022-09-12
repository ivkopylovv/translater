package com.kopylov.translator.dao.impl;

import com.kopylov.translator.dao.TranslationResultDAO;
import com.kopylov.translator.entity.TranslationResult;
import com.kopylov.translator.entity.TranslationResultDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class TranslationResultDAOImpl implements TranslationResultDAO {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public void save(TranslationResult trRes) {
        jdbcTemplate.update(
                "INSERT INTO translation_results VALUES (?, ?, ?, ?)",
                trRes.getSourceLanguageCode(),
                trRes.getTargetLanguageCode(),
                trRes.getIpAddress(),
                trRes.getRequestDate()
        );
    }
}
