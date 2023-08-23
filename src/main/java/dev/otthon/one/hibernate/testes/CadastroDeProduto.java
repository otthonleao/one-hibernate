package dev.otthon.one.hibernate.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dev.otthon.one.hibernate.modelo.Produto;


public class CadastroDeProduto {
    public static void main(String[] args) {
        Produto celular = new Produto();
        celular.setNome("iPhone 13");
        celular.setDescricao("128GB - Black");
        celular.setPreco(new BigDecimal("800"));

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("one_loja_hibernate");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        em.persist(celular);
        em.getTransaction().commit();
        em.close();
    }
}