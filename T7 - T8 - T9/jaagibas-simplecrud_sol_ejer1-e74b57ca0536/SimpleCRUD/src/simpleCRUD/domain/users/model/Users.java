package  simpleCRUD.domain.users.model;

//
public class Users {

	User[] users;

	int length;

	public User[] getUsers() {

		return users;
	}

	public void setUsers(User[] users) {

		this.users = users;
	}

	public int getLength() {

		return length;
	}

	public void setLength(int length) {

		this.length = length;
	}

	public User getUser(int pos) {

		User ret = null;

		if (pos < length) {

			ret = users[pos];
		}

		return ret;
	}
}
