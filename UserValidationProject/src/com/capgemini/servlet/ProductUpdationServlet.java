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
import com.capgemini.pojo.ProductPojo;

/**
 * Servlet implementation class ProductUpdationServlet
 */
@WebServlet("/ProductUpdationServlet")
public class ProductUpdationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductUpdationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void doCommon(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException
    {
    	String productName="",productId="";
    	double productPrice=0;
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
    	for(ProductPojo products:productPojoList)
    	{
    		productId=request.getParameter("productId"+products.getProductId());
    		productName=request.getParameter("productName"+products.getProductId());
    		productPrice=Double.parseDouble(request.getParameter("productPrice"+products.getProductId()));
    		try
        	{
        		product.updateProduct(productId, productName, productPrice);
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
