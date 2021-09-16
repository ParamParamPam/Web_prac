-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE public.product
(
    product_id integer NOT NULL DEFAULT nextval('product_id_seq'::regclass),
    price real NOT NULL,
    amount integer NOT NULL,
    type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    title character varying(100) COLLATE pg_catalog."default" NOT NULL,
    company character varying(100) COLLATE pg_catalog."default" NOT NULL,
    assemble_place character varying(200) COLLATE pg_catalog."default",
    characteristics text COLLATE pg_catalog."default",
    CONSTRAINT product_pk PRIMARY KEY (product_id)
)

TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;