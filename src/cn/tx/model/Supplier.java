package cn.tx.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Supplier {
    private Integer supplierId;
    private String name;
    private String address;
    private String contact;
    private String tel;
    private Integer needs;

    @Id
    @Column(name = "supplier_id", nullable = false)
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

    @Basic
    @Column(name = "address", nullable = true, length = 30)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "contact", nullable = true, length = 30)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 30)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Basic
    @Column(name = "needs", nullable = true)
    public Integer getNeeds() {
        return needs;
    }

    public void setNeeds(Integer needs) {
        this.needs = needs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return supplierId == supplier.supplierId &&
                Objects.equals(name, supplier.name) &&
                Objects.equals(address, supplier.address) &&
                Objects.equals(contact, supplier.contact) &&
                Objects.equals(tel, supplier.tel) &&
                Objects.equals(needs, supplier.needs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(supplierId, name, address, contact, tel, needs);
    }
}
