package main;

public class Item {

    public String name;
    public int count;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // count
    public void addCount() {
        this.count ++;
    }

    public void addCountByN(int n) {
        this.count += n;
    }

    public int getCount() {
        return this.count;
    }

}
