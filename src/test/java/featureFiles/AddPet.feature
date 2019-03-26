Feature: Test the account registration functionality



  @Smoketest
   Scenario: User is able to register a PET sucessfully on the store

      Given user post the add pet request with id '1270' and dog name "Pluto"
      Then user get response code '200'
      And user gets the id and name and response


  @Smoketest
  @Negativecase
  Scenario: User is unable to register a PET with invalid data input

    Given user post the add pet request with invalid id '00000' and dog name "ok"
    Then user get error response code '400'
    And user gets the expected response message "bad input"

