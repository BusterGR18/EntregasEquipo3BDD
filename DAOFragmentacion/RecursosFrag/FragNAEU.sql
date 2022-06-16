--Fragmentos alojados en la instancia 2:
--Creacion de Fragmento NorthAmerica
use NorthAmerica
GO
create schema Sales
GO
select * into NorthAmerica.Sales.Customer from AdventureWorks2019.Sales.Customer where TerritoryID between 1 and 6
select * into NorthAmerica.Sales.SalesOrderHeader from AdventureWorks2019.Sales.SalesOrderHeader where TerritoryID between 1 and 6
select * into NorthAmerica.Sales.SalesPerson from AdventureWorks2019.Sales.SalesPerson where TerritoryID between 1 and 6
--SalesOrderDetail
select sod.SalesOrderID,sod.SalesOrderDetailID,sod.CarrierTrackingNumber,sod.OrderQty,sod.ProductID,
sod.SpecialOfferID,sod.UnitPrice,sod.UnitPriceDiscount,sod.LineTotal,sod.rowguid,sod.ModifiedDate into NorthAmerica.Sales.SalesOrderDetail
from AdventureWorks2019.Sales.SalesOrderDetail as sod left join
(select * from AdventureWorks2019.Sales.SalesOrderHeader where TerritoryID between 1 and 6) as oh on sod.SalesOrderID=oh.SalesOrderID
GO
--Creacion de fragmento Europe
Use Europe
GO
create schema Sales
GO
select * into Europe.Sales.Customer from AdventureWorks2019.Sales.Customer where TerritoryID between 7 and 10 and TerritoryID !=9
select * into Europe.Sales.SalesOrderHeader from AdventureWorks2019.Sales.SalesOrderHeader where TerritoryID between 7 and 10 and TerritoryID !=9
select * into Europe.Sales.SalesPerson from AdventureWorks2019.Sales.SalesPerson where TerritoryID between 7 and 10 and TerritoryID !=9
--SalesOrderDetail
select sod.SalesOrderID,sod.SalesOrderDetailID,sod.CarrierTrackingNumber,sod.OrderQty,sod.ProductID,
sod.SpecialOfferID,sod.UnitPrice,sod.UnitPriceDiscount,sod.LineTotal,sod.rowguid,sod.ModifiedDate into Europe.Sales.SalesOrderDetail
from AdventureWorks2019.Sales.SalesOrderDetail as sod left join
(select * from AdventureWorks2019.Sales.SalesOrderHeader where TerritoryID between 7 and 10 and TerritoryID !=9) as oh on sod.SalesOrderID=oh.SalesOrderID
GO

--Consulta 2:
use NorthAmerica
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=1 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=2 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=3 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=4 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=5 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=6 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson where TerritoryID=6) sp 
on mv.IMV=sp.BusinessEntityID 

--Consulta 9
--9. Listar los clientes del territorio 1 y 4 que no tengan asociado un valor en personId
Use NorthAmerica
SELECT * FROM NorthAmerica.sales.CUSTOMER WHERE TerritoryID BETWEEN 1 AND 4 and TerritoryID!=2 and TerritoryID!=3 AND PersonID IS NULL

--Consulta 4
use Europe
Select TOP 1 WITH TIES ProductID, SUM(SalesOrderDetail.OrderQty) as Unidades_vendidas from Sales.SalesOrderDetail Group by SalesOrderDetail.ProductID Order by Unidades_vendidas desc


--Consulta 6
Select TOP 3 WITH TIES SalesOrderDetail.ProductID, SUM(SalesOrderDetail.OrderQty) as Unidades_vendidas from Sales.SalesOrderDetail
Group by SalesOrderDetail.ProductID Order by Unidades_vendidas asc
SELECT * FROM OPENQUERY(INS1SR,'Select TOP 3 WITH TIES SalesOrderDetail.ProductID, SUM(SalesOrderDetail.OrderQty) as Unidades_vendidas from AsiaPacific.Sales.SalesOrderDetail
Group by SalesOrderDetail.ProductID Order by Unidades_vendidas asc')