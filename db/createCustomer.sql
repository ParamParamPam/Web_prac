-- Table: public.customer

-- DROP TABLE public.customer;

CREATE TABLE public.customer
(
    customer_id integer NOT NULL DEFAULT nextval('customer_id_seq'::regclass),
    customer_login character varying(100) COLLATE pg_catalog."default" NOT NULL,
    customer_psswd character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default",
    first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    customer_address character varying(100) COLLATE pg_catalog."default",
    phone_number character varying(100) COLLATE pg_catalog."default",
    mail character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT customer_pk PRIMARY KEY (customer_id)
)

TABLESPACE pg_default;

ALTER TABLE public.customer
    OWNER to postgres;
-- Index: customer_login_uindex

-- DROP INDEX public.customer_login_uindex;

CREATE UNIQUE INDEX customer_login_uindex
    ON public.customer USING btree
    (customer_login COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;