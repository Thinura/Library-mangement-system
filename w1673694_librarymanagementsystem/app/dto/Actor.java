package dto;

public class Actor {

    private int actId;
    private String actName;

    public Actor(int actId, String actName) {
        this.actId = actId;
        this.actName = actName;
    }

    public int getActId() {
        return actId;
    }

    public void setActId(int actId) {
        this.actId = actId;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

}
