@workflows
#language: en
Feature: Login

  Scenario: FTN007_CheckCancelLogin
    Given I am on the home page
    When I click on "Login" in the header
    And I cancel the login

  Scenario: FTN008_CheckLoginFailed
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioFallido"
    Then I should see the error message

  Scenario: FTN009_CheckUserAdmin
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioCapibara"
    Then I check the admin user