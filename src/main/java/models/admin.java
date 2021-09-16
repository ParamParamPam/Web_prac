package models;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class admin {

    @Id
    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int admin_id;
    private String admin_login;
    private String admin_psswd;

    public admin(String login, String psswd) {
        this.admin_login = login;
        this.admin_psswd = psswd;
    }

    public admin() {    }

    public int get_id() {
        return admin_id;
    }

    public void set_id(int id) {
        this.admin_id = id;
    }

    public String get_login() {
        return admin_login;
    }

    public void set_login(String login) {
        this.admin_login = login;
    }

    public String get_psswd() {
        return admin_psswd;
    }

    public void set_psswd(String psswd) {
        this.admin_psswd = psswd;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (obj.getClass() != this.getClass()) { return false; }
        final admin other = (admin) obj;
        return (this.admin_id == other.admin_id) &&
                (this.admin_login.equals(other.admin_login)) &&
                (this.admin_psswd.equals(other.admin_psswd));
    }
}
