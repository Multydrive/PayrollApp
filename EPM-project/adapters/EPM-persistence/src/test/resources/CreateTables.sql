CREATE TABLE IF NOT EXISTS public."employee"
(
    "id" serial,
    "payment_method" character varying,
    "payment_schedule" character varying,
    "employee_classification" character varying,
    "surname" character varying,
    "firstname" character varying,
    "address" character varying,
    "mail" character varying,
    PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS public."salariedclassification"
(
    "id" serial,
    "employee_id" integer,
    "salary" integer,
    PRIMARY KEY ("id"),
    CONSTRAINT "salaried_employee" FOREIGN KEY ("employee_id")
        REFERENCES public."employee" ("id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public."directdepositmethod"
(
    id serial,
    employe_id integer,
    method character varying,
    bank character varying,
    num_account character varying,
    PRIMARY KEY (id),
    CONSTRAINT direct_employee FOREIGN KEY (employe_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public."mailmethod"
(
    id serial,
    employee_id integer,
    method character varying,
    PRIMARY KEY (id),
    CONSTRAINT mail_employee FOREIGN KEY (employee_id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);