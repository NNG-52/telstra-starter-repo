package stepDefinitions;

import au.com.telstra.simcardactivator.ResponseFromActivator;
import au.com.telstra.simcardactivator.SimCardActivator;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.assertj.core.api.Assertions.assertThat;


@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {
    @Autowired
    private TestRestTemplate restTemplate;
    
    private String iccid;
    private String activatorUrl = "http://localhost:8080/activateSimCard";
    private ResponseFromActivator response;

    @Given("sim_card_iccid is 1255789453849037777")
    public void sim_card_iccid_is_1255789453849037777() {
        iccid = "1255789453849037777";
    }

    
    @Given("sim_card_iccid is 8944500102198304826")
    public void sim_card_iccid_is_8944500102198304826() {
        iccid = "8944500102198304826";
    }

    @When("I send a request to activate the sim card")
    public void i_send_a_request_to_activate_the_sim_card() {
        response = this.restTemplate.postForObject(activatorUrl, iccid, ResponseFromActivator.class);
    }

    @Then("I should receive a response with response.isSuccess equal to {success}")
    public void I_should_receive_a_response_with_response_isSuccess_equal_to(boolean expectedSuccess) {
        // Implement the assertion logic here
        assertThat(response.isSuccess()).isEqualTo(expectedSuccess);
    }
    
    
}