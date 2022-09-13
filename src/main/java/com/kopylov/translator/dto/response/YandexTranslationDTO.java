package com.kopylov.translator.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class YandexTranslationDTO {
    private List<YandexTranslatedWordsDTO> translations;
}
