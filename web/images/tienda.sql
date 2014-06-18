-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-06-2014 a las 13:59:27
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE IF NOT EXISTS `categoria` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `imagen` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `imagen`) VALUES
(1, 'Bicicletas', 'carreras.jpg'),
(2, 'Patines', 'linea.jpg'),
(3, 'Monopatines', 'monopatin.jpg'),
(4, 'Accesorios', 'guantes.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DNI` varchar(10) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `direccion` varchar(60) NOT NULL,
  `poblacion` varchar(20) NOT NULL,
  `tarjeta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCliente_UNIQUE` (`id`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `DNI`, `Nombre`, `email`, `telefono`, `direccion`, `poblacion`, `tarjeta`) VALUES
(5, 'ih', 'jhohj', 'hoi', 'hoh', 'oh', 'oh', 'oh'),
(6, 'er', 'er', 'er', 'lkn', 'kj', 'ln', 'ljo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_orden`
--

CREATE TABLE IF NOT EXISTS `detalle_orden` (
  `idProducto` int(10) unsigned NOT NULL,
  `idOrden` int(10) unsigned NOT NULL,
  `cantidad` int(10) unsigned NOT NULL,
  `total` decimal(8,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`idOrden`,`idProducto`),
  KEY `fkProducto_idx` (`idProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `detalle_orden`
--

INSERT INTO `detalle_orden` (`idProducto`, `idOrden`, `cantidad`, `total`) VALUES
(6, 5, 1, 150.00),
(7, 5, 1, 300.00),
(2, 6, 1, 300.00),
(3, 6, 1, 150.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden_cliente`
--

CREATE TABLE IF NOT EXISTS `orden_cliente` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `total` decimal(6,2) NOT NULL DEFAULT '0.00',
  `fecha` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `NumeroConfirmacion` int(10) unsigned NOT NULL,
  `idCliente` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NumeroConfirmacion_UNIQUE` (`NumeroConfirmacion`),
  KEY `fkCliente_idx` (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Volcado de datos para la tabla `orden_cliente`
--

INSERT INTO `orden_cliente` (`id`, `total`, `fecha`, `NumeroConfirmacion`, `idCliente`) VALUES
(5, 1210.00, '2014-06-18 11:48:34', 297165183, 5),
(6, 1060.00, '2014-06-18 11:54:06', 101435098, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Imagen` varchar(45) NOT NULL,
  `Descripcion` varchar(45) NOT NULL,
  `Precio` decimal(6,2) NOT NULL,
  `idCategoria` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fkCategoria_idx` (`idCategoria`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=18 ;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `Nombre`, `Imagen`, `Descripcion`, `Precio`, `idCategoria`) VALUES
(2, 'Carreras', 'carreras.jpg', 'bicicleta de carreras amateur', 300.00, 1),
(3, 'Paseo', 'paseo.jpg', 'bicicleta parea pasear', 150.00, 1),
(4, 'Mountain', 'mountain.jpg', 'bicicleta todoterreno para deporte extremo', 600.00, 1),
(5, 'BMX', 'BMX.jpg', 'bicicleta para cross', 360.00, 1),
(6, 'Línea', 'linea.jpg', 'patinaje deportivo', 150.00, 2),
(7, 'Hielo', 'hielo.jpg', 'para patinaje sobre hielo', 300.00, 2),
(8, 'Paralelo', 'paralelo.jpg', '4 ruedas paralelas', 80.00, 2),
(9, 'Infantil', 'infantil.jpg', 'para niños', 40.00, 2),
(10, 'Monopatín', 'monopatin.jpg', 'monopatín clásico', 80.00, 3),
(11, 'Patinete', 'patinete.jpg', 'para desplazamiento urbano', 70.00, 3),
(12, 'LongBoard', 'longboard.jpg', 'grandes dimensiones', 150.00, 3),
(13, 'Articulados', 'articulado.jpg', 'articulado ligero', 50.00, 3),
(14, 'Casco', 'casco.jpg', 'Obligatorio legalmente', 20.00, 4),
(15, 'Guantes', 'guantes.jpg', 'Para las manos', 25.00, 4),
(16, 'Rueda', 'rueda.JPG', 'repuestos de colores', 45.00, 4),
(17, 'Protecciones', 'protecciones.jpg', 'rodilleras y coderas', 40.00, 4);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalle_orden`
--
ALTER TABLE `detalle_orden`
  ADD CONSTRAINT `fkOrden` FOREIGN KEY (`idOrden`) REFERENCES `orden_cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fkProducto` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `orden_cliente`
--
ALTER TABLE `orden_cliente`
  ADD CONSTRAINT `fkCliente` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `fkCategoria` FOREIGN KEY (`idCategoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
