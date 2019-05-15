package cn.tx.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Dep {
    private Integer depId;
    private String name;
    private String tel;

    @Id
    @Column(name = "dep_id", nullable = false)
    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "tel", nullable = true, length = 50)
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dep dep = (Dep) o;
        return depId == dep.depId &&
                Objects.equals(name, dep.name) &&
                Objects.equals(tel, dep.tel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depId, name, tel);
    }
}
