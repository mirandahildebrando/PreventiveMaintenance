Manutenção Preventiva de Veículos (API)

Este é um projeto de API RESTful desenvolvido com Spring Boot 3 para gerenciar veículos e calcular a quilometragem da próxima revisão preventiva usando o conceito de polimorfismo e herança.

Tecnologias Utilizadas

Linguagem: Java 17+

Framework: Spring Boot 3.x

Banco de Dados: H2 Database (em memória, ideal para desenvolvimento e testes)

ORM: Spring Data JPA / Hibernate

Utilitários: Lombok

Documentação da API: Springdoc OpenAPI (Swagger UI)

Configuração e Inicialização

O projeto utiliza o banco de dados H2 em memória, o que significa que todos os dados são perdidos quando a aplicação é encerrada.

Pré-requisitos

Java Development Kit (JDK) 17 ou superior

Maven ou Gradle (se usar a versão com base em Maven, basta o wrapper mvnw)

Como Executar

Clone o repositório: (Assumindo que está em um repositório Git)

git clone <https://github.com/mirandahildebrando/PreventiveMaintenance>

cd manutencao-preventiva


Compile e execute:

./mvnw spring-boot:run


A aplicação estará rodando em http://localhost:8080.

Documentação da API (Swagger UI)

Após iniciar a aplicação, você pode acessar a interface interativa do Swagger para testar todos os endpoints:

URL do Swagger UI: http://localhost:8080/swagger-ui.html

Endpoints da API

A API principal está sob a rota /vehicles. Os endpoints de criação são específicos para garantir a correta deserialização do objeto.

Criação (POST)

Para criar um novo veículo, use o endpoint dedicado para o seu tipo. O corpo da requisição deve ser application/json.

Tipo de Veículo

Endpoint

Exemplo de Body

Caminhão (Truck)

POST /vehicles/truck

{"mark": "Volvo", "model": "FH 540", "currentMileage": 2000.0, "axes": 4}

Carro (RideCar)

POST /vehicles/ridecar

{"mark": "Toyota", "model": "Corolla", "currentMileage": 1000.0, "passangers": "5"}

Moto (Motorcycle)

POST /vehicles/motorcycle

{"mark": "Honda", "model": "CG 160", "currentMileage": 4000.0, "cylinderCapacity": 160}

Consulta e Cálculo (GET)

Função

Endpoint

Descrição

Buscar Veículo

GET /vehicles/{id}

Retorna os detalhes do veículo (e seu subtipo específico) por ID.

Próxima Revisão

GET /vehicles/{id}/next-review

Calcula a quilometragem da próxima manutenção usando o intervalo específico do tipo de veículo (Polimorfismo).

Exemplo de Fluxo

Criação (POST /vehicles/truck):

{ "currentMileage": 5000.0, "mark": "Ford", "model": "F-250", "axes": 2 }


Retorno: 201 Created com o corpo do veículo e seu ID (ex: id: 1).

Cálculo da Revisão (GET /vehicles/1/next-review):

Cálculo (Truck): $5000\ \text{km} + 15000\ \text{km} = 20000\ \text{km}$

Retorno: A proxima revisao do veiculo com ID 1 deve ser feita aos 20000.00 km.