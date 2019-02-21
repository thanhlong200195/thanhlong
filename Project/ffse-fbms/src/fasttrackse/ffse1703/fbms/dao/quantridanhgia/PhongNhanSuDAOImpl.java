package fasttrackse.ffse1703.fbms.dao.quantridanhgia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaBanThan;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.DanhGiaNhanVien;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.KyDanhGia;
import fasttrackse.ffse1703.fbms.entity.quantridanhgia.LichDanhGia;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository
public class PhongNhanSuDAOImpl implements PhongNhanSuDAO {

	@Autowired
	public SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// CRUD kỳ đánh giá
	@SuppressWarnings("unchecked")
	@Override
	public List<KyDanhGia> getListKyDanhGia() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from KyDanhGia").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<KyDanhGia> getListKyDanhGia(int start, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from KyDanhGia").setFirstResult(start).setMaxResults(maxItems).list();
	}

	@Override
	public void insertKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(kyDanhGia);
	}

	@Override
	public void updateKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	@Override
	public KyDanhGia getKyDanhGia(int maKy) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(KyDanhGia.class, maKy);
	}

	@Override
	public void deleteKyDanhGia(KyDanhGia kyDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(kyDanhGia);
	}

	// Get nhân viên phong ban
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVien> getNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVien where phongBan.maPhongBan = :phongBan and chucDanh.maChucDanh = 'NV'").setParameter("phongBan", phongBan).list();
	}

	// Tạo phân công đánh giá
	
	@Override
	public void createPhanCongDanhGia(List<DanhGiaNhanVien> phanCong) {
		Session session = sessionFactory.getCurrentSession();
		for (DanhGiaNhanVien x : phanCong) {
			session.persist(x);
		}
	}

	// CRUD lịch đánh giá
	@Override
	@SuppressWarnings("unchecked")
	public List<LichDanhGia> getListLichDanhGia(int start, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia").setFirstResult(start).setMaxResults(maxItems).list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<LichDanhGia> getListLichDanhGia() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia").list();
	}

	@Override
	public void insertLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(lichDanhGia);
	}

	@Override
	public LichDanhGia getLichDanhGia(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(LichDanhGia.class, id);
	}

	// Active lịch đánh giá
	@Override
	public void activeLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		session.update(lichDanhGia);
	}

	// Check lịch đánh giá
	@Override
	public int checkLichDanhGia(LichDanhGia lichDanhGia) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia where kyDanhGia = :kyDG and phongBan = :phongBan")
				.setParameter("kyDG", lichDanhGia.getKyDanhGia()).setParameter("phongBan", lichDanhGia.getPhongBan())
				.list().size();
	}

	// Get list đánh giá bản thân của toàn công ty
	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan(int start, int maxItems) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan").setFirstResult(start).setMaxResults(maxItems).list();
	}

	@Override
	public int checkActiveLichDanhGia(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from LichDanhGia where phongBan = :phongBan and isActive = 1").setParameter("phongBan", phongBan).list().size();
	}

	@Override
	public int checkCompleteLichDanhGia(String phongBan) {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DanhGiaBanThan> getListDanhGiaBanThan() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan").list();
	}

	@Override
	public int countNhanVienPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from HoSoNhanVien").list().size();
	}

	@Override
	public int countDanhGiaPhongBan(String phongBan) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from DanhGiaBanThan where trangThai = 3").list().size();
	}

	@Override
	public void createDanhGiaBanThan(List<DanhGiaBanThan> danhGia) {
		Session session = sessionFactory.getCurrentSession();
		for (DanhGiaBanThan x : danhGia) {
			session.persist(x);
		}
	}
}
