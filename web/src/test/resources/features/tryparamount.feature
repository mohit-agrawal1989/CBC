@all
Feature: Try Paramount+

  @tryparamount+


  Scenario: C1503687""Try Paramount+" CTA appears for all user types"

    Given I navigate to the CBS Digital website
    When I Browse the site as an anonymous user and observe the CTA for Try Paramount+
#    When I click on sign in button

#    And I enter the email and password in sign in page
    And I Log in with unbinded registered user and Observe the CTA for Try Paramount+ and sign out
    And I Log in with a binded registered user and TV Provider and click Start Watching


