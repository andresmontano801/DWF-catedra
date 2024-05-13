-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-05-2024 a las 20:38:01
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `snickersv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `Id` int(11) NOT NULL,
  `Marca` varchar(80) NOT NULL,
  `Modelo` varchar(80) NOT NULL,
  `Precio` double NOT NULL,
  `talla` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `color` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`Id`, `Marca`, `Modelo`, `Precio`, `talla`, `stock`, `color`) VALUES
(1, 'Nike', 'Jordan 1', 170.99, 7, 8, 'Negro'),
(2, 'Nike', 'Dunk', 124.99, 5, 7, 'Azul'),
(3, 'Nike', 'Air force one', 80.99, 6, 10, 'Blanco'),
(5, 'Puma', 'Fast Rider', 109.99, 7, 5, 'Multicolor'),
(6, 'Adidas', 'Concha', 100.99, 8, 7, 'Blanco'),
(7, 'Puma', 'Classics', 150.99, 6, 3, 'Negro'),
(9, 'Puma', 'Classics', 150.99, 7, 3, 'Blanco'),
(10, 'Nike', 'Jordan 1', 170.99, 8, 10, 'Rojo');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
