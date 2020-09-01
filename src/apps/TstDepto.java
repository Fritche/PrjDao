package apps;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entidades.Department;

public class TstDepto {

	public static void main(String[] args) {
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();	
		
		List<Department> listall = departmentDao.findAll();
		
		for(Department obj2 : listall) {
			System.out.println(obj2);
		}
		
		System.out.println("Update");
		Department dep = departmentDao.findById(6);
		dep.setName("D3");
		departmentDao.update(dep);
		
		System.out.println("Insert");
		Department depinc = new Department(null, "D2");
		departmentDao.insert(depinc);
		
		System.out.println("Delete");
		departmentDao.deleteById(7);
		

	}

}
