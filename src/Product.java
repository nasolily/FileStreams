import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String ID;
    private String name;
    private String desc;
    private Double cost;

    //Constructor
    public Product(String ID, String name, String desc, Double cost) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.cost = cost;
    }

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