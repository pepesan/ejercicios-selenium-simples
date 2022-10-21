Feature: Navegación
  Descripción de Pruebas de Navegación

  Scenario: Navegando por la web
    Given Abro la pagina
    When busco "Software"
    Then Encuentro el texto "Computer software"