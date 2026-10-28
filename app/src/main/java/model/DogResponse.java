package model;

public class DogResponse {

    private String message;
    private String status;

    public DogResponse(String message, String status) {
        this.message = message;
        this.status = status;
    }

    public DogResponse() {}


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
