package service;

import model.Role;
import model.User;

import javax.persistence.EntityTransaction;
import java.util.List;

public class UserDaoImpl implements UserDao{
    @Override
    public User add(User user) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.persist(user);

        transaction.commit();

        return user;
    }

    @Override
    public User getById(int id) {
        return EntityManagerClass.entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUser() {
        return EntityManagerClass.entityManager.createQuery(
                "FROM User", User.class).getResultList();
    }

    @Override
    public User updateUser(User user) {
        User updated;
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        updated = (User) EntityManagerClass.entityManager.merge(user);
        transaction.commit();

        return updated;
    }

    @Override
    public void deleteUser(User user) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        EntityManagerClass.entityManager.remove(user);

        transaction.commit();
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        EntityTransaction transaction = EntityManagerClass.entityManager.getTransaction();
        transaction.begin();

        User updatedUser = EntityManagerClass.entityManager.find(User.class, user.getId());
        Role associatedRole = EntityManagerClass.entityManager.find(Role.class, role.getId());
        updatedUser.getRoles().add(associatedRole);

        transaction.commit();
    }
}
