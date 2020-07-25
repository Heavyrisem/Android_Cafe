import java.lang.reflect.Constructor;

class Coffee {
    private String name;
    private int price;
    
    public Coffee() {
        name = "아아";
        price = 3000;

    }

    public Coffee(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public Boolean setName(String name) {
        this.name = name;
        return true;
    }

    public Boolean setPrice(int price) {
        this.price = price;
        return true;
    }

}