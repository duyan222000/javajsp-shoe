package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Category;
import entity.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getAllProduct() {
		List<Product> list = new ArrayList<>();
		String query = "select * from product";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList<>();
		String query = "select * from Category";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Product getLast() {
		String query = "SELECT * FROM product ORDER BY id DESC LIMIT 1;";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public List<Product> getProductByCID(String cid) {
		List<Product> list = new ArrayList<>();
//    	String query = "select * from product where cateID = "+cid;  WORK OK
		String query = "select * from product where cateID = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, cid);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Product getProductByID(String id) {
//    	String query = "select * from product where cateID = "+cid;  WORK OK
		String query = "select * from product where id = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public Product getProductByID(int id) {
//    	String query = "select * from product where cateID = "+cid;  WORK OK
		String query = "select * from product where id = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public List<Product> searchByName(String txtSearch) {
		List<Product> list = new ArrayList<>();

		String query = "select * from product where name like ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, "%" + txtSearch + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	// Return account if login successfully
	public Account login(String user, String pass) {
		String query = "select * from account\n" + "where user = ?\n" + "and pass = ?";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public Account checkAccountExist(String user) {
		// If exist user -> This function will return an object.

		String query = "select * from Account where user = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
		} catch (Exception e) {
		}
		return null;
	}

	public void signup(String user, String pass) {
		String query = "insert into Account (user, pass, isSell, isAdmin) values (?,?,0,0)";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, user);
			ps.setString(2, pass);
			ps.executeUpdate();
			rs = ps.executeQuery(); // Query not return Result table => Non-usable

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Product> getProductBySellID(int id) {
		List<Product> list = new ArrayList<>();
//    	String query = "select * from product where cateID = "+cid;  WORK OK
		String query = "select * from product where sell_ID = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void deleteProduct(String pid) {
		String query = "delete from product where id = ?";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, pid);
			ps.executeUpdate(); // No return Result table
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void insertProduct(String name, String image, String price, String title, String description, String category, int sid) {
		String query = "insert into product (name, image, price, title, description, cateID, sell_ID) value \n"
				+ "(?,?,?,?,?,?,?);";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price );
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setInt(7, sid); 
			ps.executeUpdate(); // No return Result table
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void editProduct(String name, String image, String price, String title, String description, String category, String pid) {
		String query = "update product set name = ?, image = ?, price=?,title=?,description=?, cateID=? where id =?";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setString(2, image);
			ps.setString(3, price );
			ps.setString(4, title);
			ps.setString(5, description);
			ps.setString(6, category);
			ps.setString(7, pid); 
			ps.executeUpdate(); // No return Result table
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public List<Account> getAllAccount() {
		List<Account> list = new ArrayList<>();
		String query = "select * from account";
		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public Account getAccountByID(String id) {
//    	String query = "select * from product where cateID = "+cid;  WORK OK
		String query = "select * from Account where uID = ?";

		try {
			conn = new DBContext().getConnection(); // Open connection to SQL
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public void addAccount(String user, String pass, int isSell, int isAdmin) {
        String query = "INSERT INTO account (user, pass, isSell, isAdmin) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isSell);
            ps.setInt(4, isAdmin);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	

	
    public void updateAccount(String user, String pass, int isSell, int isAdmin, String id) {
        String query = "UPDATE account SET user = ?, pass = ?, isSell = ?, isAdmin = ? WHERE uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setInt(3, isSell);
            ps.setInt(4, isAdmin);
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

    public void deleteAccount(String id) {
        String query = "DELETE FROM account WHERE uID = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	
	
	public static void main(String[] args) {
		DAO dao = new DAO();
		
		dao.deleteAccount("20");
//		List<Product> list = dao.searchByName("2");
//		List<Category> listC = dao.getAllCategory();
//		Product check = new Product();
//		
//		for(Product o : list) {
//			System.out.println(o);
//		}
//		for(Category o : listC) {
//			System.out.println(o);
//		}
//		System.out.println(check);
//		list = dao.getProductByCID("3");
//		for (Product o : list) {
//			System.out.println(o);
//		}
//		check = dao.getProductByID(3);
//		System.out.println(check);
		

//		List<Account> ls = new ArrayList<Account>();
//		ls = dao.getAllAccount();
//		for(Account a:ls) {
//			System.out.println(a);
//		}
//		DAO dao = new DAO();
//		Account acc = dao.login("admin", "123");
//		dao.signup("test02", "123");
//		DAO dao = new DAO();
//		dao.insertProduct("_product1", "https://letsenhance.io/static/8f5e523ee6b2479e26ecc91b9c25261e/1015f/MainAfter.jpg" , "1300", "ok", "okD", "2", 1);
	}
}
