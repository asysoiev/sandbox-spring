CREATE TABLE PERSON (
  ID      INT         NOT NULL AUTO_INCREMENT
  ,
  NAME    VARCHAR(60) NOT NULL,
  SURNAME VARCHAR(60) NOT NULL,
  PRIMARY KEY (ID)
);
ALTER TABLE PERSON
  ADD CONSTRAINT UQ_PERSON_1 UNIQUE (NAME, SURNAME);
CREATE TABLE SKILL (
  NAME VARCHAR(20) NOT NULL
  ,
  PRIMARY KEY (NAME)
);
CREATE TABLE RANKING (
  OBSERVER_ID INT         NOT NULL
  ,
  SUBJECT_ID  INT         NOT NULL
  ,
  SKILL       VARCHAR(20) NOT NULL
  ,
  RANK        INT         NOT NULL DEFAULT 0
  ,
  VERSION     INT         NOT NULL DEFAULT 0
  ,
  PRIMARY KEY (OBSERVER_ID, SUBJECT_ID, SKILL)
  ,
  CONSTRAINT FK_PERSON_RANKING_1 FOREIGN KEY (OBSERVER_ID)
  REFERENCES PERSON (ID)
  ,
  CONSTRAINT FK_PERSON_RANKING_2 FOREIGN KEY (SUBJECT_ID)
  REFERENCES PERSON (ID)
  ,
  CONSTRAINT FK_SKILL_RANKING FOREIGN KEY (SKILL)
  REFERENCES SKILL (NAME)
);
ALTER TABLE RANKING
  ADD CONSTRAINT UQ_RANKING UNIQUE (OBSERVER_ID, SUBJECT_ID, SKILL);