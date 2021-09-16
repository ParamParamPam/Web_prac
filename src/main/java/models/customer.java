package models;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customer_id;
    private String customer_login;
    private String customer_psswd;
    private String last_name;
    private String first_name;
    private String customer_address;
    private String phone_number;
    private String mail;

    public customer(String login,
                     String psswd, String last_name,
                     String first_name, String address, String phone_number,
                     String mail) {
        this.customer_login = login;
        this.customer_psswd = psswd;
        this.last_name = last_name;
        this.first_name = first_name;
        this.customer_address = address;
        this.phone_number = phone_number;
        this.mail = mail;
    }

    public customer() {    }

    public int get_id() {
        return customer_id;
    }

    public void set_id(int id) {
        this.customer_id = id;
    }

    public String get_login() {
        return customer_login;
    }

    public void set_login(String login) {
        this.customer_login = login;
    }

    public String get_psswd() {
        return customer_psswd;
    }

    public void set_psswd(String psswd) {
        this.customer_psswd = psswd;
    }

    public String get_last_name() {
        return last_name;
    }

    public void set_last_name(String last_name) {
        this.last_name = last_name;
    }

    public String get_first_name() {
        return first_name;
    }

    public void set_first_name(String first_name) {
        this.first_name = first_name;
    }

    public String get_address() {
        return customer_address;
    }

    public void set_address(String address) {
        this.customer_address = address;
    }

    public String get_phone_number() {
        return phone_number;
    }

    public void set_phone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String get_mail() {
        return mail;
    }

    public void set_mail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final customer other = (customer) obj;
        return (this.customer_id == other.customer_id) &&
                (this.customer_login.equals(other.customer_login)) &&
                (this.customer_psswd.equals(other.customer_psswd)) &&
                (this.last_name.equals(other.last_name)) &&
                (this.first_name.equals(other.first_name)) &&
                (this.customer_address.equals(other.customer_address)) &&
                (this.phone_number.equals(other.phone_number)) &&
                (this.mail.equals(other.mail));
    }
}
