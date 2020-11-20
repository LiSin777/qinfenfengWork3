package WEB;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置请求编码
        request.setCharacterEncoding("utf-8");

        //获取服务端用于存储文件的目录,我定义在web下MyFiles中方便查看
        File folder = new File("Z:/javaPro/JavaWeb文件上传下载/web/MyFiles");
        //判断文件夹是否存在，没有就创建
        if(!folder.exists() && !folder.isDirectory()){
            folder.mkdir();
        }

        //获取一个文件单元,ServletFileUpload用不了只能退而求其次
        Part part = request.getPart("myfile");
        //获取文件类型
        String type = part.getContentType();
        //文件大小
        long size = part.getSize();
        //文件名
        String fname = part.getSubmittedFileName();
        //如果未选择文件，直接点上传就报错
        if(fname.equals("")){
            request.setAttribute("message" , "文件不存在");
            request.getRequestDispatcher("/Messages/message4.jsp").forward(request , response);
        }else {
            //存储到服务器即我创建的MyFiles
            part.write("Z:/javaPro/JavaWeb文件上传下载/web/MyFiles/" + fname);
            //用于传给下载的Sesrvlet使用即DownloadServlet
            request.getSession().setAttribute("fileName" , fname);
            request.getSession().setAttribute("uploadPath" , "Z:/javaPro/JavaWeb文件上传下载/web/MyFiles");

            //用于传给vipdownload.jsp来展示给用户看文件的信息
            request.getSession().setAttribute("fname" , fname);
            request.getSession().setAttribute("type" , type);
            request.getSession().setAttribute("size" , size);

            //跳转到判断是否是vip
            request.getRequestDispatcher("isvip.jsp").forward(request , response);
        }



    }
}


