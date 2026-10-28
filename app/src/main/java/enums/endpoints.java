package enums;

public enum endpoints {

    DOG_IMAGE("api/breeds/image/random");

    String baseUrl;

    endpoints(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}
