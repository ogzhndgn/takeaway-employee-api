package org.thepoet.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 15.07.2018
 */
@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Column(name = "id")
    private String id;

    @Column(name = "mailaddress")
    @Email(message = "Please provide a valid e-mail address")
    @Size(max = 256, message = "Size of mail address should be max 256")
    @NotNull(message = "Mail Address can not be null")
    private String mailAddress;

    @Column(name = "fullname")
    @NotNull(message = "Full name can not be null or empty")
    @Size(min = 1, max = 256, message = "Siz of fullname should be between 1 and 256")
    private String fullName;

    @Column(name = "birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "Birth Date should a past date")
    private Date birthDay;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "employeeid")
    private Set<Hobby> hobbyList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Set<Hobby> getHobbyList() {
        return hobbyList;
    }

    public void setHobbyList(Set<Hobby> hobbyList) {
        this.hobbyList = hobbyList;
    }
}
