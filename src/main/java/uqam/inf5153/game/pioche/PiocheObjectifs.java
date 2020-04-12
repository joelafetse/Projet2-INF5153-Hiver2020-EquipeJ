package uqam.inf5153.game.pioche;

import uqam.inf5153.game.objectif.Objectif;
import uqam.inf5153.game.objectif.ObjectifJardinier;
import uqam.inf5153.game.objectif.ObjectifParcelle;

import java.util.ArrayList;
import java.util.List;

public class PiocheObjectifs extends Pioche<Objectif> {

    public PiocheObjectifs(){
        for (int identifiant = 1; identifiant <= 15; identifiant++){
            super.objetsAPiocher.add(new ObjectifParcelle(identifiant));
        }
        for (int identifiant = 16; identifiant <= 30; identifiant++){
            super.objetsAPiocher.add(new ObjectifJardinier(identifiant));
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
            objetsAPiocher.remove(0);

        return objectifsPioches;
    }


}
