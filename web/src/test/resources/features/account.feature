@all @asdasdasdf
Feature: Account

	@account @cbsnstream
	Scenario Outline: C1503663 Email field displays current email
		Given I navigate to the CBS Digital website
		When I update access as "<userType>"
		And I navigate to the CBS Digital website
		And I am at the Home page
#	And I click on my username
#	Then I am at the Account page
#	And the email should match the "<userType>"

		Examples:
			| userType   |
			| Registered |
#	|AuthZ|


	
	
	