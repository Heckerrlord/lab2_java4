package servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.Part;
import org.apache.commons.io.IOUtils;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.*;
import java.util.Properties;
@MultipartConfig
@WebServlet("/sendMail")
public class SendmailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("views/sendMail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String messages = request.getParameter("message");
        Part files = request.getPart("file");

        String account = "thinhlhph19459@fpt.edu.vn";
        String passWord = "yytvkzzfliaystco";


        String fileName = files.getSubmittedFileName();
        InputStream fileContent = files.getInputStream();
        String upPart = "D:/uploads";
        File target = new File(upPart + "/" + fileName);
        OutputStream outputStream = new FileOutputStream(target);
        IOUtils.copy(fileContent, outputStream);
        outputStream.close();

        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(account, passWord);
            }
        });
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(account));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);

            BodyPart part = new MimeBodyPart();
            part.setText(messages);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(part);

            part = new MimeBodyPart();
            DataSource source = new FileDataSource(upPart + "/" +fileName);
            part.setDataHandler(new DataHandler(source));
            part.setFileName(fileName);
            multipart.addBodyPart(part);


            message.setContent(multipart);

            Transport.send(message);
            request.setAttribute("alert","Send mail successfully!");
        } catch (MessagingException e) {
            System.out.println(e);
            request.setAttribute("alert","Send mail failed!");
            e.printStackTrace();
        }
        request.getRequestDispatcher("/views/sendMail.jsp").forward(request,response);
    }
}

