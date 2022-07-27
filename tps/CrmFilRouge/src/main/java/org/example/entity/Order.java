package org.example.entity;

import org.example.util.OrderState;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private long id;
    @ManyToOne
    @JoinColumn(name="clientId")
    private Client client;

    private String typePresta;
    private String designation;

    private Integer nbDays;

    private Float unitPrice;

    private Float totalExcludeTaxe;

    private Float totalWithTaxe;
    @Column(name = "state", columnDefinition = "BIT")
    private OrderState state;

    public Order() {

    }

    public Order(long id, Client client, String typePresta, String designation, Integer nbDays, Float unitPrice, Float totalExcludeTaxe, Float totalWithTaxe, OrderState state) {
        this.id = id;
        this.client = client;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.totalExcludeTaxe = totalExcludeTaxe;
        this.totalWithTaxe = totalWithTaxe;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
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

    public Float getTotalExcludeTaxe() {
        return totalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(Float totalExcludeTaxe) {
        this.totalExcludeTaxe = totalExcludeTaxe;
    }

    public Float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(Float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void setNotNullData(Order newOrderData){
        if(newOrderData.getClient() != null){
            this.setClient(newOrderData.getClient());
        }

        if(newOrderData.getTypePresta() != null){
            this.setTypePresta(newOrderData.getTypePresta());
        }

        if(newOrderData.getDesignation() != null){
            this.setDesignation(newOrderData.getDesignation());
        }

        if(newOrderData.getNbDays() != null){
            this.setNbDays(newOrderData.getNbDays());
        }

        if(newOrderData.getUnitPrice() != null){
            this.setUnitPrice(newOrderData.getUnitPrice());
        }

        if(newOrderData.getTotalExcludeTaxe() != null){
            this.setTotalExcludeTaxe(newOrderData.getTotalExcludeTaxe());
        }

        if(newOrderData.getTotalWithTaxe() != null){
            this.setTotalWithTaxe(newOrderData.getTotalWithTaxe());
        }

        if(newOrderData.getState() != null){
            this.setState(newOrderData.getState());
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", totalExcludeTaxe=" + totalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                ", state=" + state +
                '}';
    }
}
