FROM openjdk:jre-alpine

ADD portfolio-business/target/portfolio-hollow-thorntail.jar /opt/hollow-thorntail.jar
ADD portfolio-business/target/portfolio.war /opt/portfolio.war
ADD portfolio-business/src/main/filters/project-defaults.yml /opt/project-defaults.yml

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/opt/hollow-thorntail.jar", "-Djava.net.preferIPv4Stack=true", "/opt/portfolio.war", "-s", "/opt/project-defaults.yml"]