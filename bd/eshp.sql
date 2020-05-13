/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 10.1.40-MariaDB-cll-lve : Database - boutiq14_mbogni
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`eshop` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `eshop`

/*Table structure for table `categorie` */

DROP TABLE IF EXISTS `categorie`;

CREATE TABLE `categorie` (
  `idCat` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomCat` varchar(60) NOT NULL,
  PRIMARY KEY (`idCat`)
) ENGINE=InnoDB AUTO_INCREMENT=1521 DEFAULT CHARSET=utf8;

/*Table structure for table `commande` */

DROP TABLE IF EXISTS `commande`;

CREATE TABLE `commande` (
  `IDCOMMANDE` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DATECOMMANDE` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `MONTANT` decimal(10,2) unsigned NOT NULL,
  `NOMCLIENT` varchar(50) NOT NULL,
  `TELEPHONECLIENT` varchar(20) NOT NULL,
  `ADRESSECLIENT` text NOT NULL,
  `COMMENTAIRE` text,
  `LIVRE` tinyint(1) unsigned DEFAULT '0',
  PRIMARY KEY (`IDCOMMANDE`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

/*Table structure for table `facture` le magaziner, le czissier, proprietaire, super administrateur*/

DROP TABLE IF EXISTS `facture`;

CREATE TABLE `facture` (
  `idFac` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `dateFac` datetime NOT NULL,
  `remise` decimal(4,2) NOT NULL,
  `montant` decimal(10,2) NOT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `typeFac` tinyint(1) NOT NULL DEFAULT '0',
  `idCaissiere` int(10) unsigned NOT NULL,
  PRIMARY KEY (`idFac`),
  KEY `fk_idCaiss_idx` (`idCaissiere`),
  CONSTRAINT `fk_idCaiss` FOREIGN KEY (`idCaissiere`) REFERENCES `gestionnaire` (`idGest`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1003206 DEFAULT CHARSET=utf8;

/*Table structure for table `gestionnaire` */

DROP TABLE IF EXISTS `gestionnaire`;

CREATE TABLE `gestionnaire` (
  `idGest` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nomGest` varchar(45) NOT NULL,
  `typeGest` tinyint(1) NOT NULL,
  `login` varchar(20) NOT NULL,
  `pwd` varchar(20) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`idGest`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

/*Table structure for table `gestionstock` */

DROP TABLE IF EXISTS `gestionstock`;

CREATE TABLE `gestionstock` (
  `idStock` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `qte` int(10) unsigned NOT NULL,
  `dateStock` datetime NOT NULL,
  `operation` tinyint(1) NOT NULL DEFAULT '0',
  `idGest` int(10) unsigned NOT NULL,
  `codePro` int(8) unsigned NOT NULL,
  PRIMARY KEY (`idStock`),
  KEY `fk_idGest_stock_idx` (`idGest`),
  KEY `fk_codePro_stock_idx` (`codePro`),
  CONSTRAINT `fk_codePro_stock` FOREIGN KEY (`codePro`) REFERENCES `produit` (`codePro`),
  CONSTRAINT `fk_idGest_stock` FOREIGN KEY (`idGest`) REFERENCES `gestionnaire` (`idGest`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=201509 DEFAULT CHARSET=utf8;

/*Table structure for table `lignecommande` */

DROP TABLE IF EXISTS `lignecommande`;

CREATE TABLE `lignecommande` (
  `IDLCOMMANDE` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `IDCOMMANDE` int(10) unsigned NOT NULL,
  `CODEPRODUIT` int(10) unsigned NOT NULL,
  `QUANTITE` int(10) unsigned NOT NULL,
  `TAILLE` varchar(30) DEFAULT '',
  `COULEUR` varchar(30) DEFAULT '',
  PRIMARY KEY (`IDLCOMMANDE`),
  KEY `fk_IDCOMMANDE` (`IDCOMMANDE`),
  KEY `fk_CODEPRODUIT` (`CODEPRODUIT`),
  CONSTRAINT `fk_CODEPRODUIT` FOREIGN KEY (`CODEPRODUIT`) REFERENCES `produit` (`codePro`),
  CONSTRAINT `fk_IDCOMMANDE` FOREIGN KEY (`IDCOMMANDE`) REFERENCES `commande` (`IDCOMMANDE`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;

/*Table structure for table `lignefacture` */

DROP TABLE IF EXISTS `lignefacture`;

CREATE TABLE `lignefacture` (
  `idLFac` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `codePro` int(10) unsigned NOT NULL,
  `idFac` int(10) unsigned NOT NULL,
  `prix` decimal(10,2) NOT NULL,
  `qte` smallint(4) unsigned NOT NULL,
  PRIMARY KEY (`codePro`,`idFac`),
  UNIQUE KEY `idLFac` (`idLFac`),
  KEY `fk_idFac` (`idFac`),
  CONSTRAINT `fk_codePro` FOREIGN KEY (`codePro`) REFERENCES `produit` (`codePro`),
  CONSTRAINT `fk_idFac` FOREIGN KEY (`idFac`) REFERENCES `facture` (`idFac`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3856 DEFAULT CHARSET=utf8;


/*Table structure for table `produit` */

DROP TABLE IF EXISTS `produit`;

CREATE TABLE `produit` (
  `codePro` int(8) unsigned NOT NULL,
  `nomPro` varchar(100) NOT NULL DEFAULT 'ND',
  `prixAchat` decimal(8,2) NOT NULL,
  `prixVente` decimal(8,2) NOT NULL,
  `qte` decimal(8,2) unsigned NOT NULL,
  `description` varchar(100) NOT NULL DEFAULT 'RAS',
  `codeFour` varchar(12) NOT NULL,
  `actif` tinyint(1) NOT NULL DEFAULT '1',
  `idCategorie` int(10) unsigned NOT NULL,
  `dateInsertion` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`codePro`),
  KEY `fk_idCategorie` (`idCategorie`),
  CONSTRAINT `fk_idCategorie` FOREIGN KEY (`idCategorie`) REFERENCES `categorie` (`idCat`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
