

CREATE TABLE users(
id integer PRIMARY KEY NOT NULL, 
name text NOT NULL, 
mail_address text NOT NULL, 
password text NOT NULL 
)
;

INSERT INTO users
VALUES(
1, '佐藤太郎', 'utest2@test.com', 'Test1234’'
)
;

CREATE TABLE person (
id integer PRIMARY KEY NOT NULL,
name text NOT NULL,
birthday date NOT NULL,
hire_date date,
occupation text,
mail_address text UNIQUE NOT NULL,
comment text
)
;

INSERT INTO person 
VALUES(
1, '山田太郎', '2000-01-01', '2023-04-01', 'QA', 'ptest@test.com', 'おはようございます'
)
,(
2, '山田花子', '2000-1-2', '2023-07-01', 'Java', 'ptest2@test.com', 'こんにちは'
)
,(
3, '山田次郎', '2000-02-01', '2024-04-01', 'ML', 'ptest3@test.com', 'こんばんは'
)
;

CREATE TABLE collection (
user_id integer NOT NULL,
person_id integer,
memo text
)
;

INSERT INTO collection
VALUES(
1, 1, '1月1日の商談で会った人'
)
,(
1, 2, '1月2日に誕生日会をした人'
)
,(
1, 3, '1月15日の新年会で会った人'
)
;

