package uqam.inf5153.game.pioche;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.objectif.ObjectifParcelle;
import uqam.inf5153.game.parcelle.Parcelle;

import java.util.ArrayList;
import java.util.List;

public class PiocheObjectifs extends Pioche<Objectif> {

    public PiocheObjectifs(){
        for (int identifiant = 1; identifiant <= 15; identifiant++){
            this.objetsAPiocher.add(new ObjectifParcelle(identifiant));
            //TODO pour les autres objectifs.
        }
    }

    @Override
    public Objectif piocher() {
        return objetsAPiocher.remove(0);
    }

    @Override
    public List<Objectif> piocher(int nbrAPiocher){
        List<Objectif> objectifsPioches = new ArrayList<>();
        for (int i = 0; i < nbrAPiocher; i++)
            objectifsPioches.add(objetsAPiocher.get(i));
        for (int i = 0; i < nbrAPiocher; i++)
            objetsAPiocher.remove(i);

        return objectifsPioches;
    }


}
