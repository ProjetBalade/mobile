package be.hevelaska.mobile.dto;

public class ApiAuthRequest {

    private final String name;
    private final String password;

    public ApiAuthRequest(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
