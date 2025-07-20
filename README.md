# Sistema Escoteiro - Ramo Lobinho

Sistema completo para gerenciamento de jovens do Ramo Lobinho, incluindo controle de progressão, especialidades e relatórios.

## 🚀 Como executar

### Opção 1: Desenvolvimento rápido (H2 - banco em memória)

```bash
# Executar com perfil de desenvolvimento
./gradlew bootRun --args='--spring.profiles.active=dev'
```

Acesse: http://localhost:8080

### Opção 2: Produção com MySQL

1. **Iniciar o MySQL com Docker:**
```bash
docker-compose up -d
```

2. **Executar a aplicação:**
```bash
./gradlew bootRun --args='--spring.profiles.active=mysql'
```

3. **Parar o MySQL:**
```bash
docker-compose down
```

## 🗄️ Banco de Dados

### H2 (Desenvolvimento)
- **URL:** `jdbc:h2:mem:bcd`
- **Console:** http://localhost:8080/h2-console
- **Usuário:** `sa`
- **Senha:** (vazio)

### MySQL (Produção)
- **Host:** localhost:3306
- **Database:** bcd
- **Usuário:** aluno
- **Senha:** aluno

## 📊 Funcionalidades

### ✅ Gestão de Jovens
- Cadastro completo com dados pessoais e contatos
- Controle de alergias e tipo sanguíneo
- Histórico de entrada no grupo

### ✅ Especialidades
- Catálogo completo de especialidades por área
- Controle de requisitos por especialidade
- Acompanhamento de progresso individual

### ✅ Sistema de Progressão
- Registro de cumprimento de requisitos
- Cálculo automático de níveis
- Controle de distintivos e insígnias

### ✅ Relatórios Completos
- **Estatísticas Gerais:** Visão geral do sistema
- **Jovens por Nível:** Classificação por progresso
- **Ranking de Progressão:** Classificação dos jovens
- **Especialidades Populares:** Mais procuradas
- **Progresso por Área:** Análise por área de conhecimento
- **Jovens Inativos:** Identificação de jovens sem atividade

## 🛠️ Tecnologias

- **Backend:** Spring Boot 3.5.3, Java 17+
- **Frontend:** HTML5, CSS3, JavaScript, Bootstrap 5
- **Banco de Dados:** MySQL 8.0 / H2 (desenvolvimento)
- **Build:** Gradle 8.14.2
- **Containerização:** Docker & Docker Compose

## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/ads/bcd/
│   │   ├── controller/     # Controllers REST
│   │   ├── service/        # Lógica de negócio
│   │   ├── repository/     # Acesso a dados
│   │   ├── model/          # Entidades JPA
│   │   └── dto/            # Data Transfer Objects
│   └── resources/
│       ├── static/         # Frontend (HTML, CSS, JS)
│       ├── application*.properties
│       └── data.sql        # Dados iniciais
├── docker-compose.yml      # Configuração MySQL
└── ddl-dml.sql            # Script completo do banco
```

## 🔧 Comandos Úteis

```bash
# Limpar e compilar
./gradlew clean build

# Executar testes
./gradlew test

# Executar com perfil específico
./gradlew bootRun --args='--spring.profiles.active=dev'

# Ver logs do MySQL
docker-compose logs mysql

# Resetar banco MySQL
docker-compose down -v && docker-compose up -d
```

## 📝 Notas de Desenvolvimento

- O perfil `dev` usa H2 em memória para desenvolvimento rápido
- O perfil `mysql` usa MySQL para ambiente de produção
- Os dados de exemplo são carregados automaticamente
- O frontend é responsivo e funciona em dispositivos móveis

## 🎯 Próximos Passos

- [ ] Autenticação e autorização
- [ ] Exportação de relatórios em PDF
- [ ] Notificações por email
- [ ] API mobile
- [ ] Backup automático