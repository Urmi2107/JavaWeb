package com.capgemini.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.dal.ProductDAO;
import com.capgemini.pojo.ProductPojo;

/**
 * Servlet implementation class ViewProductServlet
 */
@WebServlet("/ViewProductServlet")
public class ViewProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doCommon(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException
    {
    	ProductDAO product=new ProductDAO();
    	ArrayList<ProductPojo> productPojoList=null;
    	try
    	{
    		productPojoList=product.viewProduct();
    	}
    	catch(SQLException e)
    	{
    		e.printStackTrace();
    	}
    	request.setAttribute("productPojoList", productPojoList);
    	 RequestDispatcher rd=request.getRequestDispatcher("jsp/viewProduct.jsp");  
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
