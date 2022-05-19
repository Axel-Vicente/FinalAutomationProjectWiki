@workflows
#language: en
Feature: Routing

  Scenario Outline: FTN001_CheckHeaderNavigation
#    Given access the wiki and login
    Given I am on the home page
    When I click on "<nameHeader>" in the header
    Then I check that I'm in "<url>"

    Examples:
      | nameHeader | url    |
      | Inicio     | home   |
      | Busqueda   | search |
      | Editar     | edit   |
      | Login      | login  |