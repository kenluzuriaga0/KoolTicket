INSERT INTO public.roles (nombre) VALUES ('ROLE_CAJERO');
INSERT INTO public.roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('C','consultas',true);
INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('I','informacion',true);
INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('L','laboratorio',true);
INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('P','pruebas covid-19',true);
INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('O','otros servicios',true);
INSERT INTO public.botones (nombre,descripcion,estado)	VALUES ('D','derivaciones',true);

INSERT INTO public.usuarios (username,password,nombres,apellidos,id_rol,caja_prioridad,estado)
	VALUES ('nek','$2a$12$Zc9P5Vnb0dsTAe6T4SuaEOkj7mTCr5EFvlce1NwLFF/jDW6/WMSke','NEK','LUZU',1,'FIFO',true);
