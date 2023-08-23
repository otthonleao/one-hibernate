package dev.otthon.one.hibernate.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import dev.otthon.one.hibernate.dao.CategoriaDAO;
import dev.otthon.one.hibernate.dao.ProdutoDAO;
import dev.otthon.one.hibernate.modelo.Categoria;
import dev.otthon.one.hibernate.modelo.Produto;
import dev.otthon.one.hibernate.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);

		Produto p = produtoDAO.buscarPorId(1l);
		System.out.println(p.getPreco());

		List<Produto> todos = produtoDAO.buscarPorNomeDaCategoria("CELULARES");
		todos.forEach(p2 -> System.out.println(p.getNome()));

		BigDecimal precoDoProduto = produtoDAO.buscarPrecoDoProdutoComNome("iPhone 13");
		System.out.println("Preco do Produto: " + precoDoProduto);
	}

	private static void cadastrarProduto() {
		Categoria celulares = new Categoria("CELULARES");
		Produto celular = new Produto("iPhone 13", "128GB - Black", new BigDecimal("4000"), celulares);

		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);

		em.getTransaction().begin();

		categoriaDAO.cadastrar(celulares);
		produtoDAO.cadastrar(celular);

		em.getTransaction().commit();
		em.close();
	}

}
