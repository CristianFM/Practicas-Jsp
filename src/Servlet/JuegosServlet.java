package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DataBase.DataManager;
import Model.Juego;



/**
 * Servlet implementation class JuegosServlet
 */
@WebServlet("/JuegosServlet")
public class JuegosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DataManager dataManager = null;
	
    public JuegosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		dataManager = new DataManager();
		dataManager.setDbURL(config.getInitParameter("dbURL"));
		dataManager.setDbUserName(config.getInitParameter("dbUserName"));
		dataManager.setDbPassword(config.getInitParameter("dbPassword"));

		ServletContext context = config.getServletContext();
		context.setAttribute("base", config.getInitParameter("base"));
		context.setAttribute("dataManager", dataManager);

		try { // load the database JDBC driver
			Class.forName(config.getInitParameter("jdbcDriver"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.toString());
		}
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = "/jsp/";
		String url = base + "index.jsp";
		String peticion = request.getParameter("peticion");
		
		//DataManager datamanager = (DataManager) request.getServletContext().getAttribute("dataManager");
		if (peticion != null) {
			switch (peticion) {
			case "altaJuego":
				
				url= base + "altaJuego.jsp";
				
				break;
				
			case "listarJuegos":
				
				url= base + "listadoJuegos.jsp";
				ArrayList<Juego> juegos = dataManager.obtenerJuegos();
				request.getSession().setAttribute("listadoJuegos", juegos);
					
				break;
				
			case "insert": 
				
				String titulo = request.getParameter("titulo");
				String consola = request.getParameter("consola");
				String genero = request.getParameter("genero");
				
				boolean existe = dataManager.insertarJuego(consola,titulo,genero);
				if(existe == false){
					System.out.println("Juego error insertcion");
				}else {
					System.out.println("Juego insertado");
				}
				break;
				
			}
			
		}
		
		RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(url);
		requestDispatcher.forward(request, response);
	}
}


