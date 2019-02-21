package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fasttrackse.ffse1703.fbms.dao.qttl.*;
import fasttrackse.ffse1703.fbms.entity.qttl.*;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDAO categoryDAO;

	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;

	}

	@Override
	@Transactional
	public List<Category> listCategory() {
		return this.categoryDAO.listCategory();
	}

	@Override
	@Transactional
	public Category findById(int id) {
		// TODO Auto-generated method stub
		return this.categoryDAO.findById(id) ;
	}

	@Override
	@Transactional
	public void add(Category category) {
		this.categoryDAO.create(category);
	}

	@Override
	@Transactional
	public void update(Category category) {
		this.categoryDAO.update(category);

	}

	@Override
	@Transactional
	public void delete(int id) {
		this.categoryDAO.delete(id);

	}

	@Override
	@Transactional
	public List<Category> findAllForPaging(int startPosition, int maxResult) {
		return this.categoryDAO.findAllForPaging(startPosition, maxResult);
	}

}