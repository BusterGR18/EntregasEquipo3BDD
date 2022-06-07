USE AdventureWorks2019
GO


CREATE PROCEDURE sp_insercion_SOD_TEST(
@ProductID varchar(20),
@CanOrden varchar(20),
@SALIDAGEN1 varchar(20) output
)
AS
BEGIN
select * from Sales.SalesOrderDetail
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

delete from Sales.SalesOrderHeader where SalesOrderID =75136

drop procedure sp_insercion_SOH

exec sp_insercion_SOH 8,5,1,27918,21592,21592,5,''


SELECT xd = MAX(SalesOrderID) FROM Sales.SalesOrderHeader;
SELECT *  FROM Sales.SalesOrderHeader;
