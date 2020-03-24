package uqam.inf5153.game.pioche;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Pioche<T> {

    protected List<T> objetsAPiocher = new ArrayList<>();

    public void melangerPioche(){
        Collections.shuffle(objetsAPiocher);
    }


    public abstract T piocher();
    public abstract List<T> piocher(int nbrAPiocher);



}
