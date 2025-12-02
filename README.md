# Workshop Spring Boot 2 com MongoDB

Estou retomando meus estudos em Java com Spring Boot, com um projeto RESTful utilizando Spring Boot 2 JPA e Hibernate! Acredito que a melhor forma de evoluir é revisitar e reconstruir, peguei um projeto que fiz em Julho de 2024 como modelo, dessa vez utilizei o banco MongoDB e também adicionei outras implementações!


## Tecnologias Utilizadas

- **Spring Boot 2**
- **Spring Data JPA**
- **MongoDB**
- **Swagger**
- **Maven**


## Praticas adotadas

- **SOLID**
- **DRY**
- **YAGNI**
- **KISS**


## API

A API oferece operações CRUD para gerenciamento de recursos. A documentação completa da API pode ser acessada via Swagger. [Swagger UI](http://localhost:8080/swagger-ui.html) 


### Endpoints Principais

- **GET USERS**
- `http://localhost:8080/users` - Lista todos os usuários

- **GET USER**
- `http://localhost:8080/users/{id}` - Listar usuário por ID

- **UPDATE USER**
- `http://localhost:8080/users/{id}` - Atualizar usuário

- **GET POSTS**
- `http://localhost:8080/users/{id}/posts` - Listar os posts de um usuário

- **DELETE USER**
- `http://localhost:8080/users/{id}` - Deletar usuário

- **GET TEXT COM QUERY METHODS**
- `http://localhost:8080/posts/fullsearch?text=Partiu&minDate=2025-11-21&maxData=2025-11-30` - Procurar um texto com parâmetros


## Como Rodar a Aplicação

1. **Clone o repositório:**
 - git clone https://github.com/Guilherme0035/workshopmongo.git

2. **Entrar na pasta:**
 - cd workshopmongo

3. **Compile a aplicação:**
 - mvn spring-boot:run


## Como Testar os Endpoints

1. **Via Swagger:**
 - Acesse a documentação interativa do Swagger em [Swagger UI](http://localhost:8080/swagger-ui.html) para testar os endpoints da API.

2. **Via Postman ou outra ferramenta de sua preferência:**
- Configure os endpoints e envie requisições para os URLs listados na seção de endpoints principais.
