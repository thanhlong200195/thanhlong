package fasttrackse.ffse1703.fbms.dao.mvpquanliduan;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.mvpquanliduan.Nhiemvu;


@Repository
@Transactional
public class NhiemVuDaoImpl implements NhiemVuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	@Override
	public void add(Nhiemvu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(nhiemVu);

	}

	@Override
	public Nhiemvu getByID(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(Nhiemvu.class, id);
	}

	@Override
	public List<Nhiemvu> getByDuAn(String idProjects) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Nhiemvu where status =1 and projects.idProject='"+idProjects+"'", Nhiemvu.class).list();
	}
	@Override
	public List<Nhiemvu> getByMaNhanVien(String idNv) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from Nhiemvu where hoSoNhanVien.maNv='"+idNv+"'", Nhiemvu.class).list();
	}

	@Override
	public void update(Nhiemvu nhiemVu) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(nhiemVu);

	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Nhiemvu nhiemVu = session.get(Nhiemvu.class, id);
		nhiemVu.setStatus(0);
		session.update(nhiemVu);
	}

}
