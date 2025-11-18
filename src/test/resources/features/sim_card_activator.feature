Feature: sim_card_activator
    test whether sim card activator works

    Scenario: Sim Card Activation return true
        Given sim_card_iccid is 1255789453849037777
        When I send a request to activate the sim card
        Then I should receive a response with response.isSuccess equal to true

    Scenario: Sim Card Activation return false
        Given sim_card_iccid is 8944500102198304826
        When I send a request to activate the sim card
        Then I should receive a response with response.isSuccess equal to false