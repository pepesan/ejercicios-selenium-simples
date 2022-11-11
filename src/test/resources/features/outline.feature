Feature: Calculator
  As a user
  I want to use a calculator to add numbers
  So that I don't need to add myself

  Scenario Outline: Add two numbers <num1> & <num2>
    Given Tengo un objeto de la calculadora
    When suma <num1> y <num2>
    Then el resultado es <total>

    Examples:
      | num1  | num2  | total |
      | -2    | 3     | 1     |
      | 10    | 15    | 25    |
      | 99    | -99   | 0     |
      | -1    | -10   | -11   |