-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         8.0.30 - MySQL Community Server - GPL
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para bdexamen
CREATE DATABASE IF NOT EXISTS `bdexamen` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdexamen`;

-- Volcando estructura para tabla bdexamen.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
  `idcliente` bigint NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ci` bigint NOT NULL,
  `direccion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` bigint NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.cliente: ~3 rows (aproximadamente)
INSERT INTO `cliente` (`idcliente`, `apellidos`, `ci`, `direccion`, `nombre`, `telefono`) VALUES
	(1, 'salgado', 8510425, 'loa 123', 'luis', 78787878),
	(2, 'Garcia', 78789844, 'junin 123', 'Pedro ', 784546333),
	(4, 'rios', 9895656, 'canelas 123', 'ana ', 5444565),
	(5, 'rosales', 8799565, 'bolivar 1232', 'alicia', 784545555),
	(6, 'oropeza', 965656, 'arenales 666', 'diego', 4532145);

-- Volcando estructura para tabla bdexamen.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `idequipo` bigint NOT NULL AUTO_INCREMENT,
  `idcliente` bigint NOT NULL,
  `detalle` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `marca` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `modelo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idequipo`),
  KEY `FKowljfwqffiqfkl10y6n5q32co` (`idcliente`),
  CONSTRAINT `FKowljfwqffiqfkl10y6n5q32co` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.equipo: ~4 rows (aproximadamente)
INSERT INTO `equipo` (`idequipo`, `idcliente`, `detalle`, `marca`, `modelo`) VALUES
	(1, 1, 'Color negro', 'Toshiba', 'L390'),
	(3, 1, 'COLOR GRIS', 'SAMSUNG', 'A103'),
	(4, 2, 'NEGRO TINKPAD', 'LENOVOO', 'JJJKKK000'),
	(7, 4, 'CON CARGADOR', 'LENOVO', 'ABC123'),
	(11, 6, 'GENIAL', 'MARCA', 'MODELO');

-- Volcando estructura para tabla bdexamen.orden_trabajo
CREATE TABLE IF NOT EXISTS `orden_trabajo` (
  `idorden` bigint NOT NULL AUTO_INCREMENT,
  `equipoid` bigint NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `idequipo` bigint DEFAULT NULL,
  PRIMARY KEY (`idorden`),
  KEY `FKqvi7n4avv8y3r7e4fb30qedu1` (`idequipo`),
  CONSTRAINT `FKqvi7n4avv8y3r7e4fb30qedu1` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.orden_trabajo: ~5 rows (aproximadamente)
INSERT INTO `orden_trabajo` (`idorden`, `equipoid`, `descripcion`, `fecha`, `idequipo`) VALUES
	(2, 3, 'CAMBIAR TAPA', '2023-07-10 20:00:00', NULL),
	(3, 1, 'MANTENIMIENTO', '2023-07-12 20:00:00', NULL),
	(4, 1, 'corregir', '2023-07-10 20:00:00', NULL),
	(5, 4, 'ARREGLAR', '2023-07-11 20:00:00', NULL),
	(7, 7, 'hacer mantenimiento logico', '2023-07-10 20:00:00', NULL),
	(8, 8, 'ORDEN TRABAJO', '2023-07-10 20:00:00', NULL);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
