git pull origin dev && \
mvn clean compile package -DskipTests && \
docker-compose down && \
docker build -t reldyn/rd-baas-idv-onfido-service . && \
docker image prune -f && docker-compose up -d && \
docker logs -f rd-baas-idv-onfido-service
