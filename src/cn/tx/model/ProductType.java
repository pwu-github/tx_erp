package cn.tx.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_type", schema = "tx_erp", catalog = "")
public class ProductType {
    private Integer productTypeId;
    private Integer supplierId;
    private String name;

    @Id
    @Column(name = "product_type_id", nullable = false)
    public Integer getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(Integer productTypeId) {
        this.productTypeId = productTypeId;
    }

    @Basic
    @Column(name = "supplier_id", nullable = true)
    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductType that = (ProductType) o;
        return productTypeId == that.productTypeId &&
                Objects.equals(supplierId, that.supplierId) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productTypeId, supplierId, name);
    }
}
