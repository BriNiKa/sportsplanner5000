CREATE TABLE "ESAE"."Place" (
  "placeID" INT NOT NULL,
  "location" VARCHAR(45) ,
  "name" VARCHAR(45) ,
  "description" VARCHAR(45) ,
  PRIMARY KEY ("placeID"));

CREATE TABLE  "ESAE"."Person" (
  "personID" INT NOT NULL,
  "prename" VARCHAR(45) ,
  "surname" VARCHAR(45) ,
  "address" VARCHAR(45) ,
  "mail" VARCHAR(45) ,
  "phone" VARCHAR(45) ,
  PRIMARY KEY ("personID"));

CREATE TABLE  "ESAE"."Event" (
  "eventID" INT NOT NULL ,
  "name" VARCHAR(45) ,
  "type" VARCHAR(45) ,
  "Place_ID" INT NOT NULL,
  "Person_ID" INT NOT NULL,
  PRIMARY KEY ("eventID"),
  CONSTRAINT "fk_Event_Place1"
    FOREIGN KEY ("Place_ID")
    REFERENCES "ESAE"."Place" ("placeID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_Event_Person1"
    FOREIGN KEY ("Person_ID")
    REFERENCES "ESAE"."Person" ("personID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE  "ESAE"."Team" (
  "teamID" INT NOT NULL,
  "name" VARCHAR(45) ,
  PRIMARY KEY ("teamID"));

CREATE TABLE "ESAE"."Team_has_Person" (
  "Team_ID" INT NOT NULL,
  "Person_ID" INT NOT NULL,
  PRIMARY KEY ("Team_ID", "Person_ID"),
  CONSTRAINT "fk_Team_has_Person1_Team1"
    FOREIGN KEY ("Team_ID")
    REFERENCES "ESAE"."Team" ("teamID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_Team_has_Person1_Person1"
    FOREIGN KEY ("Person_ID")
    REFERENCES "ESAE"."Person" ("personID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE "ESAE"."Team_has_Event" (
  "Team_teamID" INT NOT NULL,
  "Event_eventID" INT NOT NULL,
  PRIMARY KEY ("Team_teamID", "Event_eventID"),
  CONSTRAINT "fk_Team_has_Event_Team1"
    FOREIGN KEY ("Team_teamID")
    REFERENCES "ESAE"."Team" ("teamID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT "fk_Team_has_Event_Event1"
    FOREIGN KEY ("Event_eventID")
    REFERENCES "ESAE"."Event" ("eventID")
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);