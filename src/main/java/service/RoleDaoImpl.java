package service;

import model.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

    @Override
    public Role add(Role role) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.persist(role);

        transaction.commit();

        return role;
    }

    @Override
    public Role getById(int id) {
        return EntityManagerClass.entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> geAllRoles() {
        return EntityManagerClass.entityManager.createQuery(
                "FROM Role", Role.class).getResultList();
    }

    @Override
    public void deleteRole(Role role) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.remove(role);

        transaction.commit();
    }
}
