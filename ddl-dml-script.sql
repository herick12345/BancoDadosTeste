

CREATE TABLE Contato (
  idContato INT NOT NULL PRIMARY KEY,
  Telefone VARCHAR(15) NOT NULL,
  endereco VARCHAR(255) NOT NULL,
  email VARCHAR(100) NOT NULL
);

CREATE TABLE Jovem (
  id_jovem INT NOT NULL PRIMARY KEY,
  Nome VARCHAR(100) NOT NULL,
  dataNasc DATE NOT NULL,
  dataEntrada DATE NOT NULL,
  TipoSanguineo VARCHAR(3) NOT NULL,
  idContato INT NOT NULL,
  FOREIGN KEY (idContato) REFERENCES Contato(idContato)
);

CREATE TABLE Responsaveis (
  id_responsavel INT NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) NOT NULL,
  telefone VARCHAR(15) NOT NULL
);

CREATE TABLE Especialidade (
  id_especialidade INT NOT NULL PRIMARY KEY,
  descricao VARCHAR(255) NOT NULL,
  nivel INT NOT NULL,
  total_requisitos INT NOT NULL
);

CREATE TABLE RequisitoEspecialidade (
  id_requisito INT NOT NULL PRIMARY KEY,
  requisito VARCHAR(255) NOT NULL,
  id_especialidade INT NOT NULL,
  FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade)
);

CREATE TABLE RequisitoDistintivo (
  idRequisitoDistintivo INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL
);

CREATE TABLE Insignia (
  id_Insignia INT NOT NULL PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE atividade (
  id_atividade INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL,
  data DATE NOT NULL
);

CREATE TABLE AreaConhecimento (
  idConhecimento INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL,
  id_especialidade INT NOT NULL,
  FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade)
);

CREATE TABLE Acampamento (
  idAcampamento INT NOT NULL PRIMARY KEY,
  local VARCHAR(100) NOT NULL
);

CREATE TABLE Alergias (
  idAlergia INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL
);

CREATE TABLE jovem_responsavel (
  id_jovem INT NOT NULL,
  id_responsavel INT NOT NULL,
  PRIMARY KEY (id_jovem, id_responsavel),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (id_responsavel) REFERENCES Responsaveis(id_responsavel)
);

CREATE TABLE participacao_atividade (
  id_atividade INT NOT NULL,
  id_jovem INT NOT NULL,
  PRIMARY KEY (id_atividade, id_jovem),
  FOREIGN KEY (id_atividade) REFERENCES atividade(id_atividade),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem)
);

CREATE TABLE JovReqEsp (
  id_jovem INT NOT NULL,
  id_requisito INT NOT NULL,
  Data DATE NOT NULL,
  PRIMARY KEY (id_jovem, id_requisito),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (id_requisito) REFERENCES RequisitoEspecialidade(id_requisito)
);

CREATE TABLE JovReqDist (
  id_jovem INT NOT NULL,
  idRequisitoDistintivo INT NOT NULL,
  Data DATE NOT NULL,
  PRIMARY KEY (id_jovem, idRequisitoDistintivo),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (idRequisitoDistintivo) REFERENCES RequisitoDistintivo(idRequisitoDistintivo)
);

CREATE TABLE JovemAcampamento (
  id_jovem INT NOT NULL,
  idAcampamento INT NOT NULL,
  PRIMARY KEY (id_jovem, idAcampamento),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (idAcampamento) REFERENCES Acampamento(idAcampamento)
);

CREATE TABLE AlergiaJovem (
  id_jovem INT NOT NULL,
  idAlergia INT NOT NULL,
  PRIMARY KEY (id_jovem, idAlergia),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (idAlergia) REFERENCES Alergias(idAlergia)
);

CREATE TABLE distintivosDeProgressao (
  idDistintivo INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL,
  idRequisitoDistintivo INT NOT NULL,
  FOREIGN KEY (idRequisitoDistintivo) REFERENCES RequisitoDistintivo(idRequisitoDistintivo)
);

CREATE TABLE RequisitosInsignia (
  idRequisitoInsignia INT NOT NULL PRIMARY KEY,
  `desc` VARCHAR(255) NOT NULL,
  id_Insignia INT NOT NULL,
  FOREIGN KEY (id_Insignia) REFERENCES Insignia(id_Insignia)
);

CREATE TABLE JovReqIns (
  id_jovem INT NOT NULL,
  idRequisitoInsignia INT NOT NULL,
  Data DATE NOT NULL,
  PRIMARY KEY (id_jovem, idRequisitoInsignia),
  FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
  FOREIGN KEY (idRequisitoInsignia) REFERENCES RequisitosInsignia(idRequisitoInsignia)
);

-- ======= DML (Exemplo) =======

INSERT INTO Contato (idContato, Telefone, endereco, email) VALUES (1, '48999990000', 'Rua das Flores, 123', 'contato@email.com');

INSERT INTO Jovem (id_jovem, Nome, dataNasc, dataEntrada, TipoSanguineo, idContato)
VALUES (1, 'Carlos Silva', '2007-04-10', '2023-02-01', 'O+', 1);

INSERT INTO Responsaveis (id_responsavel, nome, email, telefone)
VALUES (1, 'Maria Silva', 'maria@email.com', '48999887766');
