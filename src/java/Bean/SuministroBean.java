package Bean;

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
@ManagedBean(name = "suministroBean", eager = true)
@SessionScoped
public class SuministroBean {

    private static final long serialVersionUID = 1L;

    public List<Suministro> getSuministros() throws ClassNotFoundException, SQLException {

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

		List<Suministro> suministros = new ArrayList<>();
		PreparedStatement pstmt = connect.prepareStatement("select sum_codigo, sum_empresa, sum_ruc from suministro");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			Suministro suministro = new Suministro();
			suministro.setCode(rs.getInt("sum_codigo"));
			suministro.setCompany(rs.getString("sum_empresa"));
			suministro.setRuc(rs.getInt("sum_ruc"));
			suministros.add(suministro);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return suministros;
    }
    
    public static String registrarSuministro(Suministro suministro) {
		int saveResult = 0;
		String navigationResult = "";
                Connection connect = null;

		String url = "jdbc:mysql://localhost:3306/labsweb";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver");

			connect = DriverManager.getConnection(url, username, password);    
			PreparedStatement pstmt = connect.prepareStatement("insert into suministro(sum_empresa, sum_ruc) values(?,?)");
			pstmt.setString(1, suministro.getCompany());
			pstmt.setInt(2, suministro.getRuc());
			saveResult = pstmt.executeUpdate();
			connect.close();
		} catch(Exception sqlException) {
			sqlException.printStackTrace();
		}
		if(saveResult !=0) {
			navigationResult = "ListarSuministro.xhtml?faces-redirect=true";
		} else {
			navigationResult = "ListarSuministro.xhtml?faces-redirect=true";
		}
		return navigationResult;
	}
}
