Entrega: Ramirez Martinez Brayan Gustavo
/*  Práctica 1: Repaso de programación de consultas en BD Relacionales 

Instrucciones: Considerando la BD escuela, programe las siguientes consultas y rutinas. Puede utilizar vistas si la solución lo requiere.
Objetivo: Ejercitar la instrucción SELECT con sus diversas clausulas (INNER JOIN, LEFT JOIN, IN, EXIST, GROUP BY, entre otras)
          aplicando el menor número de operaciones posible para resolver las consultas.  
Fecha de entrega: viernes 18 de febrero a más tardar 11:30 pm
Modalidad: individual
*/

-- Consultas a resolver 
-- insertar 5 tuplas adicionales en curso_has_estudiante
use escuela;
insert into curso_has_estudiante values ('20212', '2TM5','T203','2019640011', 8); 
insert into curso_has_estudiante values ('20221', '4TM5','T410','2018641025', 5); 
insert into curso_has_estudiante values ('20221', '3TV5','T302','2019640231',9); 
insert into curso_has_estudiante values ('20221', '4TM5','T410','2019641134',8); 
insert into curso_has_estudiante values ('20212', '2TM5','T203','2019640125',4); 

-- 1: Listar los alumnos con estatus de regular (considere que un alumno regular puede tener no aprobada como máximo una materia)
create view AlumnosIrregulares  AS select idEstudiante from curso_has_estudiante as  cuhasrep where calificacion <6  group by idEstudiante having count(idEstudiante)>1;
select * from curso_has_estudiante as ce left join AlumnosIrregulares as ai on ce.idEstudiante=ai.idEstudiante where ai.idEstudiante is NULL group by ce.idEstudiante;

-- 2: Listar el porcentaje de no aprobados por materia en los semestres 20212 y 20221 
create view Materias1221TOT AS select *, count(idMateria) Total from curso_has_estudiante where semestre='20212' or semestre='20221' group by idMateria;
create view Materias1221REP AS select *, count(idMateria) Reprobados from curso_has_estudiante where semestre='20212' and calificacion <=5 or semestre='20221' and calificacion<=5 group by idMateria;
select tot.Semestre,tot.idMateria, (Reprobados/Total)*100 Porcentaje from Materias1221TOT as tot inner join Materias1221REP as rep on tot.idMateria=rep.idMateria; 


-- 3: Listar los profesores que aprobaron a todos sus alumnos en todas sus materias
create view todosapr as select che.semestre, che.grupo, che.idEstudiante,che.calificacion,cu.Semestre sem2,cu.Grupo grupo2,idProfesor from curso_has_estudiante che inner join curso as cu on che.grupo=cu.Grupo where calificacion<6;
create view todosrep as select che.semestre, che.grupo, che.idEstudiante,che.calificacion,cu.Semestre sem2,cu.Grupo grupo2,idProfesor from curso_has_estudiante che inner join curso as cu on che.grupo=cu.Grupo where calificacion>=6; 
select idProfesor from todosapr as apr where not exists ( select * from todosrep as rep);



-- 4: Listar los profesores con el mayor porcentaje de no aprobados en los semestres 20212 y 20221

-- 5: Determinar si en la materia T302 existe un porcentaje de no aprobados entre el 30% y 50% en cada uno de sus grupos.


-- 6: Listar los alumnos que han aprobado todas las asignaturas que imparte el profesor  10275287
select idEstudiante from curso as cu inner join curso_has_estudiante as cuhas on cu.grupo=cuhas.grupo where calificacion >= 6  and cu.idProfesor=10275287 group by idEstudiante


/* Rutinas 
-- 1: Validar que la calificación que se ingrese en curso_has_estudiante sea un valor entre 0 y 10
-- 2. Validar que un alumno no se inscriba a la misma asignatura más de una vez en un mismo semestre
*/
