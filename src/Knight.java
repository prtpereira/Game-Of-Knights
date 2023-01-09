public class Knight {

    public int hitPoints;
    public String name;

    public Knight(String name, int hitPoints) {
        this.name = name;
        this.hitPoints = hitPoints;
    }

    public int decreaseHP(int p) {
        return this.hitPoints -= p;
    }

    public String toString() {
        return "Knight(name:" + name + ", hp:" + hitPoints + ")";
    }
}
