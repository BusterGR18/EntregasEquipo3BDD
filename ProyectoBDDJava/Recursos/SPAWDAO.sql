USE AdventureWorks2019
GO


CREATE PROCEDURE sp_insercion_SOD_TEST(
@ProductID varchar(20),
@CanOrden varchar(20),
@Salida_ins_sod varchar(20) output
)
AS
BEGIN
select * from Sales.SalesOrderDetail

--Comprobacion de inventario del producto deseado en MySQL
/*select EXISTS(OPENQUERY(VINCMYSQL,'select * from ProductIventory where ProductID=@ProductID' ))
*/
--Codigo para insercion en SOD
DECLARE @SalesOrderID int
DECLARE @CarrierTN nvarchar(25)

DECLARE @SpecialOfferID int
DECLARE @PrecioL varchar(25)
DECLARE @DescuentoUni varchar(25)

SET @SalesOrderID =  (SELECT max(SalesOrderID)+1 FROM Sales.SalesOrderDetail)


INSERT INTO SALES.SalesOrderDetail(SalesOrderID,CarrierTrackingNumber,OrderQty,ProductID,SpecialOfferID,
	UnitPrice,UnitPriceDiscount,rowguid,ModifiedDate) 
	VALUES(@SalesOrderID,@CarrierTN,@CanOrden,@ProductID,@SpecialOfferID,@PrecioL,@DescuentoUni,NEWID(),SYSDATETIME())

IF EXISTS (SELECT SalesOrderID FROM SALES.SalesOrderDetail WHERE SalesOrderID = @SalesOrderID) 
	BEGIN 
		SET @Salida_ins_sod = 'Insercion exitosa' 
	END
	ELSE -- No se encuentra el valor de la insercion
	BEGIN
		SET @Salida_ins_sod = 'Error'		
	END
		
END
GO

DROP PROCEDURE sp_insercionreal_sod
GO

CREATE PROCEDURE sp_insercion_SOH(
@RN INT,
@STATUS INT,
@OOF BIT,
@CUSTOMERID INT,
@BTIID INT,
@ShipTAID INT,
@SMID INT,
@Salida_ins_soh varchar(20) output
)
AS 
BEGIN	
	DECLARE @OrderID INT
	SELECT @OrderID = MAX(SalesOrderID) FROM Sales.SalesOrderHeader; --Nuevo ID dinamico para la orden nueva
	select * from Sales.SalesOrderHeader where SalesOrderID = @OrderID --Chequeo de sanidad para saber si existe el ID dinamico
	DECLARE @ST float
	SET @ST = ((SELECT SUM(SALES.SalesOrderDetail.LineTotal) FROM Sales.SalesOrderDetail where Sales.SalesOrderDetail.SalesOrderID = @OrderID))
	
	insert into Sales.SalesOrderHeader(RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,
	CustomerID,BillToAddressID,ShipToAddressID,ShipMethodID,SubTotal,TaxAmt,Freight,rowguid,ModifiedDate) 
	values(@RN,SYSDATETIME(),SYSDATETIME(),SYSDATETIME(),@STATUS,@OOF,@CUSTOMERID,
	@BTIID,@ShipTAID,@SMID,@ST,@ST*.08, @ST*.08*0.3125,NEWID(),SYSDATETIME()) 
	
	SELECT @OrderID = MAX(SalesOrderID) FROM Sales.SalesOrderHeader;
	IF EXISTS (SELECT SalesOrderID FROM SALES.SalesOrderHeader WHERE SalesOrderID = @OrderID) 
	BEGIN 
		SET @Salida_ins_soh = 'Insercion exitosa' 
	END
	ELSE -- No se encuentra el valor de la insercion
	BEGIN
		SET @Salida_ins_soh = 'Error'		
	END
	select * from Sales.SalesOrderHeader where SalesOrderID = @OrderID
END 
GO


-- drop procedure sp_insercion_SOH
/* --Codigo prueba para verificar insercion de SOH
delete from Sales.SalesOrderHeader where SalesOrderID =75136
exec sp_insercion_SOH 8,5,1,27918,21592,21592,5,''

SELECT xd = MAX(SalesOrderID) FROM Sales.SalesOrderHeader;
SELECT *  FROM Sales.SalesOrderHeader;
*/
