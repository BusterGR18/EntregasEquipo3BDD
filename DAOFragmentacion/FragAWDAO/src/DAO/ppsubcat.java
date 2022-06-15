package DAO;
import java.sql.*;
public class ppsubcat {
    private int ProductSubcategoryID;
    private int ProductCategoryID;
    private String Name;
    private String rowguid;
    private Date ModifiedDate;


    public int getProductSubcategoryID() {
        return this.ProductSubcategoryID;
    }

    public void setProductSubcategoryID(int ProductSubcategoryID) {
        this.ProductSubcategoryID = ProductSubcategoryID;
    }

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
