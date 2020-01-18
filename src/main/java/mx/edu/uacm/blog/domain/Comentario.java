package mx.edu.uacm.blog.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="comentario")
public class Comentario {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 
	 @Column(nullable = false)
	 private String contenidoComnetario;
	 
	 @Column
	 @CreationTimestamp
	 private Date fechaComentario;
	 
	 /**relacion con el post**/
	 @ManyToOne
	 @JoinColumn(name="id_post",nullable = false)
	 private Post post;
	 
	 /**relacion con el usuario**/
	 @ManyToOne
	 @JoinColumn(name="id_usuario",nullable = false)
	 private Usuario usuario;


	public Comentario() {
		
	}



	public Comentario(String contenidoComnetario, Date fechaComentario) {
		this.contenidoComnetario = contenidoComnetario;
		this.fechaComentario = fechaComentario;
	}



	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getContenidoComnetario() {
		return contenidoComnetario;
	}


	public void setContenidoComnetario(String contenidoComnetario) {
		this.contenidoComnetario = contenidoComnetario;
	}


	public Date getFechaComentario() {
		return fechaComentario;
	}


	public void setFechaComentario(Date fechaComentario) {
		this.fechaComentario = fechaComentario;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public Post getPost() {
		return post;
	}



	public void setPost(Post post) {
		this.post = post;
	}







}
