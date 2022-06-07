package DAO;
import java.sql.Date;
//Setters y getters para Production.ProductDescription
public class ppdes {
    private int ProductDescriptionID;
    private String Description;
    private String rowguid;
    private Date ModifiedDate;


    public int getProductDescriptionID() {
        return this.ProductDescriptionID;
    }

    public void setProductDescriptionID(int ProductDescriptionID) {
        this.ProductDescriptionID = ProductDescriptionID;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
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
