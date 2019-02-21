package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.TruongPhongDanhGia;

@Repository
public class NhanVienDAOImpl implements NhanVienDAO {

	@Autowired
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public DanhGiaBanThan getDanhGiaBanThan(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.byNaturalId(DanhGiaBanThan.class).using("nhanVien", maNhanVien).load();
	}

	@Override
	public void insertDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhgia);
	}

	@Override
	public void updateDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhgia);
	}

	@Override
	public void deleteDanhGiaBanThan(DanhGiaBanThan danhgia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhgia);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getListPhanCongDanhGia(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaNhanVien where nhanVienDanhGia = :nhanVien")
				.setParameter("nhanVien", maNhanVien).list();
	}

	@Override
	public void insertDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(danhGia);
	}

	@Override
	public DanhGiaNhanVien getDanhGiaNhanVien(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

	@Override
	public void updateDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@Override
	public void deleteDanhGiaNhanVien(DanhGiaNhanVien danhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhGia);
	}

	@Override
	public TruongPhongDanhGia getDanhGiaCuaTruongPhong(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.byNaturalId(TruongPhongDanhGia.class).using("nhanVien", maNhanVien).load();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaNhanVien> getListNhanVienDanhGia(int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaNhanVien where nhanVien = :nhanVien").setParameter("nhanVien", maNhanVien).list();
	}

	@Override
	public DanhGiaNhanVien getNhanVienDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(DanhGiaNhanVien.class, id);
	}

}
