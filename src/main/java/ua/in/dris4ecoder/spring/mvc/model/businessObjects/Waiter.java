package ua.in.dris4ecoder.spring.mvc.model.businessObjects;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Alex Korneyko on 21.08.2016 14:53.
 */
@Entity
@Table(name = "waiters")
@PrimaryKeyJoinColumn(name = "employee_id", referencedColumnName = "id")
public class Waiter extends Employee {

    @OneToMany()
    @JoinColumn(name = "employee_id")
    @Fetch(FetchMode.JOIN)
    private List<Order> orders;

    @Column(name = "tip")
    private float tip;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public float getTip() {
        return tip;
    }

    public void setTip(float tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("{" + super.toString());
        sb.append("\n\t tip='" + tip + "\'");
        sb.append("\n").append("\tOrders:");
        orders.forEach(order -> sb.append("\n\t\t").append(order));
        sb.append("\n}\n");

        return sb.toString();
    }
}
