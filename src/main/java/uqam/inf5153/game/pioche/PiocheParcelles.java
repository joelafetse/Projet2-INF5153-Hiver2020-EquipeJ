package uqam.inf5153.game.pioche;

import uqam.inf5153.game.parcelle.Parcelle;
import uqam.inf5153.game.parcelle.ParcelleJaune;
import uqam.inf5153.game.parcelle.ParcelleRose;
import uqam.inf5153.game.parcelle.ParcelleVerte;

import java.util.ArrayList;
import java.util.List;

public class PiocheParcelles extends Pioche<Parcelle> {

    public PiocheParcelles(){
        // 11 objetsAPiocher vertes
        for (int i=0; i < 11; i++)
            this.objetsAPiocher.add(new ParcelleVerte());

        // 7 objetsAPiocher roses
        for (int i=0; i < 7; i++)
            this.objetsAPiocher.add(new ParcelleRose());

        // 9 objetsAPiocher jaunes
        for (int i=0; i < 9; i++)
            this.objetsAPiocher.add(new ParcelleJaune());
    }

    @Override
    public Parcelle piocher() {
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher une seule parcelle.");
    }

    @Override
    public List<Parcelle> piocher(int nbrAPiocher){
        List<Parcelle> parcellesPiochees = new ArrayList<>();
        for (int i=0; i < nbrAPiocher; i++) {
            parcellesPiochees.add(objetsAPiocher.get(i));
            objetsAPiocher.remove(i);
        }

        return parcellesPiochees;
    }

    public void replacerParcellesNonChoisies(List<Parcelle> parcellesNonChoisies){
        for (Parcelle p: parcellesNonChoisies)
            objetsAPiocher.add(p);
    }
}
