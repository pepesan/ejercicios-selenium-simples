Feature: Navegación
  Descripción de Pruebas de Navegación

  Scenario: Navegando por la web
    Given Abro la pagina a buscar
    When busco  poniendo "docker"
    Then Encuentro el titulo "Search results for: docker"