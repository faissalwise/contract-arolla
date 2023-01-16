Feature: Test Contracts

  Scenario Outline: any contract
    Given employee has a "<type>" contract with a base salary of <base salary>
    When revenue is <revenue>
    Then the net salary is <net salary>
    Examples:
      | type       | base salary | revenue | net salary |
      | normal     | 75000       | 0       | 75000      |
      | referent   | 80000       | 173000  | 80700      |
      | consulting | 90000       | 189000  | 91500      |
