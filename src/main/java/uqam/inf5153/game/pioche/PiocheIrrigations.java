package uqam.inf5153.game.pioche;

import uqam.inf5153.game.plateau.Irrigation;
import java.util.List;


public class PiocheIrrigations extends Pioche<Irrigation>{

    @Override
    public Irrigation piocher() {
        int nbrCanauxIrrigationRestant = Irrigation.getNbrCanauxIrrigation() - 1;
        Irrigation.setNbrCanauxIrrigation(nbrCanauxIrrigationRestant);
        return objetsAPiocher.get(0);
    }


    @Override
    public List<Irrigation> piocher(int nbrAPiocher){
        throw new UnsupportedOperationException("Vous ne pouvez pas piocher plusieurs irrigation à la fois.");
    }

}
