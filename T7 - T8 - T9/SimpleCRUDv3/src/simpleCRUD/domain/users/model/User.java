package simpleCRUD.domain.users.model;

public class User {

	private int uId;
	private String uNombre;
	private String uApellido;
	private String uProvincia;
	private String uEmail;

	public User(int id) {
		uId = id;
		uNombre = null;
		uApellido = null;
		uProvincia = null;
		uEmail = null;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public String getuNombre() {
		return uNombre;
	}

	public void setuNombre(String uNombre) {
		this.uNombre = uNombre;
	}

	public String getuApellido() {
		return uApellido;
	}

	public void setuApellido(String uApellido) {
		this.uApellido = uApellido;
	}

	public String getuProvincia() {
		return uProvincia;
	}

	public void setuProvincia(String uProvincia) {
		this.uProvincia = uProvincia;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	
}
