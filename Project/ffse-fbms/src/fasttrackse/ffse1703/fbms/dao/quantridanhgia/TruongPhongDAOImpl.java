package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository
public class TruongPhongDAOImpl implements TruongPhongDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public DanhGiaBanThan getNhanVienTuDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaBanThan.class, id );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TruongPhongDanhGia> getListNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from TruongPhongDanhGia where phongBan = :phongBan").setParameter("phongBan", phongBan).list();
	}

	@Override
	public void insertDanhGiaNhanVien(TruongPhongDanhGia danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhGia);
	}

	@Override
	public TruongPhongDanhGia getDanhGiaNhanVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(TruongPhongDanhGia.class, id);
	}

	@Override
	public void createListNhanVienPhongBan(List<TruongPhongDanhGia> danhGia) {
		Session session = sessionFactory.getCurrentSession();
		for (TruongPhongDanhGia x : danhGia) {
			session.persist(x);
		}
	}

	@Override
	public void updateNhanVienTuDanhGia(DanhGiaBanThan danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where phongBan = :phongBan").setParameter("phongBan", phongBan).list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVien where phongBan.maPhongBan = ? and chucDanh.maChucDanh = 'NV'").setParameter(1, phongBan).list();
	}

	@Override
	public LichDanhGia getActiveLichDanhGia(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.byNaturalId(LichDanhGia.class).using("phongBan", phongBan).load();
	}

}
