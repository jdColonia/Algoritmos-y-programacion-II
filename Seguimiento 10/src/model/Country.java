package model;

public class Country implements Comparable<Country> {

    private String name;
    private int gold;
    private int silver;
    private int bronze;
    private int total;

    public Country(String name, int gold, int silver, int bronze, int total) {
        this.name = name;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold += gold;
        setTotal(gold);
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver += silver;
        setTotal(silver);
    }

    public int getBronze() {
        return bronze;
    }

    public void setBronze(int bronze) {
        this.bronze += bronze;
        setTotal(bronze);
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total += total;
    }

    @Override
    public int compareTo(Country o) {
        int goldComparison = Integer.compare(o.gold, this.gold);
        if (goldComparison == 0) {
            int silverComparison = Integer.compare(o.silver, this.silver);
            if (silverComparison == 0) {
                int bronzeComparison = Integer.compare(o.bronze, this.bronze);
                if (bronzeComparison == 0) {
                    return this.name.compareTo(o.name);
                } else {
                    return bronzeComparison;
                }
            } else {
                return silverComparison;
            }
        } else {
            return goldComparison;
        }
    }

}