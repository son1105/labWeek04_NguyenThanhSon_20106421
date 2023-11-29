CREATE DATABASE IF NOT EXISTS `workweek04` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `workweek04`;

CREATE TABLE IF NOT EXISTS `candidate` (
  `can_id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`can_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `candidate` (`can_id`, `full_name`, `email`, `phone`, `address`) VALUES
	(1, 'Nguyen Thanh Son', 'son@gmail.com', '0944572934', '12 Nguyen Van Bao'),
	(2, 'Pham Thanh Son', 'sonPham@gmail.com', '0944386754', '1/6 Nguyen Van Nghi');

CREATE TABLE IF NOT EXISTS `candidate_skill` (
  `candidate_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`candidate_id`,`skill_id`),
  KEY `FK_candidate_skill_skill` (`skill_id`),
  CONSTRAINT `FK_candidate_skill_candidate` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`can_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_candidate_skill_skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `candidate_skill` (`candidate_id`, `skill_id`, `level`) VALUES
	(1, 1, 4),
	(1, 2, 2),
	(2, 1, 1),
	(2, 3, 4);

CREATE TABLE IF NOT EXISTS `job` (
  `job_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL DEFAULT '',
  `description` varchar(50) NOT NULL DEFAULT '',
  `location` varchar(50) NOT NULL DEFAULT '',
  `salary` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `job` (`job_id`, `title`, `description`, `location`, `salary`) VALUES
	(1, 'title', 'description', '10, 10', 10000000);

CREATE TABLE IF NOT EXISTS `job_skill` (
  `job_id` int(11) NOT NULL,
  `skill_id` int(11) NOT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`job_id`,`skill_id`),
  KEY `FK_job_skill_skill` (`skill_id`),
  CONSTRAINT `FK_job_skill_job` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_job_skill_skill` FOREIGN KEY (`skill_id`) REFERENCES `skill` (`skill_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `job_skill` (`job_id`, `skill_id`, `level`) VALUES
	(1, 1, 2);

CREATE TABLE IF NOT EXISTS `skill` (
  `skill_id` int(11) NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`skill_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO `skill` (`skill_id`, `skill_name`) VALUES
	(1, 'Skill 1'),
	(2, 'Skill 2'),
	(3, 'Skill 3');