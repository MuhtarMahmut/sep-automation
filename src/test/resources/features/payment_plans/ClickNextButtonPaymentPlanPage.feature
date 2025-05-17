@sep9
Feature: Click on the next button on payment plans page

  As a customer, I should be able to click on the next button on step 2 when I select a plan.

  Background:
    Given the user is on the enrollment page "taws"
    And the user has completed step one with valid information
    And the user is on step two of the enrollment process


  Scenario: The next button on step two is displayed but inactive by default
    Then the next button should be displayed
    But the next button should be inactive by default

  Scenario: The next button becomes active after the user selects a payment plan
    When the user selects the Upfront payment plan
    Then the next button becomes active
