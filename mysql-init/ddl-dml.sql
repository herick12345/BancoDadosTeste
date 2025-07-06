-- Criação do banco de dados
CREATE DATABASE bcd;
USE bcd;

-- Tabela AreaConhecimento
CREATE TABLE AreaConhecimento (
    idAreaConhecimento INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL
);

-- Tabela Contato
CREATE TABLE Contato (
    idContato INT PRIMARY KEY AUTO_INCREMENT,
    telefone VARCHAR(20) NOT NULL,
    endereco VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL
);

-- Tabela Responsaveis
CREATE TABLE Responsaveis (
    id_responsavel INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

-- Tabela Jovem
CREATE TABLE Jovem (
    id_jovem INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    dataNasc DATE NOT NULL,
    dataEntrada DATE NOT NULL,
    tipoSanguineo VARCHAR(10) NOT NULL,
    alergias TEXT NOT NULL,
    idContato INT NOT NULL,
    FOREIGN KEY (idContato) REFERENCES Contato(idContato)
);

-- Tabela Especialidade
CREATE TABLE Especialidade (
    id_especialidade INT PRIMARY KEY AUTO_INCREMENT,
    descricao TEXT NOT NULL,
    nivel INT NOT NULL CHECK (nivel IN (1, 2, 3)),
    total_requisitos INT NOT NULL,
    idAreaConhecimento INT NOT NULL,
    FOREIGN KEY (idAreaConhecimento) REFERENCES AreaConhecimento(idAreaConhecimento)
);

-- Tabela DistintivosDeProgressao
CREATE TABLE DistintivosDeProgressao (
    idDistintivo INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL
);

-- Tabela RequisitosInsignia
CREATE TABLE RequisitosInsignia (
    idRequisitoInsignia INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL
);

-- Tabela RequisitoEspecialidade
CREATE TABLE RequisitoEspecialidade (
    id_requisito INT PRIMARY KEY AUTO_INCREMENT,
    requisito TEXT NOT NULL
);

-- Tabela RequisitoDistintivo
CREATE TABLE RequisitoDistintivo (
    idRequisitoDistintivo INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL
);

-- Tabela Insignia
CREATE TABLE Insignia (
    id_Insignia INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL
);

-- Tabela Atividade
CREATE TABLE Atividade (
    id_atividade INT PRIMARY KEY AUTO_INCREMENT,
    `desc` TEXT NOT NULL,
    data DATE NOT NULL
);

-- Tabela Jovem_Responsavel (N:N)
CREATE TABLE Jovem_Responsavel (
    id_jovem INT NOT NULL,
    id_responsavel INT NOT NULL,
    PRIMARY KEY (id_jovem, id_responsavel),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_responsavel) REFERENCES Responsaveis(id_responsavel)
);

-- Tabela ERequisitoEspecialidade (N:N)
CREATE TABLE ERequisitoEspecialidade (
    id_especialidade INT NOT NULL,
    id_requisito INT NOT NULL,
    PRIMARY KEY (id_especialidade, id_requisito),
    FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade),
    FOREIGN KEY (id_requisito) REFERENCES RequisitoEspecialidade(id_requisito)
);

-- Tabela ERequisitoInsignia (N:N)
CREATE TABLE ERequisitoInsignia (
    id_Insignia INT NOT NULL,
    idRequisitoInsignia INT NOT NULL,
    PRIMARY KEY (id_Insignia, idRequisitoInsignia),
    FOREIGN KEY (id_Insignia) REFERENCES Insignia(id_Insignia),
    FOREIGN KEY (idRequisitoInsignia) REFERENCES RequisitosInsignia(idRequisitoInsignia)
);

-- Tabela Insignia_Jovem (N:N)
CREATE TABLE Insignia_Jovem (
    id_jovem INT NOT NULL,
    id_Insignia INT NOT NULL,
    data_conquista DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_Insignia),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_Insignia) REFERENCES Insignia(id_Insignia)
);

-- Tabela Prog_Requesito (N:N)
CREATE TABLE Prog_Requesito (
    idDistintivo INT NOT NULL,
    idRequisitoDistintivo INT NOT NULL,
    PRIMARY KEY (idDistintivo, idRequisitoDistintivo),
    FOREIGN KEY (idDistintivo) REFERENCES DistintivosDeProgressao(idDistintivo),
    FOREIGN KEY (idRequisitoDistintivo) REFERENCES RequisitoDistintivo(idRequisitoDistintivo)
);

-- Tabela Distintivo_Jovem (N:N)
CREATE TABLE Distintivo_Jovem (
    idDistintivo INT NOT NULL,
    id_jovem INT NOT NULL,
    data DATE NOT NULL,
    PRIMARY KEY (idDistintivo, id_jovem),
    FOREIGN KEY (idDistintivo) REFERENCES DistintivosDeProgressao(idDistintivo),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem)
);

-- Tabela Participacao_Atividade (N:N)
CREATE TABLE Participacao_Atividade (
    id_atividade INT NOT NULL,
    id_jovem INT NOT NULL,
    PRIMARY KEY (id_atividade, id_jovem),
    FOREIGN KEY (id_atividade) REFERENCES Atividade(id_atividade),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem)
);

-- Tabela Jovem_Especialidade (N:N)
CREATE TABLE Jovem_Especialidade (
    id_jovem INT NOT NULL,
    id_especialidade INT NOT NULL,
    data_conquista DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_especialidade),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_especialidade) REFERENCES Especialidade(id_especialidade)
);

-- Tabela Jovem_RequisitoEspecialidade (N:N)
CREATE TABLE Jovem_RequisitoEspecialidade (
    id_jovem INT NOT NULL,
    id_requisito INT NOT NULL,
    data_cumprimento DATE NOT NULL,
    PRIMARY KEY (id_jovem, id_requisito),
    FOREIGN KEY (id_jovem) REFERENCES Jovem(id_jovem),
    FOREIGN KEY (id_requisito) REFERENCES RequisitoEspecialidade(id_requisito)
);

-- Dados de exemplo (DML)
INSERT INTO AreaConhecimento (nome) VALUES
('Ciência e Tecnologia'),
('Cultura'),
('Desportos'),
('Habilidades Escoteiras'),
('Serviços');

INSERT INTO Contato (telefone, endereco, email) VALUES
('48999990000', 'Rua das Acácias, 100', 'joao@email.com'),
('48988881111', 'Rua das Palmeiras, 200', 'maria@email.com');

INSERT INTO Responsaveis (nome, email, telefone) VALUES
('Carlos Silva', 'carlos@email.com', '48991234567'),
('Ana Souza', 'ana@email.com', '48997654321');

INSERT INTO Jovem (nome, dataNasc, dataEntrada, tipoSanguineo, alergias, idContato) VALUES
('João Lobinho', '2015-04-20', '2022-01-15', 'O+', 'Nenhuma', 1),
('Maria Escoteira', '2014-09-10', '2021-09-01', 'A-', 'Alergia a amendoim', 2);

INSERT INTO Especialidade (descricao, nivel, total_requisitos, idAreaConhecimento) VALUES
('Radioamadorismo', 1, 12, 1),
('Criptografia', 1, 12, 1),
('Animais Peçonhentos', 1, 9, 1);

INSERT INTO DistintivosDeProgressao (`desc`) VALUES
('Lobo Pata Tenra'),
('Lobo Saltador'),
('Lobo Rastreador'),
('Lobo Caçador'),
('Cruzeiro do Sul');

INSERT INTO Insignia (nome) VALUES
('Aprender'),
('Servir');

INSERT INTO Atividade (`desc`, data) VALUES
('Acampamento inicial', '2023-05-15'),
('Curso de Radioamadorismo', '2023-07-10');

INSERT INTO Jovem_Responsavel (id_jovem, id_responsavel) VALUES
(1, 1),
(2, 2);

INSERT INTO Distintivo_Jovem (idDistintivo, id_jovem, data) VALUES
(4, 1, '2024-08-15');

INSERT INTO Insignia_Jovem (id_jovem, id_Insignia, data_conquista) VALUES
(1, 1, '2024-09-01'),
(1, 2, '2024-10-01');

INSERT INTO Participacao_Atividade (id_atividade, id_jovem) VALUES
(1, 1),
(2, 1);

INSERT INTO RequisitoEspecialidade (requisito) VALUES
('Montar antena básica'),
('Fazer transmissão'),
('Decifrar código simples');

INSERT INTO ERequisitoEspecialidade (id_especialidade, id_requisito) VALUES
(1, 1),
(1, 2),
(2, 3);

INSERT INTO Jovem_Especialidade (id_jovem, id_especialidade, data_conquista) VALUES
(1, 1, '2024-09-15'),
(1, 2, '2024-10-15');

INSERT INTO Jovem_RequisitoEspecialidade (id_jovem, id_requisito, data_cumprimento) VALUES
(1, 1, '2024-08-01'),
(1, 2, '2024-08-10'),
(1, 3, '2024-09-05');