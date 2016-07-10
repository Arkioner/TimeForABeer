Feature: Open a tab

  Scenario: Customer open a tab in a table with a waiter
    Given a customer and the waiter "john" are at the table 42
    When customer ask waiter to "openTab"
    Then the tab is "opened"
    And the tab table is 42
    And the tab waiter is "john"