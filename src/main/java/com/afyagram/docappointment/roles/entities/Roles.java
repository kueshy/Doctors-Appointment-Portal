package com.afyagram.docappointment.roles.entities;

import com.afyagram.docappointment.commons.identifiable.Auditable;
import com.afyagram.docappointment.roles.enums.SystemRoles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 * Author:Zack Ogoma
 * Since v1.0.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Builder
@Table(name = "sys_roles")
public class Roles extends Auditable {

    @Column(name = "sys_roles_name")
    @Enumerated
    private SystemRoles systemRoles;

}
