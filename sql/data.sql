DELETE from public.penalite CASCADE;
DELETE from public.round CASCADE;
DELETE from public.joueur CASCADE;
DELETE from public.judge CASCADE;
DELETE from public.tournoi CASCADE;
CREATE TABLE public.tournoi
(
    id_tournoi SERIAL NOT NULL,
	numero_round_actuelle smallint DEFAULT 0,
    PRIMARY KEY (id_tournoi)
);

CREATE TABLE public.joueur
(
    id_joueur SERIAL NOT NULL,
    id_tournoi SERIAL NOT NULL,
    nom character varying,
	prenom character varying,
	cossy character varying(10),
	point integer,
	drop boolean,
    PRIMARY KEY (id_joueur),
    CONSTRAINT id_tournoi FOREIGN KEY (id_tournoi)
        REFERENCES public.tournoi (id_tournoi)
);

CREATE TABLE public.judge
(
    id_judge SERIAL NOT NULL,
    id_tournoi SERIAL NOT NULL,
    nom character varying,
	prenom character varying,
	cossy character varying(10),
    PRIMARY KEY (id_judge),
    CONSTRAINT id_tournoi FOREIGN KEY (id_tournoi)
        REFERENCES public.tournoi (id_tournoi)
);

CREATE TABLE public.penalite
(
    id_penalite SERIAL NOT NULL,
	id_joueur SERIAL NOT NULL,
	id_judge SERIAL NOT NULL,
    type_penalite character varying,
	sanction character varying,
	description text,
	temps_supplementaire real,
    PRIMARY KEY (id_penalite),
	CONSTRAINT id_joueur FOREIGN KEY (id_joueur)
        REFERENCES public.joueur (id_joueur),
	CONSTRAINT id_judge FOREIGN KEY (id_judge)
        REFERENCES public.judge (id_judge)
);

CREATE TABLE public.round
(
    id_round SERIAL NOT NULL,
    id_tournoi SERIAL NOT NULL,
	id_joueur1 SERIAL,
	id_joueur2 SERIAL,
    numero_round smallint,
	numero_table smallint,
	temps_supplementaire real,
	id_joueur_winner bigint,
	winner_name character varying,
	winner_cossy character varying,
	duel_fini boolean,
    PRIMARY KEY (id_round),
	CONSTRAINT id_joueur1 FOREIGN KEY (id_joueur1)
        REFERENCES public.joueur (id_joueur),
	CONSTRAINT id_joueur2 FOREIGN KEY (id_joueur2)
        REFERENCES public.joueur (id_joueur),
    CONSTRAINT id_tournoi FOREIGN KEY (id_tournoi)
        REFERENCES public.tournoi (id_tournoi)
);