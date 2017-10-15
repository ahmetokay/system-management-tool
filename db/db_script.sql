CREATE TABLE "smt_user" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"surname" varchar(50) NOT NULL,
	"fk_role_id" bigint NOT NULL,
	"fk_detail_id" bigint NOT NULL,
	CONSTRAINT smt_user_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_user_role" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	CONSTRAINT smt_user_role_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_project" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(100) NOT NULL,
	CONSTRAINT smt_project_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_user_detail" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"email" varchar(150) NOT NULL,
	"address" varchar(150) NOT NULL,
	"city" varchar(50) NOT NULL,
	"country" varchar(50) NOT NULL,
	CONSTRAINT smt_user_detail_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"url" varchar NOT NULL,
	"ip" varchar(50) NOT NULL,
	"username" varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	"refresh_time" int NOT NULL,
	"fk_smt_request_type_id" bigint NOT NULL,
	"try_count" int NOT NULL,
	"fk_smt_project_id" bigint NOT NULL,
	CONSTRAINT smt_request_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_type" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(100) NOT NULL,
	CONSTRAINT smt_request_type_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_history" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"time" TIMESTAMP NOT NULL,
	"status" varchar(10) NOT NULL,
	"status_message" varchar(255) NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	CONSTRAINT smt_request_history_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_notification" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	"email" varchar(150) NOT NULL,
	"notification_type" varchar(50) NOT NULL,
	CONSTRAINT smt_request_notification_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "smt_user" ADD CONSTRAINT "smt_user_fk_1" FOREIGN KEY ("fk_role_id") REFERENCES "smt_user_role"("pkid");
ALTER TABLE "smt_user" ADD CONSTRAINT "smt_user_fk_2" FOREIGN KEY ("fk_detail_id") REFERENCES "smt_user_detail"("pkid");

ALTER TABLE "smt_request" ADD CONSTRAINT "smt_request_fk_1" FOREIGN KEY ("fk_smt_request_type_id") REFERENCES "smt_request_type"("pkid");
ALTER TABLE "smt_request" ADD CONSTRAINT "smt_request_fk_2" FOREIGN KEY ("fk_smt_project_id") REFERENCES "smt_project"("pkid");

ALTER TABLE "smt_request_history" ADD CONSTRAINT "smt_request_history_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");

ALTER TABLE "smt_request_notification" ADD CONSTRAINT "smt_request_notification_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");


--insert data
INSERT INTO "smt_request_type" values (1, true, '200', 'OK');
INSERT INTO "smt_request_type" values (2, true, '404', 'NOT FOUND');
