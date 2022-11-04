# Ejemplos de Junit 5 y Cucumber

## lanzamiento mvn test
mvn test
mvn -Dtest=com.cursosdedesarrollo.app.CalculadoraTest test
### ejecución de tag integracion
mvn test -Dgroups="integracion"
### ejecución de tag varios tag
mvn test -Dgroups="integracion | aceptacion"
## no ejecutes este tag api
mvn test -Dgroups="!api"
