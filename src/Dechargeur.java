import java.util.ArrayList;
import java.util.List;

public class Dechargeur implements Runnable{

    List<AleaObjet> stock ;




    public Dechargeur() {
        stock = new ArrayList<>();
    }

    public void decharger(List<AleaObjet> list){
        stock = list;
    }

    @Override
    public void run() {


    }
}
