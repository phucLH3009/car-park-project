package com.phuclh.carparkproject.entity;

import com.phuclh.carparkproject.entity.converter.BooleanToStringConverter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity

@Table
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId", length = 20)
    private long id;

    @Column(length = 50)
    @NotBlank(message = "account required")
    private String account;

    @Column(length = 10)
    @NotBlank(message = "department required")
    private String department;

    @Column(name = "employeeAddress", length = 50)
    private String address;

    @Column(name = "employeeBirthdate")
    @NotNull(message = "birthdate required")
    private LocalDate birthdate;

    @Column(name = "employeeEmail", length = 50)
    private String email;

    @Column(name = "employeeName", length = 50)
    @NotBlank(message = "name required")
    private String name;

    @Column(name = "employeePhone", length = 10)
    @NotBlank(message = "phone required")
    private String phone;

    @Column(length = 20)
    @NotBlank(message = "password required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$", message = "Password must match with criteria")
    private String password;

    @Column(length = 1)
    @NotNull(message = "sex required")
    @Convert(converter = BooleanToStringConverter.class)
    private boolean sex;

    public Employee() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }
}
