package pkgServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pkgPojo.UserPojo;
/**
 * Servlet implementation class UserServletValidate
 */
@WebServlet("/ValidateServlet")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	List<UserPojo> l;
	@Override
	
   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		l=new ArrayList<UserPojo>();
		UserPojo u=new UserPojo("Urmi","U21101995","User");
		l.add(u);
		u=new UserPojo("Dhruba","D12345678","Admin");
		l.add(u);
		u=new UserPojo("Supriti","S77259031","User");
		l.add(u);
		u=new UserPojo("Kuheli","K12117062","User");
		l.add(u);
		u=new UserPojo("Rajdeep","R13130983","User");
		l.add(u);
   		String userName=request.getParameter("user");
   		String password=request.getParameter("pass");
   		Iterator<UserPojo> i=l.iterator();
   		while(i.hasNext())
   		{
   			UserPojo user=(UserPojo)i.next();
   			if(userName.equals(user.getUserName()))
   				if(password.equals(user.getPassword()))
   					if(user.getUserType().equals("Admin"))
  					{
   						RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
   				        rd.forward(request, response);  
   				       return;
   					}
   					else if(user.getUserType().equals("User"))
   					{
   						RequestDispatcher rd=request.getRequestDispatcher("user.jsp");  
   				        rd.forward(request, response);  
   				      return;
   					}
   					else
   					{
   						RequestDispatcher rd=request.getRequestDispatcher("invalidUser.jsp");  
   				        rd.forward(request, response);  
   				      return;
   					}
   					
   		   						
   		}
   	
   		RequestDispatcher rd=request.getRequestDispatcher("invalidUser.jsp");  
	        rd.forward(request, response);  
		
	}

}
