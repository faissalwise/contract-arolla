Feature: Test Contracts

  Scenario Outline: any contract
    Given employee has a "<type>" contract with a base salary of <base salary>
    When margin is <margin>
    Then the net salary is <net salary>
    Examples:
      | type       | base salary | margin | net salary |
      | normal     | 1000        | 0      | 1000       |
      | referent   | 1500        | 45000  | 2200       |
      | consulting | 1500        | 45000  | 3000       |
