package car.dominio;


import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Articulo {
	final static char sep ='-';
	
	private String clave;
	private String nombre;
	private String descripcion;
	private BigDecimal costo;
	private BigDecimal precio;
	private int stock;
	

	public Articulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public BigDecimal getCosto() {
		return costo;
	}
	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Articulo(String clave, String nombre, String descripcion, BigDecimal costo, BigDecimal precio,
			int stock) {
		super();
		this.clave = clave;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		this.precio = precio;
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder().append(clave).append(sep)
											  .append(nombre).append(sep)
											  .append(descripcion).append(sep)
											  .append(costo).append(sep)
											  .append(precio).append(sep)
											  .append(stock);
		return sb.toString();
	}
	
	
}

