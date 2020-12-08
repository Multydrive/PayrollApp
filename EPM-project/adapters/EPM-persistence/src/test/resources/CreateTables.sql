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
    "salary" double precision,
    CONSTRAINT "salaried_employee" FOREIGN KEY ("id")
        REFERENCES public."employee" ("id") MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public."directdepositmethod"
(
    id serial,
    method character varying,
    bank character varying,
    num_account character varying,
    CONSTRAINT direct_employee FOREIGN KEY (id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE IF NOT EXISTS public."mailmethod"
(
    id serial,
    method character varying,
    CONSTRAINT mail_employee FOREIGN KEY (id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.hourlyclassification
(
    id integer,
    rate integer,
    CONSTRAINT "EmpId" FOREIGN KEY (id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.timecard
(
    id integer,
    date character varying(15),
    hour integer,
    CONSTRAINT "HourlyId" FOREIGN KEY (id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

CREATE TABLE public.commissionclassification
(
    id integer,
    salary integer,
    commission double precision,
    CONSTRAINT "CommId" FOREIGN KEY (id)
        REFERENCES public.employee (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);