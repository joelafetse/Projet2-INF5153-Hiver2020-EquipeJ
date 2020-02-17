package uqam.inf5153.game.pioche;

import java.util.Collections;
import java.util.List;

public abstract class Pioche<T> {

    public void melangerPioche(List<T> tList){
        Collections.shuffle(tList);
    }


    public abstract T piocher(List<T> tList);
    public abstract List<T> piocher(int nbrAPiocher, List<T> tList);
}
