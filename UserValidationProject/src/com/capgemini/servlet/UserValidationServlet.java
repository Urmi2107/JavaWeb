package com.capgemini.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.dal.InvalidUserException;
import com.capgemini.dal.UserDAO;

/**
 * Servlet implementation class UserValidationServlet
 */
@WebServlet("/UserValidationServlet")
public class UserValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public void doCommon(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException
    {
    	String userName=request.getParameter("user");
    	String password=request.getParameter("pass");
    	String userType="";
    	HttpSession session=request.getSession();
    	session.setAttribute("USER",userName);
    	UserDAO user=new UserDAO();
    	try
    	{
    		userType=user.getUserType(userName, password);
    	}
    
    	catch(InvalidUserException e)
    	{
    		userType="Invalid User";
    	}
    	RequestDispatcher rd=null;
    	if(userType.equals("Admin"))
    	  		rd=request.getRequestDispatcher("jsp/admin.jsp");
    	else if(userType.equals("User"))
    		rd=request.getRequestDispatcher("jsp/user.jsp");
    	else
    		rd=request.getRequestDispatcher("jsp/invalidUser.jsp");
    rd.forward(request, response);			
    	
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doCommon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			doCommon(request,response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
