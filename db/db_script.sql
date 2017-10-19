--drop table
ALTER TABLE "smt_user" DROP CONSTRAINT IF EXISTS "smt_user_fk_1";
ALTER TABLE "smt_request" DROP CONSTRAINT IF EXISTS "smt_request_fk_1";
ALTER TABLE "smt_request" DROP CONSTRAINT IF EXISTS "smt_request_fk_2";
ALTER TABLE "smt_request_history" DROP CONSTRAINT IF EXISTS "smt_request_history_fk_1";
ALTER TABLE "smt_request_notification" DROP CONSTRAINT IF EXISTS "smt_request_notification_fk_1";
ALTER TABLE "smt_request_header" DROP CONSTRAINT IF EXISTS "smt_request_header_fk_1";
ALTER TABLE "smt_request_recovery" DROP CONSTRAINT IF EXISTS "smt_request_recovery_fk_1";
ALTER TABLE "smt_user_subscription" DROP CONSTRAINT IF EXISTS "smt_user_subscription_fk_1";
ALTER TABLE "smt_user_subscription" DROP CONSTRAINT IF EXISTS "smt_user_subscription_fk_2";
ALTER TABLE "smt_user_project" DROP CONSTRAINT IF EXISTS "smt_user_project_fk_1";
ALTER TABLE "smt_user_project" DROP CONSTRAINT IF EXISTS "smt_user_project_fk_2";

DROP TABLE IF EXISTS "smt_user";
DROP TABLE IF EXISTS "smt_user_role";
DROP TABLE IF EXISTS "smt_project";
DROP TABLE IF EXISTS "smt_request";
DROP TABLE IF EXISTS "smt_request_type";
DROP TABLE IF EXISTS "smt_request_history";
DROP TABLE IF EXISTS "smt_request_notification";
DROP TABLE IF EXISTS "smt_request_header";
DROP TABLE IF EXISTS "smt_request_recovery";
DROP TABLE IF EXISTS "smt_request_response";
DROP TABLE IF EXISTS "smt_subscription";
DROP TABLE IF EXISTS "smt_user_subscription";
DROP TABLE IF EXISTS "smt_user_project";

--create table
CREATE TABLE "smt_user" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_user_role_id" bigint NOT NULL,
	"name" varchar(50) NOT NULL,
	"surname" varchar(50) NOT NULL,
	"email" varchar(200) NOT NULL,
	"password" varchar(20) NOT NULL,
	"address" varchar(200),
	"city" varchar(200),
	"country" varchar(100),
	CONSTRAINT smt_user_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_user_role" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(150),
	CONSTRAINT smt_user_role_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_project" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_user_id" bigint NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(100),
	CONSTRAINT smt_project_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_project_id" bigint NOT NULL,
	"fk_smt_request_type_id" bigint NOT NULL,
	"url" varchar NOT NULL,
	"body" TEXT,
	"refresh_time" int NOT NULL,
	"try_count" int NOT NULL,
	CONSTRAINT smt_request_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_type" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(100),
	CONSTRAINT smt_request_type_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_history" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	"status" varchar(10) NOT NULL,
	"status_message" varchar(255) NOT NULL,
	"time" TIMESTAMP NOT NULL,
	CONSTRAINT smt_request_history_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_notification" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	"email" varchar(150),
	"sms" varchar(15),
	"restart" BOOLEAN,
	CONSTRAINT smt_request_notification_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_header" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	"key" varchar(255) NOT NULL,
	"value" varchar(255) NOT NULL,
	CONSTRAINT smt_request_header_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_recovery" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_request_id" bigint NOT NULL,
	"ip" varchar(50) NOT NULL,
	"username" varchar(50) NOT NULL,
	"password" varchar(50) NOT NULL,
	"run_script" varchar(50) NOT NULL,
	CONSTRAINT smt_request_recovery_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_request_response" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"status" varchar(10) NOT NULL,
	CONSTRAINT smt_request_response_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_subscription" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"name" varchar(50) NOT NULL,
	"description" varchar(150),
	"request_size" int NOT NULL,
	CONSTRAINT smt_subscription_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

CREATE TABLE "smt_user_subscription" (
	"pkid" serial NOT NULL,
	"isactive" BOOLEAN NOT NULL,
	"fk_smt_subscription_id" bigint NOT NULL,
	"fk_smt_user_id" bigint NOT NULL,
	"start_date" TIMESTAMP NOT NULL,
	"end_date" TIMESTAMP,
	CONSTRAINT smt_user_subscription_pk PRIMARY KEY ("pkid")
) WITH (
  OIDS=FALSE
);

ALTER TABLE "smt_user" ADD CONSTRAINT "smt_user_fk_1" FOREIGN KEY ("fk_smt_user_role_id") REFERENCES "smt_user_role"("pkid");
ALTER TABLE "smt_project" ADD CONSTRAINT "smt_project_fk_1" FOREIGN KEY ("fk_smt_user_id") REFERENCES "smt_user"("pkid");
ALTER TABLE "smt_request" ADD CONSTRAINT "smt_request_fk_1" FOREIGN KEY ("fk_smt_project_id") REFERENCES "smt_project"("pkid");
ALTER TABLE "smt_request" ADD CONSTRAINT "smt_request_fk_2" FOREIGN KEY ("fk_smt_request_type_id") REFERENCES "smt_request_type"("pkid");
ALTER TABLE "smt_request_history" ADD CONSTRAINT "smt_request_history_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");
ALTER TABLE "smt_request_notification" ADD CONSTRAINT "smt_request_notification_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");
ALTER TABLE "smt_request_header" ADD CONSTRAINT "smt_request_header_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");
ALTER TABLE "smt_request_recovery" ADD CONSTRAINT "smt_request_recovery_fk_1" FOREIGN KEY ("fk_smt_request_id") REFERENCES "smt_request"("pkid");
ALTER TABLE "smt_user_subscription" ADD CONSTRAINT "smt_user_subscription_fk_1" FOREIGN KEY ("fk_smt_subscription_id") REFERENCES "smt_subscription"("pkid");
ALTER TABLE "smt_user_subscription" ADD CONSTRAINT "smt_user_subscription_fk_2" FOREIGN KEY ("fk_smt_user_id") REFERENCES "smt_user"("pkid");


--insert data
INSERT INTO "smt_request_type" values (1, true, 'POST', null);
INSERT INTO "smt_request_type" values (2, true, 'GET', null);
INSERT INTO "smt_request_type" values (3, true, 'DELETE', null);
INSERT INTO "smt_request_type" values (4, true, 'PUT', null);

INSERT INTO "smt_request_response" values (1, true, '200');
INSERT INTO "smt_request_response" values (2, true, '404');

INSERT INTO "smt_user_role" values (1, true, 'Sistem Yoneticisi', '');

INSERT INTO "smt_user" values (1, true, 1, 'Ahmet', 'Okay', 'ahmet.okay@outlook.com', '123', null, null, null);
INSERT INTO "smt_user" values (2, true, 1, 'Bilal', 'Ocal', 'bilalocal06@gmail.com', '123', null, null, null);