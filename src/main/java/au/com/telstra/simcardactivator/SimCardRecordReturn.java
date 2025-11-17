package au.com.telstra.simcardactivator;

public class SimCardRecordReturn {
    public String iccid;
    public String customerEmail;
    public boolean active;

    public SimCardRecordReturn(String iccid, String customerEmail, boolean active) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
        this.active = active;
    }
}
