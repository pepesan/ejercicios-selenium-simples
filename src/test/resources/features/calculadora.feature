Feature: Calculadora
  Pruebas de una calculadora que hace sumas
  Scenario:
    Given Tengo un objeto de la calculadora
    When hago una suma de 1 y 1
    Then tengo un resultado de 2


  Scenario:
    Given Tengo un objeto de la calculadora
    When hago una suma de 2 y 3
    Then tengo un resultado de 5

  Scenario:
    Given Tengo un objeto de la calculadora
    When suma 2 y 3
    Then el resultado es 5