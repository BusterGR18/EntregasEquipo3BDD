package DAO;
import java.sql.Date;

//Setters y getters para Production.ProductInventory
public class ppinv {
    private int ProductID;
    private short LocationID;
    private String Shelf;
    private short bin;
    private short Quantity;
    private String rowguid;
    private Date ModifiedDate;


    public int getProductID() {
        return this.ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public short getLocationID() {
        return this.LocationID;
    }

    public void setLocationID(short LocationID) {
        this.LocationID = LocationID;
    }

    public String getShelf() {
        return this.Shelf;
    }

    public void setShelf(String Shelf) {
        this.Shelf = Shelf;
    }

    public short getBin() {
        return this.bin;
    }

    public void setBin(short bin) {
        this.bin = bin;
    }

    public short getQuantity() {
        return this.Quantity;
    }

    public void setQuantity(short Quantity) {
        this.Quantity = Quantity;
    }

    public String getRowguid() {
        return this.rowguid;
    }

    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    public Date getModifiedDate() {
        return this.ModifiedDate;
    }

    public void setModifiedDate(Date ModifiedDate) {
        this.ModifiedDate = ModifiedDate;
    }

    
}
