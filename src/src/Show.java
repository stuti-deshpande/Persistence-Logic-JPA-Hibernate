package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;

import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;


@Stateless
@Remote(ShowRemote.class)

public class Show implements ShowRemote {

	 @PersistenceContext(unitName = "sbansal2")
	    private EntityManager entityManager;
	  
	@Override
	public ArrayList<ArrayList<String>> getAllData() throws SQLException {
		ArrayList<ArrayList<String>> allresults = new ArrayList<ArrayList<String>>();
		ArrayList<String> results = new ArrayList<String>();
		DataSource ds = null;
		Connection con = null; 
		PreparedStatement pr = null; 
		InitialContext ic; 
		try {
		ic = new InitialContext();
		ds = (DataSource)ic.lookup( "java:/sbansal2" );
		con = ds.getConnection(); 
		pr = con.prepareStatement("Select * from survey");
		System.out.println(pr.toString());
		ResultSet rst = pr.executeQuery();
		
		while (rst.next()) {
			
			results.add(rst.getString(1));
			results.add(rst.getString(2));
			results.add(rst.getString(3));
			results.add(rst.getString(4));
			results.add(rst.getString(5));
			results.add(rst.getString(6));
			results.add(rst.getString(7));
			results.add(rst.getString(8));
			results.add(rst.getString(9));		
			results.add(rst.getString(10));
			results.add(rst.getString(11));
			results.add(rst.getString(12));
			results.add(rst.getString(13));
			results.add(rst.getString(14));
			results.add(rst.getString(15));
			results.add(rst.getString(16));	
			allresults.add(results);
			results= new ArrayList<String>(); 
		}
		rst.close();
		pr.close();
		}
		catch(Exception ex){
	 
			return allresults;
		}finally{
			if(con != null){
				con.close();
				} 
				}
		return allresults;
	}

	public List<Survey> retrieveProjects(String query) {
		
		if (query.equals("asc")){
        String q = "Select s from "+ Survey.class.getName() + " s ORDER BY s.lastname ASC" ;
        Query query1 = entityManager.createQuery(q);
     
        List<Survey> survey = query1.getResultList();
       
        return survey;
		}
		else{
			 String q = "Select s from "+ Survey.class.getName() + " s where "+query ;
		        Query query1 = entityManager.createQuery(q);
		    List<Survey> survey = query1.getResultList();
		       return survey;
	
		}	
	}	
	public ArrayList<ArrayList<String>> getData1(String query)throws SQLException {
		ArrayList<ArrayList<String>> allresults = new ArrayList<ArrayList<String>>();
		ArrayList<String> results = new ArrayList<String>();
		DataSource ds = null;
		Connection con = null; 
		PreparedStatement ps = null; 
		InitialContext ic; 
		try {
		ic = new InitialContext();
		ds = (DataSource)ic.lookup( "java:/sbansal2" );
		con = ds.getConnection(); 
		ps = con.prepareStatement(query);
		System.out.println(ps.toString());
		ResultSet rst = ps.executeQuery();
		
		while (rst.next()) {
			
			results.add(rst.getString(1));
			results.add(rst.getString(2));
			results.add(rst.getString(3));
			results.add(rst.getString(4));
			results.add(rst.getString(5));
			results.add(rst.getString(6));
			results.add(rst.getString(7));
			results.add(rst.getString(8));
			results.add(rst.getString(9));	
			results.add(rst.getString(10));
			results.add(rst.getString(11));
			results.add(rst.getString(12));
			results.add(rst.getString(13));
			results.add(rst.getString(14));
			results.add(rst.getString(15));
			results.add(rst.getString(16));	
			allresults.add(results);
			results= new ArrayList<String>();
	 
		}
		rst.close();
		ps.close();
		}
		catch(Exception ex){
			 
			return allresults;
		}finally{
			if(con != null){
				con.close();
				} 
				}
		return allresults;
	}
	public ArrayList<ArrayList<String>> getData(String query)
			throws SQLException {
		ArrayList<ArrayList<String>> allresults = new ArrayList<ArrayList<String>>();
		ArrayList<String> results = new ArrayList<String>();
		DataSource ds = null;
		Connection con = null; 
		PreparedStatement ps = null; 
		InitialContext ic; 
		try {
		ic = new InitialContext();
		ds = (DataSource)ic.lookup( "java:/sbansal2" );
		con = ds.getConnection(); 
		ps = con.prepareStatement(query);
		System.out.println(ps.toString());
		ResultSet rst = ps.executeQuery();
		
		while (rst.next()) {
			
			results.add(rst.getString(1));
			results.add(rst.getString(2));
			results.add(rst.getString(3));
			results.add(rst.getString(4));
			results.add(rst.getString(5));
			results.add(rst.getString(6));
			results.add(rst.getString(7));
			results.add(rst.getString(8));
			results.add(rst.getString(9));
			results.add(rst.getString(10));
			results.add(rst.getString(11));
			results.add(rst.getString(12));
			results.add(rst.getString(13));
			results.add(rst.getString(14));
			results.add(rst.getString(15));
			results.add(rst.getString(16));	
			allresults.add(results);
			results= new ArrayList<String>();
		}
		rst.close();
		ps.close();
		}
		catch(Exception ex){
			return allresults;
		}finally{
			if(con != null){
				con.close();
				} 
				}
		return allresults;
	}

	@Override
	public List<Survey> retrieveAllProjects() {   
    	System.out.println(Survey.class.getSimpleName());
        String q = "Select s from "+ Survey.class.getName() + " s";
        Query query = entityManager.createQuery(q);
        List<Survey> projects = query.getResultList();
        return projects;
	}

}
