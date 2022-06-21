@workflows
#language: en
Feature: Home

  Scenario: FTN004_CheckDescriptionHome
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioPrueba"
    And I click on "Inicio" in the header
    Then I check the main description of the page

  Scenario Outline: FTN005_CheckHeaderIcons
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioPrueba"
    And I click on "Inicio" in the header
    Then I check the icon "<icon>"

    Examples:
      | icon             |
      | book             |
      | house            |
      | magnifying-glass |
      | pencil           |
      | user             |

  Scenario: FTN006_CheckFooter
    Given I am on the home page
    When I click on "Login" in the header
    And access the wiki and login with user "usuarioPrueba"
    When I click on "Inicio" in the header
    Then I check the footer of the page