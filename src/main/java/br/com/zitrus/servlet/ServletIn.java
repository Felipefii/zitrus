package br.com.zitrus.servlet;

import br.com.zitrus.controller.Controller;
import br.com.zitrus.controller.ControllerInstance;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/in")
public class ServletIn extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("acao");
        Controller controller = ControllerInstance.getInstanceByAction(action);
        String execute = controller.execute(req, resp);

        String[] goal = execute.split(":");
        if (goal[0].equalsIgnoreCase("redirect")){
            resp.sendRedirect(goal[1]);
        }else{
            req.getRequestDispatcher(goal[1]).forward(req, resp);
        }


    }
}
