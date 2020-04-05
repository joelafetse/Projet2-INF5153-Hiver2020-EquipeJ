package uqam.inf5153.game.tuile.parcelle;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.bambou.BambouJaune;


import java.util.ArrayList;
import java.util.List;

public class ParcelleJaune extends Parcelle {

    private final static int NB_SECTIONS_DE_BAMBOU_JAUNE = 30;
    private static int nbr_sections_bambou_jaune = NB_SECTIONS_DE_BAMBOU_JAUNE;

    public ParcelleJaune() {
        super.voisins=new ArrayList<Parcelle>();
    }

    public void prendreBambou(){
        nbr_sections_bambou_jaune--;
    }
    public int getNbSectionsDeBambou () {
        return nbr_sections_bambou_jaune;
    }

    @Override
    public Couleur getCouleur() {
        return Couleur.JAUNE;
    }


    @Override
    public void fairePousserBambou() {
        if (this.irriguee) {
            if(nbr_sections_bambou_jaune > 0 && bambous.size() < 4 ) {
                prendreBambou();
                super.bambous.push(new BambouJaune());
            }
        }
    }

    @Override
    public int getNombreDeBambous () {
        return super.bambous.size();
    }











}
