
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `salary` decimal(38,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `doctor` (`id`, `description`, `first_name`, `last_name`, `location`, `salary`) VALUES
(2, 'Medico cirujano', 'Juan Ángel', 'Espinoza Sánchez', 'Fraccionamiento Anna', '38.55');
INSERT INTO `doctor` (`id`, `description`, `first_name`, `last_name`, `location`, `salary`) VALUES
(3, 'médico pasante en turno', 'Miguel ', 'Unamuno Urquizo', 'Bosque Galápago', '38.55');


DROP TABLE IF EXISTS `doctor_seq`;
CREATE TABLE `doctor_seq` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `doctor_seq` (`next_val`) VALUES
(101);
