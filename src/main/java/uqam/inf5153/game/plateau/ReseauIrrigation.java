package uqam.inf5153.game.plateau;

import java.util.ArrayList;
import java.util.List;

public class ReseauIrrigation {

    private List<Irrigation> irrigations;

    public ReseauIrrigation(Irrigation irrigationDebut){
        irrigations = new ArrayList<>();
        irrigations.add(irrigationDebut);
    }

    public void ajouterIrragtionAuReseau(Irrigation irrigation){
        irrigations.add(irrigation);
    }

    public List<Irrigation> getIrrigations(){
        return irrigations;
    }

}
