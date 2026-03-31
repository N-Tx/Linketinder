
CREATE TABLE candidato (
  id SERIAL PRIMARY KEY,
  nome VARCHAR,
  sobrenome VARCHAR,
  cpf VARCHAR UNIQUE,
  email VARCHAR,
  telefone VARCHAR,
  data_nascimento DATE,
  pais VARCHAR,
  cep VARCHAR,
  descricao VARCHAR,
  senha VARCHAR
);


CREATE TABLE competencias (
  id SERIAL PRIMARY KEY,
  nome VARCHAR
);


CREATE TABLE empresa (
  id SERIAL PRIMARY KEY,
  nome VARCHAR,
  cnpj VARCHAR UNIQUE,
  email VARCHAR,
  telefone VARCHAR,
  pais VARCHAR,
  cep VARCHAR,
  descricao VARCHAR,
  senha VARCHAR
);


CREATE TABLE vagas (
  id SERIAL PRIMARY KEY,
  empresa_id INTEGER,
  nome VARCHAR,
  descricao VARCHAR,
  local_vaga VARCHAR,
  FOREIGN KEY (empresa_id) REFERENCES empresa(id)
);


CREATE TABLE candidato_competencia (
  candidato_id INTEGER,
  competencia_id INTEGER,
  PRIMARY KEY (candidato_id, competencia_id),
  FOREIGN KEY (candidato_id) REFERENCES candidato(id),
  FOREIGN KEY (competencia_id) REFERENCES competencias(id)
);


CREATE TABLE vaga_competencia (
  vaga_id INTEGER,
  competencia_id INTEGER,
  PRIMARY KEY (vaga_id, competencia_id),
  FOREIGN KEY (vaga_id) REFERENCES vagas(id),
  FOREIGN KEY (competencia_id) REFERENCES competencias(id)
);


CREATE TABLE curtidas_candidato (
  candidato_id INTEGER,
  vaga_id INTEGER,
  PRIMARY KEY (candidato_id, vaga_id),
  FOREIGN KEY (candidato_id) REFERENCES candidato(id),
  FOREIGN KEY (vaga_id) REFERENCES vagas(id)
);


CREATE TABLE curtidas_empresa (
  empresa_id INTEGER,
  candidato_id INTEGER,
  PRIMARY KEY (empresa_id, candidato_id),
  FOREIGN KEY (empresa_id) REFERENCES empresa(id),
  FOREIGN KEY (candidato_id) REFERENCES candidato(id)
);


CREATE TABLE matches (
  candidato_id INTEGER,
  vaga_id INTEGER,
  data_match DATE,
  PRIMARY KEY (candidato_id, vaga_id),
  FOREIGN KEY (candidato_id) REFERENCES candidato(id),
  FOREIGN KEY (vaga_id) REFERENCES vagas(id)
);


INSERT INTO candidato (nome, cpf) VALUES ('Nathan', '18785130354');
INSERT INTO empresa (nome, cnpj) VALUES ('PastelSoft', '34233100034');

INSERT INTO vagas (empresa_id, nome) VALUES (1, 'Dev Java');

UPDATE candidato
SET nome = 'Nathan',
    sobrenome = 'Teixeira',
    email = 'nathan@email.com'
	telefone ='210932333'
	data_nascimento ='13/02/2001'
	pais = 'Brasil'
	cep = '26600000'
	descricao = 'procurando estagio'
WHERE id = 1;


SELECT * FROM candidato;
