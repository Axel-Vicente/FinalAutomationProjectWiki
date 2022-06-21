@workflows
#language: en
Feature: Routing

  Scenario Outline: FTN001_CheckHeaderNavigation
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioPrueba"
    And I click on "<nameHeader>" in the header
    Then I check that I'm in "<url>"

    Examples:
      | nameHeader  | url     |
      | Inicio      | home    |
      | Busqueda    | search  |
      | Contactanos | contact |