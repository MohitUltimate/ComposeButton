Feature: Compose Button feature
  
  Background: I am logged in to gmail account
  Given I open "https://gmail.com"
    And I am on the login page
    When I login using "Composebutton23@gmail.com" and "Compose23button!"
       
  Scenario: Verify that the compose button is getting displayed when landed on main page
    Given I am on main email landing page
    Then I am able to verify that the compose button is displayed on the email landing page
      
  Scenario: Verify user is able to send an email
  Given I am on main email landing page
  When I click on compose button
  Then New message tab is opened
  And I am able to write email with subject "Incubyte" and body "Automation QA test for Incubyte"
  And I am able to click on Send button
  
  Scenario: Verify that user is able to add to, cc and bcc from My contacts tab
  Given I am on main email landing page
  When I click on compose button
  Then New message tab is opened
  When I click on To button
  Then My Contacts tab is opened
  When I click on CC button
  Then My Contacts tab is opened
  When I click on BCC button
  Then My Contacts tab is opened
  
  Scenario: Verify all the buttons are visible in message box
  Given I am on main email landing page
  When I click on compose button
  And New message tab is opened
  Then I verify that all the buttons like Formatting options, Attach files, Insert link, etc are visible
  