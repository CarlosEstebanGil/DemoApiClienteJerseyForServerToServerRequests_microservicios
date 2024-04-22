package car.web;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.TreeMap;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/*	Este servlet vá a ser mi controlador de mi modelo MVC , es el que se encargará
	de todo el tráfico de mi aplicacion. Tiene todo el flujo de pantallas, from,
		where, y operaciones para cada pantalla.
		En este ejemplo 1ero vá a venir desde/con "inicio.jsp" ent el switch va 
			a redireccion auto hacia DemoGui.jsp pero de invocar esa vista/pagina 
			acá mismo va a invocar un servicio rest de otra app usando el api 
			jersey client para consumirlo y pasarle ya la  data inicial a la vista 
			q la requiere. ( en este caso un hashmap map de arts: clave - valor )
			xa que esa vista (pagina demogui.jsp) ya pueda rellenar x jsp el desde
			el req al combo(html select)c/todaesa data inicial qledoy desdeel controler
			
		( luego Recibirá los datos de la vista (datos en el req, fromStr y opStr) 
		  luego Efecturá las peticiones al modelo (requests al modelo) 
		  		( ya sea a los dao de la capa de datos xa acceso a db 
		  			o a objs similares pero para acceso a otras fuentes coo 
		  			en este ej a otros servicios rest (servers rest) en otras apps ) 
		) 
*/
public class TestRestArticuloServlet extends HttpServlet {
	private static final long serialVersionUID =1L;
	
	private Client cliente=null;

	public TestRestArticuloServlet() {
		super();
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.cliente = ClientBuilder.newClient(); //me dá un socket cli /req tipo rest
	}

	@Override
	public void destroy() {
		this.cliente.close();
		super.destroy();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String vista=req.getParameter("vista");
		String operacion= req.getParameter("operacion");
			if ( vista == null ) vista ="inicio.jsp";
		
		switch (vista) {
			case "inicio.jsp":
				Map<String, String> datosComboArticulo = this.getDatosComboArticulo();
				req.setAttribute("mapaArticulos", datosComboArticulo);
				invocar("/DemoGui.jsp",req,resp);
				break;
			case "DemoGui.jsp":
				switch (operacion) {
					case "consulta":
						invocar("/Articulo.jsp",req,resp);
						break;
					case "alta":
						
						break;
					default:
						break;
				}
				break;
			case "Alta..jsp":
				switch (operacion) {
				case "insercion":
					
					break;
				case "regresar":
					
					break;
				default:
					break;
				} 
			break;
			
			default:
				break;
		}
		
	}
	
	private Map<String, String> getDatosComboArticulo() {
		String strComboJasonFromServer;
		final String svcComboArtsURI = "http://localhost:8080"+ 
										"/demRest01-PrimerServicio"+ 
										"/webapi" + 
										"/articulo"+
										"/todos";
		
		strComboJasonFromServer		=  
										cliente .target(svcComboArtsURI)
										.request(MediaType.APPLICATION_JSON)
										.get(String.class); //exec Async ???

		
		return ArticulosJsonKVToMap(strComboJasonFromServer);
	}

	protected Map<String, String> ArticulosJsonKVToMap(String cadJasonArts){
		Map<String,String> map = new TreeMap<String, String>();
		JsonReader jReader = Json.createReader(new StringReader(cadJasonArts));
		JsonArray jArray = jReader.readArray();
		for (int i = 0; i < jArray.size(); i++) {
			JsonObject artJson = jArray.getJsonObject(i);
			String clave = artJson.getString("clave");
			String nombre = artJson.getString("valor");
			map.put(clave,nombre);
		}
		return map;
	}
	protected void invocar(String strVistaURI, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		RequestDispatcher reqJsp = req.getServletContext().getRequestDispatcher(strVistaURI);
		reqJsp.forward(req, resp);
	}
}
