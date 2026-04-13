public class Product {
    private String ID;
    private String name;
    private String desc;
    private Double cost;

    public static final int ID_LENGTH = 6;
    public static final int NAME_LENGTH = 35;
    public static final int DESC_LENGTH = 75;

    //Constructor
    public Product(String ID, String name, String desc, Double cost) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

    private String padField(String data, int length) {
        if (data.length() > length) {
            return data.substring(0, length);
        }
        return String.format("%-" + length + "s", data); //padding
    }

    public String getPaddedID() { return padField(ID, ID_LENGTH); }
    public String getPaddedName() { return padField(name, NAME_LENGTH); }
    public String getPaddedDesc() { return padField(desc, DESC_LENGTH); }

    //Getters and Setters
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", cost=" + cost +
                '}';
    }

    /**
     * Convert the Product object to a CSV data string.
     * @return A string in CSV format representing the Person object.
     */

    public String toCSVDataString() {
        return ID + "," + name + "," + desc + "," + cost;
    }
}