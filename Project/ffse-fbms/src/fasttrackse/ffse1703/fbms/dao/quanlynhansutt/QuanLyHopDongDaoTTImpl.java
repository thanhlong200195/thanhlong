package fasttrackse.ffse1703.fbms.dao.quanlynhansutt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HopDongTT;

@Repository
public class QuanLyHopDongDaoTTImpl implements QuanLyHopDongDaoTT {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@SuppressWarnings("unchecked")
	public List<HopDongTT> getAllHopDong() {
		Session session = sessionFactory.getCurrentSession();
		List<HopDongTT> listHopDong = session.createQuery("from HopDongTT where isdelete = 1").getResultList();
		return listHopDong;
	}

	@Override
	public void addHopDong(HopDongTT tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(tt);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HoSoNhanVienTT> getAllNhanVien() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVienTT> listHopDong = session.createQuery("from HoSoNhanVienTT").getResultList();
		return listHopDong;
	}


	@Override
	public void updateHopDong(HopDongTT tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);
	}
	
	@Override
	public void removeHopDong(HopDongTT tt) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HopDongTT> getAllHopDong(int iDisplayStart, int iDisplayLength, String sql) {
		Session session = this.sessionFactory.getCurrentSession();
		List<HopDongTT> listHopDongTT = session.createQuery(sql).setFirstResult(iDisplayStart)
				.setMaxResults(iDisplayLength).list();
		return listHopDongTT;
	}

	@Override
	public String getRecordsTotal(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecordsFiltered(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAutoId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HopDongTT> getHopDongByPhongBan(String maPhongBan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HopDongTT findByMaHopDong(int maHopDong) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HopDongTT.class, maHopDong);
		
	}

	@Override
	public HoSoNhanVienTT findByMaNhanVien(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HoSoNhanVienTT.class, maNhanVien);
	}

	@Override
	public List<HopDongTT> viewOne(int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery("from HopDongTT where ma_nhan_vien = "+maNhanVien+" and trang_thai = 1 and isdelete = 1");
		@SuppressWarnings("unchecked")
		List<HopDongTT> viewOne = query.list();
		return viewOne;
	}

	@Override
	public int checkloaiHopDong( String loaiHopDong, int maNhanVien) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		List<HopDongTT> dm = session.createQuery(
				"from HopDongTT where ma_loai_hop_dong = '" + loaiHopDong + "' and ma_nhan_vien = '" + maNhanVien + "'",
				HopDongTT.class).list();
		return dm.size();
	}


}
