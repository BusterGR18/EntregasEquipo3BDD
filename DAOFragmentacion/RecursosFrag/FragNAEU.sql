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

--Consultas NA:
--Consulta 2:
--2. Listar datos del empleado que atendió más ordenes por territorio.
use NorthAmerica
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID between 1 and 6 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 


--consulta 3
--3. Listar los datos del cliente con más ordenes solicitadas en la región “North America”.
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from NorthAmerica.Sales.SalesOrderHeader 
group by SalesPersonID order by TV desc) mv
inner join 
(select * from NorthAmerica.Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

--Consulta 9
--9. Listar los clientes del territorio 1 y 4 que no tengan asociado un valor en personId
Use NorthAmerica
SELECT * FROM NorthAmerica.sales.CUSTOMER 
WHERE TerritoryID BETWEEN 1 AND 4 and TerritoryID!=2 and TerritoryID!=3 AND PersonID IS NULL
--10. Listar los clientes del territorio 1 que tengan ordenes en otro territorio*

--Consultas Europeas:

--Consulta 2
--2. Listar datos del empleado que atendió más ordenes por territorio.
use Europe
select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID between 7 and 10 and TerritoryID!=9 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 
--Consulta 4
--4. Listar el producto más solicitado en la región “Europe”.
use Europe
Select TOP 1 WITH TIES ProductID, SUM(SalesOrderDetail.OrderQty) as Unidades_vendidas from Sales.SalesOrderDetail Group by SalesOrderDetail.ProductID Order by Unidades_vendidas desc