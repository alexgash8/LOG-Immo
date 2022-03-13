-- immocrm.address definition

CREATE TABLE `address`
(
    `address_id`   INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `house_number` INT          DEFAULT NULL,
    `postal_code`  VARCHAR(5)   DEFAULT NULL,
    `street`       VARCHAR(255) DEFAULT NULL,
    `type`         VARCHAR(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.house definition

CREATE TABLE `house`
(
    `house_id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `count_appartments` INT NOT NULL,
    `ins_number`        VARCHAR(255) DEFAULT NULL,
    `fk_house_address`  INT          DEFAULT NULL,
    KEY `FK2clf5bgj3b87i2itvwk46d4gs` (`fk_house_address`),
    CONSTRAINT `FK2clf5bgj3b87i2itvwk46d4gs` FOREIGN KEY (`fk_house_address`) REFERENCES `address` (`address_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.appartment definition

CREATE TABLE `appartment`
(
    `apt_id`         INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `number`         INT NOT NULL,
    `oper_cost`      DECIMAL(19, 2) DEFAULT NULL,
    `price`          DECIMAL(19, 2) DEFAULT NULL,
    `room_count`     INT            DEFAULT NULL,
    `square`         DECIMAL(19, 2) DEFAULT NULL,
    `fk_apt_house`   INT            DEFAULT NULL,
    `fk_apt_address` INT            DEFAULT NULL,
    KEY `FKpw5sejmv9taej59a7siw7yqcf` (`fk_apt_house`),
    KEY `FKf6fu8v3jayypb2mn2pca6h9wv` (`fk_apt_address`),
    CONSTRAINT `FKf6fu8v3jayypb2mn2pca6h9wv` FOREIGN KEY (`fk_apt_address`) REFERENCES `address` (`address_id`),
    CONSTRAINT `FKpw5sejmv9taej59a7siw7yqcf` FOREIGN KEY (`fk_apt_house`) REFERENCES `house` (`house_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.bank_account definition

CREATE TABLE `bank_account`
(
    `account_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `bic`        VARCHAR(255) DEFAULT NULL,
    `iban`       VARCHAR(255) DEFAULT NULL,
    `bank_name`  VARCHAR(255) DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.comment definition

CREATE TABLE `comment`
(
    `comment_id`     INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `DATE`           DATE         DEFAULT NULL,
    `text`           VARCHAR(255) DEFAULT NULL,
    `fk_comment_apt` INT          DEFAULT NULL,
    KEY `FKmq3k36fjt2u6fk9wlso3u2xje` (`fk_comment_apt`),
    CONSTRAINT `FKmq3k36fjt2u6fk9wlso3u2xje` FOREIGN KEY (`fk_comment_apt`) REFERENCES `appartment` (`apt_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.history definition

CREATE TABLE `history`
(
    `history_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `ammount`    DECIMAL(19, 2) DEFAULT NULL,
    `DATE`       DATE           DEFAULT NULL
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.leaser definition

CREATE TABLE `leaser`
(
    `leaser_id`          INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `count_people`       INT          DEFAULT NULL,
    `email`              VARCHAR(255) DEFAULT NULL,
    `first_name`         VARCHAR(255) DEFAULT NULL,
    `last_name`          VARCHAR(255) DEFAULT NULL,
    `fk_leaser_apt`      INT          DEFAULT NULL,
    `fk_leaser_account`  INT          DEFAULT NULL,
    `fk_leaser_faddress` INT          DEFAULT NULL,
    `fk_leaser_laddress` INT          DEFAULT NULL,
    KEY `FK2wx98uk77kcbkacp3kofyhj3j` (`fk_leaser_apt`),
    KEY `FK7uacw1pxbsg6fssqtboxoahg3` (`fk_leaser_account`),
    KEY `FK29vqkuvkqdyglcxh43btwxyll` (`fk_leaser_faddress`),
    KEY `FKcnuu5nj0a30gd7v43eiercoso` (`fk_leaser_laddress`),
    CONSTRAINT `FK29vqkuvkqdyglcxh43btwxyll` FOREIGN KEY (`fk_leaser_faddress`) REFERENCES `address` (`address_id`),
    CONSTRAINT `FK2wx98uk77kcbkacp3kofyhj3j` FOREIGN KEY (`fk_leaser_apt`) REFERENCES `appartment` (`apt_id`),
    CONSTRAINT `FK7uacw1pxbsg6fssqtboxoahg3` FOREIGN KEY (`fk_leaser_account`) REFERENCES `bank_account` (`account_id`),
    CONSTRAINT `FKcnuu5nj0a30gd7v43eiercoso` FOREIGN KEY (`fk_leaser_laddress`) REFERENCES `address` (`address_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.history_in_out definition

CREATE TABLE `history_in_out`
(
    `history_id`        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `DATE_income`       DATE DEFAULT NULL,
    `DATE_outcome`      DATE DEFAULT NULL,
    `fk_history_leaser` INT  DEFAULT NULL,
    KEY `FKptvvt38dti3aj3px727lkr90h` (`fk_history_leaser`),
    CONSTRAINT `FKptvvt38dti3aj3px727lkr90h` FOREIGN KEY (`fk_history_leaser`) REFERENCES `leaser` (`leaser_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.meters definition

CREATE TABLE `meters`
(
    `meter_type`     VARCHAR(31) NOT NULL,
    `meter_id`       INT         PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `m_type`         VARCHAR(255) DEFAULT NULL,
    `number`         VARCHAR(255) DEFAULT NULL,
    `a_type`         VARCHAR(255) DEFAULT NULL,
    `fk_meter_apt`   INT          DEFAULT NULL,
    `fk_meter_house` INT          DEFAULT NULL,
    KEY `FKqbdn3a1t7u2xt0f7522l9jonp` (`fk_meter_apt`),
    KEY `FKf7pmxuiiudxnech8y10i9qu6f` (`fk_meter_house`),
    CONSTRAINT `FKf7pmxuiiudxnech8y10i9qu6f` FOREIGN KEY (`fk_meter_house`) REFERENCES `house` (`house_id`),
    CONSTRAINT `FKqbdn3a1t7u2xt0f7522l9jonp` FOREIGN KEY (`fk_meter_apt`) REFERENCES `appartment` (`apt_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.meter_history definition

CREATE TABLE `meter_history`
(
    `meter_id`   INT NOT NULL,
    `history_id` INT NOT NULL,
    PRIMARY KEY (`meter_id`, `history_id`),
    UNIQUE KEY `UK_g4o86tja4qohqaeskd8cc5vmw` (`history_id`),
    CONSTRAINT `FKk7tp1a56tejy86d2i9cke62pa` FOREIGN KEY (`meter_id`) REFERENCES `meters` (`meter_id`),
    CONSTRAINT `FKpy9gpi4jfr43wow9h0n7c6bon` FOREIGN KEY (`history_id`) REFERENCES `history` (`history_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


-- immocrm.payments definition

CREATE TABLE `payments`
(
    `payment_type`      VARCHAR(31) NOT NULL,
    `payment_id`        INT         PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `ammount`           DECIMAL(19, 2) DEFAULT NULL,
    `DATE`              DATE           DEFAULT NULL,
    `name`              VARCHAR(255)   DEFAULT NULL,
    `fk_payment_leaser` INT            DEFAULT NULL,
    `fk_payment_house`  INT            DEFAULT NULL,
    KEY `FKpkihmjmfdagx7sdryk92tflbr` (`fk_payment_leaser`),
    KEY `FKiu46x1thi1d8vogrnvy6b7fhg` (`fk_payment_house`),
    CONSTRAINT `FKiu46x1thi1d8vogrnvy6b7fhg` FOREIGN KEY (`fk_payment_house`) REFERENCES `house` (`house_id`),
    CONSTRAINT `FKpkihmjmfdagx7sdryk92tflbr` FOREIGN KEY (`fk_payment_leaser`) REFERENCES `leaser` (`leaser_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

-- immocrm.phone definition

CREATE TABLE `phone`
(
    `phone_id`        INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `type`            VARCHAR(255) DEFAULT NULL,
    `fk_phone_leaser` INT          DEFAULT NULL,
    `number`          VARCHAR(255) DEFAULT NULL,
    KEY `FKo3v4b9jgdug6dt6s19gvixx2j` (`fk_phone_leaser`),
    CONSTRAINT `FKo3v4b9jgdug6dt6s19gvixx2j` FOREIGN KEY (`fk_phone_leaser`) REFERENCES `leaser` (`leaser_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


ALTER TABLE phone AUTO_INCREMENT = 1;
ALTER TABLE payments AUTO_INCREMENT = 1;
ALTER TABLE meters AUTO_INCREMENT = 1;
ALTER TABLE history_in_out  AUTO_INCREMENT = 1;
ALTER TABLE leaser  AUTO_INCREMENT = 1;
ALTER TABLE history AUTO_INCREMENT = 1;
ALTER TABLE comment AUTO_INCREMENT = 1;
ALTER TABLE bank_account AUTO_INCREMENT = 1;
ALTER TABLE appartment AUTO_INCREMENT = 1;
ALTER TABLE house AUTO_INCREMENT = 1;
ALTER TABLE address AUTO_INCREMENT = 1;