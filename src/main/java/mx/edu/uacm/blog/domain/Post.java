package mx.edu.uacm.blog.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="post")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String titulo;
	
	@Column(columnDefinition = "LONGTEXT", nullable = false)
	private String contenido_post;
	
	private String url_post;
	
	@Column
	@CreationTimestamp
	private Date fecha_post;
	
	@ManyToOne
	@JoinColumn(name="id_usuario",nullable = false)
	private Usuario usuario;
	
	@OneToMany(mappedBy="post", cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Comentario> comentarios = new HashSet<>();

	public Post() {
		
	}
  
	public Post(String titulo, String contenido_post, String url_post, Date fecha_post, Usuario usuario) {
		this.titulo = titulo;
		this.contenido_post = contenido_post;
		this.url_post = url_post;
		this.fecha_post = fecha_post;
		this.usuario = usuario;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getContenido_post() {
		return contenido_post;
	}

	public void setContenido_post(String contenido) {
		this.contenido_post = contenido;
	}

	public String getUrl_post() {
		return url_post;
	}

	public void setUrl_post(String url_post) {
		this.url_post = url_post;
	}

	public Date getFecha_post() {
		return fecha_post;
	}

	public void setFecha_post(Date fecha_post) {
		this.fecha_post = fecha_post;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/**helpers comentario**/
	
	public void addCommentary(Comentario comentario) {
		
		comentarios.add(comentario);
		comentario.setPost(this);
		
	}
	
	public void removeCommentary(Comentario comentario) {
		comentarios.remove(comentario);
		comentario.setPost(null);
	}

		

}
