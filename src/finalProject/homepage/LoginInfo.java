package finalProject.homepage;

public class LoginInfo implements Comparable {
private String username;
private String password;
public LoginInfo(String username, String password) {
	this.username = username;
	this.password = password;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	if(this.username.compareTo(((LoginInfo) o).getUsername())==-1) {
		return -1;
	}
	if(this.username.compareTo(((LoginInfo) o).getUsername())==1) {
		return 1;
	}
	if(this.username.compareTo(((LoginInfo) o).getUsername())==0) {
		if(this.password.compareTo(((LoginInfo) o).getPassword())==-1) {
			return -1;
		}
		if(this.password.compareTo(((LoginInfo) o).getPassword())==1) {
			return 1;
		}
	}
	return 0;
	
}

}
