@all
Feature: Sign_Up


#Background:
#Given I am on 'interstitial/1/' page

#@SmokeTest @signup
  #Scenario: SignUp: 
  #When I Click Continue Button
  #Then I am on Pick A Plan page on test 2224
  #When I Click Continue Button
  #Then I am on interstitial 2 page on test 2225
  #When I Click Continue Button
  #Then I am on Create An Account page on test 2226
  #When I fill my information on Create An Account page
  #When I Click Continue Button  
  #Then I am on interstitial 3 page on test 2227
  #When I Click Continue Button    
  #When I fill my information on Payment page
  #And I Click Submit Button  
 #Then I am on Show Picker page on test 2228


  @signup
  Scenario: C1504061 "Sign Up" functionality
    Given I navigate to the CBS Digital website
    When I click on Sign In
    And I am at the sign in page
    And I click on Sign Up
