CREATE TABLE TB_WORKERS(
        ID INTEGER PRIMARY KEY AUTO_INCREMENT,
        NAME VARCHAR(150),
        DAILY_INCOME NUMERIC(20,2)
);

INSERT INTO tb_workers (name, daily_Income) VALUES ('X', 300.0);
INSERT INTO tb_workers (name, daily_Income) VALUES ('Zero', 350.0);
INSERT INTO tb_workers (name, daily_Income) VALUES ('Axl', 250.0);