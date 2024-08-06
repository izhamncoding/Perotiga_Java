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

@WebServlet("/editProposalAdmin")
public class EditProposalAdminServlet extends HttpServlet {
    private ProposalDao proposalDao;

    @Override
    public void init() throws ServletException {
        super.init();
        proposalDao = new ProposalDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proposalId = Integer.parseInt(request.getParameter("id"));
        
        try {
            Proposal proposal = proposalDao.getProposalById(proposalId);
            request.setAttribute("proposal", proposal);
            request.getRequestDispatcher("editProposalAdmin.jsp").forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException("Error fetching proposal details", ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int proposalId = Integer.parseInt(request.getParameter("proposalId"));
        String action = request.getParameter("action");
        
        try {
            Proposal proposal = proposalDao.getProposalById(proposalId);
            if ("approve".equals(action)) {
                proposal.setStatus("Approved");
            } else if ("reject".equals(action)) {
                proposal.setStatus("Rejected");
            }
            proposalDao.updateProposal(proposal);
            response.sendRedirect("proposalListAdmin");
        } catch (SQLException ex) {
            throw new ServletException("Error updating proposal status", ex);
        }
    }
}
