Feature: Gmail Compose Feature


#Scenario: Test Compose function in Gmail
#Given user is already on Login page of gmail
#When text of left side menu bar is Mail
#Then user clicks on Compose button
#Then user enter email subject "Incubyte"
#Then user enter Message Body "Automation QA test for Incubyte"
#Then user select email in to To Field "abc@gmail.com"

Scenario Outline: Gmail Compose function

Given user is already on Login page of gmail
Then user enters "<username>" and "<password>"
Then user clicks on login button
When text of left side menu bar is "Mail"
Then user clicks on Compose button
Then user enter email subject "Incubyte"
Then user enter Message Body "Automation QA test for Incubyte"
Then user select email in to To Field "abc@gmail.com"
Then user click Send button
Then Close the browser

Examples:
	| username | password |
	| sampletext  | test@123 |
   