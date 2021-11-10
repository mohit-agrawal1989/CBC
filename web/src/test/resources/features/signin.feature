@all
Feature: User Sign In feature


  #Scenario: Sign In
    #Given I am on CBS sign in page on 12345
    #When I enter the email and password as "ltest" and "aaaaaaa"
    #And I click continue
    #Then I am taken to the homepage on 12345
#
  #@signin
  #Scenario Outline: I should be able to sign in 12345
    #Given I am on CBS sign in page on <testcase>
    #When I enter the email and password as "<email>" and "<password>"
    #And I click continue
    #Then I am taken to the homepage on <testcase>
    #
    #Examples:
      #| email                    | password   |   testcase |
      #| ltestprod@ltest.com      | aaaaaa     |   12345    |
      #| ltestprod20@ltest.com    | aaaaaa     |   54321    |
      #| ltestprod5@ltest.com     | aaaaaa     |   12333    |
      #| ltestprod5@ltest.com     | aaaaaa     |   44556    |

  #Start at URL https://www.cbs.com/
  #Click on 'Try CBS All Access' CTA
  #User is taken to happy upsell page https://www.cbs.com/all-access/?intcid=CIAb4ac575

#    @failed
#	Scenario: C1461573 Try CBS All Access CTA functionality
#	Given I am on CBS Digital sign in page on 12345
#	When I enter the email and password as "websr@gmail.com" and "aaaaaa"
#    And I click continue
#    Then I am taken to the homepage on 12345


  @signin
  Scenario: C1504073 "Sign In" visibility
    Given I navigate to the CBS Digital website
    Then Sign In Options button is displayed

  @signin
  Scenario: C1504074 "Sign In" functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    Then I am at the sign in page

  @signin
  Scenario: C1504075 Empty Password field
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "cbstester@gmail.com" and ""
    Then Continue CTA is disabled

  @signin
  Scenario: C1504076 Incorrectly filled out Password field
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "aqatv001p@gmail.com" and "bbbbbb"
    And I click continue
    Then Error message Invalid email and or password appears above text boxes

  @signin
  Scenario: C1504077 Empty Email field
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "" and "bbbbbb"
    Then Continue CTA is disabled

  @signin
  Scenario: C1504078 Incorrectly filled out Email field
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "aqatv001p" and "bbbbbb"
    And I click continue
    Then Error message appears with Email text box highlighted red and Valid email required. text below

  @signin
  Scenario: C1504079 Correctly filled out Sign In form
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    When I enter the email and password as "aqatv001p@gmail.com" and "aaaaaa"
    And I click continue
    Then I am taken to the homepage on 12345

  @signin
  Scenario: C1504080 Forgot Password? visibility
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    Then Forgot Password link is legible

  @signin
  Scenario: C1504081 Forgot Password? functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    Then I am at the Forgot Password page

  @signin
  Scenario: C1504081 Forgot Password? functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    And I am at the Forgot Password page
    Then Send Email is legible

  @signin
  Scenario: C1504083 Send Email CTA functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    And I am at the Forgot Password page
    And I enter the email "tttest@mail.ru"
    And I click on Send Email
    Then Send Email becomes Gray
    And the success message should come up
#  And the user is redirected to cbs.com after 15 seconds
    #per Manual QA, the user is no longer redirected

#  @waitOnRestAPIImplementation
#  Scenario: C1504084 Corresponding Reset Password Email is available
#  Given I navigate to the CBS Digital website
#	When I click on Sign In
#  And I am at the sign in page
#  And I click on Forgot Password
#  And I am at the Forgot Password page
#  And I enter the email "tttestdigital@gmail.com"
#  And I click on Send Email
#  And I log in to gmail with the username "tttestdigital@gmail.com" and password "o12341234"

  @signin
  Scenario: C1504086 Incorrectly filled out Email field
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    And I am at the Forgot Password page
    And I enter the email "test"
    And I click on Send Email
    Then User views error message 'Valid email required.' appears below text box
    And the forgot password error message is red

  @signin
  Scenario: C1504087 Cancel visibility
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    And I am at the Forgot Password page
    Then Cancel is legible

  @signin
  Scenario: C1504088 Cancel functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Forgot Password
    And I am at the Forgot Password page
    And Cancel is legible
    And I click on Cancel
    Then I am at the sign in page

  @signin
  Scenario: C1504089 "Sign In with TV Provider" CTA visibility
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    Then Sign In With TV Provider is presented

  @signin
  Scenario: C1504090 "Sign In with TV Provider" CTA functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Sign In with TV Provider
    Then I am at the Sign In with TV Provider page

  @signin
  Scenario: C1504060 "Sign Up" visibility
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    Then Sign Up CTA on the right corner is legible
#
#  @signin, @smoke
#  Scenario: C1503715 P+ user can't Sign In on cbs.com
#    Given I navigate to the CBS Digital website
#    When I click on Sign In
#    And I am at the sign in page
#    When I enter the email and password as a P+ user
#    And I click continue
#    Then Error message Invalid email and or password appears above text boxes

  
  
  