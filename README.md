# API de Gerenciamento de Clientes

Esta API fornece funcionalidades para gerenciar clientes, incluindo operações de CRUD (Create, Read, Update, Delete). A API permite realizar operações como cadastro de clientes, consulta de clientes por ID ou nome, atualização e exclusão de clientes, além de fornecer a contagem total de clientes cadastrados.

## Tecnologias Utilizadas

- **Java 21** (Spring Boot)
- **MongoDB 8.0** (para armazenamento dos dados)
- **Swagger** (para documentação da API)
- **Spring Data** (para integração com o banco de dados)
- **Spring Web** (para criação da API RESTful)

## Endpoints da API

A seguir, são descritos os principais endpoints da API, suas funcionalidades e métodos HTTP correspondentes.

### 1. **Listar todos os clientes**
- **Endpoint:** `GET /customers`
- **Descrição:** Retorna uma lista paginada de todos os clientes cadastrados.
- **Parâmetros:**
  - `page`: Número da página (padrão 0).
  - `size`: Número de itens por página (padrão 20).
- **Resposta de Sucesso (200 OK):**
  - Um objeto `Page<Customer>` contendo os clientes.
  
### 2. **Buscar cliente por ID**
- **Endpoint:** `GET /customers/{id}`
- **Descrição:** Retorna o cliente com o ID fornecido.
- **Parâmetros:**
  - `id`: ID do cliente a ser buscado.
- **Resposta de Sucesso (200 OK):**
  - Um objeto `Customer` com os dados do cliente.
- **Resposta de Erro (404 Not Found):**
  - Caso o cliente com o ID fornecido não seja encontrado.

### 3. **Buscar clientes pelo nome**
- **Endpoint:** `GET /customers/nome/{nome}`
- **Descrição:** Retorna uma lista paginada de clientes cujo nome contenha o valor informado (case-insensitive).
- **Parâmetros:**
  - `nome`: Nome ou parte do nome do cliente a ser buscado.
  - `page`: Número da página (padrão 0).
  - `size`: Número de itens por página (padrão 20).
- **Resposta de Sucesso (200 OK):**
  - Um objeto `Page<Customer>` contendo os clientes encontrados.

### 4. **Contar total de clientes**
- **Endpoint:** `GET /customers/contar`
- **Descrição:** Retorna a quantidade total de clientes cadastrados.
- **Resposta de Sucesso (200 OK):**
  - Um número inteiro representando o total de clientes cadastrados.

### 5. **Cadastrar um novo cliente**
- **Endpoint:** `POST /customers`
- **Descrição:** Cria um novo cliente com os dados fornecidos.
- **Parâmetros:**
  - Corpo da requisição: Dados do cliente no formato JSON.
- **Resposta de Sucesso (201 Created):**
  - O objeto `Customer` com os dados do novo cliente.
- **Resposta de Erro (400 Bad Request):**
  - Caso os dados fornecidos sejam inválidos.

### 6. **Atualizar um cliente**
- **Endpoint:** `PUT /customers/{id}`
- **Descrição:** Atualiza os dados de um cliente existente.
- **Parâmetros:**
  - `id`: ID do cliente a ser atualizado.
  - Corpo da requisição: Novos dados do cliente no formato JSON.
- **Resposta de Sucesso (200 OK):**
  - O objeto `Customer` com os dados atualizados.
- **Resposta de Erro (404 Not Found):**
  - Caso o cliente com o ID fornecido não seja encontrado.

### 7. **Deletar um cliente**
- **Endpoint:** `DELETE /customers/{id}`
- **Descrição:** Exclui um cliente com o ID fornecido.
- **Parâmetros:**
  - `id`: ID do cliente a ser excluído.
- **Resposta de Sucesso (204 No Content):**
  - Caso o cliente tenha sido deletado com sucesso.
- **Resposta de Erro (404 Not Found):**
  - Caso o cliente com o ID fornecido não seja encontrado.

---

## Swagger - Documentação Interativa

A documentação interativa da API pode ser acessada através do Swagger. O Swagger fornece uma interface gráfica que permite visualizar todos os endpoints disponíveis e realizar chamadas de teste diretamente pela interface.

### Como acessar o Swagger:
- Após iniciar a aplicação, abra o navegador e acesse:
http://localhost:8080/swagger-ui/index.html

O Swagger exibirá todos os endpoints descritos acima com a capacidade de enviar requisições diretamente do navegador para testar a API.

## Como rodar o projeto

### Pré-requisitos

- Java 11 ou superior
- MongoDB em execução (local ou remoto)

### Passos para execução

1. **Clone o repositório:**
 ```bash
 git clone https://github.com/lima-renan/api-rest-desafio.git
 cd api-rest-desafio
 ```

2. **Compile o projeto com Maven:**
 ```bash
 ./mvnw clean install
```

3. **Execute a aplicação:**
 ```bash
 ./mvnw spring-boot:run
```

4. A aplicação estará disponível em http://localhost:8080. Você pode acessar a API ou a interface do Swagger conforme descrito.

## Docker Compose

Este projeto oferece duas configurações do Docker Compose para facilitar o desenvolvimento e os testes.

### 1. `docker-compose.yml` (Ambiente de Produção)

Este arquivo define os serviços necessários para rodar o backend da aplicação Spring Boot junto com o MongoDB. O ambiente é configurado para ser executado de maneira independente em qualquer máquina.

#### Como usar:

1. **Construir e rodar o Docker Compose**:
   Para iniciar os containers e rodar a aplicação, basta executar o comando a seguir:

   ```bash
   docker-compose up --build
   ```
Este comando irá:
- Criar o container do MongoDB.
- Criar o container do Spring Boot API.
- Expor a API na porta `8080`.
- O MongoDB estará acessível na porta `27017`.

2. **Acessar a aplicação**: Após o comando ser executado com sucesso, a aplicação estará rodando em `http://localhost:8080`.

3. **Parar os containers**: Para parar os containers, execute:

```bash
   docker-compose down
```

2. **`docker-compose-test.yml` (Ambiente de Desenvolvimento com DevContainer no VSCode)**:

Este arquivo é configurado especialmente para rodar a aplicação dentro de um DevContainer no VSCode. Ele inclui o mesmo ambiente do docker-compose.yml, mas com alguns ajustes para facilitar o desenvolvimento de dentro de um contêiner de desenvolvimento no VSCode.

#### Como usar no VSCode:

1. **Abra o repositório no VSCode.**

2. **Certifique-se de que a extensão "Remote - Containers" do VSCode está instalada.** Essa extensão permite abrir o código dentro de um container Docker.

3. **Execute o DevContainer**:
- Pressione `F1` no VSCode, digite **"Reopen in Container"** e pressione Enter.
- O VSCode irá automaticamente construir e abrir o ambiente de desenvolvimento dentro de um container Docker usando o `docker-compose-test.yml`.

#### O que muda neste arquivo:
- Ele garante que o VSCode consiga mapear e acessar todos os diretórios necessários, como o diretório de código da aplicação (`./api`), dentro do contêiner de desenvolvimento.

- O ambiente de desenvolvimento no contêiner mantém os mesmos serviços (`mongo` e `app`), mas com configurações específicas para facilitar a depuração, execução de testes e ajustes em tempo real.

#### Fontes:

- Bootcamp XPE Arquitetura de Software 2025.
- Gemini, ChatGpt e Copilot.
- Stack Overflow.
- Documentações oficiais: Java, Spring e Visual Studio Code.