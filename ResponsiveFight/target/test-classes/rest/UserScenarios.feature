Feature: Regression testing of all the supported rest api's.

  Scenario Outline: This test will create new user.
    Given The user wants to create a new users.
    When  The user executes create user call with username "<userName>" and score "<score>"
    Then  The user verifies the user "<userName>" is created successfully
    Examples:
      | userName     | score |
      | test_usr9006 | 10    |

  Scenario Outline: This test will check the presence of user.
    Given The user wants to get all the users.
    When  The user executes the get call
    Then  The user verifies the presence of user "<userName>"
    Examples:
      | userName    |
      | test_usr9005|

  Scenario Outline: This test will update user.
    Given The user wants to update score of users.
    When  The user executes update user call with username "<userName>" and score "<score>"
    Then  The user verifies the user is updated with new value.
    Examples:
      | userName     | score |
      | test_usr9005 | 10    |

  Scenario: This test will delete the user.
    Given The user wants to delete the users.
    When  The user executes delete all users call
    Then  The user verifies all users are deleted successfully.
