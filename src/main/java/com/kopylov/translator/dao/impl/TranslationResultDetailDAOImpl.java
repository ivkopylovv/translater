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
        String query = "INSERT INTO translation_result_details " +
                "(source_word, translated_word, translation_result_id)" +
                "VALUES (?, ?, ?)";

        for (TranslationResultDetail detail : details) {
            jdbcTemplate.update(query,
                    detail.getSourceWord(),
                    detail.getTranslatedWord(),
                    detail.getTranslationResultId()
            );
        }
    }
}
