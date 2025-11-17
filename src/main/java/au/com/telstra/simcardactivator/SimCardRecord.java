package au.com.telstra.simcardactivator;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SimCardRecord {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String iccid;
    private String customerEmail;
    private boolean active;

    protected SimCardRecord() {}  

    public SimCardRecord(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }
    @Override
    public String toString() {    
        return String.format(
            "SimCardRecord[id=%d, iccid='%s', customerEmail='%s', active='%b']",
            id, iccid, customerEmail, active);
    }

    public Long getId() {
        return id;
    }

    public String getIccid() {
        return iccid;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public boolean isActive() {
        return active;
    } 
}


