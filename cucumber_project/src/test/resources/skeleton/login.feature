Feature: Login Feature
@valid
Scenario Outline: Valid User Scenario
    Given The URL of Testme APP
    When user enters <username> as username
    And user enters <password> as password
    Then user is in <page>
Examples:

    |username  |password    | page|
    |Lalitha   |Password123 | Home|
    |admin     |Password456 | Admin Home|
    
    @invalid
    Scenario: invalid Scenario
    Given The URL of Testme APP
    When user enters invalid data as username
    |abcxyz |Password123|   
    |Lalitha|abc1223 |
    |abc123 |abc123 |
    Then user is in loginpage
    |bdc|
    |ddc|
    |hdc|
    
    #Given The URL of Testme APP
    #When user enters "admin" as username
    #And user enters "Password456" as password
    #Then user is in home page
    
    
    