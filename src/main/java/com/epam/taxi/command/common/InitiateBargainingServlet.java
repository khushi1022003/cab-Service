package com.epam.taxi.command.common;

import com.epam.taxi.db.dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InitiateBargainingServlet")
public class InitiateBargainingServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        double proposedFare = Double.parseDouble(request.getParameter("proposedFare"));

        OrderDAO orderDAO = new OrderDAO();
        boolean bargainingInitiated = orderDAO.initiateBargaining(orderId, proposedFare);

        PrintWriter out = response.getWriter();
        if (bargainingInitiated) {
            out.println("Bargaining initiated successfully");
        } else {
            out.println("Failed to initiate bargaining");
        }
    }
}
