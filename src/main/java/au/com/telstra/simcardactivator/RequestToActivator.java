package au.com.telstra.simcardactivator;

// request body class to map outgoing JSON data to activator service
public class RequestToActivator {
    private String iccid;

    // Getters and Setters
    public String getIccid() { return iccid; }
    public void setIccid(String iccid) { this.iccid = iccid; }
}
