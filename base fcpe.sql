--
-- PostgreSQL database dump
--

-- Dumped from database version 9.5.4
-- Dumped by pg_dump version 9.5.4

-- Started on 2017-01-26 14:42:29 CET

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 1 (class 3079 OID 12403)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2166 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: -
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_with_oids = false;

--
-- TOC entry 182 (class 1259 OID 16443)
-- Name: administrateur; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE administrateur (
    id integer NOT NULL,
    nom character varying(200),
    prenom character varying(200),
    email character varying(100),
    is_general boolean,
    is_activ boolean,
    date_naiss date
);


--
-- TOC entry 183 (class 1259 OID 16449)
-- Name: administrateur_etablissement; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE administrateur_etablissement (
    etab_id integer NOT NULL,
    admin_id integer NOT NULL
);


--
-- TOC entry 184 (class 1259 OID 17230)
-- Name: etab_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE etab_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 181 (class 1259 OID 16437)
-- Name: etablissement; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE etablissement (
    id integer DEFAULT nextval('etab_seq'::regclass) NOT NULL,
    nom character varying(200),
    num_rue integer,
    nom_rue character varying(200),
    code_postal character varying(5),
    ville character varying(100)
);


--
-- TOC entry 2041 (class 2606 OID 16453)
-- Name: administrateur_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY administrateur
    ADD CONSTRAINT administrateur_pkey PRIMARY KEY (id);


--
-- TOC entry 2039 (class 2606 OID 16455)
-- Name: etablissement_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY etablissement
    ADD CONSTRAINT etablissement_pkey PRIMARY KEY (id);


--
-- TOC entry 2043 (class 2606 OID 17213)
-- Name: prk_constraint_administrateur; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY administrateur_etablissement
    ADD CONSTRAINT prk_constraint_administrateur PRIMARY KEY (etab_id, admin_id);


--
-- TOC entry 2044 (class 2606 OID 17214)
-- Name: administrateur_etablissement_admin_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY administrateur_etablissement
    ADD CONSTRAINT administrateur_etablissement_admin_id_fkey FOREIGN KEY (admin_id) REFERENCES administrateur(id);


--
-- TOC entry 2045 (class 2606 OID 17219)
-- Name: administrateur_etablissement_etab_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY administrateur_etablissement
    ADD CONSTRAINT administrateur_etablissement_etab_id_fkey FOREIGN KEY (etab_id) REFERENCES etablissement(id);


-- Completed on 2017-01-26 14:42:29 CET

--
-- PostgreSQL database dump complete
--

