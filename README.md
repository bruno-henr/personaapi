# Desenvolvendo um sistema de gerenciamento de pessoas em API REST com Spring Boot

Nesse projeto é possivel realizar o cadastro de pessoas e fazer seu gerenciamento utilizando apenas uma API REST com Spring Boot. Utilizado um banco relacional para armazenar os dados.

Para utilizar esse projeto só basta clonar esse projeto e ir até o diretorio e rodar:
```
mvn spring-boot:start
```
Após rodar o comando acima, irá baixar todas as dependencias e iniciar o projeto

Para criar uma pessoa, basta criar uma request POST para o seguinte endereço:
```
http://localhost:8080/api/v1/people
```
