package com.es.jointexpensetracker.web.servlets;

import com.es.jointexpensetracker.service.ExpenseService;
import com.es.jointexpensetracker.service.impl.HardcodeExpenseService;
import com.es.jointexpensetracker.web.services.MessageService;
import com.es.jointexpensetracker.web.services.impl.SessionMessageService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExpenseListServlet extends CommonExpenseServlet {

    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = SessionMessageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        ExpenseService expenseService = loadExpenseService(request);

        request.setAttribute(
            "expenses", expenseService.getExpenses()
        );
        request.getRequestDispatcher("/WEB-INF/pages/expenses.jsp").forward(request, response);

        messageService.clearMessage(request);
    }
}