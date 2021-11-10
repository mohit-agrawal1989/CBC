@all
Feature: Hamburger

  @hamburger

  Scenario: C1503672"Hamburger menu is displayed"
    Given I navigate to the CBS Digital website
    Then I observe on smaller screens: hamburger menu is displayed on far left instead of the nav menu is displayed