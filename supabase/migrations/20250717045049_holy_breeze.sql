-- Inserção de dados de exemplo
USE bcd;

-- Dados de exemplo para AreaConhecimento
INSERT INTO AreaConhecimento (nome) VALUES
('Ciência e Tecnologia'),
('Cultura'),
('Desportos'),
('Habilidades Escoteiras'),
('Serviços');

-- Dados de exemplo para Contato
INSERT INTO Contato (telefone, endereco, email) VALUES
('48999990000', 'Rua das Acácias, 100', 'joao@email.com'),
('48988881111', 'Rua das Palmeiras, 200', 'maria@email.com'),
('48977772222', 'Rua dos Ipês, 300', 'pedro@email.com'),
('48966663333', 'Rua das Rosas, 400', 'ana@email.com');

-- Dados de exemplo para Responsaveis
INSERT INTO Responsaveis (nome, email, telefone) VALUES
('Carlos Silva', 'carlos@email.com', '48991234567'),
('Ana Souza', 'ana@email.com', '48997654321'),
('Roberto Santos', 'roberto@email.com', '48993456789'),
('Mariana Costa', 'mariana@email.com', '48998765432');

-- Dados de exemplo para Jovem
INSERT INTO Jovem (nome, dataNasc, dataEntrada, tipoSanguineo, alergias, idContato) VALUES
('João Lobinho', '2015-04-20', '2022-01-15', 'O+', 'Nenhuma', 1),
('Maria Escoteira', '2014-09-10', '2021-09-01', 'A-', 'Alergia a amendoim', 2),
('Pedro Aventureiro', '2016-02-28', '2023-03-10', 'B+', 'Alergia a lactose', 3),
('Ana Exploradora', '2015-11-15', '2022-08-20', 'AB-', 'Nenhuma', 4);

-- Dados de exemplo para Especialidade
INSERT INTO Especialidade (descricao, nivel, total_requisitos, idAreaConhecimento) VALUES
('Radioamadorismo', 1, 12, 1),
('Criptografia', 1, 12, 1),
('Animais Peçonhentos', 1, 9, 1),
('Astronomia', 2, 15, 1),
('Programação', 3, 18, 1),
('Música', 1, 10, 2),
('Teatro', 2, 12, 2),
('Dança', 1, 8, 2),
('Futebol', 1, 10, 3),
('Natação', 2, 14, 3),
('Escalada', 3, 16, 3),
('Nós e Amarras', 1, 8, 4),
('Orientação', 2, 12, 4),
('Sobrevivência', 3, 20, 4),
('Primeiros Socorros', 1, 10, 5),
('Meio Ambiente', 2, 14, 5);

-- Dados de exemplo para RequisitoEspecialidade
INSERT INTO RequisitoEspecialidade (requisito, id_especialidade) VALUES
-- Radioamadorismo (12 requisitos)
('Conhecer o alfabeto fonético internacional', 1),
('Montar uma antena básica', 1),
('Fazer uma transmissão simples', 1),
('Conhecer as frequências do radioamadorismo', 1),
('Entender o código Q básico', 1),
('Conhecer os equipamentos básicos', 1),
('Fazer contato com outra estação', 1),
('Conhecer as regras de operação', 1),
('Entender propagação de ondas', 1),
('Conhecer tipos de modulação', 1),
('Fazer log de contatos', 1),
('Participar de concurso', 1),

-- Criptografia (12 requisitos)
('Conhecer cifra de César', 2),
('Decifrar código morse', 2),
('Criar código secreto', 2),
('Usar cifra de substituição', 2),
('Conhecer esteganografia', 2),
('Decifrar mensagem em código', 2),
('Criar chave criptográfica', 2),
('Usar cifra de Vigenère', 2),
('Conhecer criptografia moderna', 2),
('Decifrar código binário', 2),
('Criar sistema de senhas', 2),
('Ensinar criptografia básica', 2),

-- Animais Peçonhentos (9 requisitos)
('Identificar serpentes venenosas', 3),
('Conhecer aranhas perigosas', 3),
('Identificar escorpiões', 3),
('Conhecer primeiros socorros para picadas', 3),
('Saber prevenção de acidentes', 3),
('Conhecer antídotos básicos', 3),
('Identificar plantas venenosas', 3),
('Conhecer insetos perigosos', 3),
('Ensinar prevenção para outros', 3);

-- Dados de exemplo para DistintivosDeProgressao
INSERT INTO DistintivosDeProgressao (`desc`) VALUES
('Lobo Pata Tenra'),
('Lobo Saltador'),
('Lobo Rastreador'),
('Lobo Caçador'),
('Cruzeiro do Sul');

-- Dados de exemplo para RequisitoDistintivo
INSERT INTO RequisitoDistintivo (`desc`) VALUES
('Conhecer a história do escotismo'),
('Saber a oração do escoteiro'),
('Conhecer a lei do lobinho'),
('Participar de atividade em grupo'),
('Demonstrar habilidade manual'),
('Conhecer símbolos escoteiros'),
('Participar de jogo cooperativo'),
('Demonstrar espírito de equipe'),
('Conhecer tradições escoteiras'),
('Participar de cerimônia');

-- Dados de exemplo para Insignia
INSERT INTO Insignia (nome) VALUES
('Aprender'),
('Servir'),
('Compartilhar'),
('Cuidar'),
('Descobrir');

-- Dados de exemplo para RequisitosInsignia
INSERT INTO RequisitosInsignia (`desc`, id_Insignia) VALUES
-- Insígnia Aprender (8 requisitos)
('Ler um livro adequado à idade', 1),
('Aprender uma nova habilidade', 1),
('Ensinar algo para outro jovem', 1),
('Participar de curso ou oficina', 1),
('Fazer pesquisa sobre tema de interesse', 1),
('Criar projeto educativo', 1),
('Compartilhar conhecimento', 1),
('Demonstrar aprendizado', 1),

-- Insígnia Servir (8 requisitos)
('Ajudar em atividade comunitária', 2),
('Participar de ação solidária', 2),
('Auxiliar pessoa necessitada', 2),
('Colaborar em projeto social', 2),
('Organizar campanha beneficente', 2),
('Visitar instituição de caridade', 2),
('Participar de mutirão', 2),
('Demonstrar espírito de serviço', 2);

-- Dados de exemplo para Atividade
INSERT INTO Atividade (`desc`, data) VALUES
('Acampamento de Integração', '2023-05-15'),
('Curso de Radioamadorismo', '2023-07-10'),
('Gincana Escoteira', '2023-08-20'),
('Caminhada Ecológica', '2023-09-05'),
('Festival de Talentos', '2023-10-12'),
('Acampamento de Inverno', '2023-11-25');

-- Dados de exemplo para Acampamento
INSERT INTO Acampamento (local) VALUES
('Campo Escoteiro São José'),
('Parque Nacional da Serra'),
('Camping Aventura'),
('Base Escoteira Regional');

-- Dados de exemplo para Alergias
INSERT INTO Alergias (`desc`) VALUES
('Amendoim'),
('Lactose'),
('Glúten'),
('Frutos do mar'),
('Pólen'),
('Medicamentos');

-- Relacionamentos de exemplo

-- Jovem_Responsavel
INSERT INTO Jovem_Responsavel (id_jovem, id_responsavel) VALUES
(1, 1), (2, 2), (3, 3), (4, 4);

-- Participacao_Atividade
INSERT INTO Participacao_Atividade (id_atividade, id_jovem) VALUES
(1, 1), (1, 2), (1, 3), (1, 4),
(2, 1), (2, 3),
(3, 2), (3, 4),
(4, 1), (4, 2), (4, 3);

-- Jovem_RequisitoEspecialidade (alguns requisitos cumpridos)
INSERT INTO Jovem_RequisitoEspecialidade (id_jovem, id_requisito, data_cumprimento) VALUES
-- João completou alguns requisitos de Radioamadorismo
(1, 1, '2024-08-01'),
(1, 2, '2024-08-10'),
(1, 3, '2024-08-15'),
(1, 4, '2024-08-20'),
-- Maria completou alguns requisitos de Criptografia
(2, 13, '2024-09-01'),
(2, 14, '2024-09-05'),
(2, 15, '2024-09-10'),
(2, 16, '2024-09-15'),
(2, 17, '2024-09-20'),
(2, 18, '2024-09-25'),
(2, 19, '2024-09-30'),
(2, 20, '2024-10-05');

-- Distintivo_Jovem (alguns distintivos conquistados)
INSERT INTO Distintivo_Jovem (idDistintivo, id_jovem, data_conquista) VALUES
(1, 1, '2024-06-15'),
(2, 1, '2024-09-20'),
(1, 2, '2024-07-10'),
(2, 2, '2024-10-15');

-- Insignia_Jovem (algumas insígnias conquistadas)
INSERT INTO Insignia_Jovem (id_jovem, id_Insignia, data_conquista) VALUES
(1, 1, '2024-09-01'),
(1, 2, '2024-10-01'),
(2, 1, '2024-08-15'),
(2, 3, '2024-11-01');

-- Jovem_Especialidade (especialidades conquistadas)
INSERT INTO Jovem_Especialidade (id_jovem, id_especialidade, data_conquista) VALUES
(2, 2, '2024-10-15'); -- Maria conquistou Criptografia

-- Prog_Requisito (requisitos para distintivos)
INSERT INTO Prog_Requisito (idDistintivo, idRequisitoDistintivo) VALUES
(1, 1), (1, 2), (1, 3),
(2, 4), (2, 5), (2, 6),
(3, 7), (3, 8), (3, 9),
(4, 1), (4, 2), (4, 3), (4, 4), (4, 5),
(5, 1), (5, 2), (5, 3), (5, 4), (5, 5), (5, 6), (5, 7), (5, 8), (5, 9), (5, 10);