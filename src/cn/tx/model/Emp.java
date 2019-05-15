package cn.tx.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Emp {
    private Integer empId;
    private Integer depId;
    private String name;
    private String username;
    private String email;
    private String tel;
    private Integer gender;
    private String address;
    private Date birthday;
    private String password;

    private Dep dep;

    public Dep getDep() {
        return dep;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    @Id
    @Column(name = "emp_id", nullable = false)
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Basic
    @Column(name = "dep_id", nullable = true)
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
    @Column(name = "username", nullable = true, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    @Column(name = "gender", nullable = true)
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 50)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "birthday", nullable = true)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Basic
    @Column(name = "password", nullable = true, length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return empId == emp.empId &&
                Objects.equals(depId, emp.depId) &&
                Objects.equals(name, emp.name) &&
                Objects.equals(username, emp.username) &&
                Objects.equals(email, emp.email) &&
                Objects.equals(tel, emp.tel) &&
                Objects.equals(gender, emp.gender) &&
                Objects.equals(address, emp.address) &&
                Objects.equals(birthday, emp.birthday) &&
                Objects.equals(password, emp.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId, depId, name, username, email, tel, gender, address, birthday, password);
    }
}
