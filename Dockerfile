FROM tomcat:8.5.73

ADD . /code
WORKDIR /code
COPY target/*.war $CATALINA_HOME/webapps/zitrus-test.war
EXPOSE 8080