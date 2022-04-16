Feature: login
  As a user
  I should login and use the application

  Background:
    Given I open homepage "https://www.amazon.co.uk/" with title as "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more"

  @login
  Scenario: Verify login with valid username and password
    When I click sign button
    And I enter username "tmtntesting@gmail.com"
    And I click continue
    And I enter password"Testing@22"
    And I click sign-In button
    Then I should be landing on the login page with heading "Hello, Adhee"

  @login
  Scenario: Verify login with invalid username
    When I click sign button
    And I enter username "tmtnting@gmail.com"
    And I click continue
    Then I shouldn't be allowed login with message "We cannot find an account with that e-mail address"

  @login
  Scenario: Verify login with valid username and invalid password
    When I click sign button
    And I enter username "tmtntesting@gmail.com"
    And I click continue
    And I enter password"Tesng@22"
    And I click sign-In button
    Then I shouldn't be allowed login with message "To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below."

  @login
  Scenario: Verify login with no username
    When I click sign button
    And I enter username ""
    And I click continue
    Then I shouldn't be allowed login message "Enter your e-mail address or mobile phone number"