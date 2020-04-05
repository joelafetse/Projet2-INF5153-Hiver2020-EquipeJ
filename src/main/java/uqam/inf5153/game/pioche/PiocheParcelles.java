package uqam.inf5153.game.pioche;

import uqam.inf5153.game.tuile.ComposantParcelle;
import uqam.inf5153.game.tuile.amenagement.AmenagementBassin;
import uqam.inf5153.game.tuile.amenagement.AmenagementEnclos;
import uqam.inf5153.game.tuile.amenagement.AmenagementEngrais;
import uqam.inf5153.game.tuile.parcelle.Parcelle;
import uqam.inf5153.game.tuile.parcelle.ParcelleJaune;
import uqam.inf5153.game.tuile.parcelle.ParcelleRose;
import uqam.inf5153.game.tuile.parcelle.ParcelleVerte;

import java.util.ArrayList;
import java.util.List;

public class PiocheParcelles extends Pioche<ComposantParcelle> {


    public PiocheParcelles(){
        // 11 parcelles vertes
        this.objetsAPiocher.add(new AmenagementBassin(new ParcelleVerte()));
        this.objetsAPiocher.add(new AmenagementBassin(new ParcelleVerte()));
        this.objetsAPiocher.add(new AmenagementEnclos(new ParcelleVerte()));
        this.objetsAPiocher.add(new AmenagementEnclos(new ParcelleVerte()));
        this.objetsAPiocher.add(new AmenagementEngrais(new ParcelleVerte()));
        for (int i=0; i < 6; i++)
            this.objetsAPiocher.add(new ParcelleVerte());

        // 7 parcelles roses
        this.objetsAPiocher.add(new AmenagementBassin(new ParcelleRose()));
        this.objetsAPiocher.add(new AmenagementEnclos(new ParcelleRose()));
        this.objetsAPiocher.add(new AmenagementEngrais(new ParcelleRose()));
        for (int i=0; i < 4; i++)
            this.objetsAPiocher.add(new ParcelleRose());

        // 9 parcelles jaunes
        this.objetsAPiocher.add(new AmenagementBassin(new ParcelleJaune()));
        this.objetsAPiocher.add(new AmenagementEnclos(new ParcelleJaune()));
        this.objetsAPiocher.add(new AmenagementEngrais(new ParcelleJaune()));
        for (int i=0; i < 6; i++)
            this.objetsAPiocher.add(new ParcelleJaune());
    }


    @Override
    public ComposantParcelle piocher() {
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher une seule parcelle.");
    }

    @Override
    public List<ComposantParcelle> piocher(int nbrAPiocher){
        List<ComposantParcelle> parcellesPiochees = new ArrayList<>();
        for (int i=0; i < nbrAPiocher; i++)
            parcellesPiochees.add(this.objetsAPiocher.get(i));
        for (int i=0; i < nbrAPiocher; i++)
            this.objetsAPiocher.remove(0);

        return parcellesPiochees;
    }

    public void replacerParcellesNonChoisies(List<ComposantParcelle> parcellesNonChoisies){
        for (ComposantParcelle p: parcellesNonChoisies)
            this.objetsAPiocher.add(p);
    }


    public void afficherParcelles(List<ComposantParcelle> parcelles) {
        int i=0;
        while(i < parcelles.size()) {
            if (parcelles.get(i)!=null) {
                System.out.println(i+1+". "+parcelles.get(i));
            }
            i++;
        }
    }
}
