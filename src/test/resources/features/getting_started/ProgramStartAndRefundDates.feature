@sep19
Feature: Program start dates and Refund dates

  As a user, I want to see the program start dates and refund policy details
  before enrolling so that I can make informed decisions.

  Scenario Outline: Program start date and refund date should be correct dates
    Given the user is on the enrollment page "<program code>"
    Then the start date for the program is displayed
    And the refund date for the program is displayed
    Then the displayed program start date of "<program code>"  is correct
    Then the displayed program refund date of "<program code>" is correct
    Examples:
      | program code |
      | taws         |
      | rfep         |
      | jfft         |
      | jss          |