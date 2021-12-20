package be.hevelaska.mobile.dto;

public class ApiAuthResult {

    private final int id;
    private final String name;
    private final String token;

    public ApiAuthResult(int id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
