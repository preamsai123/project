package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Order_details;
import com.bean.Product;
import com.bean.User;
import com.dao.OrderDao;
import com.dao.Order_detailsDao;
import com.dao.ProductDao;
import com.dao.UserDao;

@WebServlet("/FurnitureServlet")
public class FurnitureServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession se = request.getSession(false);
		if (se != null) {
			se.invalidate();
		}
		response.setContentType("text/html");
		String bt = request.getParameter("action");
		HttpSession session = request.getSession();
		if (bt == null) {
			try {
				List<String> clist = ProductDao.getAllCategories();
				ArrayList<Product> plist = ProductDao.GetAllProductDetails();
				session.setAttribute("clist", clist);
				session.setAttribute("plist", plist);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String buttonvalue = request.getParameter("button");

		if (buttonvalue.equals("register")) {
			String uname = request.getParameter("t1");
			String uemail = request.getParameter("t2");
			String upassword = request.getParameter("t3");
			try {
				boolean check = UserDao.CheckEmailexitsorNot(uemail);
				if (check) {
					out.print("Account already exists");
					request.getRequestDispatcher("login.jsp").include(request, response);
				} else {
					User u = new User(uname, uemail, upassword);
					boolean res = UserDao.AddCustomer(u);
					if (res) {
						out.print("Signed up sucessfully");
						request.getRequestDispatcher("login.jsp").include(request, response);
					} else {
						out.print("signup failed");
						request.getRequestDispatcher("login.jsp").include(request, response);
					}

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (buttonvalue.equals("login")) {
			String email = request.getParameter("t6");
			String password = request.getParameter("t7");
			try {
				boolean check = UserDao.CheckEmailexitsorNot(email);
				if (check) {
					String dpassword = UserDao.Uservalidation(email);
					if (dpassword.contentEquals(password)) {

						String username = UserDao.UserName(email);
						int uid = UserDao.UserID(email);
						session.setAttribute("uid", uid);
						session.setAttribute("uname", username);

						request.getRequestDispatcher("loginhome.jsp").forward(request, response);
					} else {
						out.print("Userid and password do ot match");

						request.getRequestDispatcher("login.jsp").include(request, response);
					}

				} else {
					out.print("User id doesn't exist, please sign up");
					request.getRequestDispatcher("login.jsp").include(request, response);
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonvalue.equals("Go")) {

			try {
				String selection = request.getParameter("f1");
				ArrayList<Product> plist = ProductDao.GetAllProductDetailsWithCategory(selection);
				request.setAttribute("plist", plist);
				request.getRequestDispatcher("login.jsp").include(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonvalue.equals("select")) {

			try {
				String selection = request.getParameter("f2");
				ArrayList<Product> plist = ProductDao.GetAllProductDetailsWithCategory(selection);
				request.setAttribute("plist", plist);
				request.getRequestDispatcher("loginhome.jsp").include(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (buttonvalue.equals("cart")) {
			HashMap<Product, Integer> hp = new HashMap<Product, Integer>();

			int Totalamount = 0;
			if (session.getAttribute("hp") == null) {
				String[] id = request.getParameterValues("itemid");
				String[] quantities = request.getParameterValues("quantity");

				for (int i = 0; i < quantities.length && i < id.length; i++) {

					if (Integer.parseInt(quantities[i]) != 0) {
						try {
							Product p = ProductDao.GetAllProductsWithID(Integer.parseInt(id[i]));
							hp.put(p, Integer.parseInt(quantities[i]));

						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				Set<Entry<Product, Integer>> entry = hp.entrySet();
				for (Entry<Product, Integer> e : entry) {
					Totalamount += (e.getKey().getPrice() * e.getValue());
				}
			}

			else {
				Totalamount = 0;
				hp = (HashMap<Product, Integer>) session.getAttribute("hp");
				String[] id = request.getParameterValues("itemid");
				String[] quantities = request.getParameterValues("quantity");

				for (int i = 0; i < quantities.length && i < id.length; i++) {

					if (Integer.parseInt(quantities[i]) != 0) {
						try {
							Product p = ProductDao.GetAllProductsWithID(Integer.parseInt(id[i]));
							hp.put(p, Integer.parseInt(quantities[i]));
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
				Set<Entry<Product, Integer>> entry = hp.entrySet();
				for (Entry<Product, Integer> e : entry) {
					Totalamount += (e.getKey().getPrice() * e.getValue());
				}

			}

			session.setAttribute("hp", hp);
			session.setAttribute("amount", Totalamount);
			request.getRequestDispatcher("cart.jsp").forward(request, response);

		} else if (buttonvalue.equals("continue")) {
			int custId = (int) session.getAttribute("uid");
			int ta = (int) session.getAttribute("amount");
			Date d = new Date();
			Timestamp t = new java.sql.Timestamp(d.getTime());

			try {
				boolean res = OrderDao.Generatebill(custId, ta, t);
				if (res) {
					HashMap<Product, Integer> hp = (HashMap<Product, Integer>) session.getAttribute("hp");
					Set<Entry<Product, Integer>> entry = hp.entrySet();
					int orderid = OrderDao.GetOrderIDwithUserIdandTimestamp(custId, t);
					for (Entry<Product, Integer> e : entry) {
						int pid = e.getKey().getId();
						int quantity = e.getValue();
					boolean res1=Order_detailsDao.AddOrderDetails(orderid, pid, quantity);
					}
					out.print("bill generated sucessfully");
					request.getRequestDispatcher("final.jsp").forward(request, response);        
				} else {
					out.print("Bill not generated");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
