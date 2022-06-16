DROP SCHEMA IF EXISTS Clinic;
create schema Clinic;
use Clinic;

CREATE TABLE `doctors` (
  `doctor_id` int NOT NULL,
  `doctor_name` varchar(50) DEFAULT NULL,
  `doctor_surname` varchar(50) DEFAULT NULL,
  `doctor_address` varchar(150) DEFAULT NULL,
  `doctor_telephone` varchar(15) DEFAULT NULL,
  `doctor_specialization` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`doctor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from doctors;
INSERT INTO `doctors` VALUES
(68,'Diana ','Sandi','Rotonda Barone 33','398 232 0803','Allergist'),
(213,'Flavio ','Fagotto','Borgo Miriam 9','357 927 468','Dermatologist'),
(234,'Loredana','Loredana ','Rotonda Umberto 4','316 652 2786','Cardiologist'),
(257,'Lauretta','Littizzetto','Piazza Giulietta 839','341 893 7569','Physiotherapist'),
(342,'Bianca','Niscoromni','Via Fabbri 219','394 296 2843','Osteopath'),
(345,'Annamaria','Niscoromni','Incrocio Ferretti 764','358 567 718','Dentist');


CREATE TABLE `patients` (
  `patient_id` int NOT NULL,
  `patient_name` varchar(50) DEFAULT NULL,
  `patient_surname` varchar(50) DEFAULT NULL,
  `patient_email` varchar(320) DEFAULT NULL,
  `patient_address` varchar(150) DEFAULT NULL,
  `patient_birthdate` date DEFAULT NULL,
  `patient_fiscode` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from patients;
INSERT INTO `patients` VALUES 
(1,'Marcantonio','Piazzi','marcantoniopiazzi@gmail.com','Via dei mille 15','1997-11-11','CAFBGE56F78H268T'),
(2,'Luca','Rossi','lucarossi@yahoo.com','Via Roma 20','1998-12-15','SFJCUT94I90H386O'),
(3,'Marco','Rizza','marcorizza@gmail.com','Via Repubblica 56','1997-09-03','SPTVSJ43H39H439I'),
(4,'Luca','Rossi','lucarossi@live.it','Strada Milan 4','1970-10-24','SLRCHW04G28F295O'),
(5,'Ettore','Bignami','ettorebignami@live.com','Via Fontana 618','1982-01-12','CMAFKE93L93L395O'),
(6,'Cecilia','Zola','ceciliazola@yahoo.com','Strada Martinelli 71','1999-06-26','CMATLE92H92H924O'),
(7,'Uberto','Favata','umbertofavata@tiscali.com','Via Joannes 123','1950-12-22','QORCLE92H54H935I'),
(8,'Pierangelo','Borsellino','pierangelob@yahoo.com','Rotonda Samuel 27','1994-12-18','ALEBME09C87H365Y'),
(9,'Ezio','Gabbana','eziogabbana@yahoo.com','Contrada Ferri 413','1995-11-17','BHRCME56H29Q344A'),
(10,'Lucrezia','Caruso','lucrecaruso@yahoo.com','Rotonda Augusto 81','1996-10-16','SDLEER34G67G039V'),
(11,'Rocco','Sauro','rsauro@yahoo.com','Contrada Grazia 172','1997-09-15','CMYNLT09H45B356M'),
(12,'Daniele','Germano','danielegermano@yahoo.com','Incrocio Emilia 8','1990-10-13','CSSMRJ88C44G859E'),
(13,'Raffaello','Moretti','raffmoretti@yahoo.com','Piazza Gentile 60','1965-03-07','DBWZKV90P06L851W'),
(14,'Luciana','Treccani','lucianatreccani@hotmail.it','Incrocio Silvestri 2','1962-10-09','PDZYGR38T44B317X'),
(15,'Vittorio','Turchetta','vittorioturchetta@live.com','Strada Leonardo 8','2015-08-02','FHFRZN41L23C784P'),
(16,'Alessia','Cutrona','alessiacutrona@live.it','Via doria 5','2010-10-12','GVOTNP66R48E041G');


CREATE TABLE `receipts` (
  `receipt_id` int NOT NULL DEFAULT '0',
  `receipt_description` varchar(400) DEFAULT NULL,
  `patient_ID` int NOT NULL,
  `doctor_ID` int NOT NULL,
  PRIMARY KEY (`receipt_id`),
  KEY `doctorID_idx` (`doctor_ID`),
  KEY `patientID_idx` (`patient_ID`),
  CONSTRAINT `doctorID` FOREIGN KEY (`doctor_ID`) REFERENCES `doctors` (`doctor_id`),
  CONSTRAINT `patientID` FOREIGN KEY (`patient_ID`) REFERENCES `patients` (`patient_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select * from receipts;
INSERT INTO `receipts` VALUES
(1,'Tachipirina per la febbre',1,68),
(2,'Oki per mal di testa',9,213),
(3,'Lioresal rilassante muscolare',4,234),
(4,'Eutirox per la tiroide',2,345),
(5,'Aulin mal di testa',5,68),
(6,'Spidifen anti infiammotorio',1,213),
(7,'Oky per dolori',3,68),
(8,'Artrosilene per mal di schiena',6,213),
(9,'Levotuss sciroppo per tosse',7,234),
(10,'Baclofene rilassante muscolare',8,257),
(11,'Cortisone per puntura',10,68),
(12,'Tantum verde per mal di gola',12,213),
(13,'Moment per il mal di testa',15,345),
(14,'Borocillina per mal di gola',14,342),
(15,'Enterolactis per ravvivare flora intestiale',11,68);


create table appointments(
appointment_id int primary key not null auto_increment,
appointment_date date,
patient_id int not null,
doctor_id int not null,
foreign key(patient_id) references patients(patient_id),
foreign key(doctor_id) references doctors(doctor_id)
);

select * from appointments;
INSERT INTO `appointments` VALUES
(1,'2022-11-11',2,213),
(2,'2022-06-11',2,213),
(3,'2023-06-11',2,213),
(4,'2022-06-11',9,68),
(5,'2022-10-11',4,234),
(6,'2023-12-12',5,345),
(7,'2022-03-11',3,213);
