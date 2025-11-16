package au.com.telstra.simcardactivator;

// response body class to map incoming JSON data from activator service
public class ResponseFromActivator {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}