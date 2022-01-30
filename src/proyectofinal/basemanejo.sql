-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 30-01-2022 a las 19:02:06
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `basemanejo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablaestudiantes`
--

CREATE TABLE `tablaestudiantes` (
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  `nota` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tablaestudiantes`
--

INSERT INTO `tablaestudiantes` (`cedula`, `nombre`, `apellido`, `correo`, `contraseña`, `nota`) VALUES
('1901', 'Pablo', 'Paredes', 'pparedes@uta', 'pparedes', 'S/N'),
('1902', 'Juan', 'Carrazco', 'jcarrazco@uta', 'jcarrazco', 'Aprobado'),
('1903', 'Adan', 'Villafuerte', 'avillafuerte@uta', 'avillafuerte', 'Reprobado'),
('1904', 'Marco', 'Diaz', 'mdiaz@uta', 'mdiaz', 'Aprobado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tablamaestros`
--

CREATE TABLE `tablamaestros` (
  `cedula` varchar(10) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  `apellido` varchar(15) NOT NULL,
  `correo` varchar(20) NOT NULL,
  `contraseña` varchar(20) NOT NULL,
  `materia` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tablamaestros`
--

INSERT INTO `tablamaestros` (`cedula`, `nombre`, `apellido`, `correo`, `contraseña`, `materia`) VALUES
('1801', 'Carlos', 'Perez', 'cperez@uta', 'cperez', 'Matematicas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tablaestudiantes`
--
ALTER TABLE `tablaestudiantes`
  ADD PRIMARY KEY (`cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
