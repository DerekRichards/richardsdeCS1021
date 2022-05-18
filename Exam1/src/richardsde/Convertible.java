package richardsde;

public class Convertible {
    protected boolean topOpen;

    public Convertible(boolean topOpen){
        super();
        this.topOpen = topOpen;
    }

    public Convertible(){
        super();
        this.topOpen = false;
    }

    public boolean getTopOpen(){
        return topOpen;
    }
}
