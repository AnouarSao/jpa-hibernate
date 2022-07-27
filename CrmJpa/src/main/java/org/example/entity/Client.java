package org.example.entity;

import org.example.enums.ClientState;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String address;
    private String city;
    private String companyName;
    private String country;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String zipCode;
    @Column(columnDefinition = "BIT")
    private ClientState state;

    public Client(){
    }
    public Client(String firstName, String lastName, String address, String city,
                  String zipCode, String country, String email, String phone, String companyName){

        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.companyName = companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ClientState getState() {
        return state;
    }

    public void setState(ClientState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state=" + state +
                '}';
    }

    public void setNotNullData(Client data){
        if(data.getFirstName() != null) {
            this.setFirstName(data.getFirstName());
        }

        if(data.getLastName() != null) {
            this.setLastName(data.getLastName());
        }

        if(data.getAddress() != null) {
            this.setAddress(data.getAddress());
        }

        if(data.getCity() != null) {
            this.setCity(data.getCity());
        }

        if(data.getCountry() != null) {
            this.setCountry(data.getCountry());
        }

        if(data.getCompanyName() != null) {
            this.setCompanyName(data.getCompanyName());
        }

        if(data.getPhone() != null) {
            this.setPhone(data.getPhone());
        }

        if(data.getZipCode() != null) {
            this.setZipCode(data.getZipCode());
        }

        if(data.getEmail() != null) {
            this.setEmail(data.getEmail());
        }

        if(data.getState() != null) {
            this.setState(data.getState());
        }
    }

}
