-- Table: public.admin

-- DROP TABLE public.admin;

CREATE TABLE public.admin
(
    admin_id integer NOT NULL DEFAULT nextval('admin_id_seq'::regclass),
    admin_login character varying(100) COLLATE pg_catalog."default" NOT NULL,
    admin_psswd character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT admin_pk PRIMARY KEY (admin_id)
)

TABLESPACE pg_default;

ALTER TABLE public.admin
    OWNER to postgres;
-- Index: admin_login_uindex

-- DROP INDEX public.admin_login_uindex;

CREATE UNIQUE INDEX admin_login_uindex
    ON public.admin USING btree
    (admin_login COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;