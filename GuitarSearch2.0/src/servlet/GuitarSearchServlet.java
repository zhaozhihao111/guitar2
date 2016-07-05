package servlet;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.Guitar;
import bean.GuitarSpec;
import dao.InventoryDao;
import dao.InventoryDaoImpl;
import model.InventoryModel;

/**
 * Servlet implementation class GuitarSearchServlet
 */
@WebServlet("/GuitarSearchServlet")
public class GuitarSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GuitarSearchServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	    InventoryModel inventory = new InventoryModel();
	    String serialNumber= request.getParameter("serialNumber");
	    initializeInventory(serialNumber, inventory);
	    
	    String a="1";
	    GuitarSpec whatErinLikes = 
	      new GuitarSpec(a,a,a,a,a);
	    List matchingGuitars = inventory.search(whatErinLikes);
	    if (!matchingGuitars.isEmpty()) {
	    	String info="success!";
	    	List list=new LinkedList();
	      for (Iterator i = matchingGuitars.iterator(); i.hasNext(); ) {
	        Guitar guitar = (Guitar)i.next();
	        GuitarSpec spec = guitar.getSpec();
	        list.add(guitar);
	        System.out.print(guitar.getSerialNumber());
//	        System.out.println("  We have a " +
//	          spec.getBuilder() + " " + spec.getModel() + " " +
//	          spec.getType() + " guitar:\n     " +
//	          spec.getBackWood() + " back and sides,\n     " +
//	          spec.getTopWood() + " top.\n  You can have it for only $" +
//	          guitar.getPrice() + "!\n  ----");
	      }
	      request.setAttribute("list", list);
	      request.setAttribute("info", info);
	    } else {
	      String info="Sorry, Erin, we have nothing for you.";
	      request.setAttribute("info", info);
	    }
		request.getRequestDispatcher("/search.jsp").forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	  private static void initializeInventory(String serialNumber,InventoryModel inventory) {
		  	InventoryDao dao=new InventoryDaoImpl();
		  	
		  	try {
				for(Guitar guitar:dao.search(serialNumber)){
					inventory.addGuitar(guitar.getSerialNumber(),
										guitar.getPrice(), 
										guitar.getSpec().getBuilder(),
										guitar.getSpec().getModel(), 
										guitar.getSpec().getType(), 
										guitar.getSpec().getBackWood(),
										guitar.getSpec().getTopWood());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  	
		  }
	
}
