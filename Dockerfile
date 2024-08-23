FROM gradle:8.8-jdk21

WORKDIR /demo

COPY /demo .

RUN gradle installDist

CMD ./build/install/app/bin/demo