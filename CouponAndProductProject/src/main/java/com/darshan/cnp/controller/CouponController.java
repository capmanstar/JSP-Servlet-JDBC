package com.darshan.cnp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.darshan.cnp.dao.CouponDAO;
import com.darshan.cnp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    CouponDAO dao = new CouponDAO();   
    
    public CouponController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		if(action.equals("create"))
			createCoupon(request, response);
		else if(action.contains("find"))
			findCoupon(request, response);
		
	}


	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expiryDate = request.getParameter("expiryDate");
		
		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expiryDate);
		
		dao.save(coupon);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print("<b>Product created</b>");
		writer.print("<br/><a href='index.html'>Home</a>");
	}
	
	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String couponCode = request.getParameter("couponCode");
		Coupon code = dao.findByCode(couponCode);
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.print(code);
		
	}

}
