import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TaxServlet")
public class TaxServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String incomeStr = request.getParameter("income");

        double income;
        String errorMessage = null;
        double tax = 0;

        try {
            income = Double.parseDouble(incomeStr);

            if (income < 0) {
                errorMessage = " Income cannot be negative.";
            } else {
                // Tax calculation (simple slabs)
                if (income <= 250000) {
                    tax = 0;
                } else if (income <= 500000) {
                    tax = (income - 250000) * 0.05;
                } else if (income <= 1000000) {
                    tax = (250000 * 0.05) + (income - 500000) * 0.2;
                } else {
                    tax = (250000 * 0.05) +
                          (500000 * 0.2) +
                          (income - 1000000) * 0.3;
                }
            }

        } catch (NumberFormatException e) {
            errorMessage = " Please enter a valid number.";
            income = 0;
        }

        request.setAttribute("income", income);
        request.setAttribute("tax", tax);
        request.setAttribute("error", errorMessage);

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}