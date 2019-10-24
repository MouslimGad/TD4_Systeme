import java.util.ArrayList;
import java.util.List;

public class Dechargeur {

    List<AleaObjet> stock ;


    public Dechargeur() {
        stock = new ArrayList<>();
    }



    public void decharger(List<AleaObjet> list){
        stock = list;
    }
}
