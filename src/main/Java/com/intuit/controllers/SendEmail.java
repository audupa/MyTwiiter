package com.intuit.controllers;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;



public class SendEmail {

    private SendEmail sendMail;

    public void setSendMail(SendEmail sendMail) {
        this.sendMail = sendMail;
    }

    public static void main(String[] args) {
// Collect the necessary information to send a simple message
// Make sure to replace the values for host, to, and from with
// valid information.
// host - must be a valid smtp server that you currently have
// access to.
// to - whoever is going to get your email
// from - whoever you want to be. Just remember that many smtp
// servers will validate the domain of the from address
// before allowing the mail to be sent.
        String host = "mail.sdg.ie.intuit.com";
        String to = " Utpal_Sarkar@intuit.com";
        String from = "SecretSanta@northpole.com";
        String subject = "Ho Ho Ho";
        String messageText = "Hi Utpal,\n"
                + "Merry Christmas..It's me ,Santa! :)";
        boolean sessionDebug = false;
// Create some properties and get the default Session.
        Properties props = System.getProperties();
        props.put("mail.host", host);
        props.put("mail.transport.protocol", "smtp");
        Session session = Session.getDefaultInstance(props, null);
// Set debug on the Session so we can see what is going on
// Passing false will not echo debug info, and passing true
// will.
        session.setDebug(sessionDebug);
        try {
// Instantiate a new MimeMessage and fill it with the
// required information.
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(messageText);
// Hand the message to the default transport service
// for delivery.
            Transport.send(msg);
        }
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}





