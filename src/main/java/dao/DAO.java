package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Account;
import entity.Cart;
import entity.CartItem;
import entity.Category;
import entity.Comment;
import entity.Product;
import entity.Rating;

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
//	public List<Product> getAllProduct() {
//	    List<Product> list = new ArrayList<>();
//	    String query = "SELECT p.id, p.name, p.image, p.price, p.title, p.description, "
//	                 + "(SELECT AVG(r.rating) FROM Rating r WHERE r.product_id = p.id) AS avgRating "
//	                 + "FROM product p";
//	    try {
//	        conn = new DBContext().getConnection();
//	        ps = conn.prepareStatement(query);
//	        rs = ps.executeQuery();
//
//	        while (rs.next()) {
//	            Product product = new Product();
//	            product.setId(rs.getInt("id"));
//	            product.setName(rs.getString("name"));
//	            product.setImage(rs.getString("image"));
//	            product.setPrice(rs.getDouble("price"));
//	            product.setTitle(rs.getString("title"));
//	            product.setDescription(rs.getString("description"));
//	            product.setAvgRating(rs.getDouble("avgRating")); // Giả sử bạn đã thêm getter và setter cho avgRating trong Product
//
//	            list.add(product);
//	        }
//	    } catch (Exception e) {
//	        e.printStackTrace();
//	    }
//	    return list;
//	}


	public List<Product> getProductsByPage(int page, int pageSize) {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM product LIMIT ? OFFSET ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
                        rs.getString(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getTotalProductCount() {
        String query = "SELECT COUNT(*) FROM product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
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
		String query = "select * from product where cateID = ? order by name asc";

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

	// Rating and Comment DAO
    public List<Rating> getRatingsByProductId(int productId) {
        List<Rating> list = new ArrayList<>();
        String query = "SELECT * FROM Rating WHERE productId = ?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Rating(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Comment> getCommentsByProductId(int productId) {
        List<Comment> list = new ArrayList<>();
        String query = "SELECT * FROM Comment WHERE productId = ? ORDER BY createdDate DESC";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Comment(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getTimestamp(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void addRating(int productId, int userId, int rating) {
        String query = "INSERT INTO Rating(productId, userId, rating) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE rating=?";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.setInt(3, rating);
            ps.setInt(4, rating); // Cập nhật nếu đã tồn tại
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addComment(int productId, int userId, String comment) {
        String query = "INSERT INTO Comment(productId, userId, comment) VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection(); 
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.setString(3, comment);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public double getAverageRating(int productId) {
        double avgRating = 0;
        String query = "SELECT AVG(rating) FROM Rating WHERE productId = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            if (rs.next()) {
                avgRating = rs.getDouble(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return avgRating;
    }

    public int getCouponIdByName(String couponName) {
        String query = "SELECT couponID FROM Coupon WHERE code = ?";
        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query);
            ps.setString(1, couponName);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("couponID"); // Trả về couponID nếu tìm thấy
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Trả về -1 nếu không tìm thấy coupon
    }
    
    public int saveOrder(int userID, String name, String phone, int couponID, double totalAmount) {
        String query = "INSERT INTO Orders (userID, name, phone, couponID, totalAmount) VALUES (?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection(); // Mở kết nối đến cơ sở dữ liệu
            ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);         // Thiết lập giá trị cho trường userID
            ps.setString(2, name);        // Thiết lập giá trị cho trường name
            ps.setString(3, phone);       // Thiết lập giá trị cho trường phone
            ps.setInt(4, couponID);       // Thiết lập giá trị cho trường couponID
            ps.setDouble(5, totalAmount);       // Thiết lập giá trị cho trường totalAmount
            ps.executeUpdate();

            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1); // Trả về khóa chính của đơn hàng mới
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Trả về -1 nếu không thành công
    }


//    public void saveOrderDetails(int orderId, int productId, int quantity, double totalPrice) {
//        String query = "INSERT INTO OrderDetails (orderID, productID, quantity, price) VALUES (?, ?, ?, ?)";
//        try {
//            conn = new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setInt(1, orderId);
//            ps.setInt(2, productId);
//            ps.setInt(3, quantity);
//            ps.setDouble(4, totalPrice);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    public void saveOrderDetails(int orderID, Cart cart) {
        String query = "INSERT INTO OrderDetails (orderID, productID, quantity, price) VALUES (?, ?, ?, ?)";
        try (Connection conn = new DBContext().getConnection(); 
             PreparedStatement ps = conn.prepareStatement(query)) {
            for (CartItem item : cart.getItems()) {
                ps.setInt(1, orderID);
                ps.setInt(2, item.getProduct().getId());
                ps.setInt(3, item.getQuantity());
                ps.setDouble(4, item.getProduct().getPrice());
                ps.addBatch();
            }
            ps.executeBatch(); // Thực hiện tất cả các câu lệnh chèn
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
