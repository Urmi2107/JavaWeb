package com.capgemini.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.ProductDAO;

/**
 * Servlet implementation class ProductDeletionServlet
 */
@WebServlet("/ProductDeletionServlet")
public class ProductDeletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDeletionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doCommon(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException
    {
    	String products[] = request.getParameterValues("checkProduct");
    	ProductDAO product=new ProductDAO();
    	for(String prod:products)
    	{
    		try
    		{
    			product.deleteProduct(prod);
    		}
    		catch(SQLException e)
    		{
    			e.printStackTrace();
    		}
    	}
    	response.sendRedirect("jsp/admin.jsp");
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
