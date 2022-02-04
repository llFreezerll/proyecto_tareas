package Model;

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

public class ConfigEmail {

    public static void EnviarCorreo(String host, String puerto, final String remitente, final String contrasena,
                                    String destinatario, String asunto, String mensaje) throws MessagingException {

        Properties propiedades = new Properties();

        propiedades.put("mail.smtp.host", host);
        propiedades.put("mail.smtp.port", puerto);
        propiedades.put("mail.smtp.auth", "true");
        propiedades.put("mail.smtp.starttls.enable", "true");

        Authenticator autenticar = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                if (remitente != null && contrasena != null && remitente.length()>0 && contrasena.length()>0){

                    return new PasswordAuthentication(remitente, contrasena);
                }

                return null;
        }
    };

    Session sesion = Session.getDefaultInstance(propiedades, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(remitente, contrasena);
        }
    });

        Message msg=new MimeMessage(Session.getDefaultInstance(propiedades,autenticar));

        msg.setFrom(new InternetAddress(remitente));

        InternetAddress[]direcciones= {new InternetAddress(destinatario)};

        msg.setRecipients(Message.RecipientType.TO, direcciones);
        msg.setSubject(asunto);
        msg.setSentDate(new Date());
        msg.setContent(mensaje,"text/html; charset=utf-8");

        Transport.send(msg);

}
}
