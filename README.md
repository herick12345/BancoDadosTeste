# Trabalho - Banco de Dados
Aluno: Herick

## Funcionalidades

- **Gestão de Jovens**: Cadastro completo com dados pessoais, contatos e responsáveis
- **Especialidades**: Controle de especialidades por área de conhecimento
- **Progressão**: Acompanhamento individual do progresso dos jovens
- **Distintivos**: Controle de distintivos de progressão (Lobo Pata Tenra até Cruzeiro do Sul)
- **Insígnias**: Gerenciamento de insígnias de interesse especial
- **Relatórios**: Relatórios de progressão e jovens aptos ao Cruzeiro do Sul

## 🚀 Como Executar

### Pré-requisitos
- Java 21+
- Docker e Docker Compose
- VSCode (recomendado)

### 1. Clonar o Repositório
```bash
git clone <url-do-repositorio>
cd sistema-escoteiro
```

### 2. Configurar VSCode (Opcional)
Instale as extensões recomendadas:
- Java Extension Pack
- Spring Boot Extension Pack
- SQLTools
- SQLTools MySQL Driver

### 3. Iniciar o Banco de Dados
```bash
# Iniciar MySQL e phpMyAdmin
docker-compose up -d

# Verificar se os containers estão rodando
docker-compose ps
```

### 4. Executar a Aplicação
```bash
# Via Gradle
./gradlew bootRun

# Ou via VSCode: Ctrl+Shift+P -> "Java: Run"
```

### 5. Acessar o Sistema
- **Aplicação Web**: http://localhost:8080
- **phpMyAdmin**: http://localhost:8081
- **API REST**: http://localhost:8080/api
- **Documentação API**: http://localhost:8080/swagger-ui.html

## 🗄️ Conexão com Banco de Dados no VSCode

### Configuração Automática
O projeto já inclui configurações do SQLTools no `.vscode/settings.json`:

```json
{
    "sqltools.connections": [
        {
            "name": "Sistema Escoteiro - MySQL",
            "driver": "MySQL",
            "server": "localhost",
            "port": 3333,
            "database": "bcd",
            "username": "aluno",
            "password": "aluno"
        }
    ]
}
```

### Como Conectar
1. Instale a extensão **SQLTools** e **SQLTools MySQL Driver**
2. Pressione `Ctrl+Shift+P` e digite "SQLTools: Connect"
3. Selecione "Sistema Escoteiro - MySQL"
4. A conexão será estabelecida automaticamente

### Credenciais do Banco
- **Host**: localhost
- **Porta**: 3333
- **Database**: bcd
- **Usuário**: aluno
- **Senha**: aluno
- **Root Password**: senhaRoot

## 📊 Estrutura do Banco de Dados

### Principais Tabelas
- `Jovem` - Dados dos jovens lobinhos
- `Contato` - Informações de contato
- `Responsaveis` - Dados dos responsáveis
- `Especialidade` - Especialidades por área de conhecimento
- `RequisitoEspecialidade` - Requisitos de cada especialidade
- `DistintivosDeProgressao` - Distintivos (Lobo Pata Tenra, etc.)
- `Insignia` - Insígnias de interesse especial

### Lógica de Negócio
- **Níveis de Especialidade**:
  - Nível 1: 1/3 dos requisitos (33%)
  - Nível 2: 2/3 dos requisitos (67%)
  - Nível 3: 100% dos requisitos

- **Cruzeiro do Sul**: Requer Lobo Caçador + 1 insígnia + 5 especialidades em 3 áreas diferentes

## 🔧 Comandos Úteis

### Docker
```bash
# Iniciar ambiente
docker-compose up -d

# Parar ambiente
docker-compose down

# Ver logs
docker-compose logs -f mysql

# Resetar dados (CUIDADO!)
docker-compose down -v
```

### Gradle
```bash
# Build completo
./gradlew clean build

# Executar aplicação
./gradlew bootRun

# Executar testes
./gradlew test

# Verificar Docker
./gradlew checkDocker

# Ambiente completo
./gradlew startDev
```

### VSCode Tasks
- `Ctrl+Shift+P` → "Tasks: Run Task"
- **Iniciar Docker MySQL**
- **Spring Boot Run**
- **Ambiente Completo**

## 📱 Interface Web

### Dashboard
- Estatísticas gerais do sistema
- Acesso rápido às funcionalidades principais

### Gestão de Jovens
- Cadastro completo com validações
- Filtros por nome e tipo sanguíneo
- Edição e exclusão de registros

### Acompanhamento de Progressão
- Visualização individual por jovem
- Barras de progresso por especialidade
- Registro de cumprimento de requisitos

### Relatórios
- Jovens aptos ao Cruzeiro do Sul
- Estatísticas de progressão

## 🧪 Dados de Exemplo

O sistema vem com dados pré-carregados:
- 4 jovens cadastrados
- 16 especialidades em 5 áreas
- 5 distintivos de progressão
- 5 insígnias de interesse especial
- Requisitos e progressões de exemplo

## 🐛 Troubleshooting

### Erro de Conexão com MySQL
```bash
# Verificar se o container está rodando
docker-compose ps

# Reiniciar o MySQL
docker-compose restart mysql

# Ver logs do MySQL
docker-compose logs mysql
```

### Erro de Porta em Uso
```bash
# Verificar processos na porta 3333
lsof -i :3333

# Ou alterar a porta no docker-compose.yml
```

### Problemas com Java/Gradle
```bash
# Limpar cache do Gradle
./gradlew clean

# Verificar versão do Java
java -version

# Recarregar projeto no VSCode
Ctrl+Shift+P → "Java: Reload Projects"
```

## 📄 Licença

Este projeto foi desenvolvido para fins educacionais como parte do curso de Análise e Desenvolvimento de Sistemas.

## 👥 Contribuição

Para contribuir com o projeto:
1. Faça um fork
2. Crie uma branch para sua feature
3. Commit suas mudanças
4. Push para a branch
5. Abra um Pull Request

---

**Desenvolvido com ❤️ para o movimento escoteiro** 🏕️