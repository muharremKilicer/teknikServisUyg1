-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 15 Nis 2016, 07:17:22
-- Sunucu sürümü: 5.6.17
-- PHP Sürümü: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Veritabanı: `vize1`
--

DELIMITER $$
--
-- Yordamlar
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `arama`(IN `ara` VARCHAR(255))
BEGIN
	#Routine body goes here...

	SELECT * FROM arizalar, cihazlar WHERE cihazlar.marka = arizalar.cihazModel AND MATCH(madi) AGAINST (ara IN BOOLEAN MODE);

END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `arizalar`
--

CREATE TABLE IF NOT EXISTS `arizalar` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `madi` varchar(255) DEFAULT NULL,
  `mtelefon` varchar(255) DEFAULT NULL,
  `cihazModel` varchar(255) DEFAULT NULL,
  `cihazArizasi` varchar(255) DEFAULT NULL,
  `durum` tinyint(255) DEFAULT NULL,
  PRIMARY KEY (`aid`),
  FULLTEXT KEY `madi` (`madi`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Tablo döküm verisi `arizalar`
--

INSERT INTO `arizalar` (`aid`, `madi`, `mtelefon`, `cihazModel`, `cihazArizasi`, `durum`) VALUES
(3, 'ali', '333', 'cihaz2', 'ariza2', 1),
(6, 'atilla', '123', 'cihaz1', 'ariza', 1),
(7, 'veli', '1234567890', 'cihaz3', 'arizası', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `cihazlar`
--

CREATE TABLE IF NOT EXISTS `cihazlar` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `adi` varchar(255) DEFAULT NULL,
  `marka` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `adi` (`adi`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=50 ;

--
-- Tablo döküm verisi `cihazlar`
--

INSERT INTO `cihazlar` (`cid`, `adi`, `marka`, `model`) VALUES
(41, 'cihaz2', 'cihaz2', 'cihaz2'),
(48, 'cihaz1', 'cihaz1', 'cihaz1'),
(49, 'cihaz3', 'cihaz3', 'cihaz3');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kullanici`
--

CREATE TABLE IF NOT EXISTS `kullanici` (
  `kid` int(11) NOT NULL AUTO_INCREMENT,
  `kadi` varchar(255) DEFAULT NULL,
  `sifre` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`kid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Tablo döküm verisi `kullanici`
--

INSERT INTO `kullanici` (`kid`, `kadi`, `sifre`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
