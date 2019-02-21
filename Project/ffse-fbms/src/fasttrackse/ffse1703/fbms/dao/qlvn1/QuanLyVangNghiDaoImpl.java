package fasttrackse.ffse1703.fbms.dao.qlvn1;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.qlvn1.DonNghi;
import fasttrackse.ffse1703.fbms.entity.qlvn1.LyDo;
import fasttrackse.ffse1703.fbms.entity.qlvn1.TinhTrangNghi;
import fasttrackse.ffse1703.fbms.entity.security.UserAccount;

@Repository
public class QuanLyVangNghiDaoImpl implements QuanLyVangNghiDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(dn);
	}


	@Override
	public UserAccount getThongTinUser(String username) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		UserAccount user = session.createQuery("from UserAccount where username='" + username + "'", UserAccount.class)
				.getSingleResult();
		session.close();
		return user;
	}

	@Override
	public TinhTrangNghi getTinhTrang(int id_nv) {
		// TODO Auto-generated method stub
		TinhTrangNghi tinhTrang = null;
		Session session = null;
		try {
			session = this.sessionFactory.openSession();
			tinhTrang = session.createQuery("from TinhTrangNghi where id_nv=" + id_nv + "", TinhTrangNghi.class).getSingleResult();
		}catch (Exception e) {
			tinhTrang= null;
		}
		
		session.close();
		return tinhTrang;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LyDo> listLyDo() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		List<LyDo> list = session.createQuery("from LyDo").list();
		session.close();
		return list;
	}

	@Override
	public List<DonNghi> listDonNghiNhap(int id_nv) {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and tinh_trang = "+0+" ").list();
		session.close();
		return listDn;
	}

	@Override
	public void insertTinhTrang(int id_nv, TinhTrangNghi tt) {
		// TODO Auto-generated method stub
		TinhTrangNghi tinhTrang = new TinhTrangNghi();
		Session session = null;
		tinhTrang = getTinhTrang(id_nv);
		session = this.sessionFactory.getCurrentSession();
		if(tinhTrang==null) {
			session.persist(tt);
		}else {
			session.update(tt);
		}
	}
	
	public void updateTinhTrang(TinhTrangNghi tt) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(tt);
	}


	@Override
	public List<DonNghi> listDonNghiChoDuyet(int id_nv) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where id_nv ='"+id_nv+"' and ( tinh_trang = "+1+" or tinh_trang = "+2+")").list();
		session.close();
		return listDn;
	}

	@Override
	public DonNghi getDonNghiNv(int id_don) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.openSession();
		DonNghi donNghi = new DonNghi();
		donNghi = session.createQuery("from DonNghi where id_don=" + id_don + "", DonNghi.class).getSingleResult();
		return donNghi;
	}

	@Override
	public void updateDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(dn);
	}

	@Override
	public void deleteDon(DonNghi dn) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(dn);
	}

	@Override
	public void removeDonNhap(int id_don) {
		Session session = this.sessionFactory.getCurrentSession();
		DonNghi donNghi = (DonNghi) session.load(DonNghi.class, new Integer(id_don));
		if(null != donNghi){
			session.delete(donNghi);
		}
	}

	@Override
	public List<DonNghi> listDonNghiPheDuyet1() {
		Session session = this.sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<DonNghi> listDn = session.createQuery("from DonNghi where tinh_trang = "+1+" ").list();
		session.close();
		return listDn;
	}

	
	
	
}
