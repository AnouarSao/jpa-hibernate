package org.example.entity;

import org.example.enums.OrderState;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INTEGER")
    private Long id;

    private String typePresta;
    private String designation;
    private Integer nbDays;
    private Float unitPrice;
    @Column(columnDefinition = "BIT")
    private OrderState state;

    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;


    public Order() {

    }

    public Order(String typePresta, String designation, int nbDays, float unitPrice) {
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setNotNullData(Order data){

        if(data.getTypePresta() != null) {
            this.setTypePresta(data.getTypePresta());
        }

        if(data.getDesignation() != null) {
            this.setDesignation(data.getDesignation());
        }

        if(data.getNbDays() != null) {
            this.setNbDays(data.getNbDays());
        }

        if(data.getUnitPrice() != null) {
            this.setUnitPrice(data.getUnitPrice());
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                ", client=" + client +
                '}';
    }
}
