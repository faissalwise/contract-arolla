Feature: Test Contracts

  Scenario Outline: any contract
    Given employee has a "<type>" contract with a base salary of <base salary>
    When revenue is <revenue>
    Then the net salary is <net salary>
    Examples:
      | type       | base salary | revenue | net salary |
      | normal     | 75000       | 0       | 75000      |
      | referent   | 80000       | 100000  | 80000      |
      | referent   | 80000       | 173000  | 80700      |
      | consulting | 90000       | 189000  | 91500      |

  Scenario Outline: find contract type
    Given employee joined on "<date>"
    And employee validated is "<validated>"
    When determine contract type for "<today>"
    Then contract type is "<type>"
    Examples:
      | date       | today      | validated | type       |
      | 16/01/2023 | 16/01/2023 | true      | consulting |
      | 16/01/2021 | 16/01/2023 | false     | normal     |
      | 16/01/2020 | 16/01/2023 | false     | referent   |