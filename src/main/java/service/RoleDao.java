package service;

import model.Role;

import java.util.List;

public interface RoleDao {
    Role add(Role role);

    Role getById(int id);

    List<Role> geAllRoles();

    void deleteRole(Role role);
}
