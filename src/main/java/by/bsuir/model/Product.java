package by.bsuir.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private double price;

    @Column(name = "year")
    private int year;

    @Column(name = "diagonal")
    private double diagonal;

    @Column(name = "resolution")
    private String resolution;

    @Column(name = "ram")
    private int ram;

    @Column(name = "memory_size")
    private int memorySize;

    @Column(name = "battery_capacity")
    private int batteryCapacity;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "colors")
    private String colors;

    public Product() {
        this.type = null;
        this.manufacturer = null;
        this.model = null;
        this.imageUrl = null;
        this.colors = null;
    }

    public Product(String type, String manufacturer, String model, long price, int year, double diagonal,
                   String resolution, int ram, int memorySize, int batteryCapacity, String imageUrl, String colors) {
        this.type = type;
        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.year = year;
        this.diagonal = diagonal;
        this.resolution = resolution;
        this.ram = ram;
        this.memorySize = memorySize;
        this.batteryCapacity = batteryCapacity;
        this.imageUrl = imageUrl;
        this.colors = colors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                Double.compare(product.price, price) == 0 &&
                year == product.year &&
                Double.compare(product.diagonal, diagonal) == 0 &&
                ram == product.ram &&
                memorySize == product.memorySize &&
                batteryCapacity == product.batteryCapacity &&
                Objects.equals(type, product.type) &&
                Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(model, product.model) &&
                Objects.equals(resolution, product.resolution) &&
                Objects.equals(imageUrl, product.imageUrl) &&
                Objects.equals(colors, product.colors);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, type, manufacturer, model, price, year, diagonal, resolution, ram, memorySize, batteryCapacity, imageUrl, colors);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", year=" + year +
                ", diagonal=" + diagonal +
                ", resolution='" + resolution + '\'' +
                ", ram=" + ram +
                ", memorySize=" + memorySize +
                ", batteryCapacity=" + batteryCapacity +
                ", imageUrl='" + imageUrl + '\'' +
                ", colors='" + colors + '\'' +
                '}';
    }
}
