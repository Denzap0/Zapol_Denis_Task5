package Task;

public enum Model {
    MERCEDES("Mercedes-Benz", "Stuttgart", 1926),
    BMW("Bayerische Motoren Werke", "Munich", 1916),
    AUDI("Audi", "Ingolstadt", 1909);

    private String name, country;
    private int date;

    Model() {

    }

    Model(String name, String country, int date) {
        this.name = name;
        this.country = country;
        this.date = date;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

}
