package game.domain;

public class Spiller {
    private int balance;
    private Terning t1;
    private Terning t2;
    private static final int TERNING_SIDER = 6;

    public Spiller(){
        balance = 1000;
        t1 = new Terning(TERNING_SIDER);
        t2 = new Terning(TERNING_SIDER);
    }

    public int rul_terninger(){
        t1.rul();
        t2.rul();
        int sum = t1.getVærdi() + t2.getVærdi();
        return sum;
    }
    public int getBalance() {
        return balance;
    }

    private int[] getTerningØjne(){
        return new int[]{t1.getVærdi(), t2.getVærdi()};
    }

    public int[] getStatus(){
        int[] øjne = getTerningØjne();
        return new int[]{øjne[0], øjne[1], getBalance()};
    }


    public void opdaterBalance(int p) {
        this.balance += p;
    }
}

