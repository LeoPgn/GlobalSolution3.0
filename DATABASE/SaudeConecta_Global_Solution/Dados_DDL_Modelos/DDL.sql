DROP TABLE consulta CASCADE CONSTRAINTS;
DROP TABLE exame CASCADE CONSTRAINTS;
DROP TABLE plano CASCADE CONSTRAINTS;
DROP TABLE beneficiario CASCADE CONSTRAINTS;
DROP TABLE funcionario CASCADE CONSTRAINTS;
DROP TABLE medico CASCADE CONSTRAINTS;

-- Scripts DDL

CREATE TABLE beneficiario (
    id              NUMBER(10) NOT NULL,
    nome            VARCHAR2(50) NOT NULL,
    email           VARCHAR2(50) NOT NULL,
    cpf             CHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    cep             CHAR(8) NOT NULL,
    senha           VARCHAR2(50) NOT NULL
);

ALTER TABLE beneficiario ADD CONSTRAINT beneficiario_pk PRIMARY KEY ( id );

CREATE TABLE consulta (
    id_consulta     NUMBER(10) NOT NULL,
    especialidade   VARCHAR2(50) NOT NULL,
    data_consulta   DATE NOT NULL,
    beneficiario_id NUMBER(10) NOT NULL,
    funcionario_id  NUMBER(10) NOT NULL
);

ALTER TABLE consulta ADD CONSTRAINT consulta_pk PRIMARY KEY ( id_consulta );

CREATE TABLE exame (
    id_exame        NUMBER(10) NOT NULL,
    especialista    VARCHAR2(50) NOT NULL,
    data_exame      DATE NOT NULL,
    beneficiario_id NUMBER(10) NOT NULL,
    funcionario_id  NUMBER(10) NOT NULL,
    medico_id       NUMBER(10) NOT NULL
);

ALTER TABLE exame ADD CONSTRAINT exame_pk PRIMARY KEY ( id_exame );

CREATE TABLE funcionario (
    id              NUMBER(10) NOT NULL,
    nome            VARCHAR2(50) NOT NULL,
    cpf             CHAR(11) NOT NULL,
    data_nascimento DATE NOT NULL,
    cep             CHAR(8) NOT NULL
);

ALTER TABLE funcionario ADD CONSTRAINT funcionario_pk PRIMARY KEY ( id );

CREATE TABLE medico (
    id                   NUMBER(10) NOT NULL,
    nome                 VARCHAR2(50) NOT NULL,
    cpf                  CHAR(11) NOT NULL,
    data_nascimento      DATE NOT NULL,
    cep                  CHAR(8) NOT NULL,
    especialidade_medico VARCHAR2(50) NOT NULL
);

ALTER TABLE medico ADD CONSTRAINT medico_pk PRIMARY KEY ( id );

CREATE TABLE plano (
    id_plano         NUMBER(10) NOT NULL,
    data_contratacao DATE NOT NULL,
    beneficiario_id  NUMBER(10) NOT NULL
);

CREATE UNIQUE INDEX plano__idx ON
    plano (
        beneficiario_id
    ASC );

ALTER TABLE plano ADD CONSTRAINT plano_pk PRIMARY KEY ( id_plano );

ALTER TABLE consulta
    ADD CONSTRAINT consulta_beneficiario_fk FOREIGN KEY ( beneficiario_id )
        REFERENCES beneficiario ( id );

ALTER TABLE consulta
    ADD CONSTRAINT consulta_funcionario_fk FOREIGN KEY ( funcionario_id )
        REFERENCES funcionario ( id );

ALTER TABLE exame
    ADD CONSTRAINT exame_beneficiario_fk FOREIGN KEY ( beneficiario_id )
        REFERENCES beneficiario ( id );

ALTER TABLE exame
    ADD CONSTRAINT exame_funcionario_fk FOREIGN KEY ( funcionario_id )
        REFERENCES funcionario ( id );

ALTER TABLE exame
    ADD CONSTRAINT exame_medico_fk FOREIGN KEY ( medico_id )
        REFERENCES medico ( id );

ALTER TABLE plano
    ADD CONSTRAINT plano_beneficiario_fk FOREIGN KEY ( beneficiario_id )
        REFERENCES beneficiario ( id );


-- Carga de Dados
        
set serveroutput on
set verify off
        
DECLARE
    v_id              NUMBER(10);
    v_nome            VARCHAR2(50);
    v_email           VARCHAR2(50);
    v_cpf             CHAR(11);
    v_data_nascimento DATE;
    v_cep             CHAR(8);
    v_senha           VARCHAR2(50);
BEGIN
    -- Inserindo dados para a tabela beneficiario
    v_id := 5;
    v_nome := 'Tiago Nicolas Thiago Teixeira';
    v_email := 'tiago.nicolas.teixeira@focustg.com.br';
    v_cpf := '95443312472';
    v_data_nascimento := TO_DATE('19931017', 'YYYYMMDD');
    v_cep := '54330551';
    v_senha := 'kbUuFd6yi0';

    -- Tratando exceções para evitar inserção duplicada na tabela beneficiario
    BEGIN
        INSERT INTO beneficiario (id, nome, email, cpf, data_nascimento, cep, senha)
        VALUES (v_id, v_nome, v_email, v_cpf, v_data_nascimento, v_cep, v_senha);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Beneficiario com ID ' || v_id || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM beneficiario;

DECLARE
    v_id              NUMBER(10);
    v_nome            VARCHAR2(50);
    v_cpf             CHAR(11);
    v_data_nascimento DATE;
    v_cep             CHAR(8);
BEGIN
    -- Inserindo dados para a tabela funcionario
    v_id := 5;
    v_nome := 'Nathan Jorge Moraes';
    v_cpf := '40506004635';
    v_data_nascimento := TO_DATE('19510607', 'YYYYMMDD');
    v_cep := '81710100';

    -- Tratando exceções para evitar inserção duplicada na tabela funcionario
    BEGIN
        INSERT INTO funcionario (id, nome, cpf, data_nascimento, cep)
        VALUES (v_id, v_nome, v_cpf, v_data_nascimento, v_cep);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Funcionario com ID ' || v_id || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM funcionario;

DECLARE
    v_id                   NUMBER(10);
    v_nome                 VARCHAR2(50);
    v_cpf                  CHAR(11);
    v_data_nascimento      DATE;
    v_cep                  CHAR(8);
    v_especialidade_medico VARCHAR2(50);
BEGIN
    -- Inserindo dados para a tabela medico
    v_id := 5;
    v_nome := 'Kauê Lorenzo Sebastião Pires';
    v_cpf := '84890442367';
    v_data_nascimento := TO_DATE('19501103', 'YYYYMMDD');
    v_cep := '79037887';
    v_especialidade_medico := 'Infectologia';

    -- Tratando exceções para evitar inserção duplicada na tabela medico
    BEGIN
        INSERT INTO medico (id, nome, cpf, data_nascimento, cep, especialidade_medico)
        VALUES (v_id, v_nome, v_cpf, v_data_nascimento, v_cep, v_especialidade_medico);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Medico com ID ' || v_id || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM medico;

DECLARE
    v_id_consulta     NUMBER(10);
    v_especialidade   VARCHAR2(50);
    v_data_consulta   DATE;
    v_beneficiario_id NUMBER(10);
    v_funcionario_id  NUMBER(10);
BEGIN
    -- Inserindo dados para a tabela consulta
    v_id_consulta := 5;
    v_especialidade := 'Infectologia';
    v_data_consulta := TO_DATE('20230324', 'YYYYMMDD');
    v_beneficiario_id := 5;
    v_funcionario_id := 1;

    -- Tratando exceções para evitar inserção duplicada na tabela consulta
    BEGIN
        INSERT INTO consulta (id_consulta, especialidade, data_consulta, beneficiario_id, funcionario_id)
        VALUES (v_id_consulta, v_especialidade, v_data_consulta, v_beneficiario_id, v_funcionario_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Consulta com ID ' || v_id_consulta || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM consulta;

DECLARE
    v_id_exame        NUMBER(10);
    v_especialista    VARCHAR2(50);
    v_data_exame      DATE;
    v_beneficiario_id NUMBER(10);
    v_funcionario_id  NUMBER(10);
    v_medico_id       NUMBER(10);
BEGIN
    -- Inserindo dados para a tabela exame
    v_id_exame := 5;
    v_especialista := 'Cardiologista';
    v_data_exame := TO_DATE('20231125', 'YYYYMMDD');
    v_beneficiario_id := 5;
    v_funcionario_id := 1;
    v_medico_id :=4;

    -- Tratando exceções para evitar inserção duplicada na tabela exame
    BEGIN
        INSERT INTO exame (id_exame, especialista, data_exame, beneficiario_id, funcionario_id, medico_id)
        VALUES (v_id_exame, v_especialista, v_data_exame, v_beneficiario_id, v_funcionario_id, v_medico_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Exame com ID ' || v_id_exame || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM exame;

DECLARE
    v_id_plano         NUMBER(10);
    v_data_contratacao DATE;
    v_beneficiario_id  NUMBER(10);
BEGIN
    -- Inserindo dados para a tabela plano
    v_id_plano := 5;
    v_data_contratacao := TO_DATE('20230909', 'YYYYMMDD');
    v_beneficiario_id :=1;

    -- Tratando exceções para evitar inserção duplicada na tabela plano
    BEGIN
        INSERT INTO plano (id_plano, data_contratacao, beneficiario_id)
        VALUES (v_id_plano, v_data_contratacao, v_beneficiario_id);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Erro: Plano com ID ' || v_id_plano || ' já existe.');
    END;
    COMMIT;
END;

SELECT * FROM plano;

-- Relatórios

set serveroutput on
set verify off

DECLARE
    CURSOR consulta_cursor IS
        SELECT c.id_consulta,
               c.especialidade,
               c.data_consulta,
               b.nome AS beneficiario_nome,
               f.nome AS funcionario_nome
          FROM consulta c
               JOIN beneficiario b ON c.beneficiario_id = b.id
               JOIN funcionario f ON c.funcionario_id = f.id;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ID_CONSULTA | ESPECIALIDADE | DATA_CONSULTA | BENEFICIARIO_NOME | FUNCIONARIO_NOME');
    DBMS_OUTPUT.PUT_LINE('=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=');

    FOR consulta_rec IN consulta_cursor
    LOOP
        DBMS_OUTPUT.PUT_LINE(consulta_rec.id_consulta || ' | ' ||
                             consulta_rec.especialidade || ' | ' ||
                             TO_CHAR(consulta_rec.data_consulta, 'DD/MM/YYYY') || ' | ' ||
                             consulta_rec.beneficiario_nome || ' | ' ||
                             consulta_rec.funcionario_nome);
    END LOOP;
END;

DECLARE
    CURSOR exame_cursor IS
        SELECT e.id_exame,
               e.especialista,
               e.data_exame,
               b.nome AS beneficiario_nome,
               f.nome AS funcionario_nome,
               m.nome AS medico_nome
          FROM exame e
               JOIN beneficiario b ON e.beneficiario_id = b.id
               JOIN funcionario f ON e.funcionario_id = f.id
               JOIN medico m ON e.medico_id = m.id;
BEGIN
    DBMS_OUTPUT.PUT_LINE('ID_EXAME | ESPECIALISTA | DATA_EXAME | BENEFICIARIO_NOME | FUNCIONARIO_NOME | MEDICO_NOME');
    DBMS_OUTPUT.PUT_LINE('=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=');

    FOR exame_rec IN exame_cursor
    LOOP
        DBMS_OUTPUT.PUT_LINE(exame_rec.id_exame || ' | ' ||
                             exame_rec.especialista || ' | ' ||
                             TO_CHAR(exame_rec.data_exame, 'DD/MM/YYYY') || ' | ' ||
                             exame_rec.beneficiario_nome || ' | ' ||
                             exame_rec.funcionario_nome || ' | ' ||
                             exame_rec.medico_nome);
    END LOOP;
END;


