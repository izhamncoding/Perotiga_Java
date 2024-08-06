package controller;

import dao.ProposalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/deleteProposal")
public class DeleteProposalServlet extends HttpServlet {
    private ProposalDao proposalDao;

    @Override
    public void init() throws ServletException {
        super.init();
        proposalDao = new ProposalDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proposalId = Integer.parseInt(request.getParameter("id"));

        try {
            proposalDao.deleteProposalById(proposalId);
            response.sendRedirect("proposalListAdmin");
        } catch (SQLException ex) {
            throw new ServletException("Error deleting proposal", ex);
        }
    }
}
