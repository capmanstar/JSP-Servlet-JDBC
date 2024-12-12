package com.darshan.cnp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darshan.cnp.dao.ProductDAO;
import com.darshan.cnp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/product")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDAO dao = new ProductDAO();
       
    
    public ProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("name");
		String discription = request.getParameter("discription");
		String price = request.getParameter("price");
		
		Product product = new Product();
		product.setName(productName);
		product.setDescription(discription);
		product.setPrice(new BigDecimal(price));
		
		dao.save(product);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<b>Product created</b>");
		writer.print("<br/><a href='index.html'>Home</a>");
	}

}
