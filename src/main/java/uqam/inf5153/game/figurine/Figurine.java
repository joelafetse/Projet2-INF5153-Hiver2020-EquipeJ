package uqam.inf5153.game.figurine;

import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.plateau.Coordonnees;

public abstract class Figurine {

    protected ComposantParcelle comParcelleDepart;

    public Figurine(ComposantParcelle comParcelle){
        this.comParcelleDepart = comParcelle;
    }

    public ComposantParcelle getParcelleDepart() {
        return comParcelleDepart;
    }

    public void setParcelleDepart(ComposantParcelle comParcelleDepart) {
        this.comParcelleDepart = comParcelleDepart;
    }


    public boolean estDeplaceableSur(ComposantParcelle comParcelleDestination){
        boolean estDeplaceable = false;
        Coordonnees coordDepart = comParcelleDepart.getComposant().getCoordonnees();
        Coordonnees coordDestination = comParcelleDestination.getComposant().getCoordonnees();
        double pente1 = 1/2;
        double pente2 = -1/2;
        double numerateur = coordDestination.getY() - coordDepart.getY();
        double denominateur = coordDestination.getX() - coordDepart.getX();

        double coef = 0;

        if(numerateur == 0) {return false;}

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






