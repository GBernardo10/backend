INSERT INTO TBD_USUARIO ( APELIDO , NOME, CELULAR , EMAIL ,SENHA ) VALUES ('Bru','Bruno',12345678911,'bruno@email.com','123456');
INSERT INTO TBD_USUARIO ( APELIDO , NOME, CELULAR , EMAIL ,SENHA ) VALUES ('admin','admin',12345678911,'admin@email.com','123456');

INSERT INTO TBD_CATEGORIA (NOME_CATEGORIA) values ('Esportes');
INSERT INTO TBD_CATEGORIA (NOME_CATEGORIA) values ('Festas');
INSERT INTO TBD_CATEGORIA (NOME_CATEGORIA) values ('Jogos');

INSERT INTO TBD_EVENTO ( DATA_HORA_INICIO , DATA_HORA_FIM , DESCRICAO , ENDERECO , IS_PRIVADO , NOME_EVENTO , CATEGORIA_ID_CATEGORIA , ORGANIZADOR_ID  ) VALUES (15,16,'Fut de sabadao','Av. Paulista',0,'FUTEBAS',1,2);

INSERT INTO TBD_SUB_CATEGORIA ( NOME_SUB_CATEGORIA , ID_CATEGORIA ) values ('Futebol',2);