@workflows
#language: en
Feature: Search Engine

  Scenario Outline: FTN002_CheckSearchEngine
#    Given access the wiki and login
    Given I am on the home page
    When I click on "Busqueda" in the header
    When I search for a "<nameMonster>"
    Then I should see "<nameMonster>", "<life>", "<dices>" in the search results

    Examples:
      | nameMonster        | life | dices |
      | Adult Black Dragon | 195  | 17d12 |
      | Goblin             | 7    | 2d6   |
      | Aboleth            | 135  | 18d10 |
      | Fire Giant         | 162  | 13d12 |

  Scenario: FTN003_CheckSearchEngineResultsDefaultText
#   Given access the wiki and login
    Given I am on the home page
    When I click on "Busqueda" in the header
    Then I check that the text "Busca algo" does not disappear after a search