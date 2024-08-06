package controller;

import dao.ProposalWithCarDao;
import model.ProposalWithCarDetails;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/proposalListUser")
public class ProposalListUserServlet extends HttpServlet {
    private ProposalWithCarDao proposalDao;

    @Override
    public void init() throws ServletException {
        super.init();
        proposalDao = new ProposalWithCarDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        if (user != null) {
            int userId = user.getId();
            try {
                List<ProposalWithCarDetails> proposals = proposalDao.getProposalsWithCarDetailsByUserId(userId);

                request.setAttribute("proposals", proposals);
                request.getRequestDispatcher("/proposalListUser.jsp").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
                request.setAttribute("errorMessage", "Error fetching proposals: " + e.getMessage());
                request.getRequestDispatcher("/error.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
