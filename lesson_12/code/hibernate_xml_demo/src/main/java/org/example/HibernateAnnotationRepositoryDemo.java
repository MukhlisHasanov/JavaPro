package org.example;

import org.example.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateAnnotationRepositoryDemo {
    private  final SessionFactory sessionFactory;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/app42_1";
    private static final String USER = "postgres";
    private static final String PASSWORD = "m0555252505";
    private static final String SCHEMA = "app42_1";
    private static final String UPDATE = "update";

    public HibernateAnnotationRepositoryDemo() {
        sessionFactory = init();
    }

    public SessionFactory init() {
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class",DRIVER);
            configuration.setProperty("hibernate.connection.url", URL);
            configuration.setProperty("hibernate.connection.username", USER);
            configuration.setProperty("hibernate.connection.password", PASSWORD);
            configuration.setProperty("hibernate.default_schema", SCHEMA);
            configuration.setProperty("hibernate.hbm2ddl.auto", UPDATE);

            configuration.addAnnotatedClass(User.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e){
            throw new RuntimeException("init Hibernate failed");
        }
    }



    public List<User> findAll(){
        try(EntityManager entityManager = sessionFactory.createEntityManager()){
            return entityManager.createQuery("from User", User.class).getResultList();
        } catch (Exception e) {
            throw new RuntimeException("get all users failed");
        }
    }

    public User findById(Long id){
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
            return entityManager.find(User.class, id);
        } catch (Exception e) {
            throw new RuntimeException("get by id (" + id + ") failed");
        }
    }

    public User create(User user){
        EntityTransaction transaction = null;
        try(EntityManager entityManager = sessionFactory.createEntityManager()){
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("create user (" + user + ") failed");
        }
    }
}










