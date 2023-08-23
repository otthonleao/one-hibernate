package dev.otthon.one.hibernate.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/** ESSA CLASSE TEM COMO FUNÇÃO ISOLAR O ENTITY MANAGER */
public class JPAUtil {
    private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("one-loja-hibernate");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
