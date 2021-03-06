package com.es.jointexpensetracker.web.filters;

import com.es.jointexpensetracker.web.Constants;
import com.es.jointexpensetracker.web.exceptions.HttpNotFoundException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ExpenseGroupFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final int SKIP_SLASH_VALUE = 1;

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String[] splittedRequestURI = request.getRequestURI().split("expense-groups");
        if (splittedRequestURI.length < 2) {
            throw new HttpNotFoundException();
        }

        String filterPathInfo = splittedRequestURI[1];
        int expenseGroupIndex = filterPathInfo.indexOf("/", SKIP_SLASH_VALUE);

        if (expenseGroupIndex == -1) {
            throw new HttpNotFoundException();
        }

        String newPath = filterPathInfo.substring(expenseGroupIndex);
        String expenseGroup = filterPathInfo.substring(SKIP_SLASH_VALUE, expenseGroupIndex);

        request.setAttribute(Constants.EXPENSE_GROUP_ATTRIBUTE_NAME, expenseGroup);
        request.getRequestDispatcher(newPath).forward(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}
}
