DROP DATABASE IF EXISTS Alimentation;

CREATE DATABASE Alimentation CHARACTER SET 'utf8';

USE Alimentation;

CREATE TABLE Produit(
	codePro INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100),
	prixVente DECIMAL(8, 2),
	prixAchat DECIMAL(8, 2),
	qte DECIMAL(8, 2),
	description VARCHAR(1000),
	fourn INT(3) UNSIGNED,
	dateInsert DATETIME,
	actif TINYINT(1),
	categorie INT(3) UNSIGNED
) Engine = InnoDB;

CREATE TABLE Categorie(
	id INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(60)
) Engine = InnoDB;

CREATE TABLE Fournisseur(
	id INT(3) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(45),
	adresse VARCHAR(45),
	tel VARCHAR(45)
) Engine = InnoDB;

CREATE TABLE LigneFacture(
	id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	produit INT(6) UNSIGNED,
	facture INT(10) UNSIGNED,
	prixAchat DECIMAL(8, 2),
	prixVente DECIMAL(8, 2),
	qte DECIMAL(8, 2)
) Engine = InnoDB;

CREATE TABLE GestionStock(
	id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	qte DECIMAL(8, 2),
	dateStockage DATETIME,
	operation TINYINT(1),
	gestionnaire INT(4) UNSIGNED,
	produit INT(6) UNSIGNED
) Engine = InnoDB;

CREATE TABLE Client(
	id INT(7) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(100),
	tel VARCHAR(13),
	adresse VARCHAR(45),
	bonus INT(10),
	actif TINYINT(1)
) Engine = InnoDB;

CREATE TABLE Facture(
	id INT(10) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	dateFacturation DATETIME,
	codePaiement VARCHAR(60),
	remise DECIMAL(4, 2),
	montant DECIMAL(10, 2),
	modePaiement TINYINT(1),
	caissiere INT(4) UNSIGNED,
	client INT(7) UNSIGNED
) Engine = InnoDB;

CREATE TABLE Gestionnaire(
	id INT(4) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	nom VARCHAR(45),
	type TINYINT(1),
	login VARCHAR(20),
	pwd VARCHAR(100),
	actif TINYINT(1)
) Engine = InnoDB;

ALTER TABLE Produit ADD CONSTRAINT fk_prod_fourn FOREIGN KEY (fourn) REFERENCES Fournisseur(id) ON DELETE SET NULL;
ALTER TABLE Produit ADD CONSTRAINT fk_prod_categorie FOREIGN KEY (categorie) REFERENCES Categorie(id) ON DELETE SET NULL;
ALTER TABLE LigneFacture ADD CONSTRAINT fk_ligneFac_codePro FOREIGN KEY (produit) REFERENCES Produit(codePro) ON DELETE SET NULL;
ALTER TABLE LigneFacture ADD CONSTRAINT fk_ligneFac_facture FOREIGN KEY (facture) REFERENCES Facture(id) ON DELETE SET NULL;
ALTER TABLE GestionStock ADD CONSTRAINT fk_stock_codePro FOREIGN KEY (produit) REFERENCES Produit(codePro) ON DELETE SET NULL;
ALTER TABLE GestionStock ADD CONSTRAINT fk_stock_gestionnaire FOREIGN KEY (gestionnaire) REFERENCES Gestionnaire(id) ON DELETE SET NULL;
ALTER TABLE Facture ADD CONSTRAINT fk_facture_client FOREIGN KEY (client) REFERENCES Client(id) ON DELETE SET NULL;
ALTER TABLE Facture ADD CONSTRAINT fk_facture_caissiere FOREIGN KEY (caissiere) REFERENCES Gestionnaire(id) ON DELETE SET NULL;
