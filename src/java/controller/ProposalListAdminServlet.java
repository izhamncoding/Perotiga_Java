package controller;

import dao.CarDao;
import dao.ProposalDao;
import model.Proposal;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/proposalListAdmin")
public class ProposalListAdminServlet extends HttpServlet {
    private ProposalDao proposalDao;
    private CarDao carDao;

    @Override
    public void init() throws ServletException {
        super.init();
        proposalDao = new ProposalDao();
        carDao = new CarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        User user = (User) session.getAttribute("user");
        int userRole = user.getUserRole();

        if (userRole != 2 && userRole != 3) {
            response.sendRedirect("accessDenied.jsp");
            return;
        }

        try {
            List<Proposal> proposals = proposalDao.getAllProposals();

            Collections.sort(proposals, Comparator.comparingInt(Proposal::getId));

            request.setAttribute("proposals", proposals);
            request.getRequestDispatcher("proposalListAdmin.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException("Error fetching proposals", ex);
        }
    }
}
