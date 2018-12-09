package dto;

/**
 *
 */
public class Overdue extends LibraryItem{

    private double overdueFee;
    private String overdueReturnDate;

    public Overdue(int ISBN, String title, String sector, String publicationDate, String borrowedDate,
                   Reader borrowedReader, String type, double overdueFee, String overdueReturnDate) {
        super(ISBN, title, sector, publicationDate, borrowedDate, borrowedReader, type);
        this.overdueFee = overdueFee;
        this.overdueReturnDate = overdueReturnDate;
    }

    public double getOverdueFee() {
        return overdueFee;
    }

    public void setOverdueFee(double overdueFee) {
        this.overdueFee = overdueFee;
    }

    public String getOverdueReturnDate() {
        return overdueReturnDate;
    }

    public void setOverdueReturnDate(String overdueReturnDate) {
        this.overdueReturnDate = overdueReturnDate;
    }

}
