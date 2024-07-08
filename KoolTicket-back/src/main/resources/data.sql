DELETE FROM public.boton;

INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (1,'consultas','C',true);
INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (2,'informacion','I',true);
INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (3,'laboratorio','L',true);
INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (4,'otros servicios','O',true);
INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (5,'pruebas covid-19','P',true);
INSERT INTO public.boton (id,nombre,prefijo_ticket,estado)	VALUES (6,'derivaciones','D',true);

DELETE FROM public.usuario;
DELETE FROM public.roles;
DELETE FROM public.sucursal;

INSERT INTO public.roles (id, nombre) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_CAJERO');

INSERT INTO public.usuario (id,username,password,nombres,apellidos,id_rol,caja_prioridad,estado)
	VALUES (1, 'nek','$2a$12$Zc9P5Vnb0dsTAe6T4SuaEOkj7mTCr5EFvlce1NwLFF/jDW6/WMSke','NEK','LUZU',2,'FIFO',true),
	(2, 'demo','$2a$12$Zc9P5Vnb0dsTAe6T4SuaEOkj7mTCr5EFvlce1NwLFF/jDW6/WMSke','DEMO','CAJA',1,'FIFO',true);

-- Auto-generated SQL script #202407072021
INSERT INTO public.sucursal (id,nombre,direccion,orden,estado)
	VALUES (1,'Alborada','Guayaquil Alborada 5ta etapa',1,true),
		(2,'Vergeles','Direccion ejemplo vergeles',2,true),
		(3,'Mucho Lote II','Direccion ejemplo mucho lote 2',2,true);

