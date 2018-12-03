package Bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Mario
 */
@ManagedBean(name = "almacenBean", eager = true)
@SessionScoped
public class AlmacenBean implements Serializable{

    private static final long serialVersionUID = 1L;

    public List<Almacen> getAlmacenes() throws ClassNotFoundException, SQLException {

		Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/labsweb";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);
			// System.out.println("Conexión establecida"+connect);

		} catch (SQLException ex) {
			System.out.println("en ejecución");
			System.out.println(ex.getMessage());
		}

		List<Almacen> almacenes = new ArrayList<>();
		PreparedStatement pstmt = connect.prepareStatement("select alm_codigo, alm_distrito, alm_responsable from almacen");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Almacen almacen = new Almacen();
			almacen.setCode(rs.getInt("alm_codigo"));
			almacen.setDistrict(rs.getString("alm_distrito"));
			almacen.setResponsible(rs.getString("alm_responsable"));
			almacenes.add(almacen);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return almacenes;
    }
    
    public static String registrarAlmacen(Almacen almacen) {
		int saveResult = 0;
		String navigationResult = "";
                Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/labsweb";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);    
			PreparedStatement pstmt = connect.prepareStatement("insert into almacen(alm_distrito, alm_responsable) values(?,?)");
			pstmt.setString(1, almacen.getDistrict());
			pstmt.setString(2, almacen.getResponsible());
			saveResult = pstmt.executeUpdate();
			connect.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "ListarAlmacen.xhtml?faces-redirect=true";
		} else {
			navigationResult = "ListarAlmacen.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}
    
}
