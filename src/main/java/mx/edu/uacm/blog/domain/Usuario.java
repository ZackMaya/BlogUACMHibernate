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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;



@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String url;
	
	@Column(nullable = false)
	private String nombre; 
	
	@Column(nullable = false)
	private String cuidad;
	
	@Column(nullable = false)
	private String email;
	
	@Column
	@CreationTimestamp
	private Date fecha_registro;
	 
	@ColumnTransformer(write=" MD5(?) ")
	private String password;

	/****Relacion de uno a muchos con el post********/
	@OneToMany(mappedBy="usuario", cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Post> posts = new HashSet<>();
	
	
	
	/****Relacion de uno a muchos con los comentarios********/
	@OneToMany(mappedBy="usuario",cascade=CascadeType.PERSIST, fetch = FetchType.EAGER)
	private Set<Comentario> comentarios = new HashSet<>();

	
	
	public Usuario() {
	}

	public Usuario(String url, String nombre, String cuidad, String email, Date fecha_registro, String password) {
		this.url = url;
		this.nombre = nombre;
		this.cuidad = cuidad;
		this.email = email;
		this.fecha_registro = fecha_registro;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCuidad() {
		return cuidad;
	}


	public void setCuidad(String cuidad) {
		this.cuidad = cuidad;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFecha_registro() {
		return fecha_registro;
	}


	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

    

	public Set<Post> getPosts() {
		return posts;
	}



	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}


	/**helpers post**/
	public void addPost(Post post) {
		posts.add(post);
		post.setUsuario(this);

	}
	
	public Post removePost(Post post) {
		
		getPosts().remove(post);
		post.setUsuario(null);
		return post;
		
	}
	
	public Set<Comentario> getComentarios() {
		return comentarios;
	}


	public void setComentarios(Set<Comentario> comentario) {
		this.comentarios = comentario;
	}
	
	/**helpers comentario**/
	public void addComentarios(Comentario comentario) {
		comentarios.add(comentario);
		comentario.setUsuario(this);
	}
	
	public Comentario removeComentarios(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuario(null);
		return comentario;
	}
	
	
}
