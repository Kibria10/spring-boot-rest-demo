package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String mobile_no;

//    @NotBlank
//    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
//    private Date dob;

    @NotBlank
    private String address;

    @NotBlank
    private String gender;

    @Column(nullable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date updatedAt;

    public Long getId(){return id;}

    public void setId(Long id){ this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getMobile_no(){return mobile_no;}
    public void setMobile_no(String mobile_no){this.mobile_no = mobile_no;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getGender(){return gender;}
    public void setGender(String gender){this.gender = gender;}

//    public Date getDob(){return dob;}
//    public void setDob(Date dob){this.dob = dob;}

    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
