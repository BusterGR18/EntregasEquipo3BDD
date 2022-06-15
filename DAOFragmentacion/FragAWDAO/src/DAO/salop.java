package DAO;
import java.sql.*;

public class salop {
    private int BusinessEntityID;
    private int TerritoryID;
    private float SalesQuota;
    private float Bonus;
    private float CommissionPct;
    private float SalesYTD;
    private float SalesLastYear;    
    private String rowguid;
    private Date ModifiedDate;


    public int getBusinessEntityID() {
        return this.BusinessEntityID;
    }

    public void setBusinessEntityID(int BusinessEntityID) {
        this.BusinessEntityID = BusinessEntityID;
    }

    public int getTerritoryID() {
        return this.TerritoryID;
    }

    public void setTerritoryID(int TerritoryID) {
        this.TerritoryID = TerritoryID;
    }

    public float getSalesQuota() {
        return this.SalesQuota;
    }

    public void setSalesQuota(float SalesQuota) {
        this.SalesQuota = SalesQuota;
    }

    public float getBonus() {
        return this.Bonus;
    }

    public void setBonus(float Bonus) {
        this.Bonus = Bonus;
    }

    public float getCommissionPct() {
        return this.CommissionPct;
    }

    public void setCommissionPct(float CommissionPct) {
        this.CommissionPct = CommissionPct;
    }

    public float getSalesYTD() {
        return this.SalesYTD;
    }

    public void setSalesYTD(float SalesYTD) {
        this.SalesYTD = SalesYTD;
    }

    public float getSalesLastYear() {
        return this.SalesLastYear;
    }

    public void setSalesLastYear(float SalesLastYear) {
        this.SalesLastYear = SalesLastYear;
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
