package com.kopylov.translator.dao;

import com.kopylov.translator.entity.TranslationResultDetail;

import java.util.List;

public interface TranslationResultDetailDAO {
    void saveAll(List<TranslationResultDetail> details);
}
