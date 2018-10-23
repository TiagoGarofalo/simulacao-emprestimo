DROP DATABASE IF EXISTS SIMULAEMPRESTIMO;
CREATE DATABASE SIMULAEMPRESTIMO;
USE SIMULAEMPRESTIMO;

CREATE TABLE CLIENTE (
 ID_CLIENTE INT (11) NOT NULL
,NOME VARCHAR (100)
,CPF INT (11) PRIMARY KEY 
,EMAIL VARCHAR(100)

);

CREATE TABLE EMPRESTIMO (
 ID_EMPRESTIMO INT(11) NOT NULL PRIMARY KEY
,VALOR_DO_CONTRATO INT(10)
,NUMERO_PARCELAS INT (12)
);

CREATE TABLE SIMULACAO (
 ID_SIMULACAO INT NOT NULL 
,CPF INT
,IDEMPRESTIMO INT
,DATAINICIO DATE
,DATAFINAL DATE
,TXJUROS INT (10)
,QNTPARCERLAS INT (12)
,VALORJUROS INT (12)
,VALORTOTALEMPRESTIMO INT (12)
,CONSTRAINT FK_CPF FOREIGN KEY (CPF) REFERENCES CLIENTE (CPF)
,CONSTRAINT FK_EMPRESTIMO FOREIGN KEY(IDEMPRESTIMO) REFERENCES EMPRESTIMO (ID_EMPRESTIMO)
);