package uqam.inf5153.game.pioche;

import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;
import uqam.inf5153.game.tuile.parcelle.ParcelleRose;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import java.util.ArrayList;
import java.util.List;

public class PiocheParcelles extends Pioche<Parcelle> {


    public PiocheParcelles(){
        // 11 parcelles vertes
        for (int i=0; i < 11; i++)
            this.objetsAPiocher.add(new ParcelleVerte());

        // 7 parcelles roses
        for (int i=0; i < 7; i++)
            this.objetsAPiocher.add(new ParcelleRose());

        // 9 parcelles jaunes
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
        for (int i=0; i < nbrAPiocher; i++)
            parcellesPiochees.add(this.objetsAPiocher.get(i));
        for (int i=0; i < nbrAPiocher; i++)
            this.objetsAPiocher.remove(i);

        return parcellesPiochees;
    }

    public void replacerParcellesNonChoisies(List<Parcelle> parcellesNonChoisies){
        for (Parcelle p: parcellesNonChoisies)
            this.objetsAPiocher.add(p);
    }


    public void afficherParcelles(List<Parcelle> parcelles) {
        int i=0;
        while(i < parcelles.size()) {
            if (parcelles.get(i)!=null) {
                System.out.println(i+1+". "+parcelles.get(i));
            }
            i++;
        }
    }
}
