# Host: localhost  (Version: 5.6.25)
# Date: 2016-08-06 09:44:20
# Generator: MySQL-Front 5.3  (Build 5.16)

/*!40101 SET NAMES latin1 */;

create database catalog_book;
use catalog_book;

#
# Structure for table "ms_buku"
#
DROP TABLE IF EXISTS `ms_buku`;
CREATE TABLE `ms_buku` (
  `id_buku` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(100) DEFAULT NULL,
  `judul_buku` varchar(100) DEFAULT NULL,
  `pengarang` varchar(50) DEFAULT NULL,
  `tahun_buku` int(11) DEFAULT NULL,
  `kat_id` int(11) DEFAULT NULL,
  `image_buku` blob,
  `sinopsis_buku` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_buku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for table "ms_kategori"
#

DROP TABLE IF EXISTS `ms_kategori`;
CREATE TABLE `ms_kategori` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_kategori` varchar(50) DEFAULT NULL,
  `desc_kategori` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for table "ms_kategori"
#

