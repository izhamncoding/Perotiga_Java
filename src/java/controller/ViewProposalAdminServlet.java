package controller;

import dao.ProposalDao;
import model.Proposal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/viewProposalAdmin")
public class ViewProposalAdminServlet extends HttpServlet {
    private ProposalDao proposalDao;

    @Override
    public void init() throws ServletException {
        super.init();
        proposalDao = new ProposalDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proposalId = Integer.parseInt(request.getParameter("id"));

        Proposal proposal = null;
        try {
            proposal = proposalDao.getProposalById(proposalId);
        } catch (SQLException ex) {
            throw new ServletException("Error fetching proposal details", ex);
        }

        if (proposal != null) {
            request.setAttribute("proposal", proposal);
            request.getRequestDispatcher("viewProposalDetailsAdmin.jsp").forward(request, response);
        } else {
            response.sendRedirect("proposalListAdmin");
        }
    }
}
