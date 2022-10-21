Feature: Prueba de Día
  Descipción de Pruebas

  Scenario: ¿Que dia es?
    Given hoy es Lunes
    When compruebo el dia
    Then Meto el valor "Martes"