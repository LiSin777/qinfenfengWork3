package WEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import java.io.IOException;

//选择是vip下载还是普通下载
public class SelectDownloadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String identity = request.getParameter("vip");

        if("yes".equals(identity)){
            request.getRequestDispatcher("/admin/vipdownload.jsp").forward(request , response);
        }else {
            request.getRequestDispatcher("/admin/download.jsp").forward(request , response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
