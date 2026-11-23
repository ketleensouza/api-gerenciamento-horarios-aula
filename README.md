# Sistema de Horarios de Aula

API web em Java com Spring Boot para organizacao e gerenciamento de horarios de aula.

Repositorio: https://github.com/ketleensouza/api-gerenciamento-horarios-aula

## Tecnologias

- Java 11
- Spring Boot 2.7
- Spring Web (API REST)
- Spring Data JPA (ORM)
- Spring Security (Basic Auth)
- H2 Database
- Springdoc OpenAPI (Swagger)

## Entidades

- Professores
- Disciplinas
- Turmas
- Horarios

## Funcionalidades obrigatorias

- Cadastro completo (CRUD) de professores, disciplinas, turmas e horarios
- Visualizacao de horarios por professor
- Visualizacao de horarios por turma

## Como executar

```bash
cd <pasta-do-projeto>
mvn spring-boot:run
```

## Documentacao Swagger

- Swagger UI: http://localhost:8080/swagger-ui.html
- OpenAPI JSON: http://localhost:8080/v3/api-docs

## Autenticacao basica

- Usuario: `admin`
- Senha: `admin123`

## Endpoints principais

- `GET|POST /api/professores`
- `GET|PUT|DELETE /api/professores/{id}`
- `GET|POST /api/disciplinas`
- `GET|PUT|DELETE /api/disciplinas/{id}`
- `GET|POST /api/turmas`
- `GET|PUT|DELETE /api/turmas/{id}`
- `GET|POST /api/horarios`
- `GET|PUT|DELETE /api/horarios/{id}`
- `GET /api/horarios/professor/{professorId}`
- `GET /api/horarios/turma/{turmaId}`

## Persistencia

O projeto usa ORM com Spring Data JPA. Neste ajuste foi configurado H2 em memoria para facilitar execucao local e testes.

## Testes

```bash
mvn test
```

## Relatorio

Veja o arquivo `RELATORIO_EVOLUCAO.md` para o resumo da evolucao do projeto.


