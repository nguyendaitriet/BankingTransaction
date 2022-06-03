package com.triet.controller;

import com.triet.model.Customer;
import com.triet.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "TransferServlet", value = "/transfer")
public class TransferServlet extends HttpServlet {
    private ICustomerService customerService;
    private ITransferService transferService;

    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
        transferService = new TransferService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        try {
            Customer sender = customerService.findById(id);
            request.setAttribute("sender", sender);

            List<Customer> customers = customerService.findAll();
            customers.remove(sender);
            request.setAttribute("recipients", customers);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/transfer.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long senderId = Long.parseLong(request.getParameter("id"));
        long recipientId = Long.parseLong(request.getParameter("recipientId"));
        long amount = Long.parseLong(request.getParameter("transfer"));
        BigDecimal transactionAmount = BigDecimal.valueOf(amount);

        try {
            boolean transferred = transferService.transfer(transactionAmount, senderId, recipientId);
            request.setAttribute("transferred", transferred);


            Customer sender = customerService.findById(senderId);
            request.setAttribute("sender", sender);

            List<Customer> customers = customerService.findAll();
            customers.remove(sender);
            request.setAttribute("recipients", customers);


            String message = TransferService.message;
            request.setAttribute("message",message);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/transfer.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
