package com.raising.modules.PersonUser.service;

import com.sun.mail.util.MailSSLSocketFactory;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

//import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.List;
import java.util.Properties;


@Service("mailService")
public class MailService {
    @Value("${spring.mail.username}")
    private String from;
    @Autowired
    private JavaMailSender mailSender;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    public Boolean sendSimpleMail(String to, String title, String content) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom(from);
//        message.setTo(to);
//        message.setSubject(title);
//        message.setText(content);
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();

            sf.setTrustAllHosts(true);
            Properties props = new Properties();
            props.setProperty("mail.debug", "true");
            // 发送服务器需要身份验证
            props.setProperty("mail.smtp.auth", "true");
// 发送邮件协议名称
            props.setProperty("mail.transport.protocol", "smtp");

            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.ssl.socketFactory", sf);
            props.setProperty("mail.smtp.host", "smtp.qq.com");
            Session session = null;
            session = Session.getDefaultInstance(props, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("1959915747@qq.com", "eskpkpfwghuddjgj");
                }
            });
            Message message1 = new MimeMessage(session);
            message1.setFrom(new InternetAddress("1959915747@qq.com"));
            message1.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(to));
            message1.setSubject(title);
            message1.setContent(content, "text/html;charset=UTF-8");
            Transport.send(message1);
//        mailSender.send(message);
            logger.info("邮件发送成功");
            return true;
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

//    public void sendAttachmentsMail(String to, String title, String cotent, List<File> fileList){
//        MimeMessage message = mailSender.createMimeMessage();
//        try {
//            MimeMessageHelper helper = new MimeMessageHelper(message,true);
//            helper.setFrom(from);
//            helper.setTo(to);
//            helper.setSubject(title);
//            helper.setText(cotent);
//            String fileName = null;
//            for (File file:fileList) {
//                fileName = MimeUtility.encodeText(file.getName(), "GB2312", "B");
//                helper.addAttachment(fileName, file);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mailSender.send(message);
//        logger.info("邮件发送成功");
//    }


}
