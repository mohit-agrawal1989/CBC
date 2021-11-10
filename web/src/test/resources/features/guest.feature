@all @jkhsfdg
Feature: Guest

  @guest

  Scenario: C1503683 "The user name on the dropdown menu displays "Guest" for TV Provider w/o Name user"

    Given I navigate to the CBS Digital website
    When I update access as "Ghost"
    Then I observe user name on the dropdown menu displays Guest for TV Provider Name user