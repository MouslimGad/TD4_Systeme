public class AleaObjet {


    private int poids;



    public AleaObjet(int min, int max) {
        this.poids = (int) (Math.random() * (max - min)) + min;
    }


    public int getPoids() {
        return poids;
    }


    @Override
    public String toString() {
        return "AleaObjet{" +
                "poids=" + poids +
                '}';
    }
}
