INSERT INTO tb_user (name, email, password) VALUES ('X', 'x@gmail.com', 'password1');
INSERT INTO tb_user (name, email, password) VALUES ('Zero', 'zero@gmail.com', 'password2');

INSERT INTO tb_role (role_name) VALUES ('B-Rank');
INSERT INTO tb_role (role_name) VALUES ('S-Rank');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);