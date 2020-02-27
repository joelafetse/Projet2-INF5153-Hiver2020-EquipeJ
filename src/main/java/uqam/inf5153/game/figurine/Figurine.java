package uqam.inf5153.game.figurine;

import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.plateau.Coordonnees;

public abstract class Figurine {

    protected Parcelle parcelleDepart;

    public Figurine(Parcelle parcelleEtang){
        this.parcelleDepart = parcelleEtang;
    }

    public Parcelle getParcelleDepart() {
        return parcelleDepart;
    }

    public void setParcelleDepart(Parcelle parcelleDepart) {
        this.parcelleDepart = parcelleDepart;
    }


    public boolean estDeplaceableSur(Parcelle parcelleDestination){
        Coordonnees coordDepart = parcelleDepart.getCoordonnees();
        Coordonnees coordDestination = parcelleDestination.getCoordonnees();
        double pente1 = 1/2;
        double pente2 = -1/2;
        double coef = (coordDestination.getY() - coordDepart.getY()) /
                (coordDestination.getX() - coordDepart.getX());

        return coordDepart.getX() == coordDestination.getX() || coef == pente1 || coef == pente2;
    }
}
