# Ejemplos de Junit 5 y Cucumber

## lanzamiento mvn test
mvn test
mvn -Dtest=example.SimpleTest test
### ejecución de tag integracion
mvn test -Dgroups="integracion"
### ejecución de tag varios tag
mvn test -Dgroups="integracion | aceptacion"
## no ejecutes este tag api
mvn test -Dgroups="!api"
