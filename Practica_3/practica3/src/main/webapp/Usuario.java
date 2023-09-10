package ttps.clasificados;

public class Usuario {
	private String nombre_usuario;
	private String clave;
	private String perfil;
	
	public Usuario (String nombre, String clave, String perfil) {
		this.nombre_usuario = nombre;
		this.clave = clave;
		this.perfil = perfil;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public String getClave() {
		return clave;
	}
	public String getPerfil() {
		return perfil;
	}
	
	public boolean validarUsuario(String nombre, String clave) {
		return (this.nombre_usuario.equals(nombre) && this.clave.equals(clave));
	}
}
