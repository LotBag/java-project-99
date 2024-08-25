FROM gradle:8.8-jdk21

WORKDIR /.

COPY /. .

RUN gradle installDist

CMD java -jar build/libs/app-0.0.1-SNAPSHOT.jar