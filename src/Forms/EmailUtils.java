/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Forms;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author Lenovo
 */
public class EmailUtils {
    public static void sendWelcomeEmail(String recipientEmail) {
        String subject = "Welcome to Our Application!";
        String message = "Dear User,\n\nThank you for registering with us.\n\nBest Regards,\nYour Application Team";

        try {
            String fromEmail = "sree123assignment@gmail.com";
            String password = "rgha piqd gbng wacq";
            String smtpHost = "smtp.gmail.com";
            int smtpPort = 465;

            Properties properties = new Properties();
            properties.put("mail.smtp.auth", "true");

            if (smtpPort == 465) {
                properties.put("mail.smtp.ssl.enable", "true");
            } else {
                properties.put("mail.smtp.starttls.enable", "true");
            }
            
            properties.put("mail.smtp.host", smtpHost);
            properties.put("mail.smtp.port", smtpPort);
            properties.put("mail.debug", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
            msg.setSubject(subject);
            msg.setText(message);

            Transport.send(msg);
            System.out.println("Welcome email sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Error sending welcome email: " + e.getMessage());
        }
    }
    
}
