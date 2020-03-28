package uqam.inf5153.game.tuile.parcelle;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.bambou.BambouRose;

import java.util.ArrayList;
import java.util.List;

public class ParcelleRose extends Parcelle {

    private final static int NB_SECTIONS_DE_BAMBOU_ROSE = 24;
    private static int nbr_sections_bambou_rose = NB_SECTIONS_DE_BAMBOU_ROSE;

    public ParcelleRose() {
        super.voisins=new ArrayList<Parcelle>();
    }
    public void prendreBambou(){
        this.nbr_sections_bambou_rose--;
    }
    public int getNbSectionsDeBambou () {
        return nbr_sections_bambou_rose;
    }

    @Override
    public Couleur getCouleur() {
        return Couleur.ROSE;
    }

    @Override
    public int getNombreDeBambous () {
        return super.bambous.size();
    }

    /*@Override
    public void setBambous() {

    }*/

    @Override
    public void fairePousserBambou(Bambou bambou) {
        if (this.irriguee) {
            if(nbr_sections_bambou_rose > 0 && bambous.size() < 4 ) {
                super.bambous.add(new BambouRose());
                prendreBambou();
            }
        }
    }



}
