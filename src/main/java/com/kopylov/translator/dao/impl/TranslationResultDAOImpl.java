package com.kopylov.translator.dao.impl;

import com.kopylov.translator.dao.TranslationResultDAO;
import com.kopylov.translator.entity.TranslationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@RequiredArgsConstructor
public class TranslationResultDAOImpl implements TranslationResultDAO {
    private final JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public Long save(TranslationResult trRes) {
        String query =
                "INSERT INTO translation_results " +
                        "(source_language_code, target_language_code, ip_address, request_date) " +
                        "VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, trRes.getSourceLanguageCode());
            ps.setString(2, trRes.getTargetLanguageCode());
            ps.setString(3, trRes.getIpAddress());
            ps.setDate(4, trRes.getRequestDate());

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();
    }
}
