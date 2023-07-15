package servlet;


import jakarta.servlet.*;
import jakarta.servlet.http.*;
import model.Staff;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

@MultipartConfig
@WebServlet("/staff")
public class StaffServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/staff/form.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("dd/MM/yyy");
            ConvertUtils.register(dtc, Date.class);

            Staff staff = new Staff();
            BeanUtils.populate(staff, request.getParameterMap());
            String message = Arrays.toString(staff.getHobbies());

            File dir = new File(request.getServletContext().getRealPath("/files"));
            Part photo = request.getPart("avt_img");
            File photoFile = new File(dir, photo.getSubmittedFileName());
            photo.write(photoFile.getAbsolutePath());
            staff.setAvatar(photoFile.getName());

            if (staff.getAvatar() == null) {
                request.setAttribute("alert", "Vui lòng chọn avatar");
            }
            if (staff.getHobbies() == null) {
                request.setAttribute("hobbies", "Bí mật");
            } else {
                request.setAttribute("hobbies", message);

            }
            String marriedStatus = staff.isMarried() ? "Đã kết hôn" : "Ế mòn đít";
            request.setAttribute("married", marriedStatus);
            request.setAttribute("gender", staff.isGender() == true ? "Nam" : "Nữ");
            request.setAttribute("bean", staff);
        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("views/staff/form.jsp").forward(request, response);
        }
        request.getRequestDispatcher("views/staff/resultForm.jsp").forward(request, response);
    }

}

