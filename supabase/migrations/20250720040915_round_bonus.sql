-- Dados de exemplo para H2
-- Área de conhecimento
INSERT INTO area_conhecimento (nome) VALUES
('Ciência e Tecnologia'),
('Cultura'),
('Desportos'),
('Habilidades Escoteiras'),
('Serviços');

-- Contatos
INSERT INTO contato (telefone, endereco, email) VALUES
('48999990000', 'Rua das Acácias, 100', 'joao@email.com'),
('48988881111', 'Rua das Palmeiras, 200', 'maria@email.com'),
('48991112222', 'Rua do Carvalho, 300', 'lucas@email.com'),
('48992223333', 'Av. das Araucárias, 400', 'sofia@email.com'),
('48993334444', 'Rua das Hortênsias, 500', 'enrico@email.com');

-- Responsáveis
INSERT INTO responsaveis (nome, email, telefone) VALUES
('Carlos Silva', 'carlos@email.com', '48991234567'),
('Ana Souza', 'ana@email.com', '48997654321'),
('Fernando Lima', 'fernando@email.com', '48995556666'),
('Paula Mendes', 'paula@email.com', '48996667777'),
('Ricardo Torres', 'ricardo@email.com', '48997778888');

-- Jovens
INSERT INTO jovem (nome, data_nasc, data_entrada, tipo_sanguineo, alergias, id_contato) VALUES
('João Lobinho', '2015-04-20', '2022-01-15', 'O+', 'Nenhuma', 1),
('Maria Escoteira', '2014-09-10', '2021-09-01', 'A-', 'Alergia a amendoim', 2),
('Lucas Aventureiro', '2015-11-30', '2023-03-12', 'B+', 'Nenhuma', 3),
('Sofia Exploradora', '2013-06-22', '2022-05-18', 'AB-', 'Poeira', 4),
('Enrico Valente', '2014-02-17', '2022-08-25', 'O-', 'Alergia a frutos do mar', 5);

-- Especialidades
INSERT INTO especialidade (descricao, nivel, total_requisitos, id_area_conhecimento) VALUES
('Radioamadorismo', 1, 12, 1),
('Criptografia', 1, 12, 1),
('Animais Peçonhentos', 1, 9, 1),
('Culinária', 1, 8, 2),
('Primeiros Socorros', 1, 10, 5),
('Natação', 1, 6, 3),
('Orientação', 1, 8, 4),
('Fotografia', 1, 7, 2);

-- Distintivos de progressão
INSERT INTO distintivos_de_progressao (descricao) VALUES
('Lobo Pata Tenra'),
('Lobo Saltador'),
('Lobo Rastreador'),
('Lobo Caçador'),
('Cruzeiro do Sul');

-- Insígnias
INSERT INTO insignia (nome) VALUES
('Aprender'),
('Servir');

-- Atividades
INSERT INTO atividade (descricao, data_atividade) VALUES
('Acampamento inicial', '2023-05-15'),
('Curso de Radioamadorismo', '2023-07-10'),
('Trilha ecológica', '2023-08-20'),
('Oficina de culinária', '2023-09-15');

-- Relacionamentos jovem-responsável
INSERT INTO jovem_responsavel (id_jovem, id_responsavel) VALUES
(1, 1), (2, 2), (3, 3), (4, 4), (5, 5);

-- Requisitos de especialidade
INSERT INTO requisito_especialidade (requisito, id_especialidade) VALUES
('Montar antena básica', 1),
('Fazer transmissão', 1),
('Reconhecer sinais de rádio', 1),
('Decifrar código simples', 2),
('Criptografar mensagem', 2),
('Identificar cobra venenosa', 3),
('Primeiros socorros para picada', 3),
('Preparar refeição completa', 4),
('Técnicas de corte seguras', 4),
('Tratar ferimento', 5),
('Manobra de Heimlich', 5),
('Nadar 100 metros', 6),
('Salvamento básico', 6),
('Ler mapa topográfico', 7),
('Usar bússola', 7),
('Tirar foto bem composta', 8),
('Editar fotografia', 8);

-- Jovens cumprindo requisitos
INSERT INTO jovem_requisito_especialidade (id_jovem, id_requisito, data_cumprimento) VALUES
(1, 1, '2024-08-01'),
(1, 2, '2024-08-10'),
(1, 3, '2024-08-15'),
(2, 4, '2024-09-05'),
(2, 5, '2024-09-10'),
(3, 6, '2024-09-15'),
(3, 7, '2024-09-20'),
(4, 8, '2024-10-01'),
(4, 9, '2024-10-05'),
(5, 10, '2024-10-10'),
(5, 11, '2024-10-15');

-- Especialidades conquistadas
INSERT INTO jovem_especialidade (id_jovem, id_especialidade, data_conquista) VALUES
(1, 1, '2024-09-15'),
(2, 2, '2024-10-15'),
(3, 3, '2024-11-01'),
(4, 4, '2024-11-10'),
(5, 5, '2024-11-20');

-- Distintivos conquistados
INSERT INTO distintivo_jovem (id_distintivo, id_jovem, data_conquista) VALUES
(1, 1, '2024-08-15'),
(2, 2, '2024-09-20'),
(3, 3, '2024-10-25'),
(4, 4, '2024-11-15'),
(1, 5, '2024-12-01');

-- Insígnias conquistadas
INSERT INTO insignia_jovem (id_jovem, id_insignia, data_conquista) VALUES
(1, 1, '2024-09-01'),
(1, 2, '2024-10-01'),
(2, 1, '2024-10-15'),
(3, 2, '2024-11-01'),
(4, 1, '2024-11-20'),
(5, 2, '2024-12-05');

-- Participação em atividades
INSERT INTO participacao_atividade (id_atividade, id_jovem) VALUES
(1, 1), (1, 2), (1, 3),
(2, 1), (2, 4),
(3, 2), (3, 3), (3, 5),
(4, 4), (4, 5);