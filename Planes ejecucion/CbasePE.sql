--Configuracion de la base sobre la que se trabajan los planes de ejecucion
--CREATE CLUSTERED INDEX Inicial
ALTER TABLE dbo.datoscovid alter column ID_REGISTRO nvarchar(15) not null 
ALTER TABLE dbo.datoscovid
add constraint PK_datoscovid_ID_Registro PRIMARY KEY CLUSTERED(ID_REGISTRO)
--Droppeo del Indice Agrupado original:
alter table dbo.datoscovid drop constraint PK_datoscovid_ID_Registro
drop index PK_datoscovid_ID_Registro on dbo.datoscovid
--Indice no Implementable:
--create clustered index IX_DCovid_FD_CF on dbo.datoscovid ([CLASIFICACION_FINAL])
--INCLUDE ([FECHA_DEF])

--Clustered index sustituido:
create clustered index IX_DC_FD on dbo.datoscovid ([FECHA_DEF])


--Indices Secundarios:
CREATE INDEX IX_DatosCovid_FECHA_DEF on dbo.datoscovid (FECHA_DEF)
CREATE INDEX IX_DatosCovid_CLASIFICACION_FINAL on dbo.datoscovid (CLASIFICACION_FINAL)
USE [covidHistorico]
CREATE NONCLUSTERED INDEX [IX_DatosCovid_CLASIFICACION_FINAL_ENTIDAD]
ON dbo.datoscovid (CLASIFICACION_FINAL)
INCLUDE ([MUNICIPIO_RES],[ENTIDAD_RES])

CREATE NONCLUSTERED INDEX [IX_DatosCovid_EDAD_DEF]
ON [dbo].[datoscovid] ([FECHA_DEF])
INCLUDE ([EDAD])

--Copia de la tabla sin llaves
select *  into copiacovidh from [covidHistorico].[dbo].[datoscovid]

where CLASIFICACION_FINAL between 1 and 3 
order by ENTIDAD_RES