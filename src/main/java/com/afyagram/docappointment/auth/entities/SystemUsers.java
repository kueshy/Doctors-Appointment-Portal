package com.afyagram.docappointment.auth.entities;

import com.afyagram.docappointment.commons.identifiable.Auditable;
import com.afyagram.docappointment.roles.entities.Roles;
import com.afyagram.docappointment.roles.enums.SystemRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "sys_users")
public class SystemUsers extends Auditable {

    @Column(name = "name")
    private String  name;

    @Column(name = "phone_no")
    private String  phoneNumber;

    @Column(name = "username")
    private String  userName;

    @Column(name = "password")
    private String  passWord;

    @ManyToOne
    @JoinColumn(name ="roles" )
    private Roles roles;
}
