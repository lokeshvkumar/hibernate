CREATE TABLE "TESTSCHEMA"."EMPLOYEE" (
		"ID" INTEGER NOT NULL,
		"EMPLOYEENAME" VARCHAR(255)
	);

CREATE UNIQUE INDEX "TESTSCHEMA"."SQL150420212146640" ON "TESTSCHEMA"."EMPLOYEE" ("ID" ASC);

ALTER TABLE "TESTSCHEMA"."EMPLOYEE" ADD CONSTRAINT "SQL150420212146640" PRIMARY KEY ("ID");