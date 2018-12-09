package models;

import io.ebean.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "w1673694_DVD")
public class DVDModel extends Model {

    @Id
    @GeneratedValue
    @Column(name = "dvdId",nullable = false)
    private int dvdId;

    @Column(name = "ISBN", nullable = false)
    private int ISBN;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "sector", nullable = false)
    private String sector;

    @Column(name = "publicationDate", nullable = false)
    private String publicationDate;

    @Column(name = "borrowedDate")
    private String borrowedDate;

    @ManyToOne
    @JoinColumn(name = "reader", referencedColumnName = "redId")
    private ReaderModel borrowedReader;

    @Column(name = "objectType", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "producer", referencedColumnName = "proId")
    private ProducerModel producerModel;

    @ManyToMany(mappedBy = "w1673694_DVD")
    private List<ActorModel> actorModels;

    private String avaLang;

    private String avaSub;

    public DVDModel(int ISBN, String title, String sector, String publicationDate, String type,
                    ProducerModel producerModel, List<ActorModel> actorModels,
                    String avaLang, String avaSub) {
        this.ISBN = ISBN;
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
        this.type = type;
        this.producerModel = producerModel;
        this.actorModels = actorModels;
        this.avaLang = avaLang;
        this.avaSub = avaSub;
    }

    public int getDvdId() {
        return dvdId;
    }

    public void setDvdId(int dvdId) {
        this.dvdId = dvdId;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public ReaderModel getBorrowedReader() {
        return borrowedReader;
    }

    public void setBorrowedReader(ReaderModel borrowedReader) {
        this.borrowedReader = borrowedReader;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProducerModel getProducerModel() {
        return producerModel;
    }

    public void setProducerModel(ProducerModel producerModel) {
        this.producerModel = producerModel;
    }

    public List<ActorModel> getActorModels() {
        return actorModels;
    }

    public void setActorModels(List<ActorModel> actorModels) {
        this.actorModels = actorModels;
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
