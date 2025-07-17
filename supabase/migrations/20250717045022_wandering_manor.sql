-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS bcd;
USE bcd;

-- Tabela Contato
CREATE TABLE IF NOT EXISTS Contato (
    idContato INT PRIMARY KEY AUTO_INCREMENT,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Tabela Responsaveis
CREATE TABLE IF NOT EXISTS Responsaveis (
    id_responsavel INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

-- Tabela Jovem
CREATE TABLE IF NOT EXISTS Jovem (
    id_jovem INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    dataNasc DATE NOT NULL,
    dataEntrada DATE NOT NULL,
    tipoSanguineo VARCHAR(10) NOT NULL,
    alergias TEXT NOT NULL,
    idContato INT NOT NULL,
    FOREIGN KEY (idContato) REFERENCES Contato(idContato)
);

-- Tabela AreaConhecimento
CREATE TABLE IF NOT EXISTS AreaConhecimento (
    idAreaConhecimento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Especialidade
CREATE TABLE IF NOT EXISTS Especialidade (
    id_especialidade INT PRIMARY KEY AUTO_INCREMENT,
    descricao TEXT NOT NULL,
    nivel INT NOT NULL CHECK (nivel IN (1, 2, 3)),
    total_requisitos INT NOT NULL,
    idAreaConhecimento INT NOT NULL,
    FOREIGN KEY (idAreaConhecimento) REFERENCES AreaConhecimento(idAreaConhecimento)
);

-- Tabela RequisitoEspecialidade
CREATE TABLE IF NOT EXISTS RequisitoEspecialidade (
    id_requisito INT PRIMARY KEY AUTO_INCREMENT,
    requisito TEXT NOT NULL,
    id_especialidade INT NOT NULL,
    FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade)
);

-- Tabela DistintivosDeProgressao
CREATE TABLE IF NOT EXISTS DistintivosDeProgressao (
    idDistintivo INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL
);

-- Tabela RequisitoDistintivo
CREATE TABLE IF NOT EXISTS RequisitoDistintivo (
    idRequisitoDistintivo INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL
);

-- Tabela Insignia
CREATE TABLE IF NOT EXISTS Insignia (
    id_Insignia INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

-- Tabela RequisitosInsignia
CREATE TABLE IF NOT EXISTS RequisitosInsignia (
    idRequisitoInsignia INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL,
    id_Insignia INT NOT NULL,
    FOREIGN KEY (id_Insignia) REFERENCES Insignia(id_Insignia)
);

-- Tabela Atividade
CREATE TABLE IF NOT EXISTS Atividade (
    id_atividade INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL,
    data DATE NOT NULL
);

-- Tabela Acampamento
CREATE TABLE IF NOT EXISTS Acampamento (
    idAcampamento INT PRIMARY KEY AUTO_INCREMENT,
    local VARCHAR(100) NOT NULL
);

-- Tabela Alergias
CREATE TABLE IF NOT EXISTS Alergias (
    idAlergia INT PRIMARY KEY AUTO_INCREMENT,
    `desc` VARCHAR(255) NOT NULL
);

-- Tabelas de relacionamento N:N

-- Tabela Jovem_Responsavel (N:N)
CREATE TABLE IF NOT EXISTS Jovem_Responsavel (
    id_jovem INT NOT NULL,
    id_responsavel INT NOT NULL,
    PRIMARY KEY (id_jovem, id_responsavel),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_responsavel) REFERENCES Responsaveis(id_responsavel)
);

-- Tabela Participacao_Atividade (N:N)
CREATE TABLE IF NOT EXISTS Participacao_Atividade (
    id_atividade INT NOT NULL,
    id_jovem INT NOT NULL,
    PRIMARY KEY (id_atividade, id_jovem),
    FOREIGN KEY (id_atividade) REFERENCES Atividade(id_atividade),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem)
);

-- Tabela Jovem_RequisitoEspecialidade (N:N)
CREATE TABLE IF NOT EXISTS Jovem_RequisitoEspecialidade (
    id_jovem INT NOT NULL,
    id_requisito INT NOT NULL,
    data_cumprimento DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_requisito),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_requisito) REFERENCES RequisitoEspecialidade(id_requisito)
);

-- Tabela Jovem_RequisitoDistintivo (N:N)
CREATE TABLE IF NOT EXISTS Jovem_RequisitoDistintivo (
    id_jovem INT NOT NULL,
    idRequisitoDistintivo INT NOT NULL,
    data_cumprimento DATE NOT NULL,
    PRIMARY KEY (id_jovem, idRequisitoDistintivo),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (idRequisitoDistintivo) REFERENCES RequisitoDistintivo(idRequisitoDistintivo)
);

-- Tabela Jovem_Acampamento (N:N)
CREATE TABLE IF NOT EXISTS Jovem_Acampamento (
    id_jovem INT NOT NULL,
    idAcampamento INT NOT NULL,
    PRIMARY KEY (id_jovem, idAcampamento),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (idAcampamento) REFERENCES Acampamento(idAcampamento)
);

-- Tabela Alergia_Jovem (N:N)
CREATE TABLE IF NOT EXISTS Alergia_Jovem (
    id_jovem INT NOT NULL,
    idAlergia INT NOT NULL,
    PRIMARY KEY (id_jovem, idAlergia),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (idAlergia) REFERENCES Alergias(idAlergia)
);

-- Tabela Prog_Requisito (N:N)
CREATE TABLE IF NOT EXISTS Prog_Requisito (
    idDistintivo INT NOT NULL,
    idRequisitoDistintivo INT NOT NULL,
    PRIMARY KEY (idDistintivo, idRequisitoDistintivo),
    FOREIGN KEY (idDistintivo) REFERENCES DistintivosDeProgressao(idDistintivo),
    FOREIGN KEY (idRequisitoDistintivo) REFERENCES RequisitoDistintivo(idRequisitoDistintivo)
);

-- Tabela Distintivo_Jovem (N:N)
CREATE TABLE IF NOT EXISTS Distintivo_Jovem (
    idDistintivo INT NOT NULL,
    id_jovem INT NOT NULL,
    data_conquista DATE NOT NULL,
    PRIMARY KEY (idDistintivo, id_jovem),
    FOREIGN KEY (idDistintivo) REFERENCES DistintivosDeProgressao(idDistintivo),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem)
);

-- Tabela Insignia_Jovem (N:N)
CREATE TABLE IF NOT EXISTS Insignia_Jovem (
    id_jovem INT NOT NULL,
    id_Insignia INT NOT NULL,
    data_conquista DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_Insignia),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_Insignia) REFERENCES Insignia(id_Insignia)
);

-- Tabela Jovem_Especialidade (N:N)
CREATE TABLE IF NOT EXISTS Jovem_Especialidade (
    id_jovem INT NOT NULL,
    id_especialidade INT NOT NULL,
    data_conquista DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_especialidade),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade)
);

-- Tabela Jovem_RequisitoInsignia (N:N)
CREATE TABLE IF NOT EXISTS Jovem_RequisitoInsignia (
    id_jovem INT NOT NULL,
    idRequisitoInsignia INT NOT NULL,
    data_cumprimento DATE NOT NULL,
    PRIMARY KEY (id_jovem, idRequisitoInsignia),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (idRequisitoInsignia) REFERENCES RequisitosInsignia(idRequisitoInsignia)
);