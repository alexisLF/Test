package org.cesi.fablab.api.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.cesi.fablab.api.entity.GroupEntity;
import org.cesi.fablab.api.entity.ProjectEntity;
import org.cesi.fablab.api.entity.ReservationEntity;
import org.cesi.fablab.api.entity.RoleEntity;
import org.cesi.fablab.api.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int id;
    private String mail;
    private String password;
    private String firstname;
    private String lastname;
    private boolean active;
    private LocalDateTime dateActive;
    private String avatar;
    private int credit;
    private GroupEntity group;
    private RoleEntity role;
    private List<ReservationEntity> reservationsList = new ArrayList<ReservationEntity>();
    private List<ProjectEntity> projectCollaboratorsList = new ArrayList<ProjectEntity>();
    private List<UserEntity> projectsList = new ArrayList<UserEntity>();

    public UserDTO(UserEntity userEntity) {
        super();
        this.id = userEntity.getId();
        this.mail = userEntity.getMail();
        this.password = userEntity.getPassword();
        this.firstname = userEntity.getFirstname();
        this.lastname = userEntity.getLastname();
        this.active = userEntity.isActive();
        this.dateActive = userEntity.getDateActive();
        this.avatar = userEntity.getAvatar();
        this.credit = userEntity.getCredit();
        // this.group = userEntity.getGroup();
        // this.role = userEntity.getRole();
        // this.reservationsList = userEntity.getReservationsList();
        // this.projectCollaboratorsList = userEntity.getProjectCollaboratorsList();
        // this.projectsList = userEntity.getProjectsList();
    }

}
