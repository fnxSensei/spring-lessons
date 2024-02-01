INSERT INTO tb_genres (created_at, in_archive, name, description, url) VALUES ('01-01-2022', false, 'Натюрморт', 'Описание', 'stilllife');

INSERT INTO tb_picture (created_at, in_archive, description, genre_url, image_path, name)
VALUES ('01-01-2023', false, 'Описание...', 'stilllife', 'picture01.png', 'Картина №1');

INSERT INTO tb_picture (created_at, in_archive, description, genre_url, image_path, name)
VALUES ('01-04-2023', false, 'Описание...', 'stilllife', 'picture02.png', 'Картина №2');


-- schema.sql  запросы на создание объектов БД (например, таблиц)
-- data.sql  insert, update, delete запросы