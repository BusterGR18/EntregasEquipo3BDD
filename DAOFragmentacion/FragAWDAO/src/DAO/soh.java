package DAO;
import java.sql.Date;
import java.math.BigDecimal;

public class soh {
    private int SalesOrderID;
    private int RevisionNumber;
    private Date OrderDate;
    private Date DueDate;
    private Date ShipDate;
    private int Status;
    private boolean OnlineOrderFlag;
    private String SalesOrderNumber;
    private String PurchaseOrderNumber;
    private String AccountNumber;
    private int CustomerID;
    private int SalesPersonID;
    private int TerritoryID;
    private int BillToAddressID;
    private int ShipToAddressID;
    private int ShipMethodID;
    private int CreditCardID;
    private String CreditCardApprovalCode;
    private int CurrencyRateID;
    private BigDecimal SubTotal;
    private BigDecimal TaxAmt;
    private BigDecimal Freight;
    private BigDecimal TotalDue;
    private String Comment;
    private String rowguid;
    private Date ModifiedDate;



    public int getSalesOrderID() {
        return this.SalesOrderID;
    }

    public void setSalesOrderID(int SalesOrderID) {
        this.SalesOrderID = SalesOrderID;
    }

    public int getRevisionNumber() {
        return this.RevisionNumber;
    }

    public void setRevisionNumber(int i) {
        this.RevisionNumber = i;
    }

    public Date getOrderDate() {
        return this.OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public Date getDueDate() {
        return this.DueDate;
    }

    public void setDueDate(Date DueDate) {
        this.DueDate = DueDate;
    }

    public Date getShipDate() {
        return this.ShipDate;
    }

    public void setShipDate(Date ShipDate) {
        this.ShipDate = ShipDate;
    }

    public int getStatus() {
        return this.Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public boolean isOnlineOrderFlag() {
        return this.OnlineOrderFlag;
    }

    public boolean getOnlineOrderFlag() {
        return this.OnlineOrderFlag;
    }

    public void setOnlineOrderFlag(boolean OnlineOrderFlag) {
        this.OnlineOrderFlag = OnlineOrderFlag;
    }

    public String getSalesOrderNumber() {
        return this.SalesOrderNumber;
    }

    public void setSalesOrderNumber(String SalesOrderNumber) {
        this.SalesOrderNumber = SalesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return this.PurchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String PurchaseOrderNumber) {
        this.PurchaseOrderNumber = PurchaseOrderNumber;
    }

    public String getAccountNumber() {
        return this.AccountNumber;
    }

    public void setAccountNumber(String AccountNumber) {
        this.AccountNumber = AccountNumber;
    }

    public int getCustomerID() {
        return this.CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getSalesPersonID() {
        return this.SalesPersonID;
    }

    public void setSalesPersonID(int SalesPersonID) {
        this.SalesPersonID = SalesPersonID;
    }

    public int getTerritoryID() {
        return this.TerritoryID;
    }

    public void setTerritoryID(int TerritoryID) {
        this.TerritoryID = TerritoryID;
    }

    public int getBillToAddressID() {
        return this.BillToAddressID;
    }

    public void setBillToAddressID(int BillToAddressID) {
        this.BillToAddressID = BillToAddressID;
    }

    public int getShipToAddressID() {
        return this.ShipToAddressID;
    }

    public void setShipToAddressID(int ShipToAddressID) {
        this.ShipToAddressID = ShipToAddressID;
    }

    public int getShipMethodID() {
        return this.ShipMethodID;
    }

    public void setShipMethodID(int ShipMethodID) {
        this.ShipMethodID = ShipMethodID;
    }

    public int getCreditCardID() {
        return this.CreditCardID;
    }

    public void setCreditCardID(int CreditCardID) {
        this.CreditCardID = CreditCardID;
    }

    public String getCreditCardApprovalCode() {
        return this.CreditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String CreditCardApprovalCode) {
        this.CreditCardApprovalCode = CreditCardApprovalCode;
    }

    public int getCurrencyRateID() {
        return this.CurrencyRateID;
    }

    public void setCurrencyRateID(int CurrencyRateID) {
        this.CurrencyRateID = CurrencyRateID;
    }

    public BigDecimal getSubTotal() {
        return this.SubTotal;
    }

    public void setSubTotal(BigDecimal SubTotal) {
        this.SubTotal = SubTotal;
    }

    public BigDecimal getTaxAmt() {
        return this.TaxAmt;
    }

    public void setTaxAmt(BigDecimal TaxAmt) {
        this.TaxAmt = TaxAmt;
    }

    public BigDecimal getFreight() {
        return this.Freight;
    }

    public void setFreight(BigDecimal Freight) {
        this.Freight = Freight;
    }

    public BigDecimal getTotalDue() {
        return this.TotalDue;
    }

    public void setTotalDue(BigDecimal TotalDue) {
        this.TotalDue = TotalDue;
    }

    public String getComment() {
        return this.Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
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

