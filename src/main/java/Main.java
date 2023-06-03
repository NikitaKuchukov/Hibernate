import model.Role;
import model.RoleType;
import model.User;
import service.RoleDao;
import service.RoleDaoImpl;
import service.UserDao;
import service.UserDaoImpl;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        RoleDao roleDao = new RoleDaoImpl();

        Role role1 = Role.builder().type(RoleType.ANALYST).build();
        Role role2 = Role.builder().type(RoleType.QA).build();
        roleDao.add(role1);
        roleDao.add(role2);

        Set<Role> roles = new HashSet<>();
        roles.add(role1);
        roles.add(role2);

        User user = User.builder().login("1").name("asfd").password("sdf").roles(roles).build();

        userDao.add(user);

    }
}
