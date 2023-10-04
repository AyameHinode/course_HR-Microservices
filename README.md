# Criando e testando containers Docker

# Criar rede docker para sistema hr
docker network create hr-net

# Testando perfil dev com Postgresql no Docker
docker pull postgres12-alpine

docker run -p 54325432 --name hr-worker-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_worker postgres12-alpine

docker run -p 54325432 --name hr-user-pg12 --network hr-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_hr_user postgres12-alpine

# hr-config-server
FROM openjdk11
VOLUME tmp
EXPOSE 8888
ADD .targethr-config-server-0.0.1-SNAPSHOT.jar hr-config-server.jar
ENTRYPOINT [java,-jar,hr-config-server.jar]
mvnw clean package

docker build -t hr-config-serverv1 .

docker run -p 88888888 --name hr-config-server --network hr-net -e GITHUB_USER=acenelio -e GITHUB_PASS= hr-config-serverv1

# hr-eureka-server
FROM openjdk11
VOLUME tmp
EXPOSE 8761
ADD .targethr-eureka-server-0.0.1-SNAPSHOT.jar hr-eureka-server.jar
ENTRYPOINT [java,-jar,hr-eureka-server.jar]
mvnw clean package

docker build -t hr-eureka-serverv1 .

docker run -p 87618761 --name hr-eureka-server --network hr-net hr-eureka-serverv1

# hr-worker
FROM openjdk11
VOLUME tmp
ADD .targethr-worker-0.0.1-SNAPSHOT.jar hr-worker.jar
ENTRYPOINT [java,-jar,hr-worker.jar]
mvnw clean package -DskipTests

docker build -t hr-workerv1 .

docker run -P --network hr-net hr-workerv1

# hr-user
FROM openjdk11
VOLUME tmp
ADD .targethr-user-0.0.1-SNAPSHOT.jar hr-user.jar
ENTRYPOINT [java,-jar,hr-user.jar]
mvnw clean package -DskipTests

docker build -t hr-userv1 .

docker run -P --network hr-net hr-userv1

# hr-payroll
FROM openjdk11
VOLUME tmp
ADD .targethr-payroll-0.0.1-SNAPSHOT.jar hr-payroll.jar
ENTRYPOINT [java,-jar,hr-payroll.jar]
mvnw clean package -DskipTests

docker build -t hr-payrollv1 .

docker run -P --network hr-net hr-payrollv1

# hr-oauth
FROM openjdk11
VOLUME tmp
ADD .targethr-oauth-0.0.1-SNAPSHOT.jar hr-oauth.jar
ENTRYPOINT [java,-jar,hr-oauth.jar]
mvnw clean package -DskipTests

docker build -t hr-oauthv1 .

docker run -P --network hr-net hr-oauthv1

# hr-api-gateway-zuul
FROM openjdk11
VOLUME tmp
EXPOSE 8765
ADD .targethr-api-gateway-zuul-0.0.1-SNAPSHOT.jar hr-api-gateway-zuul.jar
ENTRYPOINT [java,-jar,hr-api-gateway-zuul.jar]
mvnw clean package -DskipTests

docker build -t hr-api-gateway-zuulv1 .

docker run -p 87658765 --name hr-api-gateway-zuul --network hr-net hr-api-gateway-zuulv1

# Alguns comandos Docker
Criar uma rede Docker

docker network create nome-da-rede
Baixar imagem do Dockerhub

docker pull nome-da-imagemtag
Ver imagens

docker images
Criarrodar um container de uma imagem

docker run -p porta-externaporta-interna --name nome-do-container --network nome-da-rede nome-da-imagemtag 
Listar containers

docker ps

docker ps -a
Acompanhar logs do container em execução

docker logs -f container-id