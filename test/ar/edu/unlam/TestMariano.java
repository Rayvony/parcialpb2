package ar.edu.unlam;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMariano {
	
	@Test
	public void queSePuedaCrearUnCumpleanios(){
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		assertEquals(nombreEvento, cumpleaños.getNombre());
		
	}
	
	@Test
	public void queSePuedaCrearUnCasamiento(){
		String nombreEvento = "casamiento";
		
		String mailAgasajado1 = "a@gmail.com";
		String nombreAgasajado1 = "jorge";
		Integer edadAgasajado1 = 23;
		
		String mailAgasajado2 = "b@gmail.com";
		String nombreAgasajado2 = "sabrina";
		Integer edadAgasajado2 = 23;
		
		Usuario agasajado = new Usuario(mailAgasajado1, nombreAgasajado1, edadAgasajado1);
		Usuario agasajado2 = new Usuario(mailAgasajado2, nombreAgasajado2, edadAgasajado2);
		
		Evento casamiento = new Casamiento(nombreEvento, TipoEvento.Casamiento, agasajado, agasajado2);
		
		assertEquals(nombreEvento, casamiento.getNombre());
		
	}
	@Test
	public void queSePuedaInvitarGenteAUnCumpleaños(){
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario usuario1 = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		cumpleaños.agregarInvitado(usuario1);
		Integer cantidadEsperada = 1;
	
		
		assertEquals(cantidadEsperada, cumpleaños.getInvitados().size(), 1);
	}
	
	@Test
	public void queUnUsuarioPuedaConfirmarSuAsistencia(){
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario usuario1 = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		assertTrue(usuario1.aceptarInvitacion());
	}
	
	@Test
	public void queUnInvitadoPuedaAsistirAUnEvento() throws usuarioNoInvitadoException{
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario usuario1 = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		cumpleaños.agregarInvitado(usuario1);
		usuario1.presentarse(cumpleaños);
		
		Integer cantidadEsperada = 1;
		
		
		assertEquals(cantidadEsperada, cumpleaños.getPresentes().size(),1);
	
	}
	
	@Test(expected=usuarioNoInvitadoException.class)
	public void queSiUnInvitadoAsisteAUnEventoAlQueNoFueInvitadoLanceLaExcepcionUsuarioNoInvitado() throws usuarioNoInvitadoException{
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario usuario1 = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		usuario1.presentarse(cumpleaños);		
	}
	
	@Test
	public void queUnOrganizadorPuedaEcharInvitados() throws usuarioNoInvitadoException {
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		String mailUsuario1 = "m@gmail.com";
		String nombreUsuario1 = "migue";
		Integer edadUsuario1 = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario organizador = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Usuario usuario1 = new Usuario(mailUsuario1, nombreUsuario1, edadUsuario1);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		cumpleaños.agregarInvitado(usuario1);
		usuario1.presentarse(cumpleaños);
		
		cumpleaños.agregarOrganizador(organizador);
		organizador.echarDelEvento(usuario1, cumpleaños);
		
		Integer valoresperado = 0;
		
		assertEquals(valoresperado, cumpleaños.getPresentes().size(),1);
		
	}
	
	@Test
	public void queUnUsuarioPromedioNoPuedaEcharInvitados() throws usuarioNoInvitadoException {
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "j@gmail.com";
		String nombreUsuario = "joaco";
		Integer edadUsuario = 23;
		
		String mailUsuario1 = "m@gmail.com";
		String nombreUsuario1 = "migue";
		Integer edadUsuario1 = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario organizador = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Usuario usuario1 = new Usuario(mailUsuario1, nombreUsuario1, edadUsuario1);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		cumpleaños.agregarInvitado(usuario1);
		usuario1.presentarse(cumpleaños);
		
		organizador.echarDelEvento(usuario1, cumpleaños);
		
		Integer valoresperado = 1;
		
		assertEquals(valoresperado, cumpleaños.getPresentes().size(),1);
		
	}
	
	@Test
	public void queSeObtenganLosInvitadosOrdenadosPorNombre() throws usuarioNoInvitadoException {
		String nombreEvento = "cumpleaños";
		String mailAgasajado = "a@gmail.com";
		String nombreAgasajado = "jorge";
		Integer edadAgasajado = 23;
		
		String mailUsuario = "z@gmail.com";
		String nombreUsuario = "zoaco";
		Integer edadUsuario = 23;
		
		String mailUsuario1 = "a@gmail.com";
		String nombreUsuario1 = "aigue";
		Integer edadUsuario1 = 23;
		
		
		Usuario agasajado = new Usuario(mailAgasajado, nombreAgasajado, edadAgasajado);
		Usuario organizador = new Usuario(mailUsuario, nombreUsuario, edadUsuario);
		Usuario usuario1 = new Usuario(mailUsuario1, nombreUsuario1, edadUsuario1);
		Evento cumpleaños = new Cumple(nombreEvento, TipoEvento.Cumple, agasajado);
		
		cumpleaños.agregarInvitado(organizador);
		cumpleaños.agregarInvitado(usuario1);
		
		
		Integer valoresperado = 1;
		
		assertEquals(valoresperado, cumpleaños.getPresentes().size(),1);
		
	}
	
    @Test
    public void queSePuedaListarInvitadosPorNombre() {
        Usuario usuario1 = new Usuario("1@gmail.com", "Carlos", 25);
        Usuario usuario2 = new Usuario("2@gmail.com", "Ana", 30);
        Usuario usuario3 = new Usuario("3@gmail.com", "David", 28);
        
        Evento evento = new Cumple("Nombre del Evento", TipoEvento.Cumple, usuario1);

        evento.agregarInvitado(usuario1);
        evento.agregarInvitado(usuario2);
        evento.agregarInvitado(usuario3);

        evento.listarInvitadosPorNombre();
        

       
       assertEquals(usuario2.getNombre(), evento.getInvitados().get(0).getNombre()); //Ana
       assertEquals(usuario1.getNombre(), evento.getInvitados().get(1).getNombre()); //Carlos
       assertEquals(usuario3.getNombre(), evento.getInvitados().get(2).getNombre()); //David
    }
}

