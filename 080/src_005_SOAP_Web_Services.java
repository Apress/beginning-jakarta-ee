package book.jakarta8.wsdate_client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import book.jakarta8.wsdate.generated.WsDate;
import book.jakarta8.wsdate.generated.WsDateService;

@WebServlet(name = "WsDateServlet", 
      urlPatterns = { "/WsDateServlet" })
public class WsDateServlet extends HttpServlet {
    private static final long serialVersionUID = 
        -1651237748783635642L;

    @WebServiceRef(wsdlLocation = 
        "http://localhost:8080/wsdate/WsDateService?wsdl")
    private WsDateService service;

    private 
    void processRequest(HttpServletRequest request, 
          HttpServletResponse response)
          throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      try (PrintWriter out = response.getWriter()) {
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<title>Servlet WsDateServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Servlet WsDateServlet at " + 
            request.getContextPath() + "</h1>");
        out.println("<p>" + date("yyyy-MM-dd HH:mm:ss") + 
            "</p>");
        out.println("</body>");
        out.println("</html>");
      }
    }

    @Override
    protected void doGet(HttpServletRequest request,  
          HttpServletResponse response)
          throws ServletException, IOException {
      processRequest(request, response);
    }

    private String date(String dateFormat) {
      WsDate port = service.getWsDatePort();
      return port.date(dateFormat);
    }
}
