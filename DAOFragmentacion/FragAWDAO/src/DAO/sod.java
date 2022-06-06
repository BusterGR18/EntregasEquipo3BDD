package DAO;

public class sod {
    private int SalesOrderID;
    private int SalesOrderDetailID;
    private String CarrierTrackingNumber;
    private int OrderQty;
    private int ProductID;
    private int SpecialOfferID;
    private String UnitPrice;
    private String UnitPriceDiscount;
    private String LineTotal;
    private String rowguid;
    private String ModifiedDate;


    public int getSalesOrderID() {
        return this.SalesOrderID;
    }

    public void setSalesOrderID(int SalesOrderID) {
        this.SalesOrderID = SalesOrderID;
    }

    public int getSalesOrderDetailID() {
        return this.SalesOrderDetailID;
    }

    public void setSalesOrderDetailID(int SalesOrderDetailID) {
        this.SalesOrderDetailID = SalesOrderDetailID;
    }

    public String getCarrierTrackingNumber() {
        return this.CarrierTrackingNumber;
    }

    public void setCarrierTrackingNumber(String CarrierTrackingNumber) {
        this.CarrierTrackingNumber = CarrierTrackingNumber;
    }

    public int getOrderQty() {
        return this.OrderQty;
    }

    public void setOrderQty(int OrderQty) {
        this.OrderQty = OrderQty;
    }

    public int getProductID() {
        return this.ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getSpecialOfferID() {
        return this.SpecialOfferID;
    }

    public void setSpecialOfferID(int SpecialOfferID) {
        this.SpecialOfferID = SpecialOfferID;
    }

    public String getUnitPrice() {
        return this.UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public String getUnitPriceDiscount() {
        return this.UnitPriceDiscount;
    }

    public void setUnitPriceDiscount(String UnitPriceDiscount) {
        this.UnitPriceDiscount = UnitPriceDiscount;
    }

    public String getLineTotal() {
        return this.LineTotal;
    }

    public void setLineTotal(String LineTotal) {
        this.LineTotal = LineTotal;
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
