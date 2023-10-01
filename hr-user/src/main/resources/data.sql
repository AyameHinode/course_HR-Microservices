INSERT INTO tb_user (name, email, password) VALUES ('X', 'x@gmail.com', 'password1');
INSERT INTO tb_user (name, email, password) VALUES ('Zero', 'zero@gmail.com', 'password2');

INSERT INTO tb_role (role_name) VALUES ('Leader');
INSERT INTO tb_role (role_name) VALUES ('Recruit');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);