@workflows
#language: en
Feature: Home

  Scenario: FTN004_CheckDescriptionHome
#    Given access the wiki and login
    Given I am on the home page
    When I click on "Inicio" in the header
    Then I check the main description of the page