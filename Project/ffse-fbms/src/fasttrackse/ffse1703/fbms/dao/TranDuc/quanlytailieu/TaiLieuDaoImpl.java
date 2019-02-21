package fasttrackse.ffse1703.fbms.dao.TranDuc.quanlytailieu;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.DanhMuc;
import fasttrackse.ffse1703.fbms.entity.TranDuc.quanlytailieu.TaiLieu;
import fasttrackse.ffse1703.fbms.entity.security.PhongBan;

@Repository
public class TaiLieuDaoImpl implements TaiLieuDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSession(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<TaiLieu> listAll() {
		Session session = this.sessionFactory.openSession();
		List<TaiLieu> list = session.createQuery("from TaiLieu").list();
		session.close();
		return list;
	}

	@Override
	public void addTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void updateTL(TaiLieu tl) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(tl);
		tx.commit();
		session.close();
	}

	@Override
	public void deleteTL(Integer idTL) {
		Session session = this.sessionFactory.openSession();
		Transaction tl = session.beginTransaction();
		session.delete(session.get(TaiLieu.class, idTL));
		tl.commit();
		session.close();
	}

	@Override
	public TaiLieu getTLbyID(Integer idTL) {
		Session session = this.sessionFactory.openSession();
		TaiLieu tl = session.get(TaiLieu.class, idTL);
		session.close();
		return tl;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaiLieu> listAll(int start, int limit) {
		Session session = this.sessionFactory.openSession();
		Query sql = session.createQuery("from TaiLieu");
		sql.setFirstResult((int) Math.ceil(start));
		sql.setMaxResults((int) Math.ceil(limit));
		List<TaiLieu> list = sql.getResultList();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PhongBan> listPhongBan() {
		Session session = this.sessionFactory.openSession();
		List<PhongBan> list = session.createQuery("from PhongBan").list();
		session.close();
		return list;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<DanhMuc> listDanhMuc() {
		Session session = this.sessionFactory.openSession();
		List<DanhMuc> list = session.createQuery("from DanhMuc").list();
		session.close();
		return list;
	}

	@Override
	public List<TaiLieu> listTaiLieu() {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<TaiLieu> cq = cb.createQuery(TaiLieu.class);
//		Root<TaiLieu> root = cq.from(TaiLieu.class);
//		Join<TaiLieu, TrangThaiTaiLieu> MaTrangThaiJoin = root.join("ma_trang_thai");
//		Join<TaiLieu, PhongBan> MaPhongBanJoin = root.join("ma_phong_ban");
//		cq.select(root).where(cb.and(cb.equal(MaTrangThaiJoin.get("ma_trang_thai"), "da_phe_duyet"),
//				cb.equal(MaPhongBanJoin.get("ma_phong_ban"), "all")));
//		List<TaiLieu> listPublicDocument = session.createQuery(cq).getResultList();
//		return listPublicDocument;
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder cb = session.getCriteriaBuilder();
//		CriteriaQuery<TaiLieu> cq = cb.createQuery(TaiLieu.class);
//		Root<TaiLieu> root = cq.from(TaiLieu.class);
//		Join<TaiLieu, DanhMuc> addressJoin = root.join("ma_danh_muc");
//		cq.select(root);
//		List<TaiLieu> listTL = session.createQuery(cq).getResultList();
		return null;
	}
}
