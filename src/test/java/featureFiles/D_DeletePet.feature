Feature: Test the delete account functionality



  @Smoketest
   Scenario: TC_07 User is able to delete a PET sucessfully from the store site

      Given user call the delete pet request with id '1270'
      Then record is deleted and user get the success response code '200'
      Then user call the get pet request to validate deletion with id '1270'




  @Smoketest
  @Negativecase
  Scenario: TC_08 User is unable to get a PET for deletion with invalid id input

    Given user calls delete pet request with unavailable id '00'
    Then user for unavailable id delete request get the error response code '404'
