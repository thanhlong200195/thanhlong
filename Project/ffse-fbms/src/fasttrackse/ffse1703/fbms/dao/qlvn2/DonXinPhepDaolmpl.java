package fasttrackse.ffse1703.fbms.dao.qlvn2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import fasttrackse.ffse1703.fbms.entity.qlvn2.DonXinPhepEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.LyDoEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.SoNgayNghiEntity;
import fasttrackse.ffse1703.fbms.entity.qlvn2.TrangThaiEntity;
import fasttrackse.ffse1703.fbms.entity.security.HoSoNhanVien;

@Repository(value = "DonXinPhepDao")
@Transactional(rollbackFor = Exception.class)
public class DonXinPhepDaolmpl implements DonXinPhepDao{
	@Autowired
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	public List<DonXinPhepEntity> danhsachnhap003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity where trangThai = '1'").getResultList();
		return list;
	}

	public List<DonXinPhepEntity> danhsachchoduyet003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '2'").getResultList();
		return list;
	}

	public List<DonXinPhepEntity> danhsachdaduyet003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '3'").getResultList();
		return list;
	}

	public List<DonXinPhepEntity> danhsachbituchoi003() {
		Session session = sessionFactory.getCurrentSession();
		List<DonXinPhepEntity> list = session.createQuery("from DonXinPhepEntity  where trangThai = '4'").getResultList();
		return list;
	}
	

	public List<LyDoEntity> danhSachLyDo() {
		Session session = sessionFactory.getCurrentSession();
		List<LyDoEntity> list = session.createQuery("from LyDoEntity").list();
		return list;
	}

	public List<TrangThaiEntity> danhSachTrangThai() {
		Session session = sessionFactory.getCurrentSession();
		List<TrangThaiEntity> list = session.createQuery("from TrangThaiEntity").list();
		return list;
	}
	
	public List<HoSoNhanVien> danhSachHoSo() {
		Session session = sessionFactory.getCurrentSession();
		List<HoSoNhanVien> list = session.createQuery("from HoSoNhanVien").list();
		return list;
	}


	public DonXinPhepEntity findById(int id) {
	Session session = this.sessionFactory.getCurrentSession();
		DonXinPhepEntity list = (DonXinPhepEntity) session.get(DonXinPhepEntity.class, id);
		return list;
	}
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(findById(id));
		
	}
	public void create(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(DonXinPhepEntity) == 0) {
			session.createSQLQuery("INSERT INTO `so_ngay_nghi`(`ma_nhan_vien`,`so_ngay_nghi`,`so_ngay_nghi_con_lai`) VALUES ('" + 
					DonXinPhepEntity.getNgayNghi().getMaNhanVien()+"', '0', '12')").executeUpdate();			
		}
		session.save(DonXinPhepEntity);
		session.createQuery("update DonXinPhepEntity set trangThai = '1'  where id =" + DonXinPhepEntity.getId()).executeUpdate();
	}

	public void createcho(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(DonXinPhepEntity) == 0) {
			session.createSQLQuery("INSERT INTO `so_ngay_nghi`(`ma_nhan_vien`,`so_ngay_nghi`,`so_ngay_nghi_con_lai`) VALUES ('" + 
					DonXinPhepEntity.getNgayNghi().getMaNhanVien()+"', '0', '12')").executeUpdate();			
		}
		session.save(DonXinPhepEntity);
		session.createQuery("update DonXinPhepEntity set trangThai = '2'  where id =" + DonXinPhepEntity.getId()).executeUpdate();
	}

	public void createduyet(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		int soNgayNghi = DonXinPhepEntity.getSoNgayNghi();
		int soNgayDaNghi = DonXinPhepEntity.getNgayNghi().getSoNgayNghi();
		int soNgayConLai = DonXinPhepEntity.getNgayNghi().getNgayNghiConLai();
        int maNhanVien = DonXinPhepEntity.getNgayNghi().getMaNhanVien();
        if (soNgayConLai == 0) {
			session.createQuery("update SoNgayNghiEntity set soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi)
					+ "where maNhanVien = " + maNhanVien).executeUpdate();
		} else if (soNgayNghi > soNgayConLai) {
			session.createQuery("update SoNgayNghiEntity set soNgayConLai = 0,soNgayDaNghi = "
					+ (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien).executeUpdate();
		} else {
			session.createQuery("update SoNgayNghiEntity set soNgayConLai = " + (soNgayConLai - soNgayNghi)
					+ ",soNgayDaNghi = " + (soNgayDaNghi + soNgayNghi) + "where maNhanVien = " + maNhanVien)
					.executeUpdate();
		}
		session.save(DonXinPhepEntity);
		session.createQuery("update DonXinPhepEntity set trangThai = '3'  where id =" + DonXinPhepEntity.getId()).executeUpdate();
	}

	public void createtuchoi(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();
		if (KiemTraNgayNghi(DonXinPhepEntity) == 0) {
			session.createSQLQuery("INSERT INTO `so_ngay_nghi`(`ma_nhan_vien`,`so_ngay_nghi`,`so_ngay_nghi_con_lai`) VALUES ('" + 
					DonXinPhepEntity.getNgayNghi().getMaNhanVien()+"', '0', '12')").executeUpdate();			
		}
		session.save(DonXinPhepEntity);
		session.createQuery("update DonXinPhepEntity set trangThai = '4'  where id =" + DonXinPhepEntity.getId()).executeUpdate();
	}
	
	public void Updatecho(DonXinPhepEntity DonXinPhepEntity) {
		Session session = this.sessionFactory.getCurrentSession();;
		session.update(DonXinPhepEntity);
		
	}
	
	public List<DonXinPhepEntity> findAllForPaging1(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai ='1' ").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	
	public List<DonXinPhepEntity> findAllForPaging2(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai ='2' ").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	public List<DonXinPhepEntity> findAllForPaging3(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai ='3' ").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	public List<DonXinPhepEntity> findAllForPaging4(int startPosition, int maxResult) {
		Session session = this.sessionFactory.getCurrentSession();
		return session.createQuery("from DonXinPhepEntity where trangThai ='3' ").setFirstResult(startPosition).setMaxResults(maxResult).list();
	}
	
   public int KiemTraNgayNghi(DonXinPhepEntity DonXinPhepEntity) {
		Session session = sessionFactory.getCurrentSession();
		String rowCount = session.createSQLQuery("select count(*) from `so_ngay_nghi` where `ma_nhan_vien` = '" + DonXinPhepEntity.getNgayNghi().getMaNhanVien() + "'").getSingleResult().toString();
		return Integer.parseInt(rowCount);
 }

public List<SoNgayNghiEntity> bangNgayNghi() {
	Session session = sessionFactory.getCurrentSession();
	List<SoNgayNghiEntity> list = session.createQuery("from SoNgayNghiEntity").getResultList();
	return list;
}
public SoNgayNghiEntity findByIdngay(int maNhanVien) {
	Session session = this.sessionFactory.getCurrentSession();
	SoNgayNghiEntity list = (SoNgayNghiEntity) session.get(SoNgayNghiEntity.class, maNhanVien);
	return list;
}

public void deletengay(int maNhanVien) {
	Session session = this.sessionFactory.getCurrentSession();
	session.delete(findById(maNhanVien));	
}

public List<DonXinPhepEntity> findAllForPagingngaynghi(int startPosition, int maxResult) {
	Session session = this.sessionFactory.getCurrentSession();
	return session.createQuery("from SoNgayNghiEntity  ").setFirstResult(startPosition).setMaxResults(maxResult).list();
}

}


