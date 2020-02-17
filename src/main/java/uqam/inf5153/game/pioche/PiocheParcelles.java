package uqam.inf5153.game.pioche;

import uqam.inf5153.game.parcelle.Parcelle;

import java.util.ArrayList;
import java.util.List;

public class PiocheParcelles extends Pioche<Parcelle> {

    @Override
    public Parcelle piocher(List<Parcelle> parcelles) {
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher une seule parcelle.");
    }

    @Override
    public List<Parcelle> piocher(int nbrAPiocher, List<Parcelle> parcelles){
        List<Parcelle> parcellesPiochees = new ArrayList<>();
        for (int i=0; i < nbrAPiocher; i++) {
            parcellesPiochees.add(parcelles.get(i));
            parcelles.remove(i);
        }

        return parcellesPiochees;
    }

    public void replacerParcellesNonChoisies(List<Parcelle> parcellesNonChoisies ,List<Parcelle> parcelles){
        for (Parcelle p: parcellesNonChoisies)
            parcelles.add(p);
    }
}
