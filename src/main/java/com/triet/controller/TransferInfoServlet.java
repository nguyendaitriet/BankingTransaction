package com.triet.controller;

import com.triet.dto.TransferInfoDTO;
import com.triet.service.ITransferInfoService;
import com.triet.service.TransferInfoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TransferInfoServlet", value = "/TransferInfo")
public class TransferInfoServlet extends HttpServlet {
    ITransferInfoService transferInfoService = new TransferInfoService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TransferInfoDTO> transferInfoList = transferInfoService.findAll();
        request.setAttribute("transferInfoList",transferInfoList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/transferInfo.jsp");
        dispatcher.forward(request,response);
    }


}
