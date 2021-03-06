package it.unitn.disi.buybuy.auth;

import java.util.Date;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

    private final String HOST = "";
    private final String PORT = "";
    private final String USERNAME = "";
    private final String PASSWORD = "";
    private final Session session;
    private Properties sysProperties;

    public EmailUtil() {
        sysProperties = new Properties();
        sysProperties.setProperty("mail.smtp.host", this.HOST);
        sysProperties.setProperty("mail.smtp.port", this.PORT);
        sysProperties.setProperty("mail.smtp.socketFactory.port", this.PORT);
        sysProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        sysProperties.setProperty("mail.smtp.auth", "true");
        sysProperties.setProperty("mail.smtp.starttls.enable", "true");
        this.session = Session.getInstance(sysProperties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });
    }

    /**
     * Send an email with HTML content.
     *
     * @param recipient email address of the recipient
     * @param subject subject of the email to send
     * @param text HTML content of the email
     * @throws javax.mail.MessagingException
     */
    public void sendEmail(String recipient, String subject, String text) throws MessagingException {
        Message msg = new MimeMessage(this.session);
        msg.setFrom(new InternetAddress(this.USERNAME));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient, false));
        msg.setSubject(subject);
        msg.setContent(text, "text/html; charset=utf-8");
        msg.setSentDate(new Date());
        Transport.send(msg);
    }
    
    /**
     * Checks if email address is well-formed.
     * 
     * @param email the email address to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        boolean isValid = true;
        try {
            InternetAddress internetAddress = new InternetAddress(email);
            internetAddress.validate();
        } catch (AddressException e) {
            isValid = false;
        }
        return isValid;
    }

}
