package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateAnnotationRepositoryDemo {
    private final SessionFactory sessionFactory;
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/app42_1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public HibernateAnnotationRepositoryDemo() {
        sessionFactory = init();
    }

    public SessionFactory init(){
        try {
            Configuration configuration = new Configuration();
            configuration.setProperty("hibernate.connection.driver_class",DRIVER);
            configuration.setProperty("hibernate.connection.url",URL);
            configuration.setProperty("hibernate.connection.username",USERNAME);
            configuration.setProperty("hibernate.connection.password",PASSWORD);

            configuration.addAnnotatedClass(org.example.entity.User.class);

            StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties())
                    .build();

            return configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e){
            throw  new RuntimeException("init hibernate fail");
        }

    }



    public List<User> findAll(){
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
          return entityManager.createQuery("from User", User.class).getResultList();
        } catch (Exception e){
            throw new RuntimeException("get all users fail");
        }
    }

    public User findById(Long id){
        try(EntityManager entityManager = sessionFactory.createEntityManager()) {
            return entityManager.find(User.class,id);
        } catch (Exception e){
            throw new RuntimeException("get by id (" + id +") users fail");
        }
    }

    public User create(User user){
        EntityTransaction transaction=null;
        try (EntityManager entityManager = sessionFactory.createEntityManager()) {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(user);
            transaction.commit();
            return user;
        } catch (Exception e){
            if(transaction!=null && transaction.isActive()){
                transaction.rollback();
            }
            throw new RuntimeException("Create user ("+ user + ") fail");
        }

    }

}
