package apps;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entidades.Department;
import model.entidades.Seller;

public class TstClass {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		Seller seller = new Seller(21, "Ze", "email@email.com", new Date(), 3000.00, obj);
		System.out.println(obj);
		System.out.println(seller);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();		
		Seller seller2 = sellerDao.findById(3);
		System.out.println(seller2);	
		
		System.out.println("================");
		
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
				
		for(Seller obj2 : list) {
			System.out.println(obj2);
		}
		
		System.out.println("================");
		
		//Department dep = new Department(2, null);
		List<Seller> listall = sellerDao.findAll();
				
		for(Seller obj2 : listall) {
			System.out.println(obj2);
		}

		System.out.println("================ Insert ");
		Seller newSeller = new Seller(null, "greg", "email@email.com", new Date(), 60000.00, department);
		sellerDao.insert(newSeller);
		System.out.println("id " + newSeller.getId());

		

	}

}
