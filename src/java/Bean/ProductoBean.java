package Bean;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mario
 */
@ManagedBean(name = "productoBean", eager = true)
@SessionScoped
public class ProductoBean implements Serializable{
    
    private static final long serialVersionUID = 1L;

    public List<Producto> getProductos() throws ClassNotFoundException, SQLException {

		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/labsweb";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Conexión establecida"+connect);

		} 
                
                catch (SQLException ex) {
			System.out.println("en ejecución");
			System.out.println(ex.getMessage());
		}

		List<Producto> productos = new ArrayList<>();
		PreparedStatement pstmt = connect.prepareStatement("select pro_codigo, pro_nombre, pro_precio, pro_stock, alm_codigo, sum_codigo from producto");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Producto producto = new Producto();
			producto.setCode(rs.getInt("pro_codigo"));
			producto.setName(rs.getString("pro_nombre"));
			producto.setPrice(rs.getDouble("pro_precio"));
			producto.setStock(rs.getInt("pro_stock"));
			producto.setWarehouse(rs.getInt("alm_codigo"));
                        producto.setSupply(rs.getInt("sum_codigo"));
			productos.add(producto);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return productos;

	}
    
    public static String registrarProducto(Producto producto) {
		int saveResult = 0;
		String navigationResult = "";
                Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/labsweb";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);    
			PreparedStatement pstmt = connect.prepareStatement("insert into producto(pro_nombre, pro_precio, pro_stock, alm_codigo, sum_codigo) values(?,?,?,?,?)");
			pstmt.setString(1, producto.getName());
			pstmt.setDouble(2, producto.getPrice());
			pstmt.setInt(3, producto.getStock());
			pstmt.setInt(4, producto.getWarehouse());
                        pstmt.setInt(5, producto.getSupply());
			saveResult = pstmt.executeUpdate();
			connect.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "ListarProducto.xhtml?faces-redirect=true";
		} else {
			navigationResult = "ListarProducto.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}

}
