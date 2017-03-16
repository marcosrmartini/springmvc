package br.com.mmartini.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import br.com.mmartini.model.Produto;

@Repository
public class ProdutoDAOImpl_2 implements ProdutoDAO_2 {

	private static final Logger logger = LoggerFactory
			.getLogger(ProdutoDAOImpl_2.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void adiciona(Produto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Registro salvo com sucesso, detalhes do registro = " + p);

	}

	@Override
	public void atualiza(Produto p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Registro atualizado com sucesso, detalhes do registro = " + p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = null;
		p = (Produto) session.load(p.getClass(), new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		logger.info("Registro removido com sucesso, detalhes do registro = " + p);
	}

	@Override
	public List getList() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Produto> regList = session.createQuery("from Produto").list();
		for (Produto p : regList) {
			logger.info("Registro lista :: " + p);
		}
		return regList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Produto getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Produto p = null;
		p = (Produto) session.load(p.getClass(), new Integer(id));
		logger.info("Registro carregado com sucesso, detalhes do registro = " + p);
		return p;
	}

}
