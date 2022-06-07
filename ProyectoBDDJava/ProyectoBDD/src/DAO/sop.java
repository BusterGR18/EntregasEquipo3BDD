package DAO;

public class sop {
    private int SpecialOfferID;
    private int ProductID;
    private String rowguid;
    private String ModifiedDate;


    public int getSpecialOfferID() {
        return this.SpecialOfferID;
    }

    public void setSpecialOfferID(int SpecialOfferID) {
        this.SpecialOfferID = SpecialOfferID;
    }

    public int getProductID() {
        return this.ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public String getModifiedDate() {
        return this.ModifiedDate;
    }

    public void setModifiedDate(String ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }
    

}
