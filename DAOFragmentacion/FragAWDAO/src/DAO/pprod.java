package DAO;
import java.sql.*;
//Setters y getters para Production.Product
public class pprod {
    private int ProductID;
    private String Name;
    private String ProductNumber;
    private int MakeFlag;
    private int FinishedGoodsFlag;
    private String Color;
    private short SafetyStockLevel;
    private short ReorderPoint;
    private float StandardCost;
    private float ListPrice;
    private String Size;
    private String SizeUnitMeasureCode;
    private String WeightUnitMeasureCode;
    private float Weight;
    private int DaysToManufacture;
    private String ProductLine;
    //private String Class;
    private String Style;
    private int ProductSubcategoryID;
    private int ProductModelID;
    private Date SellStartDate;
    private Date SellEndDate;
    private Date DiscontinuedDate;
    private String rowguid;
    private Date ModifiedDate;



    public int getProductID() {
        return this.ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getProductNumber() {
        return this.ProductNumber;
    }

    public void setProductNumber(String ProductNumber) {
        this.ProductNumber = ProductNumber;
    }

    public int getMakeFlag() {
        return this.MakeFlag;
    }

    public void setMakeFlag(int MakeFlag) {
        this.MakeFlag = MakeFlag;
    }

    public int getFinishedGoodsFlag() {
        return this.FinishedGoodsFlag;
    }

    public void setFinishedGoodsFlag(int FinishedGoodsFlag) {
        this.FinishedGoodsFlag = FinishedGoodsFlag;
    }

    public String getColor() {
        return this.Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public short getSafetyStockLevel() {
        return this.SafetyStockLevel;
    }

    public void setSafetyStockLevel(short SafetyStockLevel) {
        this.SafetyStockLevel = SafetyStockLevel;
    }

    public short getReorderPoint() {
        return this.ReorderPoint;
    }

    public void setReorderPoint(short ReorderPoint) {
        this.ReorderPoint = ReorderPoint;
    }

    public float getStandardCost() {
        return this.StandardCost;
    }

    public void setStandardCost(float StandardCost) {
        this.StandardCost = StandardCost;
    }

    public float getListPrice() {
        return this.ListPrice;
    }

    public void setListPrice(float ListPrice) {
        this.ListPrice = ListPrice;
    }

    public String getSize() {
        return this.Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
    }

    public String getSizeUnitMeasureCode() {
        return this.SizeUnitMeasureCode;
    }

    public void setSizeUnitMeasureCode(String SizeUnitMeasureCode) {
        this.SizeUnitMeasureCode = SizeUnitMeasureCode;
    }

    public String getWeightUnitMeasureCode() {
        return this.WeightUnitMeasureCode;
    }

    public void setWeightUnitMeasureCode(String WeightUnitMeasureCode) {
        this.WeightUnitMeasureCode = WeightUnitMeasureCode;
    }

    public float getWeight() {
        return this.Weight;
    }

    public void setWeight(float Weight) {
        this.Weight = Weight;
    }

    public int getDaysToManufacture() {
        return this.DaysToManufacture;
    }

    public void setDaysToManufacture(int DaysToManufacture) {
        this.DaysToManufacture = DaysToManufacture;
    }

    public String getProductLine() {
        return this.ProductLine;
    }

    public void setProductLine(String ProductLine) {
        this.ProductLine = ProductLine;
    }
   

    public String getStyle() {
        return this.Style;
    }

    public void setStyle(String Style) {
        this.Style = Style;
    }

    public int getProductSubcategoryID() {
        return this.ProductSubcategoryID;
    }

    public void setProductSubcategoryID(int ProductSubcategoryID) {
        this.ProductSubcategoryID = ProductSubcategoryID;
    }

    public int getProductModelID() {
        return this.ProductModelID;
    }

    public void setProductModelID(int ProductModelID) {
        this.ProductModelID = ProductModelID;
    }

    public Date getSellStartDate() {
        return this.SellStartDate;
    }

    public void setSellStartDate(Date SellStartDate) {
        this.SellStartDate = SellStartDate;
    }

    public Date getSellEndDate() {
        return this.SellEndDate;
    }

    public void setSellEndDate(Date SellEndDate) {
        this.SellEndDate = SellEndDate;
    }

    public Date getDiscontinuedDate() {
        return this.DiscontinuedDate;
    }

    public void setDiscontinuedDate(Date DiscontinuedDate) {
        this.DiscontinuedDate = DiscontinuedDate;
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
