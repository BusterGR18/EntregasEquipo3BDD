--Configuracion de la base sobre la que se trabajan los planes de ejecucion
--CREATE CLUSTERED INDEX 

ALTER TABLE dbo.datoscovid alter column ID_REGISTRO nvarchar(15) not null 
ALTER TABLE dbo.datoscovid
add constraint PK_datoscovid_ID_Registro PRIMARY KEY CLUSTERED(ID_REGISTRO)

--Indice Secundario:
CREATE INDEX IX_DatosCovid_FECHA_DEF on dbo.datoscovid (FECHA_DEF)
CREATE INDEX IX_DatosCovid_CLASIFICACION_FINAL on dbo.datoscovid (CLASIFICACION_FINAL)


DROP INDEX IX_DatosCovid_ENTIDAD_RES on dbo.datoscovid

USE [covidHistorico]
GO
CREATE NONCLUSTERED INDEX [IX_DatosCovid_CLASIFICACION_FINAL_ENTIDAD]
ON [dbo].[datoscovid] ([CLASIFICACION_FINAL])
INCLUDE ([MUNICIPIO_RES],[ENTIDAD_RES])
GO

--Copia de la tabla sin llaves
select *  into copiacovidh from [covidHistorico].[dbo].[datoscovid]

where CLASIFICACION_FINAL between 1 and 3 
order by ENTIDAD_RES
