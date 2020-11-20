package WEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;


//普通用户的下载Servlet
public class DownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求以及响应的内容类型以及编码方式
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        // 打开文件
        // 获取到要下载文件的全路径
        // 得到要下载的文件名
        String fileName = request.getSession().getAttribute("fileName").toString();

        // 得到要下载的文件的所在目录
        String uploadpath = request.getSession().getAttribute("uploadPath").toString();

        // 得到要下载的文件
        File file = new File(uploadpath + "/" + fileName);

        //如果文件不存在，则显示下载失败
        if (!file.exists() || file == null) {
            request.setAttribute("message", "下载失败,文件不存在");
            request.getRequestDispatcher("/Messages/message5.jsp").forward(request, response);
            return;
        } else {

            // 设置相应头，控制浏览器下载该文件，这里就是会出现当你点击下载后，出现的下载地址框
            response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
            // 读取要下载的文件，保存到文件输入流
            FileInputStream in = new FileInputStream(file);
            // 创建输出流
            OutputStream out = response.getOutputStream();
            // 创建缓冲区
            byte buffer[] = new byte[1024];
            int len = 0;
            // 循环将输入流中的内容读取到缓冲区中
            while ((len = in.read(buffer)) > 0) {
                // 输出缓冲区内容到浏览器，实现文件下载
                out.write(buffer, 0, len);
            }
            // 关闭文件流
            in.close();
            // 关闭输出流
            out.close();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
