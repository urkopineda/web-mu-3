package simpleCRUD.domain.users.model;

public class User {

	private int userId;

	private String userNick;

	private String userMail;

	private String userPasswd;

	private String userProfile;

	public User() {

		userNick = null;
		userMail = null;
		userPasswd = null;
		userProfile = null;
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	public String getUserNick() {

		return userNick;
	}

	public void setUserNick(String userNick) {

		this.userNick = userNick;
	}

	public String getUserMail() {

		return userMail;
	}

	public void setUserMail(String userMail) {

		this.userMail = userMail;
	}

	public String getUserProfile() {

		return userProfile;
	}

	public void setUserProfile(String userProfile) {

		this.userProfile = userProfile;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
}
