package com.tenalic.site.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tenalic.site.dao.object.RoundDao;
import com.tenalic.site.dao.repository.JoueurRepo;
import com.tenalic.site.dao.repository.RoundRepo;
import com.tenalic.site.dao.repository.TournoiRepo;
import com.tenalic.site.dto.tournoi.Joueur;
import com.tenalic.site.dto.tournoi.Round;
import com.tenalic.site.dto.tournoi.Tournoi;
import com.tenalic.site.service.JoueurService;
import com.tenalic.site.service.PairingService;
import com.tenalic.site.service.RoundService;
import com.tenalic.site.service.TournoiServiceInterface;
import com.tenalic.site.utils.constantes.Constantes;
import com.tenalic.site.utils.mapper.MapperJoueur;
import com.tenalic.site.utils.mapper.MapperRound;
import com.tenalic.site.utils.mapper.MapperTournoi;

@Service
public class PairingServiceImpl implements PairingService {

	private static final String DRAW = "draw";

	private static final double POINT_GAGNANT = 3;
	private static final double POINT_DRAW = 1;

	@Autowired
	private TournoiRepo tournoiRepo;

	@Autowired
	private RoundRepo roundRepo;

	@Autowired
	private JoueurRepo joueurRepo;

	@Autowired
	private JoueurService joueurService;

	@Autowired
	private TournoiServiceInterface tournoiService;

	@Autowired
	private RoundService roundService;

	@Override
	public List<Round> creerPairing(String infos) {
		return creerNouvelleRound(infos);
	}

	private List<Round> creerNouvelleRound(String infos) {
		Tournoi tournoi = MapperTournoi.mapTournoi(tournoiRepo.findLastTournoi());
		tournoi.setRoundActuelle(tournoi.getRoundActuelle() + 1);
		tournoi.setListeJoueur(MapperJoueur.mapListJoueur(joueurRepo.findByIdTournoi(tournoi.getIdTournoi())));
		tournoi.setListeRound(MapperRound.mapListRound(roundRepo.findByIdTournoi(tournoi.getIdTournoi())));
		List<String> listeInfosFormate;
		try {
			listeInfosFormate = Arrays.asList(infos.split(";"));
		} catch (Exception e) {
			throw e;
		}
		List<Round> listRound = creerListeRound(listeInfosFormate, tournoi.getListeJoueur(), tournoi.getListeRound(),
				tournoi.getRoundActuelle());
		try {
			roundRepo.saveAll(MapperRound.mapListRoundDao(listRound, tournoi.getIdTournoi(), null));
			tournoiRepo.save(MapperTournoi.mapTournoiDao(tournoi));
		} catch (Exception e) {
			throw e;
		}
		return listRound;
	}

	/**
	 * table;cossy
	 * 
	 * @param listeInfosFormate
	 * @param listeJoueur
	 * @param listeRound
	 * @return
	 */
	private List<Round> creerListeRound(List<String> listeInfosFormate, List<Joueur> listeJoueur,
			List<Round> listeRound, int numeroRound) {
		int count = 0;
		Round round = null;
		for (String info : listeInfosFormate) {
			if (count == 0) {
				round = getRoundByTable(Integer.parseInt(info), listeRound, numeroRound);
			}
			switch (count) {
			case 0:
				round.setNumeroTable(Integer.parseInt(info));
				break;
			case 1:
				round = setPlayerRound(findJoueur(listeJoueur, info), round);
				break;
			}
			count++;
			if (count > 1) {
				count = 0;
				round.setNumeroRound(numeroRound);
				listeRound = addRoundInList(listeRound, round);
			}
		}
		return verifierListRound(listeRound);
	}

	private List<Round> verifierListRound(List<Round> listeRound) {
		for (int i = 0; i < listeRound.size(); i++) {
			if (listeRound.get(i).getJoueur1() == null) {
				listeRound.get(i).setJoueur1(new Joueur());
			}
			if (listeRound.get(i).getJoueur2() == null || listeRound.get(i).getJoueur2().getCossy() == null
					|| listeRound.get(i).getJoueur2().getCossy().equals("")) {
				listeRound.get(i).setJoueur2(new Joueur());
				// cas d'un bye
				listeRound.get(i).setDuelFini(true);
			}
		}
		return listeRound;
	}

	private List<Round> addRoundInList(List<Round> listeRound, Round round) {
		int index = 0;
		for (Round r : listeRound) {
			if (r.getNumeroTable() == round.getNumeroTable() && r.getNumeroRound() == round.getNumeroRound()) {
				listeRound.set(index, round);
				return listeRound;
			}
			index++;
		}
		listeRound.add(round);
		return listeRound;
	}

	private Round getRoundByTable(int numeroTable, List<Round> listeRound, int numeroRound) {
		for (Round round : listeRound) {
			if (numeroTable == round.getNumeroTable() && numeroRound == round.getNumeroRound()) {
				return round;
			}
		}
		return new Round();
	}

	private Round setPlayerRound(Joueur joueur, Round round) {
		if (round.getJoueur1() == null) {
			round.setJoueur1(joueur);
		} else {
			round.setJoueur2(joueur);
		}
		return round;
	}

	private Joueur findJoueur(List<Joueur> listJoueur, String cossy) {
		Joueur joueur = Optional.ofNullable(listJoueur).orElse(new ArrayList<Joueur>()).stream()
				.filter(j -> cossy.equals(j.getCossy())).findFirst().orElse(null);
		if (joueur == null || joueur.getCossy() == null) {
			joueur = new Joueur();
			joueur.setCossy("");
			joueur.setNom("BYE");
			joueur.setPrenom("BYE");
		}
		return joueur;
	}

	@Override
	public void saisirResultatMatch(int table, int round, String cossyWinner, int action) {
		setResultat(table, round, cossyWinner, action);
	}

	private void setResultat(int table, int round, String cossyWinner, int action) {
		Tournoi tournoi = tournoiService.getTournoi();
		Joueur joueur = joueurService.recupererJoueur(cossyWinner, tournoi.getIdTournoi());

		if (joueur == null || joueur.getCossy() == null) {
			joueur = new Joueur();
			joueur.setNom("");
			joueur.setPrenom(DRAW);
			joueur.setCossy("");
		}
		RoundDao roundDao = roundRepo.findByIdTournoiAndNumeroRoundAndNumeroTable(tournoi.getIdTournoi(), round, table);
		setWinner(roundDao, joueur);
		roundRepo.save(roundDao);
		updatePoint(action, joueur, roundDao, tournoi.getIdTournoi());
	}

	private void updatePoint(int action, Joueur joueur, RoundDao roundDao, int idTournoi) {
		if (action == Constantes.SAISIR) {
			if (DRAW.equals(joueur.getPrenom())) {
				Joueur joueur1 = joueurService.recupererJoueurParId(roundDao.getIdJoueur1());
				Joueur joueur2 = joueurService.recupererJoueurParId(roundDao.getIdJoueur2());
				joueurService.updatePointThemSaveJoueur(joueur1, idTournoi, (int) (joueur1.getPoint() + POINT_DRAW));
				joueurService.updatePointThemSaveJoueur(joueur2, idTournoi, (int) (joueur2.getPoint() + POINT_DRAW));
			} else {
				joueurService.updatePointThemSaveJoueur(joueur, idTournoi, (int) (joueur.getPoint() + POINT_GAGNANT));
			}
		} else {
			Joueur joueur1 = joueurService.recupererJoueurParId(roundDao.getIdJoueur1());
			Joueur joueur2 = joueurService.recupererJoueurParId(roundDao.getIdJoueur2());
			List<Round> listRoundJoueur1 = roundService.recupererInfosJoueursRound(joueur1.getCossy());
			List<Round> listRoundJoueur2 = roundService.recupererInfosJoueursRound(joueur2.getCossy());
			joueurService.updatePointThemSaveJoueur(joueur1, idTournoi,
					calculPointFromListRound(listRoundJoueur1, joueur1));
			joueurService.updatePointThemSaveJoueur(joueur2, idTournoi,
					calculPointFromListRound(listRoundJoueur2, joueur2));
		}
	}

	private int calculPointFromListRound(List<Round> listRound, Joueur joueur) {
		int nombrePoint = 0;
		for (Round round : listRound) {
			if (round.getWinnerJoueurId() != null
					&& round.getWinnerJoueurId().intValue() == Integer.valueOf(joueur.getId()).intValue()) {
				nombrePoint += POINT_GAGNANT;
			} else {
				if (round.getWinnerJoueurId() == null && round.isDuelFini()) {
					nombrePoint += POINT_DRAW;
				}
			}
		}
		return nombrePoint;
	}

	private void setWinner(RoundDao roundDao, Joueur joueur) {
		if ((DRAW.equals(joueur.getPrenom()))
				|| (roundDao.getIdJoueur1() != null && String.valueOf(roundDao.getIdJoueur1()).equals(joueur.getId()))
				|| (roundDao.getIdJoueur2() != null
						&& String.valueOf(roundDao.getIdJoueur2()).equals(joueur.getId()))) {
			roundDao.setDuelFini(true);
			roundDao.setWinnerCossy(joueur.getCossy());
			if (joueur.getId() != null) {
				roundDao.setWinnerJoueurId(Integer.parseInt(joueur.getId()));
				roundDao.setWinnerName(joueur.getPrenom() + " " + Optional.ofNullable(joueur.getNom()).orElse("") + " "
						+ Optional.ofNullable(joueur.getCossy()).orElse(""));
			} else {
				roundDao.setWinnerName(DRAW);
				roundDao.setWinnerJoueurId(null);
			}
		}
	}

	@Override
	public boolean toutLesResultatSontRemplis() {
		return verifierResultatBdd();
	}

	private boolean verifierResultatBdd() {
		try {
			Tournoi tournoi = MapperTournoi.mapTournoi(tournoiRepo.findLastTournoi());
			List<RoundDao> listeRoundDao = roundRepo.findAllRoundSansResultat(tournoi.getIdTournoi(),
					tournoi.getRoundActuelle());
			if (listeRoundDao != null && !listeRoundDao.isEmpty()) {
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void verifierBye(List<Round> listeRound) {
		Round round = listeRound.stream().filter(r -> r.isDuelFini() && (r.getWinner() == null || r.getWinner() == ""))
				.findFirst().orElse(null);
		if (round != null) {
			saisirResultatMatch(round.getNumeroTable(), round.getNumeroRound(), round.getJoueur1().getCossy(),
					Constantes.MODIFIER);
		}
	}

}
