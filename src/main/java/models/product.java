package models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int product_id;
    private double price;
    private int amount;
    private String type;
    private String title;
    private String company;
    private String assemble_place;
    private String characteristics;

    public product(double price,
                 int amount, String type, String title, String company,
                  String assemble_place,  String characteristics) {
        this.price = price;
        this.amount = amount;
        this.type = type;
        this.title = title;
        this.company = company;
        this.assemble_place = assemble_place;
        this.characteristics = characteristics;
    }

    public product() {    }

    public int get_id() {
        return product_id;
    }

    public void set_id(int id) {
        this.product_id = id;
    }

    public double get_price() {
        return price;
    }

    public void set_price(double price) {
        this.price = price;
    }

    public int get_amount() {
        return amount;
    }

    public void set_amount(int amount) {
        this.amount = amount;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    public String get_title() {
        return title;
    }

    public void set_title(String title) {
        this.title = title;
    }

    public String get_company() {
        return company;
    }

    public void set_company(String company) {
        this.company = company;
    }

    public String get_assemble_place() {
        return assemble_place;
    }

    public void set_assemble_place(String assemble_place) {
        this.assemble_place = assemble_place;
    }

    public String get_characteristics() {
        return characteristics;
    }

    public void set_characteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final product other = (product) obj;
        return  (Double.compare(this.price, other.price) == 0) &&
                (this.amount == other.amount) &&
                (this.type.equals(other.type)) &&
                (this.title.equals(other.title)) &&
                (this.company.equals(other.company)) &&
                (this.assemble_place.equals(other.assemble_place)) &&
                (this.characteristics.equals(other.characteristics));
    }
}
