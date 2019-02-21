package fasttrackse.ffse1703.fbms.dao.quanlyduan;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fasttrackse.ffse1703.fbms.entity.quanlyduan.NhiemVuTeam1;

@Repository
public class NhiemVuTeam1DaoImpl implements NhiemVuTeam1Dao {
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void update(NhiemVuTeam1 nhiemVu, NhiemVuTeam1 oldNhiemVu) {

	}

	@Override
	public List<NhiemVuTeam1> getAll(String maDuAn) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVuTeam1 where ma_du_an='" + maDuAn + "'", NhiemVuTeam1.class).list();
	}

	@Override
	public List<NhiemVuTeam1> getById(String maDuAn, int maNhanVien) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from NhiemVuTeam1 where maDuAn ='" + maDuAn + "' and maNhanVien='" + maNhanVien + "'",
				NhiemVuTeam1.class).list();
	}

	@Override
	public NhiemVuTeam1 getDetailNhiemVu(String maDuAn, int maNhanVien, String maVaiTro) {
		return null;
	}

	@Override
	public void delete(NhiemVuTeam1 nhiemvu) {
		Session session = sessionFactory.getCurrentSession();

		session.delete(nhiemvu);

	}

	@Override
	public void save(NhiemVuTeam1 nhiemVu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(nhiemVu);
	}

}
