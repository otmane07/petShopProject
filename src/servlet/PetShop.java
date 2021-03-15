package servlet;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import dao.CategoryDao;
import dao.OrderDao;
import dao.ProductDao;
import dao.ClientDao;
import beans.Category;
import beans.Product;
import beans.Client;
import beans.Order;

@WebServlet("/PetShop")
public class PetShop extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public PetShop() {
        super();
    }
    private ClientDao clientdao;
    private ProductDao productdao;
    private CategoryDao categorydao;
    private OrderDao orderdao;
    @Override
	public void init() throws ServletException{
    	clientdao   =   new ClientDao();
    	productdao  = new ProductDao();
    	categorydao = new CategoryDao();
    	orderdao    = new OrderDao();
	}
    
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String path=request.getServletPath();
		
		List<Category> categorys = categorydao.getCategorys();		
		request.setAttribute("categorydao",categorys);
		
		List<Product> products = productdao.getProducts();	
		request.setAttribute("modelPets",products);
		
		HttpSession session =request.getSession();	
		
		if(path.equals("/index.do")) {
			
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		

		if(path.equals("/about.do")) {
			request.getRequestDispatcher("about.jsp").forward(request, response);
		}
		
		
		if(path.equals("/register.do")) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		
		
		else if(path.equals("/reg.do")&&(request.getMethod().equals("POST"))) {
				
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				String email=request.getParameter("email");
				String phone=request.getParameter("phone");
				String company=request.getParameter("company");
				String adrres=request.getParameter("adrres");
				
				Client C =clientdao.regester(new Client( username,  password,  email,  phone,  company, adrres));
				
				int id =clientdao.login(username, password);
				String name = clientdao.select(id);
				session.setAttribute("userid", id);
				session.setAttribute("username", name);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
		}

		else if(path.equals("/myaccount.do")) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		else if(path.equals("/login.do")&&(request.getMethod().equals("POST"))) {
			
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			int id =clientdao.login(username, password);
			String name = clientdao.select(id);
			if( id==-1) {
				request.getRequestDispatcher("myaccount.do").forward(request, response);
			}
			else {
				
									
				session.setAttribute("userid", id);
				session.setAttribute("username", name);
				request.getRequestDispatcher("home.jsp").forward(request, response);
				
				
				
			}
			
		}
		
		else if(path.equals("/specials.do")) {
				request.getRequestDispatcher("specials.jsp").forward(request, response);
			}
		
		else if(path.equals("/pets.do")) {
					
				request.getRequestDispatcher("pets.jsp").forward(request, response);
			}
		
		if(path.equals("/contact.do")) {
					request.getRequestDispatcher("contact.jsp").forward(request, response);
				}
		
		if(path.equals("/logout.do")) {
			
				session.invalidate();
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		
		if(path.contains("/details.do")) {
			int product_id = Integer.parseInt(request.getParameter("id")) ;
			for(Product p :products) {
				if(p.getProduct_id()==product_id) {
					request.setAttribute("productt_selected",p);
				}
			}
			
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		}
		
		
		if(path.contains("/category.do")) {
			int c_id = Integer.parseInt(request.getParameter("id")) ;
			List<Product> productCat= new ArrayList<Product>();
			for(Product p :products) {
				if(p.getProduct_category_id()==c_id) {
					productCat.add(p);
					request.setAttribute("cat_selected",productCat);
				}
			}
			
			request.getRequestDispatcher("category.jsp").forward(request, response);
		}
		
		
		if(path.equals("/order.do")) {
			int client_id = Integer.parseInt(request.getParameter("client_id")) ;
			int product_id = Integer.parseInt(request.getParameter("product_id")) ;
		
			orderdao.insert(client_id,product_id);
		
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		
		if(path.equals("/cart.do")) {
			double c= 0;
			List<Order> orders = orderdao.getOrders();		
			List<Product> productOrder= new ArrayList<Product>();
			int clientid = Integer.parseInt(request.getParameter("clientid")) ;
			for(Order o :orders) {
				if(o.getClient_id()==clientid) {
					for(Product p :products) {
						if(p.getProduct_id()==o.getProduct_id()) {
							productOrder.add(p);
							c+=p.getPrice();
							
						}
					}
					//petCat.add(p);
					//request.setAttribute("cat_selected",petCat);
				}
			}
			String formatted = String.format("%.2f", c);
			request.setAttribute("total",formatted);
			System.out.println(c);
			request.setAttribute("product_order",productOrder);
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
