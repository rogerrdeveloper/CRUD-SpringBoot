# Cadastro de Usuários (API RESTful)

Este é um projeto de estudo que implementa uma API RESTful completa (CRUD) para cadastro e gerenciamento de usuários. O projeto foi desenvolvido em **Java** utilizando o framework **Spring Boot** e adota as melhores práticas de divisão em camadas e persistência de dados.

## Tecnologias Utilizadas

* **Java 17** 
* **Spring Boot 4.0.6**
* **Spring Data JPA** (Persistência e mapeamento objeto-relacional)
* **Banco de Dados H2** (Banco em memória para testes e desenvolvimento rápido)
* **Lombok** (Produtividade e eliminação de código boilerplate)
* **Maven** (Gerenciador de dependências e build)

## Arquitetura do Projeto

O projeto segue o padrão de **Arquitetura em Camadas**, garantindo uma separação clara de responsabilidades:

1.  **`controller`**: Camada de entrada da aplicação. Expõe os endpoints REST e manipula as requisições HTTP.
2.  **`business` (Service)**: Camada que contém as regras de negócio da aplicação e orquestra as operações.
3.  **`infrastructure.repository`**: Camada de persistência que faz a comunicação direta com o banco de dados via Spring Data JPA.
4.  **`infrastructure.entitys`**: Camada que representa as tabelas do banco de dados como objetos Java mapeados pelo Jakarta Persistence.

---

## Endpoints da API

A API expõe os seguintes endpoints sob a rota base `/usuario`:

| Método | Endpoint | Parâmetros | Descrição | Corpo da Requisição (JSON) |
| :--- | :--- | :--- | :--- | :--- |
| **POST** | `/usuario` | Nenhum | Cadastra um novo usuário. | `{"nome": "Nome", "email": "email@exemplo.com"}` |
| **GET** | `/usuario` | `?email=...` (Query Param) | Busca um usuário pelo e-mail. | Vazio |
| **PUT** | `/usuario` | `?email=...` (Query Param) | Atualiza os dados de um usuário existente. | `{"nome": "Novo Nome", "email": "novo@email.com"}` |
| **DELETE** | `/usuario` | `?email=...` (Query Param) | Remove um usuário pelo e-mail. | Vazio |

---

## Configuração do Banco de Dados (H2)

O projeto está configurado para utilizar o banco de dados em memória H2. Para visualizar os dados em tempo real através do navegador, certifique-se de que as seguintes propriedades estão ativas no seu arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Ativa o Console Web do H2
spring.h2.console.enabled=true
