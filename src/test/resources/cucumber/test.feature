Feature: Test Contracts

  Scenario Outline: <scenario name>
    Given employee has a "<type>" contract with a base salary of <base salary>
    When margin is <margin>
    Then the net salary is <net salary>
    Examples:
      | scenario name       | type       | base salary | margin | net salary |
      | normal contract     | normal     | 1000        | 0      | 1000       |
      | referent contract   | referent   | 1500        | 45000  | 2200       |
      | consulting contract | consulting | 1500        | 45000  | 3000       |
