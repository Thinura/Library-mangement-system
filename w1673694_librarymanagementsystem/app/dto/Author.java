package dto;

public class Author {

    private int authId;
    private String authName;

    public Author(int authId, String authName) {
        this.authId = authId;
        this.authName = authName;
    }

    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

}
