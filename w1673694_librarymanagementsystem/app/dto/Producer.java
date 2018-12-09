package dto;

public class Producer {

    private int proId;
    private String proName;

    public Producer(int proId, String proName) {
        this.proId = proId;
        this.proName = proName;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }
}
