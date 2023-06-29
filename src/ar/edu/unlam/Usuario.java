package ar.edu.unlam;

public class Usuario {

	private String mail;
	private String nombre;
	private Integer edad;
	public Usuario(String mail, String nombre, Integer edad) {
		this.mail = mail;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public void echarDelEvento(Usuario usuario, Evento evento) {
		evento.removerPresente(this, usuario);
	}
	
	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		return true;
	}

	public boolean aceptarInvitacion() {
		return true;
	}
	
	public void presentarse(Evento evento) throws usuarioNoInvitadoException {
		evento.agregarPresente(this);
	}


}
