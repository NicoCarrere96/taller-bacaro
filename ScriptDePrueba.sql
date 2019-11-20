INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('1', 'Buenos Aires');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('2', 'Santa Fe');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('3', 'Córdoba');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('4', 'Mendoza');
INSERT INTO `taller-bacaro`.`provincia` (`id`, `nombre`) VALUES ('5', 'Entre Rios');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('1', 'Morón', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('2', 'Ciudad Evita', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('3', 'Castelar', '1');
INSERT INTO `taller-bacaro`.`localidad` (`id`, `nombre`, `provincia_id`) VALUES ('4', 'Córdoba', '3');
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

INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `fecha`, `problema`, `cliente_dni`, `taller_id`) VALUES ('1', '0', '20190917', 'algo esta roto', '11222333', '1');
INSERT INTO `taller-bacaro`.`reserva` (`id`, `estado`, `fecha`, `problema`, `cliente_dni`, `taller_id`) VALUES ('2', '2', '20190917', 'algo esta roto', '22333444', '1');
INSERT INTO `taller-bacaro`.`orden` (`id`, `horasDeTrabajo`, `reserva_id`) VALUES ('1', '4', '2');


INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` ) VALUES ('1', 'Neumatico', '1500', '150', 1);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('2', 'Amortiguador', '2000', '200',2);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('3', 'Espiral', '1000', '100', 3);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('4', 'Bujia', '60', '700', 1);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('5', 'Estereo', '12000', '40', 2);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('6', 'Disco', '200', '0', 3);
INSERT INTO `taller-bacaro`.`repuesto` (`id`, `nombre`, `precio`, `stock`, `taller_id` )  VALUES ('7', 'Pastilla', '120', '0', 1);

INSERT INTO `taller-bacaro`.`ordenrepuesto` (`id`, `cantidad`, `orden_id`, `repuesto_id`) VALUES ('1', '2', '1', '1');


INSERT INTO turno (id, descripcion)
VALUES 	(1	,'09:00 - 11:00'),
		(2	,'11:00 - 13:00'),
		(3	,'13:00 - 15:00'),
        (4	,'15:00 - 17:00'),
		(5	,'17:00 - 18:00');