package uqam.inf5153.game.tuile;

import uqam.inf5153.game.bambou.Bambou;
import uqam.inf5153.game.tuile.parcelle.Parcelle;

import java.util.ArrayList;
import java.util.List;

public interface ComposantParcelle {

    int getNombreDeBambous ();
    void fairePousserBambou();
    Bambou mangerBambou();
    Parcelle getComposant();

}
