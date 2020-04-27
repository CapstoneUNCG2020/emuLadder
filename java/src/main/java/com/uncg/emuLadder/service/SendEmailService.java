package com.uncg.emuLadder.service;

import com.uncg.emuLadder.enums.ResponseStatusType;
import com.uncg.emuLadder.model.request.SendEmailRequestData;
import com.uncg.emuLadder.model.response.ResponseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Service class for Sign In operations.
 * using gmail account and javaMail api
 */
@Component
public class SendEmailService implements IService<SendEmailRequestData, ResponseData<Boolean>> {

    private final Logger logger = LoggerFactory.getLogger((getClass()));

    private final String from = "EmuLadder@gmail.com";
    private final String password = "willchange1234";

    @Override
    public ResponseData<Boolean> service(SendEmailRequestData requestData) {
        ResponseData<Boolean> responseData = new ResponseData<>();

        logger.info("Request data: {}", requestData);

        //seting up smtp properties for gmail account
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        //TLS Port provided by google
        properties.put("mail.smtp.port", "587");
        //Enables auth and starttls
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        //Authenticator object to pass to session
        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        //creates session to get properties
        Session session = Session.getDefaultInstance(properties, auth);
        //sendEmail(session);
        try {
            //mimeMessage object
            MimeMessage message = new MimeMessage(session);

            //Set from--> adding from email
            message.setFrom(new InternetAddress(from));

            //Set to--> adding to email
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(requestData.getRecipient()));


            //Set subject of email--> subject to change
            message.setSubject(requestData.getSubject());
            message.setContent(requestData.getContent(), "text/html;  charset=utf-8");
            //BodyPart messageBodyPart = new MimeBodyPart();
            //set sent date
            //messageBodyPart.setText(body);

            //Send email
            Transport.send(message);

            responseData.setResponse(true);
            responseData.setStatus(ResponseStatusType.SUCCESS.name());
        } catch (MessagingException e) {
            responseData.setResponse(false);
            responseData.setStatus(ResponseStatusType.ERROR.name());
            logger.info("requestData: {}", requestData);
        }


        return responseData;
    }
}
