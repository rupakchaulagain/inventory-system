package com.inventory.model;

import com.inventory.configuration.Auditable;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rupak ON 2020/07/21-8:34 AM
 */
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin extends Auditable<String> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "status")
    private Character status;

    @Column(name = "remarks")
    private String remarks;


    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
