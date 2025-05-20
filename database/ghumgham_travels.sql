CREATE DATABASE  IF NOT EXISTS `travels` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `travels`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: travels
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `about_us_manage`
--

DROP TABLE IF EXISTS `about_us_manage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `about_us_manage` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `about_us_manage`
--

LOCK TABLES `about_us_manage` WRITE;
/*!40000 ALTER TABLE `about_us_manage` DISABLE KEYS */;
INSERT INTO `about_us_manage` VALUES (1,'Welcome to Ghumgham, your portal to extraordinary journeys and unforgettable adventures! As a leading travel website, Ghumgham is your trusted companion in exploring the world\'s hidden gems. Discover enchanting destinations, plan seamless itineraries, and unlock exclusive deals on flights, hotels, and tours. From pristine beaches to majestic mountains, Ghumgham caters to every traveler\'s wanderlust, ensuring memories that will last a lifetime. So pack your bags and embark on your dream escape with Ghumgham today!');
/*!40000 ALTER TABLE `about_us_manage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eentity`
--

DROP TABLE IF EXISTS `eentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eentity` (
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eentity`
--

LOCK TABLES `eentity` WRITE;
/*!40000 ALTER TABLE `eentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `eentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gallery`
--

DROP TABLE IF EXISTS `gallery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gallery` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gallery`
--

LOCK TABLES `gallery` WRITE;
/*!40000 ALTER TABLE `gallery` DISABLE KEYS */;
INSERT INTO `gallery` VALUES (2,'1690034285220_1690004750723_chitwan.jpg'),(5,'1694907220508_photo-1618851142562-ff30d09313a9.jpeg'),(7,'1694907327246_nepal-in-pictures-beautiful-places-to-photograph-annapurna-range.jpg'),(8,'1694907374469_17-best-places-to-visit-in-nepal-before-you-die-20170605040457.jpg'),(9,'1694907399952_1602412856.sidetrackimagephotohraphy.jpg'),(10,'1694907417639_desktop-wallpaper-all-nepal-nepal-kathmandu-tourist-places.jpg'),(11,'1694907441093_visit-Nepal.jpg'),(12,'1694907501585_nepal-in-pictures-beautiful-places-to-photograph-boudhanath-stupa-kathmandu.jpg'),(13,'1694907805273_photo-1661940249103-8f8127043492.jpeg'),(14,'1694907830671_ghangdrung-village-annapurna-sodha-travel.jpg'),(15,'1694907854099_Best-Places-to-Visit-in-Nepal-1024x540.jpg'),(17,'1694907914213_photo-1609224584184-893bc7157d54.jpeg'),(18,'1694908006102_photo-1618851142562-ff30d09313a9.jpeg'),(19,'1694908216581_Patan-durbar-square.png'),(20,'1694908334617_38160.jpg'),(21,'1694908369601_8d.jpg'),(22,'1694908399376_15-best-trekking-at-Nepal-Places-you-must-visit.png'),(23,'1695459573566_8d.jpg');
/*!40000 ALTER TABLE `gallery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guideline`
--

DROP TABLE IF EXISTS `guideline`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guideline` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guideline`
--

LOCK TABLES `guideline` WRITE;
/*!40000 ALTER TABLE `guideline` DISABLE KEYS */;
INSERT INTO `guideline` VALUES (1,'Traveling can be an exciting and enriching experience, but it\'s essential to plan carefully to ensure your safety and make the most of your journey. Whether you\'re traveling for business or leisure, here are some travel guidelines to help you have a smooth and enjoyable trip: \nResearch your destination and check for travel advisories.\nEnsure your passport is valid, and obtain any necessary visas.\nVisit your doctor for vaccinations and carry essential medications.\nConsider travel insurance for emergencies and cancellations.\nPack efficiently and carry copies of important documents.\nBe cautious with finances and inform your bank of your travel plans.\nStay vigilant about personal safety and belongings.\nPlan local transportation in advance and learn basic local phrases.\nBook accommodations ahead, read reviews, and prioritize safety.\nBe mindful of food and water safety.\nFollow COVID-19 guidelines if traveling during a pandemic.\nKeep a list of emergency contacts and enjoy your trip responsibly.\n\n');
/*!40000 ALTER TABLE `guideline` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `hotel_desc` varchar(10000) DEFAULT NULL,
  `hotel_name` varchar(255) DEFAULT NULL,
  `ratings` int NOT NULL,
  `owned_by_id` bigint DEFAULT NULL,
  `places_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5cfba31d8sxh02k7ymf3q76d9` (`owned_by_id`),
  KEY `FK1c4apx66woy4x58ub6rc27l44` (`places_id`),
  CONSTRAINT `FK1c4apx66woy4x58ub6rc27l44` FOREIGN KEY (`places_id`) REFERENCES `places` (`id`),
  CONSTRAINT `FK5cfba31d8sxh02k7ymf3q76d9` FOREIGN KEY (`owned_by_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES (1,'1690033596325_Hotel1.jpg','Hotel Kathmandu is a delightful oasis in the heart of Nepal\'s bustling capital. This charming hotel offers a perfect blend of modern comforts and traditional Nepali hospitality. Conveniently located near major attractions, it provides easy access to the city\'s vibrant culture and historic sites. With well-appointed rooms, delectable cuisine, and attentive service, Hotel Kathmandu promises a memorable stay for all travelers.','Hotel Kathmandu',0,3,3),(2,'1690035331758_Hotel1.jpg',' Nestled amidst lush rainforests, this eco-friendly hotel offers secluded treehouse suites and a rejuvenating spa sanctuary, providing the ultimate escape into nature\'s embrace.','Rubas',0,4,3),(3,'1690035661432_Hotel3.jpg','Step into a bygone era of opulence and elegance at this majestic castle hotel, where grand ballrooms, lavish suites, and gourmet feasts await the discerning guests.','Royal Chateau Palace:',0,5,1),(4,'1690036009805_Hotel6.jpg','Unleash your inner astronaut in this futuristic space-themed hotel, with rooms designed to mimic interstellar spacecraft, complete with cosmic views and zero-gravity beds.','Galactic Voyager Inn',0,6,4),(5,'1690036236145_Hotel7.jpg','Nestled on a secluded island, this transparent hotel allows you to slumber under the stars while surrounded by shimmering waters.','Whimsical Wonderland Lodge:',0,8,4);
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotel_review`
--

DROP TABLE IF EXISTS `hotel_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hotel_review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` int NOT NULL,
  `review_date` datetime(6) DEFAULT NULL,
  `review_desc` varchar(255) DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  `review_by_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK93xannw8r60drn1edtfa5e1e9` (`hotel_id`),
  KEY `FKp5yqwdxi7i1c3l6yghjg45jws` (`review_by_id`),
  CONSTRAINT `FK93xannw8r60drn1edtfa5e1e9` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FKp5yqwdxi7i1c3l6yghjg45jws` FOREIGN KEY (`review_by_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel_review`
--

LOCK TABLES `hotel_review` WRITE;
/*!40000 ALTER TABLE `hotel_review` DISABLE KEYS */;
INSERT INTO `hotel_review` VALUES (1,3,'2023-07-22 19:36:49.432000','Great Hotel. Had Fun',1,2),(2,5,'2023-09-17 05:52:01.792000','Nice hotel. Had fun',1,52),(3,5,'2023-09-23 19:45:04.798000','Had fun while staying here',2,102);
/*!40000 ALTER TABLE `hotel_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `user_role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_3svxcq6q51yfdg253l6x3dget` (`username`),
  KEY `FKdfw7mwdvfedd18ti3ai84i64s` (`user_id`),
  KEY `FKrwxplvc1v9t6l9ngplryjxh6` (`user_role_id`),
  CONSTRAINT `FKdfw7mwdvfedd18ti3ai84i64s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKrwxplvc1v9t6l9ngplryjxh6` FOREIGN KEY (`user_role_id`) REFERENCES `person_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'$2a$10$aDiVOoXSJPhSvIimy4gH4ej12LZurqxog5pXouvQvJKYE23rGL/2q','approved','superadmin@gmail.com',1,1),(2,'$2a$10$hVw.F6tG9mWAN0Oq8owub.41F11Y3Lr0vI8SHgzXojfGW8fKye4Sa','approved','user@gmail.com',2,2),(3,'$2a$10$jkfXG2pquFoJmLCA6YCJkuN3gmPtH1T.YjtevzlTFs9UH7UmBGMKy','approved','hotel@gmail.com',3,2),(4,'$2a$10$sPYIVYXXRpq1JKEcHMIM7e3C1NZsRj9/WrqOpZ9GNlyzlEoKmgYFW','approved','hotel2@gmail.com',4,2),(5,'$2a$10$H1cOC5n9t8xR5l6PHiJFvOOVWp.4OuTRmqrrLlMu/iB.vTyG5nE3m','approved','hotel3@gmail.com',5,2),(6,'$2a$10$kWvT7XWJT75ZyjqyNbBJ5eA.QXfuxLFzjC1mkR1RYo4WZ7os4pwqW','approved','hotel4@gmail.com',6,3),(7,'$2a$10$b0IOCdKgbJDi7Lk85Tsdrue2JmWuZZpJy/wxxQtGtdq0s7Qgwaa3C','approved','hotel5@gmail.com',8,2),(8,'$2a$10$YfytaV.aTQjVoGvq5krpNeP3HrFzeA6WApXZFgaz1p.qDjgprm8H6','approved','hotel6@gmail.com',9,2),(52,'$2a$10$T8xUqR9VHldSpqS.wcQBwupjhcGlI6WtDDq949tuDz0JDyxJGHmQK','approved','lamameelan32@gmail.com',52,1),(53,'$2a$10$t/tK7Jp30ExDlTy33TURNujTRJhUqEQG1sDS21SuJH4hGSC7VbDOW','approved','hoteltest@gmail.com',53,2),(102,'$2a$10$oUCBYJbQ0dzDOwpNSYMCc.b2Tcif8lYB8kCofgSvrr1s5yEj12dnK','approved','lamameelan77@gmail.com',102,3),(152,'$2a$10$WtclvYuWEW9dhTqAsgOqwusuUy5m9C3NAj/MXsmb5JqiZS5g91kHW','approved','mbappe123@gmail.com',152,3);
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login_seq`
--

DROP TABLE IF EXISTS `login_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_seq`
--

LOCK TABLES `login_seq` WRITE;
/*!40000 ALTER TABLE `login_seq` DISABLE KEYS */;
INSERT INTO `login_seq` VALUES (251);
/*!40000 ALTER TABLE `login_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS `package`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package` (
  `id` int NOT NULL AUTO_INCREMENT,
  `package_desc` varchar(255) DEFAULT NULL,
  `package_name` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `hotel_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5dm1c4pgpifa9e6glfokjwdec` (`hotel_id`),
  CONSTRAINT `FK5dm1c4pgpifa9e6glfokjwdec` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

LOCK TABLES `package` WRITE;
/*!40000 ALTER TABLE `package` DISABLE KEYS */;
INSERT INTO `package` VALUES (1,'fasdfasdfasdf','Dashain',1997,1),(2,'Great Package','Kathmandu Tour',4000,2),(3,'Great Packages','Package1',3000,3),(4,'Great Package.','Khaptad Package',3000,5);
/*!40000 ALTER TABLE `package` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `package_booking`
--

DROP TABLE IF EXISTS `package_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `package_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `additional_request` varchar(255) DEFAULT NULL,
  `check_in_date` datetime(6) DEFAULT NULL,
  `check_out_date` datetime(6) DEFAULT NULL,
  `payment` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `a_packages_id` int DEFAULT NULL,
  `booked_by_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm0s1y9tggx1w162dxeta21t8j` (`a_packages_id`),
  KEY `FK6eikx2wvn6fn162hdptnpwa1j` (`booked_by_id`),
  CONSTRAINT `FK6eikx2wvn6fn162hdptnpwa1j` FOREIGN KEY (`booked_by_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKm0s1y9tggx1w162dxeta21t8j` FOREIGN KEY (`a_packages_id`) REFERENCES `package` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package_booking`
--

LOCK TABLES `package_booking` WRITE;
/*!40000 ALTER TABLE `package_booking` DISABLE KEYS */;
INSERT INTO `package_booking` VALUES (1,'Should be good','2023-09-20 05:45:00.000000','2023-09-21 05:45:00.000000',0,'Pending',1,52);
/*!40000 ALTER TABLE `package_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_role`
--

DROP TABLE IF EXISTS `person_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_role` (
  `id` bigint NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_role`
--

LOCK TABLES `person_role` WRITE;
/*!40000 ALTER TABLE `person_role` DISABLE KEYS */;
INSERT INTO `person_role` VALUES (1,'Admin'),(2,'Hotel_Administrator'),(3,'User');
/*!40000 ALTER TABLE `person_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_role_seq`
--

DROP TABLE IF EXISTS `person_role_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_role_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_role_seq`
--

LOCK TABLES `person_role_seq` WRITE;
/*!40000 ALTER TABLE `person_role_seq` DISABLE KEYS */;
INSERT INTO `person_role_seq` VALUES (1);
/*!40000 ALTER TABLE `person_role_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `places`
--

DROP TABLE IF EXISTS `places`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `places` (
  `id` int NOT NULL AUTO_INCREMENT,
  `filename` varchar(255) DEFAULT NULL,
  `place_desc` varchar(10000) DEFAULT NULL,
  `place_name` varchar(255) DEFAULT NULL,
  `short_desc` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `places`
--

LOCK TABLES `places` WRITE;
/*!40000 ALTER TABLE `places` DISABLE KEYS */;
INSERT INTO `places` VALUES (1,'1690033139159_chitwan.jpg','','Chitwan','Chitwan, a picturesque district in Nepal, enchants with its rich biodiversity and lush landscapes. Home to Chitwan National Park, a UNESCO World Heritage site, it shelters diverse wildlife, including rhinos, tigers, and elephants. Visitors revel in thrilling jungle safaris, immersing in nature\'s beauty while cherishing a unique cultural experience.'),(3,'1690033363302_kathmandu.jpg','','Kathmandu','\nKathmandu, Nepal\'s vibrant capital, captivates with its ancient charm and modern allure. Nestled in the Kathmandu Valley, it boasts a rich tapestry of temples, stupas, and historic landmarks like Durbar Square. The city\'s bustling markets, colorful festivals, and warm hospitality make it a captivating destination for travelers from all walks of life.'),(4,'1690034746772_Khaptad.jpg','','Khaptad','Khaptad is a hidden gem nestled in the far western region of Nepal. This remote and pristine area is renowned for its natural beauty and spiritual significance. Khaptad National Park, a serene and untouched sanctuary, is the centerpiece of this enchanting destination. Lush forests, rolling meadows, and abundant wildlife make it a paradise for nature lovers and trekkers seeking off-the-beaten-path adventures. '),(5,'1690034819750_pokhara.jpg','','Pokhara','Pokhara, often hailed as the \"Jewel of Nepal,\" is a breathtaking city nestled in the lap of the Annapurna mountain range. Located in the central part of Nepal, Pokhara is renowned for its stunning natural beauty, tranquil lakes, and adventure opportunities. The enchanting Phewa Lake, with its reflection of the Annapurna range, forms the heart of the city and offers serene boat rides. The nearby World Peace Pagoda and Sarangkot Hill provide panoramic views of the Himalayas, captivating visitors with their majestic allure. For adventure seekers, Pokhara is a gateway to trekking routes like the Annapurna Circuit and the Ghorepani Poon Hill trek. '),(6,'1690034887434_Sgarmatha.jpg','','Sagarmatha','\nSagarmatha, also known as Mount Everest, is the crown jewel of the Himalayas and the tallest mountain on Earth. Located in the Sagarmatha National Park of Nepal, this majestic peak stands at an awe-inspiring height of 8,848 meters (29,029 feet) above sea level. Conquering Sagarmatha is a lifelong dream for mountaineers worldwide, symbolizing the epitome of human determination and endurance. Its breathtaking beauty and challenging terrain attract adventurers and trekkers, offering a once-in-a-lifetime experience. Sagarmatha\'s mystique and grandeur continue to inspire awe and reverence, leaving an indelible mark on all who dare to venture near its soaring summit.'),(8,'1694907153985_photo-1618851142562-ff30d09313a9.jpeg','','Bhaktapur','Bhaktapur, often referred to as \"The City of Devotees,\" is a captivating and historically rich city in Nepal. Nestled in the Kathmandu Valley, this ancient municipality is renowned for its well-preserved medieval architecture, exquisite artwork, and a vibrant cultural heritage that transports visitors back in time.The heart of Bhaktapur is its Durbar Square, a UNESCO World Heritage Site, which serves as the focal point of the city\'s charm. Here, you\'ll find a mesmerizing blend of intricately carved temples, pagodas, and palaces, showcasing the unparalleled craftsmanship of Newari artisans. The 55-Window Palace, Vatsala Temple, and Nyatapola Temple are just a few of the architectural wonders that adorn the square.\n\n\n\n'),(9,'1694908920749_photo-1661940249103-8f8127043492.jpeg','','Namche Bazar','Namche Bazaar is popular with trekkers in the Khumbu region, especially for altitude acclimatization, and is the gateway to the high Himalaya. The town has a number of lodgings and stores catering to the needs of visitors as well as a number of internet cafes'),(10,'1694909003808_phok.jpeg','','Dolpo','Dolpo is a remote and breathtakingly beautiful region located in the northwestern part of Nepal, nestled amidst the towering peaks of the Himalayas. This enchanting destination is renowned for its rugged terrain, pristine landscapes, and a unique cultural heritage that has remained largely untouched by modernity.Dolpo is a remote and breathtakingly beautiful region located in the northwestern part of Nepal, nestled amidst the towering peaks of the Himalayas. This enchanting destination is renowned for its rugged terrain, pristine landscapes, and a unique cultural heritage that has remained largely untouched by modernity.\n\n\n\n'),(11,'1695463814484_15-best-trekking-at-Nepal-Places-you-must-visit.png','','Dolpo','One of the beautiful places of nepal');
/*!40000 ALTER TABLE `places` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bed` int NOT NULL,
  `filename` varchar(255) DEFAULT NULL,
  `price` float NOT NULL,
  `rating` int NOT NULL,
  `room_desc` varchar(5000) DEFAULT NULL,
  `room_status` varchar(255) DEFAULT NULL,
  `room_type` varchar(255) DEFAULT NULL,
  `total_person` int NOT NULL,
  `hotel_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdosq3ww4h9m2osim6o0lugng8` (`hotel_id`),
  CONSTRAINT `FKdosq3ww4h9m2osim6o0lugng8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,1,'1690033681856_2.jpg',10,5,'\nWelcome to our exquisite room, where comfort and style intertwine for an unforgettable stay. Immerse yourself in the tranquility of modern amenities, thoughtfully designed to cater to your every need. Enjoy a restful sleep in plush bedding, revel in the sleek ambiance, and relish the panoramic views that surround you. Your perfect retreat awaits.','Available','Deluxe',6,1),(3,5,'1690035473869_2.jpg',10,4,'Great Room. With wifi.','Available','Standard',4,2),(4,2,'1690035544843_3.jpg',10,4,'Great Room','Available','Standard',4,2),(5,2,'1690035869838_Hotel4.jpg',10,4,'Great Room','Available','Deluxe',4,3),(6,1,'1690035909148_8.jpg',10,3,'Great Room Added','Available','Deluxe',3,3),(7,4,'1690036065823_2.jpg',10,4,'Room Description','Available','Standard',5,4),(8,1,'1690036110498_8.jpg',10,3,'Room Description .. Greattttt','Available','Deluxe',3,4),(9,3,'1690036288920_16.jpg',10,3,'Great Room, Have Wifi','Available','Deluxe',4,5),(10,3,'1690036325542_20.jpg',10,4,'Wifi Freee, Food and Lodge','Available','Suite',2,5),(12,2,'1694906875398_istockphoto-627892060-612x612.jpg',3999,5,'Test','Available','Standard',2,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_booking`
--

DROP TABLE IF EXISTS `room_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_booking` (
  `id` int NOT NULL AUTO_INCREMENT,
  `additional_request` varchar(255) DEFAULT NULL,
  `check_in_date` datetime(6) DEFAULT NULL,
  `check_out_date` datetime(6) DEFAULT NULL,
  `payment` float NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `booked_by_id` bigint DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg02cojcusmvl69mbmamjbgqpe` (`booked_by_id`),
  KEY `FKiwt0ws97ta91ukd4xonewjbxl` (`room_id`),
  CONSTRAINT `FKg02cojcusmvl69mbmamjbgqpe` FOREIGN KEY (`booked_by_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKiwt0ws97ta91ukd4xonewjbxl` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_booking`
--

LOCK TABLES `room_booking` WRITE;
/*!40000 ALTER TABLE `room_booking` DISABLE KEYS */;
INSERT INTO `room_booking` VALUES (9,'abc','2023-08-03 05:45:00.000000','2023-08-04 05:45:00.000000',10,'Approved',2,1),(10,'def','2023-08-09 05:45:00.000000','2023-08-10 05:45:00.000000',10,'Pending',2,10),(11,'ghi','2023-08-03 05:45:00.000000','2023-08-03 05:45:00.000000',10,'Pending',2,8),(12,'klm','2023-08-03 05:45:00.000000','2023-08-03 05:45:00.000000',10,'Pending',2,6),(14,'abc','2023-08-09 05:45:00.000000','2023-08-14 05:45:00.000000',10,'Pending',2,5),(15,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,1),(16,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,1),(17,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,1),(18,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,1),(19,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,1),(20,'ok','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',10,'Cancelled',2,1),(21,'book','2023-09-06 05:45:00.000000','2023-09-12 05:45:00.000000',10,'Approved',2,1),(22,'Book','2023-09-11 05:45:00.000000','2023-09-12 05:45:00.000000',0,'Cancelled',2,5),(23,'Book','2023-09-11 05:45:00.000000','2023-09-12 05:45:00.000000',10,'Pending',2,5),(24,'Room should be clean.','2023-09-19 05:45:00.000000','2023-09-20 05:45:00.000000',10,'Approved',52,1),(25,'Room should be clean.','2023-09-19 05:45:00.000000','2023-09-20 05:45:00.000000',10,'Pending',52,1),(26,'asasas','2023-09-22 05:45:00.000000','2023-09-22 05:45:00.000000',0,'Pending',2,3),(27,'asasas','2023-09-22 05:45:00.000000','2023-09-22 05:45:00.000000',0,'Pending',2,3),(28,'Need to be clean','2023-09-26 05:45:00.000000','2023-09-28 05:45:00.000000',10,'Approved',102,1),(29,'This room should be neat and clean','2023-09-29 05:45:00.000000','2023-09-30 05:45:00.000000',0,'Cancelled',102,1),(30,'Clean','2023-09-27 05:45:00.000000','2023-09-29 05:45:00.000000',10,'Pending',102,1),(31,NULL,'2025-03-05 05:45:00.000000','2025-03-07 05:45:00.000000',0,'Pending',152,1),(32,NULL,'2025-03-05 05:45:00.000000','2025-03-07 05:45:00.000000',0,'Cancelled',152,1);
/*!40000 ALTER TABLE `room_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_review`
--

DROP TABLE IF EXISTS `room_review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_review` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rating` int NOT NULL,
  `review_date` datetime(6) DEFAULT NULL,
  `review_desc` varchar(255) DEFAULT NULL,
  `review_by_id` bigint DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlpo7nduo690pftcs3e6jl1e16` (`review_by_id`),
  KEY `FKro27qv5e2kkbepvklt5o32t0e` (`room_id`),
  CONSTRAINT `FKlpo7nduo690pftcs3e6jl1e16` FOREIGN KEY (`review_by_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKro27qv5e2kkbepvklt5o32t0e` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_review`
--

LOCK TABLES `room_review` WRITE;
/*!40000 ALTER TABLE `room_review` DISABLE KEYS */;
INSERT INTO `room_review` VALUES (1,3,'2023-07-22 19:38:04.631000','Great Room.',2,1),(2,5,'2023-09-17 05:52:34.234000','Nice one. Had fun',52,1),(3,5,'2023-09-23 14:41:24.446000','Good room. ',102,1),(4,5,'2025-03-05 19:53:28.278000','Nice hotel;',152,1);
/*!40000 ALTER TABLE `room_review` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `support`
--

DROP TABLE IF EXISTS `support`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `support` (
  `id` int NOT NULL AUTO_INCREMENT,
  `support_desc` varchar(255) DEFAULT NULL,
  `hotel_id` int DEFAULT NULL,
  `support_by_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4wb3343sbmb95jr0it4m0iff8` (`hotel_id`),
  KEY `FKp2b4rijeibf0n26nyp90oab5p` (`support_by_id`),
  CONSTRAINT `FK4wb3343sbmb95jr0it4m0iff8` FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`),
  CONSTRAINT `FKp2b4rijeibf0n26nyp90oab5p` FOREIGN KEY (`support_by_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `support`
--

LOCK TABLES `support` WRITE;
/*!40000 ALTER TABLE `support` DISABLE KEYS */;
INSERT INTO `support` VALUES (4,'Room should be clean ',1,102),(6,'Need support for disabled',2,102);
/*!40000 ALTER TABLE `support` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `phone_no` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Super Admin','1234567890'),(2,'User','1234567890'),(3,'Hotel Kathmandu','9863837959'),(4,'Hotel 2','123456789'),(5,'Hotel 3','123456789'),(6,'Hotel4','1234567890'),(7,'Hotel 4','1234567890'),(8,'Hotel 5','123456789'),(9,'Hotel 6','1234567890'),(52,'Milan Lama','9863837951'),(53,'Hotel Test','9863837922'),(102,'Milan Lama','9863837956'),(152,'Mbappe Lama','9863837952');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_seq`
--

DROP TABLE IF EXISTS `user_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_seq`
--

LOCK TABLES `user_seq` WRITE;
/*!40000 ALTER TABLE `user_seq` DISABLE KEYS */;
INSERT INTO `user_seq` VALUES (251);
/*!40000 ALTER TABLE `user_seq` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-20 12:53:54
