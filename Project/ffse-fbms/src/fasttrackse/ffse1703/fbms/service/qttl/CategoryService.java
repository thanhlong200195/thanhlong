package fasttrackse.ffse1703.fbms.service.qttl;

import java.util.List;

import fasttrackse.ffse1703.fbms.entity.qttl.*;

public interface  CategoryService {
	
	public List<Category> listCategory();
	
	public Category findById(int id);
	
	public void add(Category category);
	
	public void update(Category category);
	
	public void delete(int id);
	
	public List<Category> findAllForPaging(int startPosition,int maxResult);
}