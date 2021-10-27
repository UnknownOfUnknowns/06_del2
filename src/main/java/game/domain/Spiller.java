package game.domain;

public class Spiller {
    private Konto konto;
    private Terning t1;
    private Terning t2;
    private static final int TERNING_SIDER = 6;
    private Felt felt;

    public Spiller(Felt f){
        konto = new Konto(1000);
        t1 = new Terning(TERNING_SIDER);
        t2 = new Terning(TERNING_SIDER);
        felt = f;
    }

    public int rul_terninger(){
        t1.rul();
        t2.rul();
        int sum = t1.getVærdi() + t2.getVærdi();
        return sum;
    }

    private int[] getTerningØjne(){
        return new int[]{t1.getVærdi(), t2.getVærdi()};
    }

    public Konto getKonto() {
        return konto;
    }

    public int[] getStatus(){
        int[] øjne = getTerningØjne();
        return new int[]{øjne[0], øjne[1], konto.getSaldo()};
    }

    public Felt getFelt() {
        return felt;
    }

    public void setFelt(Felt felt) {
        this.felt = felt;
    }
}

