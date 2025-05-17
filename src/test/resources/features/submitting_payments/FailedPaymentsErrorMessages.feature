@sep25
Feature: Failed payments and error messages

  As a user, I want to be informed when my payment is failed.

  Background:
    Given the user is on the enrollment page "taws"
    And the user already completed step one and selected Upfront payment option

  Scenario Outline: Entering invalid card information
    When the user enters invalid card number "<invalid_card_number>"
    Then the user should see an error message saying "Your card number is invalid."

    Examples:
      | invalid_card_number |
      | 1111111111111111    |
      | 1212121212121121    |
      | 3232323232323232    |

  @wip
  Scenario Outline: Entering incomplete card information
    When the user enters an incomplete card number "<incomplete_card_number>"
    Then the user should see an error message saying "Your card number is incomplete."

    Examples:
      | incomplete_card_number |
      | 1234                   |
      | 5678901                |