import java.io.Serializable;

public class User implements Serializable {
	
	private String name;
	private String ID;
	
	public User(String n, String id) {
		name = n;
		ID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String na) {
		name = na;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
	
	public String toString() {
		String s = "Name: " + name + "\nID: " + ID;
		return s;
	}
	

}
