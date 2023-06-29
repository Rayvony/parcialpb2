package ar.edu.unlam;

public class Cumple extends Evento {
	
	private Usuario agasajado;

	public Cumple(String nombre, TipoEvento tipodeevento, Usuario agasajado) {
		super(nombre, tipodeevento);
		this.agasajado = agasajado;

	}
	
	public void invitarUsuario(Usuario usuario) {
		if(usuario.aceptarInvitacion() == true) {
			super.agregarInvitado(usuario);
		}
	}

	public Usuario getAgasajado() {
		return agasajado;
	}

	public void setAgasajado(Usuario agasajado) {
		this.agasajado = agasajado;
	}
}
