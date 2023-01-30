Feature: Test Contracts

  Scenario Outline: all contract
    Given employee joined on "<date>"
    And employee validated is "<validated>"
    And base salary is <base salary>
    And today is "<today>"
    When revenue is <revenue>
    Then the net salary is <net salary>
    Examples:
      | date       | today      | validated | base salary | revenue | net salary |
      | 16/01/2023 | 16/01/2023 | true      | 90000       | 189000  | 91500      |
      | 16/01/2021 | 16/01/2023 | false     | 75000       | 0       | 75000      |
      | 16/01/2020 | 16/01/2023 | false     | 80000       | 100000  | 80000      |
      | 16/01/2020 | 16/01/2023 | false     | 80000       | 173000  | 80700      |