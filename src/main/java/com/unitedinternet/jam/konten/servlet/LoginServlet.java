package com.unitedinternet.jam.konten.servlet;

import com.unitedinternet.jam.konten.model.UserBean;
import com.unitedinternet.jam.konten.model.ZeitBean;
import com.unitedinternet.jam.konten.service.login.LoginService;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by agrunow on 10.10.16.
 */
public class LoginServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        if (request.getParameter("submit") != null) {

            String username = request.getParameter("username");
            String passwort = request.getParameter("password");

            if (new LoginService().isLoginValid(username, passwort)) {

                UserBean userBean = new UserBean();
                userBean.setUser("Wurstnase");

                ZeitBean zeitBean = new ZeitBean();

                request.getSession().setAttribute("userbean", userBean);
                request.getSession().setAttribute("zeitBean", zeitBean);

                response.sendRedirect("jsp/success.jsp");
            } else {
                response.sendRedirect("jsp/login.jsp");
            }
        }

        else {
            response.sendRedirect("jsp/login.jsp");
        }
    }
}
