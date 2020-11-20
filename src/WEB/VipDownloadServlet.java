package WEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

//VIP用户的下载Servlet
public class VipDownloadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

            /*VIP特权*/
            //此方法底层byte[]大小为8192,比普通用户的1024大,应该可以快一点
            IOUtils.copy(in , out);
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

}
