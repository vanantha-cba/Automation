
Feature: Acceptance testing to validate the following.
          user creation is successfull, complete a challenge &
          check the leader board


Scenario Outline:
    Given the user is on the home page
    And the user creates a warrior having name "<warriorName>" using browser "<browserName>"
    And user selects his battlefield as "<battleField>"
    When he is travelling by bus, he decides to "<userSelection>"
    Then the user checks his final score


  Examples:

    | warriorName | browserName| battleField | userSelection |
    | Gajusr_002  | chrome     | bus         |  Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly. |
    | Gajusr_003  | Safari     | bus         |  Use your superheroes Mask and sanitizer while traveling on public transport and clean your hands regularly. |

