-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-05-2024 a las 23:36:29
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proveedores`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `id_ciudad` int(11) NOT NULL,
  `nombre_ciudad` varchar(255) NOT NULL,
  `departamento_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`id_ciudad`, `nombre_ciudad`, `departamento_id`) VALUES
(2, 'Leticia', 2),
(3, 'Puerto Nariño', 2),
(4, 'Tarapacá', 2),
(5, 'Puerto Alegría', 2),
(6, 'Medellín', 3),
(7, 'Envigado', 3),
(8, 'Itagüí', 3),
(9, 'Bello', 3),
(10, 'Arauca', 4),
(11, 'Saravena', 4),
(12, 'Arauquita', 4),
(13, 'Tame', 4),
(14, 'Barranquilla', 5),
(15, 'Soledad', 5),
(16, 'Malambo', 5),
(17, 'Sabanagrande', 5),
(18, 'Cartagena', 6),
(19, 'Barranco de Loba', 6),
(20, 'Magangué', 6),
(21, 'Arjona', 6),
(22, 'Tunja', 7),
(23, 'Duitama', 7),
(24, 'Sogamoso', 7),
(25, 'Chiquinquirá', 7),
(26, 'Manizales', 8),
(27, 'La Dorada', 8),
(28, 'Chinchiná', 8),
(29, 'Villamaría', 8),
(30, 'Florencia', 9),
(31, 'Belén de los Andaquíes', 9),
(32, 'San Vicente del Caguán', 9),
(33, 'La Montañita', 9),
(34, 'Yopal', 10),
(35, 'Aguazul', 10),
(36, 'Tauramena', 10),
(37, 'Paz de Ariporo', 10),
(38, 'Popayán', 11),
(39, 'Santander de Quilichao', 11),
(40, 'Patía', 11),
(41, 'Puerto Tejada', 11),
(42, 'Valledupar', 12),
(43, 'Aguachica', 12),
(44, 'La Paz', 12),
(45, 'Codazzi', 12),
(46, 'Quibdó', 13),
(47, 'Istmina', 13),
(48, 'Tadó', 13),
(49, 'Condoto', 13),
(50, 'Montería', 14),
(51, 'Lorica', 14),
(52, 'Sahagún', 14),
(53, 'Montelíbano', 14),
(54, 'Bogotá', 15),
(55, 'Soacha', 15),
(56, 'Zipaquirá', 15),
(57, 'Chía', 15),
(58, 'Inírida', 16),
(59, 'Barrancominas', 16),
(60, 'Cacahual', 16),
(61, 'La Guadalupe', 16),
(62, 'San José del Guaviare', 17),
(63, 'El Retorno', 17),
(64, 'Calamar', 17),
(65, 'Miraflores', 17),
(66, 'Neiva', 18),
(67, 'Pitalito', 18),
(68, 'Garzón', 18),
(69, 'La Plata', 18),
(70, 'Riohacha', 19),
(71, 'Maicao', 19),
(72, 'Uribia', 19),
(73, 'Albania', 19),
(74, 'Santa Marta', 20),
(75, 'Ciénaga', 20),
(76, 'Fundación', 20),
(77, 'Plato', 20),
(78, 'Villavicencio', 21),
(79, 'Acacías', 21),
(80, 'Puerto López', 21),
(81, 'Granada', 21),
(82, 'Pasto', 22),
(83, 'Tumaco', 22),
(84, 'Ipiales', 22),
(85, 'Tuquerres', 22),
(86, 'Cúcuta', 23),
(87, 'Ocaña', 23),
(88, 'Pamplona', 23),
(89, 'Villa del Rosario', 23),
(90, 'Mocoa', 24),
(91, 'Puerto Asís', 24),
(92, 'Sibundoy', 24),
(93, 'Villagarzón', 24),
(94, 'Armenia', 25),
(95, 'Calarcá', 25),
(96, 'Montenegro', 25),
(97, 'La Tebaida', 25),
(98, 'Pereira', 26),
(99, 'Dosquebradas', 26),
(100, 'La Virginia', 26),
(101, 'Santa Rosa de Cabal', 26),
(102, 'San Andrés', 27),
(103, 'Providencia', 27),
(104, 'San Luis', 27),
(105, 'El Cove', 27),
(106, 'Bucaramanga', 28),
(107, 'Barrancabermeja', 28),
(108, 'Floridablanca', 28),
(109, 'Girón', 28),
(110, 'Sincelejo', 29),
(111, 'Corozal', 29),
(112, 'San Marcos', 29),
(113, 'Tolú', 29),
(114, 'Ibagué', 30),
(115, 'Espinal', 30),
(116, 'Melgar', 30),
(117, 'Honda', 30),
(118, 'Cali', 31),
(119, 'Buenaventura', 31),
(120, 'Palmira', 31),
(121, 'Tuluá', 31),
(122, 'Mitú', 32),
(123, 'Carurú', 32),
(124, 'Pacoa', 32),
(125, 'Taraira', 32),
(126, 'Puerto Carreño', 33),
(127, 'La Primavera', 33),
(128, 'Santa Rosalía', 33),
(129, 'Cumaribo', 33);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamento`
--

CREATE TABLE `departamento` (
  `id_departamento` int(11) NOT NULL,
  `nombre_departamento` varchar(255) NOT NULL,
  `pais_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departamento`
--

INSERT INTO `departamento` (`id_departamento`, `nombre_departamento`, `pais_id`) VALUES
(2, 'Amazonas', 1),
(3, 'Antioquia', 1),
(4, 'Arauca', 1),
(5, 'Atlántico', 1),
(6, 'Bolívar', 1),
(7, 'Boyacá', 1),
(8, 'Caldas', 1),
(9, 'Caquetá', 1),
(10, 'Casanare', 1),
(11, 'Cauca', 1),
(12, 'Cesar', 1),
(13, 'Chocó', 1),
(14, 'Córdoba', 1),
(15, 'Cundinamarca', 1),
(16, 'Guainía', 1),
(17, 'Guaviare', 1),
(18, 'Huila', 1),
(19, 'La Guajira', 1),
(20, 'Magdalena', 1),
(21, 'Meta', 1),
(22, 'Nariño', 1),
(23, 'Norte de Santander', 1),
(24, 'Putumayo', 1),
(25, 'Quindío', 1),
(26, 'Risaralda', 1),
(27, 'San Andrés y Providencia', 1),
(28, 'Santander', 1),
(29, 'Sucre', 1),
(30, 'Tolima', 1),
(31, 'Valle del Cauca', 1),
(32, 'Vaupés', 1),
(33, 'Vichada', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pais`
--

CREATE TABLE `pais` (
  `id_pais` int(11) NOT NULL,
  `nombre_pais` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pais`
--

INSERT INTO `pais` (`id_pais`, `nombre_pais`) VALUES
(1, 'colombia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL,
  `nit` varchar(11) NOT NULL,
  `nombre_representante_legal` varchar(100) NOT NULL,
  `razon_social` varchar(100) NOT NULL,
  `ruta_rut` varchar(255) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  `tipo_persona` varchar(10) NOT NULL,
  `ciudad_id` int(11) NOT NULL,
  `departamento_id` int(11) NOT NULL,
  `pais_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `direccion`, `email`, `nit`, `nombre_representante_legal`, `razon_social`, `ruta_rut`, `telefono`, `tipo_persona`, `ciudad_id`, `departamento_id`, `pais_id`) VALUES
(1, 'Calle 123 #45-67', 'juan.perez@ejemplo.com', '12345678901', 'Juan Perez', 'Empresa Ejemplo S.A.', 'ruta/al/archivo.pdf', '1234567890', 'Juridica', 3, 2, 1),
(2, 'Calle 123 #45-67', 'juan.perez@ejemplo.com', '12345678901', 'Juan Perez', 'Empresa Ejemplo S.A.', 'ruta/al/archivo.pdf', '1234567890', 'Juridica', 3, 2, 1),
(3, 'Calle 123 #45-67', 'juan.perez@ejemplo.com', '12345678901', 'Juan Perez', 'Empresa Ejemplo S.A.', 'ruta/al/archivo.pdf', '1234567890', 'Juridica', 3, 2, 1),
(4, 'carrera 74a 96 17', 'daniwar3@gmail.com', '1017233498', 'daniel puerta', 'grupo uribe', 'C:\\fakepath\\certificado cesde ortografia.pdf', '3103568928', 'natural', 3, 2, 1),
(5, 'Carrera 74a #96-17', 'ana@ana.com', '1214729035', 'ana diaz', 'ana cocina', 'C:\\fakepath\\Descarga_tu_Certificado.pdf', '3146560190', 'juridica', 3, 19, 1),
(6, 'Carrera 74a 96-17', 'sonimur70@hotmail.com', '43677557', 'sonia murillo', 'cardiovid', 'C:\\fakepath\\Descarga_tu_Certificado.pdf', '3127332835', 'natural', 16, 5, 1),
(7, 'Carrera 74a 96-17', 'sonimur70@hotmail.com', '43677557', 'sonia murillo', 'cardiovid', 'C:\\fakepath\\Descarga_tu_Certificado.pdf', '3127332835', 'natural', 16, 5, 1),
(8, 'Carrera 74a 96-17', 'sonimur70@hotmail.com', '43677557', 'sonia murillo', 'cardiovid', 'C:\\fakepath\\Descarga_tu_Certificado.pdf', '3127332835', 'natural', 16, 5, 1),
(9, 'Carrera 74a #96-17', 'daniwar3@gmail.com', '1017233498', 'daniel puerta', 'ana cocina', 'uploads\\Descarga_tu_Certificado.pdf', '3103568928', 'natural', 51, 14, 1),
(10, 'Carrera 74a #96-17', 'daniwar3@gmail.com', '1017233498', 'daniel puerta', 'ana cocina', 'uploads\\Descarga_tu_Certificado.pdf', '3103568928', 'natural', 51, 14, 1),
(11, 'Carrera 74a #96-17', 'dpuerta@cesde.net', '3233434', 'daniel puerta', 'ana cocina', 'uploads\\certificado cesde ortografia.pdf', '3103568929', 'juridica', 63, 17, 1),
(12, 'Carrera 74a #96-18', 'david@david.com', '98459683', 'david mariaca', 'asados la palma', 'uploads\\diploma-java-oop.pdf', '3103568929', 'juridica', 8, 3, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`id_ciudad`),
  ADD KEY `FKev870hgt8a7wx5t21q4mnsu3k` (`departamento_id`);

--
-- Indices de la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD PRIMARY KEY (`id_departamento`),
  ADD KEY `FKs4ob59h57ccjv16ie2esul77h` (`pais_id`);

--
-- Indices de la tabla `pais`
--
ALTER TABLE `pais`
  ADD PRIMARY KEY (`id_pais`),
  ADD UNIQUE KEY `UK_7ksojttl4hutfrtnvldhm9e79` (`nombre_pais`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKa3k9g932xlqwduj4m07j0k4fd` (`ciudad_id`),
  ADD KEY `FK146o1hxiwha3p428h18b7bj9i` (`departamento_id`),
  ADD KEY `FKifyod2hvbvgp83ifn0gaswt0d` (`pais_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `id_ciudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=130;

--
-- AUTO_INCREMENT de la tabla `departamento`
--
ALTER TABLE `departamento`
  MODIFY `id_departamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT de la tabla `pais`
--
ALTER TABLE `pais`
  MODIFY `id_pais` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD CONSTRAINT `FKev870hgt8a7wx5t21q4mnsu3k` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id_departamento`);

--
-- Filtros para la tabla `departamento`
--
ALTER TABLE `departamento`
  ADD CONSTRAINT `FKs4ob59h57ccjv16ie2esul77h` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id_pais`);

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `FK146o1hxiwha3p428h18b7bj9i` FOREIGN KEY (`departamento_id`) REFERENCES `departamento` (`id_departamento`),
  ADD CONSTRAINT `FKa3k9g932xlqwduj4m07j0k4fd` FOREIGN KEY (`ciudad_id`) REFERENCES `ciudad` (`id_ciudad`),
  ADD CONSTRAINT `FKifyod2hvbvgp83ifn0gaswt0d` FOREIGN KEY (`pais_id`) REFERENCES `pais` (`id_pais`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
