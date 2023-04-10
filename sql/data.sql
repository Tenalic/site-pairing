DELETE from public.tournoi CASCADE;

CREATE TABLE public.joueur
(
    id_joueur bigint NOT NULL,
    nom character varying,
	prenom character varying,
	cossy character varying(10),
	point integer,
	drop boolean,
    PRIMARY KEY (id_joueur)
);

CREATE TABLE public.judge
(
    id_judge bigint NOT NULL,
    nom character varying,
	prenom character varying,
	cossy character varying(10),
    PRIMARY KEY (id_judge)
);

CREATE TABLE public.penalite
(
    id_penalite bigint NOT NULL,
	id_joueur bigint NOT NULL,
	id_judge bigint NOT NULL,
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
    id_round bigint NOT NULL,
	id_joueur1 bigint NOT NULL,
	id_joueur2 bigint NOT NULL,
    numero_round smallint,
	numero_table smallint,
	temps_supplementaire real,
    PRIMARY KEY (id_round),
	CONSTRAINT id_joueur1 FOREIGN KEY (id_joueur1)
        REFERENCES public.joueur (id_joueur),
	CONSTRAINT id_joueur2 FOREIGN KEY (id_joueur2)
        REFERENCES public.joueur (id_joueur)
);

CREATE TABLE public.tournoi
(
    id_tournoi bigint NOT NULL,
	id_joueur bigint NOT NULL,
	id_judge bigint NOT NULL,
    id_round bigint NOT NULL,
	numero_round_actuelle smallint DEFAULT 0,
    PRIMARY KEY (id_tournoi),
	CONSTRAINT id_joueur FOREIGN KEY (id_joueur)
        REFERENCES public.joueur (id_joueur),
	CONSTRAINT id_judge FOREIGN KEY (id_judge)
        REFERENCES public.judge (id_judge),
    CONSTRAINT id_round FOREIGN KEY (id_round)
        REFERENCES public.round (id_round)
);