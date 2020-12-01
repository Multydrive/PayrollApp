CREATE TABLE IF NOT EXISTS public."EMPLOYEE"
(
    "ID" serial,
    "PAYMENT_METHOD" character varying,
    "PAYMENT_SCHEDULE" character varying,
    "EMPLOYEE_CLASSIFICATION" character varying,
    "SURNAME" character varying,
    "FIRSTNAME" character varying,
    "ADDRESS" character varying,
    "MAIL" character varying,
    PRIMARY KEY ("ID")
);

CREATE TABLE IF NOT EXISTS public."SALARIEDCLASSIFICATION"
(
    "ID" serial,
    "EMPLOYEE_ID" integer,
    "SALARY" integer,
    PRIMARY KEY ("ID"),
    CONSTRAINT "SALARIED_EMPLOYEE" FOREIGN KEY ("EMPLOYEE_ID")
        REFERENCES public."EMPLOYEE" ("ID") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);