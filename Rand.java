import java.util.Random;

public class Rand {
    private int sides;
    private int compX;
    private int compY;
    private Random rand = new Random();

    public Rand(int sides) {
        this.sides = sides;
    }

    public Rand(int x, int y) {
        this.compX = x;
        this.compY = y;
    }

    public int roll() {

        return rand.nextInt(sides) + 1;
    }

    public int getCompX() {
        return rand.nextInt(compX) + 1;
    }

    public int getCompY() {
        return rand.nextInt(compY) + 1;
    }

}
