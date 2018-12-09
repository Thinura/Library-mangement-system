package dto;

public class Publisher {

    private int pubId;
    private String pubComName;

    public Publisher(int pubId, String pubComName) {
        this.pubId = pubId;
        this.pubComName = pubComName;
    }

    public int getPubId() {
        return pubId;
    }

    public void setPubId(int pubId) {
        this.pubId = pubId;
    }

    public String getPubComName() {
        return pubComName;
    }

    public void setPubComName(String pubComName) {
        this.pubComName = pubComName;
    }

}
