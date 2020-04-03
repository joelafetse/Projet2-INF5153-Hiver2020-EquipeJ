package uqam.inf5153.game.tuile.parcelle;

public class FabriqueParcelle {

    public Parcelle getParcelle(Couleur couleur) {

        if(couleur == Couleur.VERT){
            return new ParcelleVerte();
        }
        if(couleur == Couleur.JAUNE){
            return new ParcelleJaune();
        }
        if(couleur == Couleur.ROSE){
            return new ParcelleRose();
        }
        return null;
    }
}
