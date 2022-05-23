@workflows
#language: en
Feature: Search Engine

  Scenario Outline: FTN002_CheckSearchEngine
#    Given access the wiki and login
    Given I am on the home page
    When I click on "Busqueda" in the header
    And I search for a "<nameMonster>"
    Then I should see "<nameMonster>", "<life>", "<hit dices>", "<type>", "<experience>", "<hit points>" in the search results

    Examples:
      | nameMonster        | life | hit dices | type       | experience | hit points |
      | Adult Black Dragon | 195  | 17d12     | dragon     | 11500      | 195        |
      | Goblin             | 7    | 2d6       | humanoid   | 50         | 7          |
      | Aboleth            | 135  | 18d10     | aberration | 5900       | 135        |
      | Fire Giant         | 162  | 13d12     | giant      | 5000       | 162        |

  Scenario: FTN003_CheckSearchEngineResultsDefaultText
#   Given access the wiki and login
    Given I am on the home page
    When I click on "Busqueda" in the header
    Then I check that the text "Busca algo" does not disappear after a search