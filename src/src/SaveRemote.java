package src;

import java.sql.SQLException;


import javax.ejb.Remote;

@Remote
public interface SaveRemote {
	void saveSurvey(Survey student);
	public String check(String id); 
	public void StoreSurvey(String query) throws SQLException;
}