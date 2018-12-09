package dto;

public class Reader {

    private int redId;
    private String redName;
    private long redMobileNum;
    private String redEmail;

    public Reader() {
    }

    public Reader(int redId, String redName, long redMobileNum, String redEmail) {
        this.redId = redId;
        this.redName = redName;
        this.redMobileNum = redMobileNum;
        this.redEmail = redEmail;
    }

    public int getRedId() {
        return redId;
    }

    public void setRedId(int redId) {
        this.redId = redId;
    }

    public String getRedName() {
        return redName;
    }

    public void setRedName(String redName) {
        this.redName = redName;
    }

    public long getRedMobileNum() {
        return redMobileNum;
    }

    public void setRedMobileNum(long redMobileNum) {
        this.redMobileNum = redMobileNum;
    }

    public String getRedEmail() {
        return redEmail;
    }

    public void setRedEmail(String redEmail) {
        this.redEmail = redEmail;
    }

}
