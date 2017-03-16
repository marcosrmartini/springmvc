package br.com.mmartini.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import br.com.mmartini.model.Produto;

@Repository
public class BaseDAOImpl<T> implements BaseDAO {
	
//	Descobre de qual classe o generic foi instanciado
	private final Class<T> genericType = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), BaseDAOImpl.class);	
	
	private static final Logger log = LoggerFactory
			.getLogger(BaseDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void adiciona(Object t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(t);
		log.info("Registro salvo com sucesso, detalhes do registro = " + t);

	}

	@Override
	public void atualiza(Object t) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(t);
		log.info("Registro atualizado com sucesso, detalhes do registro = " + t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		T t = (T) session.load(genericType.getName(), new Integer(id));
		if (null != t) {
			session.delete(t);
		}
		log.info("Registro removido com sucesso, detalhes do registro = " + t);
	}

	@Override
	public List getList() {
		// TODO Verificar rotina CreateQuery
		Session session = this.sessionFactory.getCurrentSession();
		List<T> regList = session.createQuery("from " + genericType.getName()).list();
		for (T t : regList) {
			log.info("Registro lista :: " + t);
		}
		return regList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		T t = (T) session.load(genericType.getName(), new Integer(id));
		log.info("Registro carregado com sucesso, detalhes do registro = " + t);
		return t;
	}

}
