Feature: Datatables
  Descripción de datatables
  Scenario:
    Given the following animals:
      | cow   |
      | horse |
      | sheep |
    When we add a "dog"
    Then we have 4 animals