package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SimpleSelectParametrizado
{
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try
		{
			// 1 - parametros de la conexion
			String url="jdbc:hsqldb:hsql://localhost:9001/xdb";
			String driver="org.hsqldb.jdbcDriver";
			String usr="sa";
			String pwd="";

			// 2 - levanto el driver
			Class.forName(driver);
			
			// 3 - Me conecto!
			con = DriverManager.getConnection(url,usr,pwd);

			// parametro
			int idCat = 1;
			
			// 4 - escribo el query
			String sql="";
			sql+="SELECT id_producto,descripcion ";
			sql+="FROM producto ";
			sql+="WHERE id_categoria=? ";
			
			// 5 - ejecuto el query
			pstm = con.prepareStatement(sql);
			pstm.setInt(1,idCat);
			rs = pstm.executeQuery();
			
			// 6 - recorro el ResultSet y muestro los datos
			while( rs.next() )
			{
				int id = rs.getInt("id_producto");
				String desc = rs.getString("descripcion");
				
				System.out.println(id+", "+desc);
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally
		{
			// 7 - cerrar los recursos (ver el finally)
			try
			{
				if(rs!=null ) rs.close();
				if(pstm!=null ) pstm.close();
				if(con!=null ) con.close();				
			}
			catch(Exception e2)
			{
				e2.printStackTrace();
				throw new RuntimeException(e2);
			}
		}
	}
}
