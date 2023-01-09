Feature: Test Contracts

  Scenario: Referring contract
    Given employee has a "normal" contract with a base salary of 1000
    When employee has received his salary
    Then the net salary is 1000