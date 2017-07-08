DROP TABLE IF EXISTS CONTACT;

CREATE TABLE CONTACT (
  ID         INT         NOT NULL AUTO_INCREMENT
  ,
  FIRST_NAME VARCHAR(60) NOT NULL
  ,
  LAST_NAME  VARCHAR(40) NOT NULL
  ,
  BIRTH_DATE DATE
  ,
  VERSION    INT         NOT NULL DEFAULT 0
  ,
  PRIMARY KEY (ID)
);

ALTER TABLE CONTACT
  ADD CONSTRAINT UQ_CONTACT_1 UNIQUE (FIRST_NAME, LAST_NAME);