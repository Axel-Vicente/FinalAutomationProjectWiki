@workflows
#language: en
Feature: Incidence

  Scenario: FTN010_SendMessageToContact
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioPrueba"
    And I click on "Contactanos" in the header
    Then I fill and send the form

  Scenario: FTN011_CheckIncidences
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioCapibara"
    And I click on "Incidencias" in the header
    Then I check de incidences