/*
SQLyog Community
MySQL - 5.7.32-google-log : Database - db_horus
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `IMAGES` */

CREATE TABLE `IMAGES` (
  `ID` varchar(255) NOT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  `GALLERY` varchar(255) DEFAULT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  `IMAGE` longblob COMMENT 'Tabla no usada directamente. El framework la usa.',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla no usada directamente. El framework la usa.';

/*Table structure for table `OXDISCUSSIONCOMMENTS` */

CREATE TABLE `OXDISCUSSIONCOMMENTS` (
  `id` varchar(32) NOT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  `comment` longtext COMMENT 'Tabla no usada directamente. El framework la usa.',
  `discussionId` varchar(32) DEFAULT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  `time` datetime DEFAULT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  `userName` varchar(30) DEFAULT NULL COMMENT 'Tabla no usada directamente. El framework la usa.',
  PRIMARY KEY (`id`),
  KEY `IDXbhlx4vunn24ym1tbrlgq8g30m` (`discussionId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Tabla no usada directamente. El framework la usa.';

/*Table structure for table `application` */

CREATE TABLE `application` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `applicationType` varchar(25) DEFAULT NULL COMMENT 'application type: WEB, API, MOBILE, DESKTOP, IOT, IA, GENERIC',
  `description` varchar(50) DEFAULT NULL COMMENT 'short description about application',
  `domain` varchar(50) DEFAULT NULL COMMENT 'application http domain',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'app identifier. Not spaces are allowed',
  `name` varchar(50) DEFAULT NULL COMMENT 'application name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qkjlu10mic5jwmnsgsl1snve7` (`identifier`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8 COMMENT='application web, api, mobile, etc';

/*Table structure for table `business_unit` */

CREATE TABLE `business_unit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT 'Business unit description',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'string without spaces. Used for external clients',
  `name` varchar(50) DEFAULT NULL COMMENT 'Business unit name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_s9aer7tslpchcy304fl9iadtk` (`identifier`),
  UNIQUE KEY `UK_ltynvb12cckg9x6m9nkkexg6d` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Business unit of organization';

/*Table structure for table `business_unit_role_application_option` */

CREATE TABLE `business_unit_role_application_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `application_id` bigint(20) DEFAULT NULL COMMENT 'app id',
  `businessUnit_id` bigint(20) DEFAULT NULL COMMENT 'business id',
  `option_id` bigint(20) DEFAULT NULL COMMENT 'option id',
  `role_id` bigint(20) DEFAULT NULL COMMENT 'role id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKcxn7mb930year1c7wf3x0t8uy` (`businessUnit_id`,`role_id`,`application_id`,`option_id`),
  KEY `FKfrh8muv69jd95urtq9blok9e3` (`application_id`),
  KEY `FKh85lycuceylbe06g5em8bcjek` (`option_id`),
  KEY `FK1rsagx191vpuu9w6uykd7two6` (`role_id`),
  CONSTRAINT `FK1rsagx191vpuu9w6uykd7two6` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKfrh8muv69jd95urtq9blok9e3` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
  CONSTRAINT `FKh85lycuceylbe06g5em8bcjek` FOREIGN KEY (`option_id`) REFERENCES `options` (`id`),
  CONSTRAINT `FKitawp3ex2usbd5xa0fd47tg61` FOREIGN KEY (`businessUnit_id`) REFERENCES `business_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=270 DEFAULT CHARSET=utf8 COMMENT='Main table association. This table create the relation between business unit, role ,application and option';

/*Table structure for table `categories` */

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT 'category description',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'string without spaces. Used for external clients',
  `name` varchar(50) DEFAULT NULL COMMENT 'category name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_pf0xgc8lt01s6wbfkqpy4t64s` (`identifier`),
  UNIQUE KEY `UK_t8o6pivur7nn124jehx7cygw5` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='User clasification inside organization';

/*Table structure for table `client` */

CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `clientId` varchar(50) DEFAULT NULL COMMENT 'client id',
  `clientSecret` varchar(50) DEFAULT NULL COMMENT 'client secret',
  `clientType` varchar(25) DEFAULT NULL COMMENT 'client type: GOOGLE_LOGIN, FACEBOOK_LOGIN, NON_INTERACTIVE_LOGIN',
  `description` varchar(50) NOT NULL COMMENT 'description of this client',
  `origin` varchar(50) NOT NULL COMMENT 'request origin',
  `redirect` varchar(100) NOT NULL COMMENT 'expected redirect',
  `googleOauthConfiguration_id` bigint(20) DEFAULT NULL COMMENT 'related google  configuration id',
  `enabled` bit(1) DEFAULT NULL COMMENT 'used for disable clients',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_mixiljaerph7o13sw93tj5kg0` (`clientId`),
  UNIQUE KEY `UK_h3kaxay3b80lh84ctpk5pbpsb` (`clientSecret`),
  KEY `FKnw8k3ad6ctefw250l7jdfhh5e` (`googleOauthConfiguration_id`),
  CONSTRAINT `FKnw8k3ad6ctefw250l7jdfhh5e` FOREIGN KEY (`googleOauthConfiguration_id`) REFERENCES `google_oauth_configuration` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='Pair values used for non interactive authentication';

/*Table structure for table `client_business_unit_profile` */

CREATE TABLE `client_business_unit_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `businessUnit_id` bigint(20) DEFAULT NULL COMMENT 'business id',
  `client_id` bigint(20) DEFAULT NULL COMMENT 'client id',
  `profile_id` bigint(20) DEFAULT NULL COMMENT 'profile id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKqjxtrnkrnplve1hv7q8v32hfr` (`client_id`,`businessUnit_id`,`profile_id`),
  KEY `FKppisv60tmdclcm9w49r6uaim6` (`businessUnit_id`),
  KEY `FK68jl7as9d5ggu2jt6314c8gml` (`profile_id`),
  CONSTRAINT `FK68jl7as9d5ggu2jt6314c8gml` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  CONSTRAINT `FKngsqmpq8d0bvvt4t5mqnfndfp` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `FKppisv60tmdclcm9w49r6uaim6` FOREIGN KEY (`businessUnit_id`) REFERENCES `business_unit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COMMENT='Main table association. This table create the relation between client, business unit and profile';

/*Table structure for table `google_oauth_configuration` */

CREATE TABLE `google_oauth_configuration` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `clientId` varchar(100) DEFAULT NULL COMMENT 'client id from console.developers.google.com',
  `clientSecret` varchar(100) DEFAULT NULL COMMENT 'client secret from console.developers.google.com',
  `comments` varchar(100) DEFAULT NULL COMMENT 'additional comments',
  `custom` varchar(150) DEFAULT NULL COMMENT 'custom field to store several field in json format.',
  `origin` varchar(100) DEFAULT NULL COMMENT 'origin from console.developers.google.com',
  `redirect` varchar(150) DEFAULT NULL COMMENT 'redirect from console.developers.google.com',
  `scopes` varchar(200) DEFAULT NULL COMMENT 'scopes from console.developers.google.com',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='Values from web client oauth2 in console.developers.google.com';

/*Table structure for table `options` */

CREATE TABLE `options` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `custom` varchar(150) DEFAULT NULL COMMENT 'custom field to store several fields in json format.',
  `description` varchar(150) DEFAULT NULL COMMENT 'option description used as optional label in clients',
  `httpMethod` varchar(25) DEFAULT NULL COMMENT 'option http method: NOT_HTTP_METHOD, GET, HEAD, POST, PUT, DELETE, CONNECT ,OPTIONS, TRACE',
  `identifier` varchar(100) DEFAULT NULL COMMENT 'String sin espacios. Debe ser la concatenacion de api + endpoint + method. Reemplazar / por - y usar _ como separador',
  `legacy` bit(1) DEFAULT NULL COMMENT 'Used to determine if this option is from a legacy system',
  `name` varchar(50) DEFAULT NULL COMMENT 'option name',
  `optionalOrder` int(11) DEFAULT NULL COMMENT 'order used for web clients',
  `type` varchar(25) DEFAULT NULL COMMENT 'option type: REST_ENDPOINT, WEB_OPTION, MOBILE_OPTION, INTERNAL_RULE',
  `optionValue` varchar(150) DEFAULT NULL COMMENT 'option main value',
  `application_id` bigint(20) DEFAULT NULL COMMENT 'id de aplicacion relacionada',
  `options_id` bigint(20) DEFAULT NULL COMMENT 'id de opcion padre',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK6loyo0xnqjbsmw6igw6h3h8y3` (`application_id`,`identifier`),
  UNIQUE KEY `UK_3pbvo4a6jx1bk9i2vdoy5g3ws` (`identifier`),
  KEY `FKgyg3me45enonn1qy5i1twgsqo` (`options_id`),
  CONSTRAINT `FKgyg3me45enonn1qy5i1twgsqo` FOREIGN KEY (`options_id`) REFERENCES `options` (`id`),
  CONSTRAINT `FKnb7kc7452vcqtd72wo3324chx` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=259 DEFAULT CHARSET=utf8 COMMENT='Option of an application: endpoint, web, mobile option, etc';

/*Table structure for table `person` */

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `additionalFirstName` varchar(50) DEFAULT NULL COMMENT 'if user has more than one first name',
  `additionalLastName` varchar(50) DEFAULT NULL COMMENT 'if user has more than one last name',
  `custom` varchar(150) DEFAULT NULL COMMENT 'custom field to store several fields in json format.',
  `email` varchar(50) DEFAULT NULL COMMENT 'main email of person in the organization. Unique!',
  `enabled` bit(1) DEFAULT NULL COMMENT 'Used for disable persons without delete it',
  `externalId` varchar(50) DEFAULT NULL COMMENT 'additional id of this person on another systems',
  `firstName` varchar(50) DEFAULT NULL COMMENT 'first name',
  `lastName` varchar(50) DEFAULT NULL COMMENT 'lastname',
  `mainIdentifier` varchar(50) DEFAULT NULL COMMENT 'main identifier in country. In peru is dni',
  `category_id` bigint(20) DEFAULT NULL COMMENT 'id de categoria de la persona',
  `position_id` bigint(20) DEFAULT NULL COMMENT 'i de posicion de la persona',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fwmwi44u55bo4rvwsv0cln012` (`email`),
  UNIQUE KEY `UK_kolbj68n0han4m7cp64r6vi87` (`mainIdentifier`),
  KEY `FKgdlikgau5hb0p99383hep77kr` (`category_id`),
  KEY `FK4i8om42npv2vi0wm6xut2djxr` (`position_id`),
  CONSTRAINT `FK4i8om42npv2vi0wm6xut2djxr` FOREIGN KEY (`position_id`) REFERENCES `position` (`id`),
  CONSTRAINT `FKgdlikgau5hb0p99383hep77kr` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6169 DEFAULT CHARSET=utf8 COMMENT='User in organization';

/*Table structure for table `person_business_unit_profile` */

CREATE TABLE `person_business_unit_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `businessUnit_id` bigint(20) DEFAULT NULL COMMENT 'business id',
  `person_id` bigint(20) DEFAULT NULL COMMENT 'person id',
  `profile_id` bigint(20) DEFAULT NULL COMMENT 'profile id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKju3osa1tcpexo8k94ecut6bn3` (`person_id`,`businessUnit_id`,`profile_id`),
  KEY `FKc7c7bout9clblhwpbhj0fu5tq` (`businessUnit_id`),
  KEY `FKquj0cpe0hksrh7ov9mbuq3hq5` (`profile_id`),
  CONSTRAINT `FKc7c7bout9clblhwpbhj0fu5tq` FOREIGN KEY (`businessUnit_id`) REFERENCES `business_unit` (`id`),
  CONSTRAINT `FKo1vb27acfcb2mb649e3x6ivh2` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`),
  CONSTRAINT `FKquj0cpe0hksrh7ov9mbuq3hq5` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8335 DEFAULT CHARSET=utf8 COMMENT='Main table association. This table create the relation between person, business unit and profile';

/*Table structure for table `position` */

CREATE TABLE `position` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT 'position description',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'string without spaces. Used for external clients',
  `name` varchar(50) DEFAULT NULL COMMENT 'position name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_qe48lxuex3swuovou3giy8qpk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='User clasification inside organization';

/*Table structure for table `profile` */

CREATE TABLE `profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT 'profile description',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'string without spaces. Used for external clients',
  `name` varchar(50) DEFAULT NULL COMMENT 'profile name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h0misxfxi90txd9e2cf1owm8j` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8 COMMENT='Profile required for any person for security relationship';

/*Table structure for table `profile_role` */

CREATE TABLE `profile_role` (
  `profile_id` bigint(20) NOT NULL COMMENT 'profile id',
  `role_id` bigint(20) NOT NULL COMMENT 'role id',
  KEY `FK9sx4d1mv1bx7ycdst08d1grmh` (`role_id`),
  KEY `FKq1xpg97gmomklc1hrdgrg19k7` (`profile_id`),
  CONSTRAINT `FK9sx4d1mv1bx7ycdst08d1grmh` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FKq1xpg97gmomklc1hrdgrg19k7` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Relationship between profile and its roles';

/*Table structure for table `role` */

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `description` varchar(50) DEFAULT NULL COMMENT 'role description',
  `identifier` varchar(50) DEFAULT NULL COMMENT 'string without spaces. Used for external clients',
  `name` varchar(50) DEFAULT NULL COMMENT 'role name',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='Role asociated to application and options';

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
