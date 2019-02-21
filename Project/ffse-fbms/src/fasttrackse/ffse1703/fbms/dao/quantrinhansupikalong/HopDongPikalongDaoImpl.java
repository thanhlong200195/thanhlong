package fasttrackse.ffse1703.fbms.dao.quantrinhansupikalong;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.BangCapPikalong;
import fasttrackse.ffse1703.fbms.entity.quantrinhansupikalong.HopDongPikalong;

@Repository
public class HopDongPikalongDaoImpl implements HopDongPikalongDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HopDongPikalong> listHopDong() {
		Session session = this.sessionFactory.getCurrentSession();
		List<HopDongPikalong> listHopDong = session.createQuery("from HopDongPikalong").list();
		return listHopDong;
	}
	
	@Override
	public void insert(HopDongPikalong hd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(hd);
	}
	
	@Override
	public void update(HopDongPikalong hd) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(hd);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getAutoId() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"SELECT `AUTO_INCREMENT` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'ffse1703' AND TABLE_NAME = 'thongtinhopdong'");
		String index = query.getSingleResult().toString();
		return index;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getLastMaHd() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery(
				"SELECT `MaHopDong` FROM `thongtinhopdong` ORDER BY `MaHopDong` DESC LIMIT 1");
		String lastMaHd;
		if(query.list().size() == 0) {
			lastMaHd = "1";
		} else {
			lastMaHd = query.getSingleResult().toString();
		}
		return lastMaHd;
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public String getLastTrangThaiHd(String maNv) {
		Session session = this.sessionFactory.getCurrentSession();
		
		Query query = session.createSQLQuery(
				"SELECT `TrangThai` FROM `thongtinhopdong` WHERE MaNv = " + maNv + " ORDER BY `MaHopDong` DESC LIMIT 1");
		String lastTrangThaiHd;
		if(query.list().size() == 0) {
			lastTrangThaiHd = "1";
		} else {
			lastTrangThaiHd = query.getSingleResult().toString();
		}
		return lastTrangThaiHd;
	}
	
	@Override
	public HopDongPikalong getMaHopDong(int maHopDong) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.get(HopDongPikalong.class, maHopDong);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public HopDongPikalong getHopDongById(String maNv) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from HopDongPikalong where maNv = " + maNv + "");
		HopDongPikalong lastIdHopDong = (HopDongPikalong) query.getSingleResult();
		return lastIdHopDong;
	}
	
	@Override
	public List<HopDongPikalong> viewOne(String maNv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createSQLQuery("SELECT * FROM `thongtinhopdong` WHERE MaNv = " + maNv + " ORDER BY `MaHopDong` DESC LIMIT 1");
		@SuppressWarnings("unchecked")
		List<HopDongPikalong> viewOne = query.list();
		return viewOne;
	}

}
