Feature: Prueba de Día
  Descripción de Pruebas

  Scenario: ¿Que dia es?
    Given hoy es Lunes
    When compruebo el dia
    Then Meto el valor "Martes"