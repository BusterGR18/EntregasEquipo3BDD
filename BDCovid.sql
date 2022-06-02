use covidHistorico
select top 5 * from dbo.datoscovid 
where CLASIFICACION_FINAL between 1 and 3 
order by ENTIDAD_RES

--alter
select ENTIDAD_RES,count(*) total_confimado from dbo.datoscovid 
where CLASIFICACION_FINAL between 1 and 3 
group by ENTIDAD_RES
order by ENTIDAD_RES

--Con 2
--2. Listar los casos sospechosos por entidad
select ENTIDAD_UM, ENTIDAD_RES,count(*) total_sospechosos from dbo.datoscovid 
where CLASIFICACION_FINAL = 6
group by ENTIDAD_RES, ENTIDAD_UM
order by ENTIDAD_UM


--CON 3

--3. Listar el top 5 de municipios por entidad con el mayor número de casos reportados, indicando casos sospechosos y casos confirmados.
select top 5 MUNICIPIO_RES, ENTIDAD_RES,count(CLASIFICACION_FINAL between 1 and 3) as total_confirmado,count(CLASIFICACION_FINAL=6) as total_sospechoso
from dbo.datoscovid
where CLASIFICACION_FINAL between 1 and 3 or CLASIFICACION_FINAL = 6
group by ENTIDAD_RES, MUNICIPIO_RES
order by ENTIDAD_RES, MUNICIPIO_RES

select top 5 cc.MUNICIPIO_RES, cc.ENTIDAD_RES,count(cc.CLASIFICACION_FINAL) as total_confirmado,count(cs.CLASIFICACION_FINAL) as total_sospechoso
from dbo.datoscovid cc inner join dbo.datoscovid cs
on (cc.CLASIFICACION_FINAL between 1 and 3 or cs.CLASIFICACION_FINAL = 6 )
and cc.ENTIDAD_RES =cs.ENTIDAD_RES and cs.MUNICIPIO_RES=cc.MUNICIPIO_RES
group by cc.ENTIDAD_RES, cc.MUNICIPIO_RES
order by total_confirmado,total_sospechoso desc

select top 5 cc.MUNICIPIO_RES, cc.ENTIDAD_RES,count(cc.CLASIFICACION_FINAL) as total_confirmado,count(cs.CLASIFICACION_FINAL) as total_sospechoso
from (select ENTIDAD_RES,MUNICIPIO_RES,CLASIFICACION_FINAL from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3) cc
inner join (select ENTIDAD_RES,MUNICIPIO_RES, CLASIFICACION_FINAL from dbo.datoscovid where CLASIFICACION_FINAL =6 ) cs
on cc.ENTIDAD_RES =cs.ENTIDAD_RES and cs.MUNICIPIO_RES =cc.MUNICIPIO_RES
group by cc.ENTIDAD_RES, cc.MUNICIPIO_RES


select cc.ENTIDAD_RES, cc.MUNICIPIO_RES, cc.confirmado, cs.sospechoso
from (select ENTIDAD_RES, MUNICIPIO_RES, count(*) as sospechoso
      from dbo.datoscovid where CLASIFICACION_FINAL = 6
      group by ENTIDAD_RES, MUNICIPIO_RES
      ) cs
inner join
(select ENTIDAD_RES, MUNICIPIO_RES, count (*) as confirmado
 from dbo.datoscovid where CLASIFICACION_FINAL between 1 and 3
 group by ENTIDAD_RES, MUNICIPIO_RES) cc
on cc.ENTIDAD_RES =  cs.ENTIDAD_RES and cs.MUNICIPIO_RES = cc.MUNICIPIO_RES
order by cc.ENTIDAD_RES

--solucion CJ

--con4 
--4. Determinar el municipio con el mayor número de defunciones en casos confirmados.
select ENTIDAD_RES, MUNICIPIO_RES, count(*) as Difuntos from dbo.datoscovid 
where FECHA_DEF !='9999-99-99' 
group by ENTIDAD_RES, MUNICIPIO_RES 
order by Difuntos desc



--5. Determinar por entidad, si de casos sospechosos hay defunciones reportadas asociadas a neumonia.
select ENTIDAD_RES,  count(*) from dbo.datoscovid
where neumonia=1 and CLASIFICACION_FINAL=6 and FECHA_DEF !='9999-99-99'
group by ENTIDAD_RES

--6. Listar por entidad el total de casos sospechosos, casos confirmados, total de defunciones en los meses de marzo a agosto 2020 y de diciembre 2020 a mayo 2021.
select ENTIDAD_RES, count(*) as fallecidos, count(case CLASIFICACION_FINAL when 1 then CLASIFICACION_FINAL
												when 2 then CLASIFICACION_FINAL
												when 3 then CLASIFICACION_FINAL
								end) as confirmado,
								count(case CLASIFICACION_FINAL when 6 then CLASIFICACION_FINAL end) as sospechoso
from dbo.datoscovid
where (FECHA_DEF between '2020-03-01' and '2020-08-01') or (FECHA_DEF between '2020-12-01' and '2021-05-01')
GROUP BY ENTIDAD_RES

--7. Listar los 5 municipios con el mayor número de casos confirmados en niños menos de 13 años con alguna comorbilidad reportada y cuantos de esos casos fallecieron.
/* CODIGO BASURA
select dmt.MUNICIPIO_RES, dmt.dm, dcomt.MUNICIPIO_RES, dcomt.dcom
from (select top 5 MUNICIPIO_RES, count(*)as dm from dbo.datoscovid where edad < 13 and FECHA_DEF !='9999-99-99' group by MUNICIPIO_RES)dmt
inner join
(select MUNICIPIO_RES, COUNT(*) as dcom from dbo.datoscovid where FECHA_DEF !='9999-99-99' and DIABETES=1 OR epoc=1 or asma=1 or INMUSUPR=1 or HIPERTENSION=1 or OTRA_COM=1 group by MUNICIPIO_RES) dcomt
on dmt.MUNICIPIO_RES=dcomt.MUNICIPIO_RES 
*/

select top 5 ENTIDAD_RES, MUNICIPIO_RES, COUNT(*) as dcom 
from dbo.datoscovid
where EDAD<13 and FECHA_DEF !='9999-99-99' and (DIABETES=1 OR epoc=1 or asma=1 or INMUSUPR=1 or HIPERTENSION=1 or OTRA_COM=1)
group by ENTIDAD_RES, MUNICIPIO_RES order by dcom desc

--8. Determinar si en el año 2020 hay una mayor cantidad de defunciones menores de edad que en el año 2021 y 2022.
select 
case  when sqrd20.DIFUNTOS2020>sqrd21.DIFUNTOS2021+sqrd22.DIFUNTOS2022 then 'fue mayor'
else 'no fue mayor'
end
from (select count(*) as DIFUNTOS2020 from dbo.datoscovid where edad<18 and FECHA_DEF  between '2020-01-01' and '2020-12-31') sqrd20,
(select count(*) as DIFUNTOS2021 from dbo.datoscovid where edad<18 and FECHA_DEF  between '2021-01-01' and '2021-12-31') sqrd21,
(select count(*) as DIFUNTOS2022 from dbo.datoscovid where edad<18 and FECHA_DEF  between '2022-01-01' and '2022-12-31') sqrd22


--9. Determinar si en el año 2021 hay un pocentaje mayor al 60 de casos reportados que son confirmados por estudios de laboratorio en comparación al año 2020.
select count(*) as CLAB21 from dbo.datoscovid where CLASIFICACION_FINAL='3' and  FECHA_INGRESO between '2021-01-01' and '2021-12-31'
select count(*) as CLAB20 from dbo.datoscovid where CLASIFICACION_FINAL='3' and  FECHA_INGRESO between '2020-01-01' and '2020-12-31'


--10. Determinar en que rango de edad: menor de edad, 19 a 40, 40 a 60 o mayor de 60 hay mas casos reportados que se hayan recuperado. 
select 
case when ran1.Recuperado>ran2.Recuperado and ran1.Recuperado>ran3.Recuperado and ran1.Recuperado>ran4.Recuperado  then 'El range de menor de edad tiene mas recuperados'
when  ran2.Recuperado>ran1.Recuperado and ran2.Recuperado>ran3.Recuperado and ran2.Recuperado>ran4.Recuperado then 'El rango de 18 a 40 tiene mas recuperados'
when  ran3.Recuperado>ran1.Recuperado and ran3.Recuperado>ran2.Recuperado and ran3.Recuperado>ran4.Recuperado then 'El rango de 18 a 40 tiene mas recuperados'
when  ran4.Recuperado>ran1.Recuperado and ran4.Recuperado>ran2.Recuperado and ran4.Recuperado>ran3.Recuperado then 'El rango de 18 a 40 tiene mas recuperados'
else 'error' 
end
from 
(select count(*) as Recuperado from dbo.datoscovid where FECHA_DEF ='9999-99-99' and (CLASIFICACION_FINAL= '1' or CLASIFICACION_FINAL = '3') and EDAD<18) ran1,
(select count(*) as Recuperado from dbo.datoscovid where FECHA_DEF ='9999-99-99' and (CLASIFICACION_FINAL= '1' or CLASIFICACION_FINAL = '3') and EDAD between '18' and '40') ran2,
(select count(*) as Recuperado from dbo.datoscovid where FECHA_DEF ='9999-99-99' and (CLASIFICACION_FINAL= '1' or CLASIFICACION_FINAL = '3') and EDAD between '41' and '60'  ) ran3,
(select count(*) as Recuperado from dbo.datoscovid where FECHA_DEF ='9999-99-99' and (CLASIFICACION_FINAL= '1' or CLASIFICACION_FINAL = '3') and EDAD >'60' ) ran4
