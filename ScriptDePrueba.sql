INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('1', 'Buenos Aires');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('2', 'Santa Fe');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('3', 'CÃ³rdoba');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('4', 'Mendoza');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('5', 'Entre Rios');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('1', 'MorÃ³n', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('2', 'Ciudad Evita', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('3', 'Castelar', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('4', 'CÃ³rdoba', '3');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('5', 'Rio Cuarto', '3');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('6', 'San Francisco', '3');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('7', 'Mina Clavero', '3');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('8', 'Rafaela', '2');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('9', 'Rosario', '2');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('10', 'Santa Fe', '2');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('11', 'Parana', '5');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('12', 'Mendoza', '4');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('13', 'Godoy Cruz', '4');
INSERT INTO `taller-bacaro`.`cliente` (`dni`, `apellido`, `mail`, `nombre`, `telefono`) VALUES ('11222333', 'Gomez', 'agomez@unlam.com', 'Alfredo', '12345678');
INSERT INTO `taller-bacaro`.`cliente` (`dni`, `apellido`, `mail`, `nombre`, `telefono`) VALUES ('22333444', 'Perez', 'mperez@unlam.com', 'Miguel', '23456789');

INSERT INTO `taller-bacaro`.`usuario` (`id`, `email`, `password`, `rol`) VALUES ('1', 'lodetito@racingteam.com', '4444', 'taller');
INSERT INTO `taller-bacaro`.`usuario` (`id`, `email`, `password`, `rol`) VALUES ('2', 'admin@racingteam.com', '1111', 'admin');
INSERT INTO `taller-bacaro`.`usuario` (`id`, `email`, `password`, `rol`) VALUES ('3', 'cacho@gomeriacacho.com', '1111', 'taller');
INSERT INTO `taller-bacaro`.`usuario` (`id`, `email`, `password`, `rol`) VALUES ('4', 'gg@gomeriag.com', '1111', 'taller');

INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('1', 'Tte.Gral.Juan Domingo Peron', '0', '500.0', 'Roberto', 'Tito', '2190',  '46203852', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('2', 'El Calden', '0', '485.0', 'Carlos', 'Gomeria Cacho', '1821',  '44871188', '2', '3');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('3', 'Justo Daract', '0', '685.0', 'Gerardo', 'Gomeria G', '1500',  '44871199', '2', '4');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('4', 'migueletes', '1', '582.0', 'Armando', 'Taller-Armando', '1998',  '44875366', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('5', 'el blanquillo', '2', '582.0', 'Juan', 'lubri-movil', '2210',  '44873366', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('6', 'av. esteban crovara', '3', '582.0', 'mariano', 'Ms', '5447',  '44870215', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('7', 'cno. de cintura', '4', '582.0', 'Arnaldo', 'Jb', '7781',  '44875577', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('8', 'av. italia', '5', '582.0', 'Pedro', 'cisa', '1200',  '44878967', '2', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('9', 'cno. de cintura', '6', '582.0', 'José', 'Pepe', '4300',  '44873152', '2', '1');


INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('10', 'Av. Rivadavia', '0', '582.0', 'Guido', 'Lopez', '17332',  '44891148', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('11', 'Tucuman', '1', '582.0', 'Luis', 'Los santiagueños', '951',  '46294690', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('12', 'Carlos Pellegrini', '2', '582.0', 'Juan', 'El fortin', '534',  '46297680', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('13', 'Dr. Rodolfo Monte', '3', '582.0', 'mariano', 'Mr', '381',  '', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('14', 'Av. Eva Peron', '4', '582.0', 'Carlos', 'Edg', '1388',  '46962939', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('15', 'Gral. Juan Jose Valle', '5', '582.0', 'Walter', 'GPS-Taller', '233',  '46277839', '1', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('16', 'Av. Hipolito Yrigoyen', '6', '582.0', 'Damian', 'El colorado', '268',  '22003046', '1', '1');

INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('17', 'Sarmiento', '1', '582.0', 'Raul', 'Customcast', '2134',  '46290549', '3', '1');
INSERT INTO `taller-bacaro`.`taller` (`id`, `calle`, `especialidad`, `manoDeObra`, `nombreDelDuenio`, `nombreDelTaller`, `numero`, `telefono`, `localidad_id`, `usuario_id`) 
VALUES ('18', 'Av. Zeballos', '2', '582.0', 'Matias', 'La ruta', '2873',  '46241106', '3', '1');


INSERT INTO `taller-bacaro`.`turno` (`id`, `fecha`, `horario`, `cantidad`)
VALUES 	(1	,'24/02/2020', '08:00 - 14:00', 3),
		(2	,'25/02/2020', '08:00 - 14:00', 2),
		(3	,'26/02/2020', '08:00 - 14:00', 2),
        (4	,'27/02/2020', '08:00 - 14:00', 1),
		(5	,'28/02/2020', '08:00 - 14:00', 1);

<<<<<<< HEAD
INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `turno_id`, `problema`, `cliente_dni`, `taller_id`) VALUES ('1', '0', '4', 'algo esta roto', '11222333', '1');
INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `turno_id`, `problema`, `cliente_dni`, `taller_id`) VALUES ('2', '2', '4', 'algo esta roto', '22333444', '1');
=======
INSERT INTO `taller-bacaro`.`turno` (id, horario, descripcion)
VALUES 	(1	,1,'09:00 - 11:00'),
		(2	,2,'11:00 - 13:00'),
		(3	,3,'13:00 - 15:00'),
        (4	,4,'15:00 - 17:00'),
		(5	,5,'17:00 - 18:00');
INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `fecha`, `problema`, `cliente_dni`, `taller_id`, `reserva_turno`) VALUES ('1', '0', '20190917', 'algo esta roto', '11222333', '1',1);
INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `fecha`, `problema`, `cliente_dni`, `taller_id`, `reserva_turno`) VALUES ('2', '2', '20190917', 'algo esta roto', '22333444', '1',1);
>>>>>>> turnos
INSERT INTO `taller-bacaro`.`orden` (`id`, `horasDeTrabajo`, `reserva_id`) VALUES ('1', '4', '2');

INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` ) VALUES ('1', 'Neumatico', '1500', '150', 1);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('2', 'Amortiguador', '2000', '200',2);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('3', 'Espiral', '1000', '100', 3);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('4', 'Bujia', '60', '700', 1);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('5', 'Estereo', '12000', '40', 2);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('6', 'Disco', '200', '0', 3);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('7', 'Pastilla', '120', '0', 1);
<<<<<<< HEAD
=======

INSERT INTO `taller-bacaro`.`ordenrepuesto` (`id`, `cantidad`, `orden_id`, `repuesto_id`) VALUES ('1', '2', '1', '1');

>>>>>>> turnos
