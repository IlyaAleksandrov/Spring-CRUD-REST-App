CREATE TABLE public.books
(
    id integer NOT NULL DEFAULT nextval('books_id_seq'::regclass),
    book_title character varying COLLATE pg_catalog."default" NOT NULL,
    "Book_author" character varying COLLATE pg_catalog."default" NOT NULL,
    published_in integer NOT NULL,
    CONSTRAINT books_pkey PRIMARY KEY (id)
)
