package fasttrackse.ffse1703.fbms.service.quanlynhansutt;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fasttrackse.ffse1703.fbms.dao.quanlynhansutt.ProjectDAOTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.HoSoNhanVienTT;
import fasttrackse.ffse1703.fbms.entity.quanlynhansutt.ProjectsTT;

@Service
@Transactional
public class ProjectServiceTTImpl implements ProjectServiceTT {
	@Autowired
	private ProjectDAOTT projectDAO;

	@Override
	public List<ProjectsTT> findAll() {
		// TODO Auto-generated method stub
		return projectDAO.findAll();
	}

	@Override
	public ProjectsTT findById(String id) {
		// TODO Auto-generated method stub
		return projectDAO.findById(id);
	}

	@Override
	public void addNew(ProjectsTT projects) {
		// TODO Auto-generated method stub
		projectDAO.addNew(projects);
	}

	@Override
	public void update(ProjectsTT projects) {
		// TODO Auto-generated method stub
		projectDAO.update(projects);
	}

	@Override
	public void delete(ProjectsTT projects) {
		// TODO Auto-generated method stub
		projectDAO.delete(projects);
	}

	@Override
	public int checkNameProjects(String nameProjects) {
		// TODO Auto-generated method stub
		return projectDAO.checkNameProjects(nameProjects);
	}

	@Override
	public int checkMaProjects(String idProjects) {
		// TODO Auto-generated method stub
		return projectDAO.checkMaProjects(idProjects);
	}

	@Override
	public List<HoSoNhanVienTT> getPm(String maPhongBan) {
		// TODO Auto-generated method stub
		return projectDAO.getPm(maPhongBan);
	}

}
