package dto;

import java.util.List;

public class DVD extends LibraryItem {

    private int dvdId;
    private Producer producer;
    private List<Actor> actors;
    private String avaLang;
    private String avaSub;

    public DVD(int ISBN, String title, String sector, String publicationDate, String borrowedDate,
               Reader borrowedReader, String type, int dvdId, Producer producer, List<Actor> actors,
               String avaLang, String avaSub) {
        super(ISBN, title, sector, publicationDate, borrowedDate, borrowedReader, type);
        this.dvdId = dvdId;
        this.producer = producer;
        this.actors = actors;
        this.avaLang = avaLang;
        this.avaSub = avaSub;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getAvaLang() {
        return avaLang;
    }

    public void setAvaLang(String avaLang) {
        this.avaLang = avaLang;
    }

    public String getAvaSub() {
        return avaSub;
    }

    public void setAvaSub(String avaSub) {
        this.avaSub = avaSub;
    }

}
