

public class Usuario {
	private String nombre_usuario;
	private String clave;
	
	public Usuario (String nombre, String clave) {
		this.nombre_usuario = nombre;
		this.clave = clave;
	}
	
	public String getNombre_usuario() {
		return nombre_usuario;
	}
	public String getClave() {
		return clave;
	}
	
	public boolean validarUsuario(String nombre, String clave) {
		return (this.nombre_usuario.equals(nombre) && this.clave.equals(clave));
	}
}
