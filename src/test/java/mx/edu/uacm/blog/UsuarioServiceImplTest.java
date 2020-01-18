package mx.edu.uacm.blog;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mx.edu.uacm.blog.domain.Usuario;
import mx.edu.uacm.blog.service.UsuarioService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=BlogProyectoFinalApplication.class)
public class UsuarioServiceImplTest {
	private static final Logger log = LogManager.getLogger(UsuarioServiceImplTest.class);
	
	
	@Autowired
	private UsuarioService usuarioService;
	
	/*@Test
	public void testCrearUsuarioService() {
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Fecha: "+dateFormat.format(date));
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Mariana");
		usuario.setCuidad("CDMX");
		usuario.setEmail("mariana.gonzaga.nu@gmail.com");
		usuario.setFecha_registro(date);
		System.out.println("Fecha generada"+date);
		usuario.setPassword("12345");
		
		
		usuarioService.insertarUsuario(usuario);
		
		
	}*/
	
   @Test
	public void testValidarUsuarioService() {
	   log.debug("Entrando a metodo testValidarUsuarioService() ");
	    String mail="mariana.gonzaga.nu@gmail.com";
	    String mail1="mariana@gmail.com";
		Usuario usuarioEncontrado = usuarioService.encontrarPorEmail(mail1);
		
		if(usuarioEncontrado != null) {
			
			log.debug("Usuario registrado");
		}else {
			log.debug("Usuario no registrado");
		}
	    
			
	}
   
   
   /*@Test
	public void testValidarUsuarioyPasswordService() {
	   log.debug("testValidarUsuarioyPasswordService() ");
	    String mail="mariana.gonzaga.nu@gmail.com";
	    String password="12345";
	    Usuario usuarioValido = usuarioService.validarUsuarioyContraseña(mail,password);
		
	    Assert.assertThat( usuarioValido, is(not(nullValue())));
	    
			
	}*/
	
	

}
