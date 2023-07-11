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
  `apellidos` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `ci` bigint NOT NULL,
  `direccion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` bigint NOT NULL,
  PRIMARY KEY (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.cliente: ~2 rows (aproximadamente)

-- Volcando estructura para tabla bdexamen.equipo
CREATE TABLE IF NOT EXISTS `equipo` (
  `idequipo` bigint NOT NULL AUTO_INCREMENT,
  `idcliente` bigint NOT NULL,
  `detalle` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `marca` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `modelo` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`idequipo`),
  KEY `FKowljfwqffiqfkl10y6n5q32co` (`idcliente`),
  CONSTRAINT `FKowljfwqffiqfkl10y6n5q32co` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.equipo: ~1 rows (aproximadamente)

-- Volcando estructura para tabla bdexamen.orden_trabajo
CREATE TABLE IF NOT EXISTS `orden_trabajo` (
  `idorden` bigint NOT NULL AUTO_INCREMENT,
  `equipoid` bigint NOT NULL,
  `descripcion` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `fecha` datetime NOT NULL,
  `idequipo` bigint DEFAULT NULL,
  PRIMARY KEY (`idorden`),
  KEY `FKqvi7n4avv8y3r7e4fb30qedu1` (`idequipo`),
  CONSTRAINT `FKqvi7n4avv8y3r7e4fb30qedu1` FOREIGN KEY (`idequipo`) REFERENCES `equipo` (`idequipo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Volcando datos para la tabla bdexamen.orden_trabajo: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
