# Translator

## Запуск проекта

1. Установить Docker - https://www.docker.com/get-started/
2. Создать файл `docker-compose.override.yml` с содержимым:

  ```yaml
version: '3.4'

services:
  translator:
    environment:
      - YANDEX_API_TOKEN=<Your token>
      - YANDEX_FOLDER_ID=<Your folder id>
      - H2_DB_NAME=<Your H2 in-memory database name>
      - H2_USERNAME=<Your H2 username>
      - H2_PASSWORD=<Your H2 password>
```

3. Собрать проект, для этого выполнить команду:

  ```sh
  docker compose build
  ```

4. Запустить собранный проект:

  ```sh
  docker compose up
  ```

5. Для перевода слов использовать endpoint POST `http://<server>:8081/translator/v1`

Входные данные:

```json
{
    "sourceString": "Example of input data",
    "translationOptions": "en-ru"
}
```

Выходные данные:

```json
{
    "text": "Пример от вход данные"
}
```

## Технологии

- `Java 11`
- `Spring Boot`
- `Spring MVC`
- `JDBC`
- `H2 Database`
- `REST`
- `Web-Client`
- `Yandex API`
- `Gradle`
- `Lombok`
- `Intellij Idea for IDE`
