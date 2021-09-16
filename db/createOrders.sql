-- Table: public.orders

-- DROP TABLE public.orders;

CREATE TABLE public.orders
(
    order_id integer NOT NULL DEFAULT nextval('order_id_seq'::regclass),
    order_address character varying(100) COLLATE pg_catalog."default" NOT NULL,
    delivery_date timestamp without time zone NOT NULL,
    order_date timestamp without time zone NOT NULL,
    status character varying(100) COLLATE pg_catalog."default" NOT NULL,
    order_price real NOT NULL,
    customer_id integer NOT NULL,
    product_id integer NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (order_id),
    CONSTRAINT customer_order___fk FOREIGN KEY (customer_id)
        REFERENCES public.customer (customer_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE,
    CONSTRAINT product_order___fk FOREIGN KEY (product_id)
        REFERENCES public.product (product_id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE public.orders
    OWNER to postgres;