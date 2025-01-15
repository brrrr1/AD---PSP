insert into departamento (id, nombre)
values (nextval('departamento_seq'), 'Departamento 1');

insert into empleado (nombre, id, departamento_id)
values ('Anuel AA', nextval('empleados_seq'), currval('departamento_seq'));
