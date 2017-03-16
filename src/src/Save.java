package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Stateless
@Remote(SaveRemote.class)
public class Save implements SaveRemote {
	@PersistenceContext(unitName = "sbansal2")
    private EntityManager entityManager;
     
 
	@Override
	public void saveSurvey(Survey student) {
        entityManager.persist(student);

	}

	@Override
	public String check(String id) {
		Survey survey=entityManager.find(Survey.class, id);
	
		if(survey!= null){
			return "exists";
		}
		return "notexists";
			
	}
	@Override
	public void StoreSurvey(String query) throws SQLException {
		DataSource ds = null;
		Connection con = null; 
		PreparedStatement ps = null; 
		InitialContext ic; 
		try {
			ic = new InitialContext();
			ds = (DataSource)ic.lookup( "java:/sbansal2" );
			con = ds.getConnection(); 
	
		ps = con.prepareStatement(query);
		ResultSet rst = ps.executeQuery();
	
		rst.close();
		ps.close();
		}catch(Exception e){ 
		}finally{
		if(con != null){
		con.close();
		} 
		}
		
	}

	

 

}
