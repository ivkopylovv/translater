CREATE TABLE IF NOT EXISTS translation_results (
    id INT NOT NULL AUTO_INCREMENT,
    source_language_code CHAR(2) NOT NULL,
    target_language_code CHAR(2) NOT NULL,
    ip_address VARCHAR(45) NOT NULL,
    request_date DATETIME NOT NULL,
    CONSTRAINT translation_results_pk
        PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS translation_result_details (
    id INT NOT NULL AUTO_INCREMENT,
    source_word VARCHAR(255) NOT NULL,
    translated_word VARCHAR(255) NOT NULL,
    translation_result_id INT NOT NULL,
    CONSTRAINT translation_result_details_pk
        PRIMARY KEY (id),
    CONSTRAINT fk_translation_results
        FOREIGN KEY (translation_result_id)
            REFERENCES translation_results(id)
);