package dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vo.EmailVO;

public class EmailDAO {
	
   public int email(EmailVO vo) {

//      String host = "smtp.gmail.com"; // 사용할 사이트
//      final String user = "아이디@gmail.com"; // ID
//      final String password = "구글 2차 비밀번호 or 비밀번호"; // PW
//
//      String to = "보낼 이메일 주소"; // 보낼 이메일 주소
      
      String host = "smtp.naver.com"; // 사용할 사이트
      final String user = "tyk0721@naver.com"; // 보내는 사람(일반회원)의 아이디로 고정
      final String password = "1qaz1qaz**"; // PW
      
      String to = vo.getEmailAddress(); // 받는사람 이메일 주소(중개사 아이디를 받아옴)


      // Get the session object
      Properties props = new Properties();
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.port", "587");
      props.put("mail.smtp.ssl.protocols", "TLSv1.2");

      Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(user, password);
         }
      });

      // Compose the message
      try {
         MimeMessage message = new MimeMessage(session);
         message.setFrom(new InternetAddress(user));
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // 제목
         message.setSubject(vo.getTitle());

         // 내용
         message.setText(vo.getCdate()+vo.getContent());

         // send the message
         Transport.send(message);
         System.out.println("로그: 이메일 전송 성공!");
         
         return 1;

      } catch (MessagingException e) {
         e.printStackTrace();
         return 0;
      }
   }
}