--Consultas que se ejecutan independientemente de los fragmentos
--5. Listar las ofertas que tienen los productos de la categoría “Bikes”
Select * from Sales.SpecialOfferProduct as sop inner join
(Select ProductID from Production.Product as p inner join
(Select *from Production.ProductSubcategory where ProductSubcategory.ProductCategoryID=1)as Cat 
on p.ProductSubcategoryID=Cat.ProductSubcategoryID) as psubid on sop.ProductID=psubid.ProductID

--7. Actualizar la subcategoría de los productos con productId del 1 al 4 a la subcategoría valida para el tipo de producto.
go
create procedure sp_frag7
(@Salida_con7 varchar(20) output)
as
--select * from Production.Product where ProductID between 1 and 4
update Production.Product
set ProductSubcategoryID = 11
where ProductID=1
update Production.Product
set ProductSubcategoryID = 17
where ProductID=2
update Production.Product
set ProductSubcategoryID = 17
where ProductID=3
update Production.Product
set ProductSubcategoryID = 11
where ProductID=4
IF EXISTS (SELECT ProductID FROM Production.Product WHERE ProductID = 4) 
	BEGIN 
		SET @Salida_con7= 'Actualizacion exitosa' 
	END
	ELSE -- No se encuentra el valor de la insercion
	BEGIN
		SET @Salida_con7= 'Error' 	
	END

go
exec sp_frag7 '' 


--8. Listar los productos que no estén disponibles a la venta.
select * from Production.Product where SellEndDate is not null

