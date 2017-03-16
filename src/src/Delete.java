/*Allows a user to delete the corresponding record not only from the database but also from the search result page*/
package src;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class Delete implements DeleteRemote {
	@PersistenceContext(unitName = "sbansal2")
    private EntityManager entityManager;
    
    public Delete() {
      
    }

	@Override
	public void delete(String del) {
		Survey survey = entityManager.find(Survey.class, del);
		entityManager.remove(survey);
	
		
		
	}

}
