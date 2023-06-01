FROM openjdk:17
COPY ./out/production/DevopsLab1/ /tmp/
WORKDIR /tmp
ENTRYPOINT ["java", "Main", "Complex", "ComplexIO", "Matrix", "MatrixIO"]