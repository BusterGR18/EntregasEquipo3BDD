--2. Listar datos del empleado que atendió más ordenes por territorio.
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
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=7 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=8 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=9 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

select * from 
(select top 1 SalesPersonID IMV, count(SalesOrderID) TV from Sales.SalesOrderHeader where  TerritoryID=10 and SalesPersonID>1 group by SalesPersonID order by TV desc) mv
inner join 
(select * from Sales.SalesPerson) sp 
on mv.IMV=sp.BusinessEntityID 

--3. Listar los datos del cliente con más ordenes solicitadas en la región “North America”.
--4. Listar el producto más solicitado en la región “Europe”.
--5. Listar las ofertas que tienen los productos de la categoría “Bikes”
--6. Listar los 3 productos menos solicitados en la región “Pacific”
--7. Actualizar la subcategoría de los productos con productId del 1 al 4 a la subcategoría valida para el tipo de producto.
--8. Listar los productos que no estén disponibles a la venta.
--9. Listar los clientes del territorio 1 y 4 que no tengan asociado un valor en personId
--10. Listar los clientes del territorio 1 que tengan ordenes en otro territorio*
