# Ejemplos de Junit 5 y Cucumber

## lanzamiento mvn test
mvn test
mvn -Dtest=com.cursosdedesarrollo.app.CalculadoraTest test
# lanzamiento test de cucumber
mvn test -Dtest=com.cursosdedesarrollo.app.cucumber.RunCucumberTest

### ejecución de tags en cucumber
mvn test -Dtest=com.cursosdedesarrollo.app.cucumber.RunCucumberTest -Dgroups="cursos | @busqueda"
### ejecución de un tag
mvn test -Dgroups="smoke"
### ejecución de tag varios tag
mvn test -Dgroups="integracion | aceptacion"
## no ejecutes este tag api
mvn test -Dgroups="!api"

# Lanzamiento de Grid
Descarga el selenium server y lanzalo con:
java -jar selenium-server-xxx.jar standalone