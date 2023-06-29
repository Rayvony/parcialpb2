package ar.edu.unlam;

public class Casamiento extends Evento {
	
	private Usuario agasajado1;
	private Usuario agasajado2;
	
	public Casamiento(String nombre, TipoEvento tipodeevento, Usuario agasajado1, Usuario agasajado2) {
		super(nombre, tipodeevento);
		this.agasajado1 = agasajado1;
		this.agasajado2 = agasajado2;
	}
	
	public void invitarUsuario(Usuario usuario) {
		if(usuario.aceptarInvitacion() == true) {
			super.agregarInvitado(usuario);
		}
	}

	public Usuario getAgasajado1() {
		return agasajado1;
	}

	public void setAgasajado1(Usuario agasajado1) {
		this.agasajado1 = agasajado1;
	}

	public Usuario getAgasajado2() {
		return agasajado2;
	}

	public void setAgasajado2(Usuario agasajado2) {
		this.agasajado2 = agasajado2;
	}

}
