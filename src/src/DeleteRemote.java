package src;

import javax.ejb.Remote;

@Remote
public interface DeleteRemote {
	public void delete(String del);

}
