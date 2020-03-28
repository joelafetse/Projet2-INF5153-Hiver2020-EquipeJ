package uqam.inf5153.game.joueur;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.figurine.Figurine;
import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.pioche.PiocheObjectifs;
import uqam.inf5153.game.plateau.Coordonnees;
import uqam.inf5153.game.plateau.Irrigation;
import uqam.inf5153.game.plateau.PlateauDeJeu;
import uqam.inf5153.game.plateau.ReseauIrrigation;
import uqam.inf5153.game.tuile.parcelle.Couleur;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

    private PlateauDeJoueur plateauDeJoueur;
    private List<Objectif> objectifs;
    private int nombreActions = 2;
    private int score;

    public Joueur(){
        this.plateauDeJoueur = new PlateauDeJoueur();
        this.objectifs = new ArrayList<>();
        this.score = 0;
    }

    public PlateauDeJoueur getPlateauDeJoueur() {
        return plateauDeJoueur;
    }

    public boolean placerParcelleDansPlateau(PlateauDeJeu plateau, Parcelle parcelle, int x, int y){
            Coordonnees coordParcelle = new Coordonnees(x,y);

            parcelle.setCoordonnees(coordParcelle);

            planterBambouSurParcelleDeposee(parcelle);

            plateau.ajouterParcelle(parcelle);

            plateau.getPositionsDisponibles().removeIf(coordonnees -> coordonnees.equals(coordParcelle));

            int i = plateau.positionParcelle(x, y + 2);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);            }
            i = plateau.positionParcelle(x + 2, y + 1);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);
            }
            i = plateau.positionParcelle(x + 2, y - 1);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);
            }
            i = plateau.positionParcelle(x, y - 2);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);
            }
            i = plateau.positionParcelle(x - 2, y - 1);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);
            }
            i = plateau.positionParcelle(x - 2, y + 1);
            if (i != -1) {
                parcelle.setVoisins(plateau.getParcelles().get(i));
                plateau.getParcelles().get(i).setVoisins(parcelle);
            }

            plateau.mettreAjourListePosiDisp(coordParcelle);
        return true;
    }

    public void prendreIrrigation() {
        int nbrCanauxIrrigationRestant = Irrigation.getNbrCanauxIrrigation() - 1;
        Irrigation.setNbrCanauxIrrigation(nbrCanauxIrrigationRestant);
    }

    public Objectif prendreObjectif(PiocheObjectifs pioche, PlateauDeJoueur plateauDeJoueur){
        if (plateauDeJoueur.peutAjouterObjectif()){
            Objectif objectifPioche = pioche.piocher();
            plateauDeJoueur.ajouterObjectif(objectifPioche);
            return objectifPioche;
        }
        return null;
    }

    public boolean remplirObjectif(Objectif obj, PlateauDeJeu plateauDeJeu){
        int points = obj.appliquerObjectif(plateauDeJeu);
        if (points == 0){
            return false;
        }
        score += obj.appliquerObjectif(plateauDeJeu);
        plateauDeJoueur.ajouterObjectifAccomplis(obj);
        return true;
    }

    /* Méthode à déplacer eventuellement plus tard */
    public void placerIrrigation(PlateauDeJeu plateauDeJeu, Parcelle p1, Parcelle p2){
        Irrigation irr = new Irrigation(p1,p2);
        if (irr.getParcelle1().estAdjacent(plateauDeJeu.getParcelleEtang()) &&
            irr.getParcelle2().estAdjacent(plateauDeJeu.getParcelleEtang())){

            plateauDeJeu.ajouterNouveauReseauIrrigation(new ReseauIrrigation(irr));
        }else {
            for (ReseauIrrigation reseau : plateauDeJeu.getReseauxIrr()) {
                List<Irrigation> irrigationsDuReseau = reseau.getIrrigations();
                for (int i=0; i < irrigationsDuReseau.size(); i++) {
                    Irrigation irrigation = irrigationsDuReseau.get(i);
                    if (irr.getParcelle1().equals(irrigation.getParcelle1()) ||
                            irr.getParcelle2().equals(irrigation.getParcelle2())) {

                        reseau.ajouterIrragtionAuReseau(irr);
                        break;
                    }
                }
            }
        }
    }

    public boolean deplacerJardinier(Figurine jardinier, Parcelle parcelleDestination){
        if (!jardinier.estDeplaceableSur(parcelleDestination)) {
            return false;
        }else{
            jardinier.setParcelleDepart(parcelleDestination);
            if (parcelleDestination.estIrriguee() && parcelleDestination.getNombreDeBambous() <= 4) {
                parcelleDestination.fairePousserBambou(
                        new Bambou() {
                    @Override
                    public Couleur getCouleur() {
                        return parcelleDestination.getCouleur();
                    }
                });
            }
        }
        return true;
    }

    public boolean deplacerPanda(Figurine panda, Parcelle parcelleDestination){
        if (!panda.estDeplaceableSur(parcelleDestination)){
            return false;
        }else{
            panda.setParcelleDepart(parcelleDestination);
            if (parcelleDestination.getNombreDeBambous() != 0) {
                parcelleDestination.mangerBambou();
            }
        }
        return true;
    }

    /*
     * Si une parcelle est adjacent à la parcelle Étang, ça deviendra irriguée.
     * et on pourrait faire pousser une section de bambou sur cette parcelle.
     */
    public void planterBambouSurParcelleDeposee(Parcelle parcelle) {
        if (parcelle.estAdjacentAParcelleEtang(parcelle)) {
            parcelle.setIrriguee(true);
            parcelle.fairePousserBambou(
                    new Bambou() {
                @Override
                public Couleur getCouleur() {
                    return parcelle.getCouleur();
                }
            });
        }

    }

}
