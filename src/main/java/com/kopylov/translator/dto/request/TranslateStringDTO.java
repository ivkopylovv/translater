package com.kopylov.translator.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TranslateStringDTO {
    private String sourceString;
    private String translationOptions;
}
