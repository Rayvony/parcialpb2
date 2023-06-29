package ar.edu.unlam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class Evento {
	private ArrayList<Usuario> invitados;
	private ArrayList<Usuario> presentes;
	private HashSet<Usuario> organizadores;
	private String nombre;
	private TipoEvento tipoDeEvento;

	
	public Evento(String nombre, TipoEvento tipoDeEvento) {
		this.invitados = new ArrayList<>();
		this.presentes = new ArrayList<>();
		this.organizadores = new HashSet<>();
		this.nombre = nombre;
		this.tipoDeEvento = tipoDeEvento;
	}
	
    public void listarInvitadosPorNombre() {
        Collections.sort(invitados, new Comparator<Usuario>() {
            @Override
            public int compare(Usuario u1, Usuario u2) {
                return u1.getNombre().compareTo(u2.getNombre());
            }
        });
    }
	
	public void agregarOrganizador(Usuario usuario) {
		organizadores.add(usuario);
	}
	
	public void removerOrganizador(Usuario usuario) {
		organizadores.remove(usuario);
	}
	

	public HashSet<Usuario> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(HashSet<Usuario> organizadores) {
		this.organizadores = organizadores;
	}

	public void agregarInvitado(Usuario usuario) {
		invitados.add(usuario);
	}
	
	public void removerInvitado(Usuario usuario) {
		invitados.remove(usuario);
	}
	
	public void agregarPresente(Usuario usuario) throws usuarioNoInvitadoException {
		if(invitados.contains(usuario)) {
		presentes.add(usuario);
		} else throw new usuarioNoInvitadoException(nombre);
	}
	
	public void removerPresente(Usuario organizador, Usuario usuario) {
		if(organizadores.contains(organizador)) {
		presentes.remove(usuario);
		}
	}
	public ArrayList<Usuario> getPresentes() {
		return presentes;
	}

	public void setPresentes(ArrayList<Usuario> presentes) {
		this.presentes = presentes;
	}

	public ArrayList<Usuario> getInvitados() {
		return invitados;
	}


	public void setInvitados(ArrayList<Usuario> invitados) {
		this.invitados = invitados;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public TipoEvento getTipoDeEvento() {
		return tipoDeEvento;
	}


	public void setTipoDeEvento(TipoEvento tipoDeEvento) {
		this.tipoDeEvento = tipoDeEvento;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Evento other = (Evento) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
}
