CREATE TABLE `tabple_emp`
(
    `emp_id`     INT           NOT NULL AUTO_INCREMENT,
    `emp_name`   VARCHAR(500)  NULL,
    `emp_salary` DOUBLE(15, 5) NULL,
    `emp_age`    INT           NULL,
    PRIMARY KEY (`emp_id`)
);
INSERT INTO `tabple_emp` (`emp_name`, `emp_salary`, `emp_age`)
VALUES ('tom', '1254.37', '27');
INSERT INTO `tabple_emp` (`emp_name`, `emp_salary`, `emp_age`)
VALUES ('jerry', '6635.42', '38');
INSERT INTO `tabple_emp` (`emp_name`, `emp_salary`, `emp_age`)
VALUES ('bob', '5560.11', '40');
INSERT INTO `tabple_emp` (`emp_name`, `emp_salary`, `emp_age`)
VALUES ('kate', '2209.11', '22');
INSERT INTO `tabple_emp` (`emp_name`, `emp_salary`, `emp_age`)
VALUES ('justin', '4203.15', '30')



CREATE TABLE `table_user`
(
    `user_id`   INT   NOT NULL AUTO_INCREMENT,
    `user_name` VARCHAR(100) NULL,
    `address`   VARCHAR(100) NULL,
    `season`    VARCHAR(100) NULL,
    PRIMARY KEY (`user_id`)
);