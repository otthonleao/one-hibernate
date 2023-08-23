package dev.otthon.one.hibernate.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import dev.otthon.one.hibernate.dao.CategoriaDAO;
import dev.otthon.one.hibernate.dao.ProdutoDAO;
import dev.otthon.one.hibernate.modelo.Categoria;
import dev.otthon.one.hibernate.modelo.Produto;
import dev.otthon.one.hibernate.util.JPAUtil;

public class CadastroDeProduto {
	
	public static void main(String[] args) {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("iPhone 13", "128GB - Black", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);

		em.getTransaction().commit();
		em.close();

//		celulares.setNome("Samsung Galaxy S22");
//		em.flush();
	}
}
