package masayuki.jpa.entity;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name = "products")
public class Product {

    @Id
    private String id;

    @Column(name = "brand_id")
    private String brandId;

    private String name;

    private Long price;

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Brands getBrands() {
        return brands;
    }

    public void setBrands(Brands brands) {
        this.brands = brands;
    }

    @ManyToOne
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private Brands brands;
}
