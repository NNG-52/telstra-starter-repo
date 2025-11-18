package au.com.telstra.simcardactivator;

// import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;




@RestController
public class SimCardActivatorController {

	@PostMapping("/activateSimCard")
	public ResponseFromActivator receiveActivationRequest(@RequestBody MyRequestBody requestBody) {
        // Access data from the requestBody object
        String iccid = requestBody.getIccid();
        String customerEmail = requestBody.getCustomerEmail();

        // Perform business logic with the received data
        System.out.println("Received ICCID: " + iccid);
        System.out.println("Received Customer Email: " + customerEmail);

        // prepare request to activator service
        RequestToActivator requestToActivator = new RequestToActivator();
        requestToActivator.setIccid(iccid);

        String actuatorUrl = "http://localhost:8444/actuate";

        RestTemplate restTemplate = new RestTemplate();      

        // send request to activator service
        ResponseFromActivator response = restTemplate.postForObject(actuatorUrl, requestToActivator, ResponseFromActivator.class);

        // verify response
        if (response != null && response.isSuccess()) {
            System.out.println("SIM card activation successful for ICCID: " + iccid);
        } else {
            System.out.println("SIM card activation failed for ICCID: " + iccid);
        }

        return response;

    }

    @GetMapping("/customer")
    public SimCardRecordReturn getCustomerByID(@RequestParam Long id, SimCardRecordRepository repository) {
        Optional<SimCardRecord> record = repository.findById(id);
        if (record.isEmpty()) {
            return null;
        } else {
            return new SimCardRecordReturn(
                record.get().getIccid(),
                record.get().getCustomerEmail(),
                record.get().isActive()
            );
        }
    }

}