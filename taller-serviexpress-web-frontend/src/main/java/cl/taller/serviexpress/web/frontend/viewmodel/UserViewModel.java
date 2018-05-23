package cl.taller.serviexpress.web.frontend.viewmodel;

public class UserViewModel {

	private Long id;
	private String rut;
	private String name;
	private String lastName;
	private String mothersLastName;
	private String profile;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMothersLastName() {
		return mothersLastName;
	}

	public void setMothersLastName(String mothersLastName) {
		this.mothersLastName = mothersLastName;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

}
