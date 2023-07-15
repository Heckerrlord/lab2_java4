package servlet;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/upload.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File dir = new File(request.getServletContext().getRealPath("/files"));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        try {
            Part photo = request.getPart("img");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());

            Part doc = request.getPart("doc");
            File docFile = new File(dir, doc.getSubmittedFileName());
            doc.write(docFile.getAbsolutePath());

            request.setAttribute("img", photoFile);
            request.setAttribute("doc", docFile);
            request.getRequestDispatcher("/views/result.jsp").forward(request, response);
        } catch (IOException e) {
            request.setAttribute("message", "Bạn chưa chọn đủ file!");
            e.printStackTrace();
            request.getRequestDispatcher("/views/upload.jsp").forward(request, response);
        }
    }

}