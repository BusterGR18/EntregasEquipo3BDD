package DAO;
import java.sql.Date;
//Setters y getters para Production.ProductCategory
public class ppcat {
    private int ProductCategoryID;
    private String Name;
    private String rowguid;
    private Date ModifiedDate;


    public int getProductCategoryID() {
        return this.ProductCategoryID;
    }

    public void setProductCategoryID(int ProductCategoryID) {
        this.ProductCategoryID = ProductCategoryID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
