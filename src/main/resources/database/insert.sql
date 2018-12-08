INSERT INTO department
  (id, name, description, picture)
VALUES
  (1, 'Компьютерных Наук', '', ''),
  (2, 'Прикладной математики и информатики', '', ''),
  (3, 'ФИПСИ', '', ''),
  (4, 'Экономический', '', ''),
  (5, 'Юридический', '', ''),
  (6, 'Биологический', '', ''),
  (7, 'Геологический', '', '')
;

CREATE TABLE "users" (
  "id" bigint NOT NULL,
  "role_id" bigint NOT NULL,
  "student_book_id" bigint NOT NULL,
  "department_id" bigint NOT NULL,
  "username" character varying NOT NULL,
  "first_name" character varying NOT NULL,
  "second_name" character varying NOT NULL,
  "rating" bigint NOT NULL,
  "password" character varying NOT NULL,
  "description" character varying,
  "birthday" timestamptz,
  "picture" character varying,
  "social_vk" character varying,
  "social_inst" character varying,
  "social_twi" character varying,
  "social_fb" character varying,
  CONSTRAINT users_pk PRIMARY KEY ("id")
) WITH (
OIDS=FALSE
);

INSERT INTO users
(id, role_id, student_book_id, department_id, username, first_name, second_name, rating, password, description, picture)
VALUES
  (1, 0, 80809090, 1, 'admin', 'Administrator', ' ', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 2, 80809090, 1, 'dataart', 'DataArt', ' ', 0, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 2, 80809090, 1, 'netcrk', 'NetCracker', ' ', 0, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 2, 80809090, 1, 'lukoil', 'ЛУКОИЛ', ' ', 0, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 2, 80809090, 1, 'inline', 'Ин Лайн', 'Груп', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 1, 80809090, 1, 'admin', 'Administrator', ' ', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 1, 80809090, 1, 'admin', 'Administrator', ' ', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 1, 80809090, 1, 'admin', 'Administrator', ' ', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
  (1, 1, 80809090, 1, 'admin', 'Administrator', ' ', 100000, '', 'Администратор сервиса VSU Tournaments', 'http://www.monteirolobato.edu.br/public/assets/admin/images/avatars/avatar4_big.png'),
;