package by.bsuir.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "role")
    private String role;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @Column(name = "birthdate")
    private Date birthDate;

    public Account() {
        this.login = null;
        this.password = null;
        this.email = null;
        this.role = null;
        this.name = null;
        this.surname = null;
        this.middleName = null;
        this.phone = null;
        this.address = null;
        this.birthDate = null;
    }

    public Account(String login, String password, String email, String role, String name, String surname,
                   String middleName, String phone, String address, Date birthDate) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.phone = phone;
        this.address = address;
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id &&
                Objects.equals(login, account.login) &&
                Objects.equals(password, account.password) &&
                Objects.equals(email, account.email) &&
                Objects.equals(role, account.role) &&
                Objects.equals(name, account.name) &&
                Objects.equals(surname, account.surname) &&
                Objects.equals(middleName, account.middleName) &&
                Objects.equals(phone, account.phone) &&
                Objects.equals(address, account.address) &&
                Objects.equals(birthDate, account.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, email, role, name, surname, middleName, phone, address, birthDate);
    }

    @Override
    public String toString() {
        return "Account {" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                " }";
    }
}
