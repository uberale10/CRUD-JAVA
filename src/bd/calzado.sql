-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 21-06-2020 a las 22:49:43
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `calzado`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `idempleado` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fechanacimiento` date NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `idrol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idempleado`, `nombre`, `fechanacimiento`, `telefono`, `direccion`, `idrol`) VALUES
(1, 'don julio', '1899-07-19', '12345', 'calle 5', 3),
(2, 'don miguel', '1987-12-07', '11111', 'calle falsa', 3),
(3, 'don pedro', '1982-08-12', '222222', 'no tiene', 2),
(4, 'Camilo', '2007-06-07', '555555', 'calle 5', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `nombre_usuario` varchar(50) NOT NULL,
  `contrasena` varchar(50) NOT NULL,
  `idRoles` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`id`, `nombre_usuario`, `contrasena`, `idRoles`) VALUES
(1, 'Juan', '1234', 1),
(2, 'Alejo', '12345', 4),
(3, 'Valentina', '4555', 2),
(4, 'Martha', '12345', 3),
(7, 'culin', '123', 2),
(9, 'carlos', '123', 2),
(10, 'dfd', 'dfd', 2),
(11, 'veronica', 'teamohp', 4),
(12, 'aa', '123', 3),
(13, 'cucho', '123', 3),
(14, 'qq', 'qq', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparaciones`
--

CREATE TABLE `reparaciones` (
  `codigo` int(11) NOT NULL,
  `fecha_reparacion` date NOT NULL,
  `idUsuarios` int(11) DEFAULT NULL,
  `idRol` int(11) DEFAULT NULL,
  `codZapatos` int(11) DEFAULT NULL,
  `arreglo` varchar(30) NOT NULL,
  `precio` varchar(10) NOT NULL,
  `pago` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `reparaciones`
--

INSERT INTO `reparaciones` (`codigo`, `fecha_reparacion`, `idUsuarios`, `idRol`, `codZapatos`, `arreglo`, `precio`, `pago`) VALUES
(1, '2018-11-08', 13, 3, 1, 'remiendo', '5000', 1000),
(2, '2018-12-05', 1, 4, 1, '222', '2000', 2000),
(5, '2018-11-04', 1, 2, 1, 'asasas', '50000', 20000),
(6, '2018-12-05', 1, 3, 433, 'pega de zuela', '6000', 2500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `rol` varchar(15) NOT NULL DEFAULT 'usuario'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `rol`) VALUES
(1, 'Administrador'),
(2, 'Cajero'),
(3, 'Zapatero'),
(4, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(8) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `telefono` varchar(50) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `idRol` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `fechaNacimiento`, `telefono`, `direccion`, `idRol`) VALUES
(1, 'uber', '1991-04-29', '12345', 'cali', 4),
(2, 'sofia', '2018-12-06', '111111', 'calle 6', 4),
(13, 'diego', '2018-11-10', '212312', 'calle 4', 4),
(123, 'victor4', '2018-11-12', '54321', 'calle falsa', 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zapatos`
--

CREATE TABLE `zapatos` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(30) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `idCliente` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `zapatos`
--

INSERT INTO `zapatos` (`codigo`, `tipo`, `marca`, `idCliente`) VALUES
(1, 'botas', 'brama', NULL),
(2, 'Zapatillas', 'Puma', NULL),
(433, 'asa', 'asds', NULL),
(437, 'Sandalias ', 'CHANEL', NULL),
(438, 'deportivo', 'panpi', NULL);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`idempleado`),
  ADD KEY `idrol` (`idrol`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_login_idRoles` (`idRoles`);

--
-- Indices de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `codZapatos` (`codZapatos`),
  ADD KEY `fk_reparacion_idCliente` (`idUsuarios`),
  ADD KEY `idRol` (`idRol`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuarios_idRol` (`idRol`);

--
-- Indices de la tabla `zapatos`
--
ALTER TABLE `zapatos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `fk_zapatos_idCliente` (`idCliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=124;
--
-- AUTO_INCREMENT de la tabla `zapatos`
--
ALTER TABLE `zapatos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=439;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idrol`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `login`
--
ALTER TABLE `login`
  ADD CONSTRAINT `fk_login_idRoles` FOREIGN KEY (`idRoles`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD CONSTRAINT `fk_reparacion_idCliente` FOREIGN KEY (`idUsuarios`) REFERENCES `usuarios` (`id`),
  ADD CONSTRAINT `reparaciones_ibfk_1` FOREIGN KEY (`codZapatos`) REFERENCES `zapatos` (`codigo`),
  ADD CONSTRAINT `reparaciones_ibfk_2` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_usuarios_idRol` FOREIGN KEY (`idRol`) REFERENCES `roles` (`id`);

--
-- Filtros para la tabla `zapatos`
--
ALTER TABLE `zapatos`
  ADD CONSTRAINT `fk_zapatos_idCliente` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
