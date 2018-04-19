package pl.dezet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Transit {

    public Transit() {
    }

    @Column(name = "id")
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    private String sourceAddress;
    @NotEmpty
    private String destinationAddress;
    private double price;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private Long distance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Transit{" +
                "id=" + id +
                ", sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", distance=" + distance +
                '}';
    }


}
