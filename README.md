# API de Board de Tarefas
Uma API RESTful para gerenciar quadros de tarefas no estilo Kanban, permitindo a criação de boards, colunas e cards. As tarefas podem ser movidas entre as colunas, simulando o fluxo de trabalho de um projeto.

## 🚀 Tecnologias
* Java 17+
* Spring Boot 3+: Framework para a construção da API.
* Maven: Gerenciamento de dependências.
* PostgreSQL: Banco de dados relacional.
* Spring Data JPA: Abstração para a camada de persistência.
* Flyway: Gerenciamento de migrations do banco de dados.

## SpringDoc OpenAPI: Documentação interativa da API.

## 🛠️ Funcionalidades Implementadas
### Estrutura
* Modelo de Dados: Entidades Board, Lane e Task com relacionamentos definidos.
* Camadas: Separação clara entre Controller, Service, Repository e Model.
* Persistência: Integração com o PostgreSQL e uso de Flyway para garantir a consistência do schema do banco de dados.

### Endpoints
* POST /api/boards: Cria um novo board com colunas padrão ("A Fazer", "Em Andamento", "Concluído" e "Pausado").
* POST /api/lanes/{laneId}/tasks: Adiciona um novo card (tarefa) a uma coluna específica.
* PUT /api/lanes/{taskId}/move: Move um card para uma nova coluna e posição.

### 💡 Próximos Passos e Melhorias Futuras
O projeto base está funcional, mas pode ser expandido com diversas funcionalidades para se tornar uma aplicação mais completa.

### Otimizações
* Tratamento de Exceções: Implementar um GlobalExceptionHandler para retornar respostas de erro padronizadas (ex: 404 Not Found, 400 Bad Request).
* Segurança: Adicionar autenticação e autorização para proteger os endpoints da API (e.g., Spring Security com JWT).
* Validação de Dados: Adicionar validação de entrada nos DTOs para garantir que os dados recebidos sejam válidos (e.g., not blank, size).

### Novas Funcionalidades
* Endpoints de Leitura e Edição:
* GET /api/boards/{boardId}: Buscar um board por ID.
* GET /api/lanes/{laneId}/tasks: Listar todas as tarefas de uma coluna.
* PUT /api/tasks/{taskId}: Editar uma tarefa existente.
* DELETE /api/boards/{boardId}: Excluir um board.

### Subtarefas: Adicionar uma entidade Subtask para permitir a criação de tarefas menores dentro de um card.

### Membros e Comentários:

* Permitir a atribuição de membros a um board ou a uma tarefa.
* Adicionar um sistema de comentários para a colaboração em cada card.
* Arquivos Anexados: Habilitar o upload de arquivos para os cards.
* Webhooks: Implementar webhooks para notificar outros serviços sobre alterações nos dados (ex: tarefa movida, comentário adicionado).

### ⚙️ Como Executar o Projeto
* Pré-requisitos: Certifique-se de ter o Docker e o Docker Compose instalados.
* Configurar o Banco de Dados: No seu arquivo application.properties, configure as credenciais de acesso ao PostgreSQL.
* Executar a Aplicação: Compile e execute o projeto com Maven.

```bash
# Para compilar e rodar
mvn spring-boot:run
````

* Acessar a Documentação: Abra seu navegador e acesse a interface interativa do Swagger para testar os endpoints.

````bash
http://localhost:8080/swagger-ui.html
````