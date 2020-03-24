package uqam.inf5153.game.figurine;

import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.plateau.Coordonnees;

public abstract class Figurine {

    protected Parcelle parcelleDepart;

    public Figurine(Parcelle parcelle){
        this.parcelleDepart = parcelle;
    }

    public Parcelle getParcelleDepart() {
        return parcelleDepart;
    }

    public void setParcelleDepart(Parcelle parcelleDepart) {
        this.parcelleDepart = parcelleDepart;
    }


    public boolean estDeplaceableSur(Parcelle parcelleDestination){
        boolean estDeplaceable = false;
        Coordonnees coordDepart = parcelleDepart.getCoordonnees();
        Coordonnees coordDestination = parcelleDestination.getCoordonnees();
        double pente1 = 1/2;
        double pente2 = -1/2;
        double numerateur = coordDestination.getY() - coordDepart.getY();
        double denominateur = coordDestination.getX() - coordDepart.getX();

        double coef = 0;

        if(numerateur==0){return false;}

        if(denominateur == 0) {
            estDeplaceable = true;
        }else {
            coef =  (coordDestination.getY() - coordDepart.getY()) /
                    (coordDestination.getX() - coordDepart.getX());
            return coef == pente1 || coef == pente2;
        }

        return estDeplaceable;
    }


}






