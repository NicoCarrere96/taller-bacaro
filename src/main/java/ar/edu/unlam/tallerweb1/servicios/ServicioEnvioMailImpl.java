package ar.edu.unlam.tallerweb1.servicios;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import ar.edu.unlam.tallerweb1.modelo.Orden;
import ar.edu.unlam.tallerweb1.modelo.cliente.Cliente;
import ar.edu.unlam.tallerweb1.modelo.cliente.Reserva;
import ar.edu.unlam.tallerweb1.modelo.taller.Taller;

@Service("ServicioEnvioMail")
public class ServicioEnvioMailImpl implements ServicioEnvioMail{
	
	ServicioRepuesto servicioRepuesto;
	ServicioOrden servicioOrden;
	

	@Override
	public void enviarMail(Reserva reserva, Cliente cliente, Taller taller, Orden orden) {
		
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);

        mailSender.setUsername("buscotallerarg@gmail.com");
        mailSender.setPassword("tallerweb");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        MimeMessagePreparator preparator = mimeMessage -> {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo("el_basco@hotmail.com");
            message.setFrom("buscotallerArg@gmail.com");
            message.setSubject("Facturacion Reserva #"+reserva.getId());
            message.setText(GetBody(reserva,cliente,taller, orden), true);
        };
        mailSender.send(preparator);
        
      	}
	private String GetBody(Reserva reserva, Cliente cliente, Taller taller, Orden orden) {

		return "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
 			"<html>\r\n" + 
 			"  <head>\r\n" + 
 			"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n" + 
 			"    <meta name=\"x-apple-disable-message-reformatting\" />\r\n" + 
 			"    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" + 
 			"    <title></title>\r\n" + 
 			"    <style type=\"text/css\" rel=\"stylesheet\" media=\"all\">\r\n" + 
 			"    /* Base ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    @import url(\"https://fonts.googleapis.com/css?family=Nunito+Sans:400,700&display=swap\");\r\n" + 
 			"    body {\r\n" + 
 			"      width: 100% !important;\r\n" + 
 			"      height: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      -webkit-text-size-adjust: none;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    a {\r\n" + 
 			"      color: #3869D4;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    a img {\r\n" + 
 			"      border: none;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    td {\r\n" + 
 			"      word-break: break-word;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .preheader {\r\n" + 
 			"      display: none !important;\r\n" + 
 			"      visibility: hidden;\r\n" + 
 			"      mso-hide: all;\r\n" + 
 			"      font-size: 1px;\r\n" + 
 			"      line-height: 1px;\r\n" + 
 			"      max-height: 0;\r\n" + 
 			"      max-width: 0;\r\n" + 
 			"      opacity: 0;\r\n" + 
 			"      overflow: hidden;\r\n" + 
 			"    }\r\n" + 
 			"    /* Type ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    body,\r\n" + 
 			"    td,\r\n" + 
 			"    th {\r\n" + 
 			"      font-family: \"Nunito Sans\", Helvetica, Arial, sans-serif;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    h1 {\r\n" + 
 			"      margin-top: 0;\r\n" + 
 			"      color: #333333;\r\n" + 
 			"      font-size: 22px;\r\n" + 
 			"      font-weight: bold;\r\n" + 
 			"      text-align: left;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    h2 {\r\n" + 
 			"      margin-top: 0;\r\n" + 
 			"      color: #333333;\r\n" + 
 			"      font-size: 16px;\r\n" + 
 			"      font-weight: bold;\r\n" + 
 			"      text-align: left;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    h3 {\r\n" + 
 			"      margin-top: 0;\r\n" + 
 			"      color: #333333;\r\n" + 
 			"      font-size: 14px;\r\n" + 
 			"      font-weight: bold;\r\n" + 
 			"      text-align: left;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    td,\r\n" + 
 			"    th {\r\n" + 
 			"      font-size: 16px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    p,\r\n" + 
 			"    ul,\r\n" + 
 			"    ol,\r\n" + 
 			"    blockquote {\r\n" + 
 			"      margin: .4em 0 1.1875em;\r\n" + 
 			"      font-size: 16px;\r\n" + 
 			"      line-height: 1.625;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    p.sub {\r\n" + 
 			"      font-size: 13px;\r\n" + 
 			"    }\r\n" + 
 			"    /* Utilities ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .align-right {\r\n" + 
 			"      text-align: right;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .align-left {\r\n" + 
 			"      text-align: left;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .align-center {\r\n" + 
 			"      text-align: center;\r\n" + 
 			"    }\r\n" + 
 			"    /* Buttons ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .button {\r\n" + 
 			"      background-color: #3869D4;\r\n" + 
 			"      border-top: 10px solid #3869D4;\r\n" + 
 			"      border-right: 18px solid #3869D4;\r\n" + 
 			"      border-bottom: 10px solid #3869D4;\r\n" + 
 			"      border-left: 18px solid #3869D4;\r\n" + 
 			"      display: inline-block;\r\n" + 
 			"      color: #FFF;\r\n" + 
 			"      text-decoration: none;\r\n" + 
 			"      border-radius: 3px;\r\n" + 
 			"      box-shadow: 0 2px 3px rgba(0, 0, 0, 0.16);\r\n" + 
 			"      -webkit-text-size-adjust: none;\r\n" + 
 			"      box-sizing: border-box;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .button--green {\r\n" + 
 			"      background-color: #22BC66;\r\n" + 
 			"      border-top: 10px solid #22BC66;\r\n" + 
 			"      border-right: 18px solid #22BC66;\r\n" + 
 			"      border-bottom: 10px solid #22BC66;\r\n" + 
 			"      border-left: 18px solid #22BC66;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .button--red {\r\n" + 
 			"      background-color: #FF6136;\r\n" + 
 			"      border-top: 10px solid #FF6136;\r\n" + 
 			"      border-right: 18px solid #FF6136;\r\n" + 
 			"      border-bottom: 10px solid #FF6136;\r\n" + 
 			"      border-left: 18px solid #FF6136;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    @media only screen and (max-width: 500px) {\r\n" + 
 			"      .button {\r\n" + 
 			"        width: 100% !important;\r\n" + 
 			"        text-align: center !important;\r\n" + 
 			"      }\r\n" + 
 			"    }\r\n" + 
 			"    /* Attribute list ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .attributes {\r\n" + 
 			"      margin: 0 0 21px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .attributes_content {\r\n" + 
 			"      background-color: #F4F4F7;\r\n" + 
 			"      padding: 16px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .attributes_item {\r\n" + 
 			"      padding: 0;\r\n" + 
 			"    }\r\n" + 
 			"    /* Related Items ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .related {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 25px 0 0 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .related_item {\r\n" + 
 			"      padding: 10px 0;\r\n" + 
 			"      color: #CBCCCF;\r\n" + 
 			"      font-size: 15px;\r\n" + 
 			"      line-height: 18px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .related_item-title {\r\n" + 
 			"      display: block;\r\n" + 
 			"      margin: .5em 0 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .related_item-thumb {\r\n" + 
 			"      display: block;\r\n" + 
 			"      padding-bottom: 10px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .related_heading {\r\n" + 
 			"      border-top: 1px solid #CBCCCF;\r\n" + 
 			"      text-align: center;\r\n" + 
 			"      padding: 25px 0 10px;\r\n" + 
 			"    }\r\n" + 
 			"    /* Discount Code ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .discount {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 24px;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"      background-color: #F4F4F7;\r\n" + 
 			"      border: 2px dashed #CBCCCF;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .discount_heading {\r\n" + 
 			"      text-align: center;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .discount_body {\r\n" + 
 			"      text-align: center;\r\n" + 
 			"      font-size: 15px;\r\n" + 
 			"    }\r\n" + 
 			"    /* Social Icons ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .social {\r\n" + 
 			"      width: auto;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .social td {\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      width: auto;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .social_icon {\r\n" + 
 			"      height: 20px;\r\n" + 
 			"      margin: 0 8px 10px 8px;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"    }\r\n" + 
 			"    /* Data table ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .purchase {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 35px 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_content {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 25px 0 0 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_item {\r\n" + 
 			"      padding: 10px 0;\r\n" + 
 			"      color: #51545E;\r\n" + 
 			"      font-size: 15px;\r\n" + 
 			"      line-height: 18px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_heading {\r\n" + 
 			"      padding-bottom: 8px;\r\n" + 
 			"      border-bottom: 1px solid #EAEAEC;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_heading p {\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      color: #85878E;\r\n" + 
 			"      font-size: 12px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_footer {\r\n" + 
 			"      padding-top: 15px;\r\n" + 
 			"      border-top: 1px solid #EAEAEC;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_total {\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      text-align: right;\r\n" + 
 			"      font-weight: bold;\r\n" + 
 			"      color: #333333;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .purchase_total--label {\r\n" + 
 			"      padding: 0 15px 0 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    body {\r\n" + 
 			"      background-color: #F2F4F6;\r\n" + 
 			"      color: #51545E;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    p {\r\n" + 
 			"      color: #51545E;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-wrapper {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"      background-color: #F2F4F6;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-content {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"    }\r\n" + 
 			"    /* Masthead ----------------------- */\r\n" + 
 			"    \r\n" + 
 			"    .email-masthead {\r\n" + 
 			"      padding: 25px 0;\r\n" + 
 			"      text-align: center;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-masthead_logo {\r\n" + 
 			"      width: 94px;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-masthead_name {\r\n" + 
 			"      font-size: 16px;\r\n" + 
 			"      font-weight: bold;\r\n" + 
 			"      color: #A8AAAF;\r\n" + 
 			"      text-decoration: none;\r\n" + 
 			"      text-shadow: 0 1px 0 white;\r\n" + 
 			"    }\r\n" + 
 			"    /* Body ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    .email-body {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 0;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-body_inner {\r\n" + 
 			"      width: 570px;\r\n" + 
 			"      margin: 0 auto;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 570px;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"      background-color: #FFFFFF;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-footer {\r\n" + 
 			"      width: 570px;\r\n" + 
 			"      margin: 0 auto;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 570px;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"      text-align: center;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .email-footer p {\r\n" + 
 			"      color: #A8AAAF;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .body-action {\r\n" + 
 			"      width: 100%;\r\n" + 
 			"      margin: 30px auto;\r\n" + 
 			"      padding: 0;\r\n" + 
 			"      -premailer-width: 100%;\r\n" + 
 			"      -premailer-cellpadding: 0;\r\n" + 
 			"      -premailer-cellspacing: 0;\r\n" + 
 			"      text-align: center;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .body-sub {\r\n" + 
 			"      margin-top: 25px;\r\n" + 
 			"      padding-top: 25px;\r\n" + 
 			"      border-top: 1px solid #EAEAEC;\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    .content-cell {\r\n" + 
 			"      padding: 45px;\r\n" + 
 			"    }\r\n" + 
 			"    /*Media Queries ------------------------------ */\r\n" + 
 			"    \r\n" + 
 			"    @media only screen and (max-width: 600px) {\r\n" + 
 			"      .email-body_inner,\r\n" + 
 			"      .email-footer {\r\n" + 
 			"        width: 100% !important;\r\n" + 
 			"      }\r\n" + 
 			"    }\r\n" + 
 			"    \r\n" + 
 			"    @media (prefers-color-scheme: dark) {\r\n" + 
 			"      body,\r\n" + 
 			"      .email-body,\r\n" + 
 			"      .email-body_inner,\r\n" + 
 			"      .email-content,\r\n" + 
 			"      .email-wrapper,\r\n" + 
 			"      .email-masthead,\r\n" + 
 			"      .email-footer {\r\n" + 
 			"        background-color: #333333 !important;\r\n" + 
 			"        color: #FFF !important;\r\n" + 
 			"      }\r\n" + 
 			"      p,\r\n" + 
 			"      ul,\r\n" + 
 			"      ol,\r\n" + 
 			"      blockquote,\r\n" + 
 			"      h1,\r\n" + 
 			"      h2,\r\n" + 
 			"      h3 {\r\n" + 
 			"        color: #FFF !important;\r\n" + 
 			"      }\r\n" + 
 			"      .attributes_content,\r\n" + 
 			"      .discount {\r\n" + 
 			"        background-color: #222 !important;\r\n" + 
 			"      }\r\n" + 
 			"      .email-masthead_name {\r\n" + 
 			"        text-shadow: none !important;\r\n" + 
 			"      }\r\n" + 
 			"    }\r\n" + 
 			"    </style>\r\n" + 
 			"    <!--[if mso]>\r\n" + 
 			"    <style type=\"text/css\">\r\n" + 
 			"      .f-fallback  {\r\n" + 
 			"        font-family: Arial, sans-serif;\r\n" + 
 			"      }\r\n" + 
 			"    </style>\r\n" + 
 			"  <![endif]-->\r\n" + 
 			"  </head>\r\n" + 
 			"  <body>\r\n" + 
 			"    <span class=\"preheader\">BuscoTaller.com-</span>\r\n" + 
 			"    <table class=\"email-wrapper\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"      <tr>\r\n" + 
 			"        <td align=\"center\">\r\n" + 
 			"          <table class=\"email-content\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"            <tr>\r\n" + 
 			"              <td class=\"email-masthead\">\r\n" + 
 			"                <a href=\"http://localhost:8080/taller-bacaro\" class=\"f-fallback email-masthead_name\">\r\n" + 
 			"                Taller Bacaro\r\n" + 
 			"              </a>\r\n" + 
 			"              </td>\r\n" + 
 			"            </tr>\r\n" + 
 			"            <!-- Email Body -->\r\n" + 
 			"            <tr>\r\n" + 
 			"              <td class=\"email-body\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
 			"                <table class=\"email-body_inner\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"                  <!-- Body content -->\r\n" + 
 			"                  <tr>\r\n" + 
 			"                    <td class=\"content-cell\">\r\n" + 
 			"                      <div class=\"f-fallback\">\r\n" + 
 			"                        <h1>Hola "+reserva.getCliente().getNombre()+"!,</h1>\r\n" + 
 			"                        <h2>Enviamos su Factura</h2>\r\n" +  
 			"                        <p> Gracias por confiar en nosotros</p>\r\n\n" + 
 			"                        <p> Detalles:</p>\r\n" + 
 			"                        <p> Taller : "+reserva.getTaller().getNombreDelTaller()+"</p>\r\n" + 
 			"                        <p> Problema: "+reserva.getProblema()+"</p>\r\n\n" + 
 			"                        <p> Este correo contiene la factura correspondiente a su reserva </p>\r\n" + 
 			"                        <!-- Discount -->\r\n" + 
 			"                        <!-- Action -->\r\n" + 
 			"                        <table class=\"body-action\" align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"                          <tr>\r\n" + 
 			"                            <td align=\"center\">\r\n" + 
 			"                             \r\n" + 
 			"                              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\">\r\n" + 
 			"                                <tr>\r\n" + 
 			"                                  <td align=\"center\">\r\n" + 
 			"                                    <a href=\"http://localhost:8080/taller-bacaro/factura/getPdf?ordenId="+orden.getReserva().getId()+"\" class=\\\"f-fallback button button--green\\\" target=\\\"_blank\\\">Descargar Factura como PDF</a>\r\n" + 
 			"                                  </td>\r\n" + 
 			"                                </tr>\r\n" + 
 			"                              </table>\r\n" + 
 			"                            </td>\r\n" + 
 			"                          </tr>\r\n" + 
 			"                        </table>\r\n" + 
 			"                        <table class=\"discount\" align=\"center\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"                          <tr>\r\n" + 
 			"                            <td align=\"center\">\r\n" + 
 			"                              <h1 class=\"f-fallback discount_heading\">Encuentra todas tus reservas</h1>\r\n" + 
 			"                              <!-- Border based button\r\n" + 
 			"           https://litmus.com/blog/a-guide-to-bulletproof-buttons-in-email-design -->\r\n" + 
 			"                              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" role=\"presentation\">\r\n" + 
 			"                                <tr>\r\n" + 
 			"                                  <td align=\"center\">\r\n" + 
 			"                                    <a href=\"http://localhost:8080/taller-bacaro/reserva/cliente?dni="+reserva.getCliente().getDni()+"\" class=\"f-fallback button button--green\" target=\"_blank\">MIS RESERVAS</a>\r\n" + 
 			"                                  </td>\r\n" + 
 			"                                </tr>\r\n" + 
 			"                              </table>\r\n" + 
 			"                            </td>\r\n" + 
 			"                          </tr>\r\n" + 
 			"                        </table>\r\n" + 
 			"                        <table class=\"purchase\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"                          <tr>\r\n" + 
 			"                            <td>\r\n" + 
 			"                              <h3>Numero de Reserva: "+reserva.getId()+"</h3></td>\r\n" + 
 			"                            <td>\r\n" + 
 			"                          <tr>\r\n" + 
 			"                            <td colspan=\"2\">\r\n" + 
 			"                              <table class=\"purchase_content\" width=\"100%\" cellpadding=\"0\" cellspacing=\"0\">\r\n" + 
 			"                                <tr>\r\n" + 
 			"                                  <th class=\"purchase_heading\" align=\"left\">\r\n" + 
 			"                                    <p class=\"f-fallback\">Descripcion</p>\r\n" + 
 			"                                  </th>\r\n" + 
 			"                                  <th class=\"purchase_heading\" align=\"right\">\r\n" + 
 			"                                    <p class=\"f-fallback\"></p>\r\n" + 
 			"                                  </th>\r\n" + 
 			"                                </tr>\r\n" + 
 			"                                \r\n" + 
 			"                                <tr>\r\n" + 
 			"                                  <td width=\"80%\" class=\"purchase_item\"><span class=\"f-fallback\">"+reserva.getTaller().getNombreDelTaller()+", Telefono:#"+reserva.getTaller().getTelefono()+"</span></td>\r\n" + 
 			"                                </tr>\r\n" + 
 			"                                \r\n" + 
 			"                                <tr>\r\n" + 
 			"                                  <td width=\"80%\" class=\"purchase_footer\" valign=\"middle\">\r\n" + 
 			"                                    <p class=\"f-fallback purchase_total purchase_total--label\">Total a pagar</p>\r\n" + 
 			"                                  </td>\r\n" + 
 			"                                  <td width=\"20%\" class=\"purchase_footer\" valign=\"middle\">\r\n" + 
 			"                                    <p class=\"f-fallback purchase_total\">"+orden.getTotal()+"</p>\r\n" + 
 			"                                  </td>\r\n" + 
 			"                                </tr>\r\n" + 
 			"                              </table>\r\n" + 
 			"                            </td>\r\n" + 
 			"                          </tr>\r\n" + 
 			"                        </table>\r\n" + 
 			"                        <p>Para consultas referidas a facturacion por favor envienos un correo buscotallerarg@gmail.com</p>\r\n" + 
 			"                        <!-- Sub copy -->\r\n" + 
 			"                        <table class=\"body-sub\" role=\"presentation\">\r\n" + 
 			"                          <tr>\r\n" + 
 			"                            <td>\r\n" + 
 			"                            </td>\r\n" + 
 			"                          </tr>\r\n" + 
 			"                        </table>\r\n" + 
 			"                      </div>\r\n" + 
 			"                    </td>\r\n" + 
 			"                  </tr>\r\n" + 
 			"                </table>\r\n" + 
 			"              </td>\r\n" + 
 			"            </tr>\r\n" + 
 			"            <tr>\r\n" + 
 			"              <td>\r\n" + 
 			"                <table class=\"email-footer\" align=\"center\" width=\"570\" cellpadding=\"0\" cellspacing=\"0\" role=\"presentation\">\r\n" + 
 			"                  <tr>\r\n" + 
 			"                    <td class=\"content-cell\" align=\"center\">\r\n" + 
 			"                      <p class=\"f-fallback sub align-center\">&copy; 2019 Bacaro. Todos los derechos reservados.</p>\r\n" + 
 			"                      <p class=\"f-fallback sub align-center\">\r\n" + 
 			"                        []\r\n" + 
 			"                        <br>Florencio Varela 1903, B1754 San Justo, Buenos Aires\r\n" + 
 			"                        <br>Argentina\r\n" + 
 			"                      </p>\r\n" + 
 			"                    </td>\r\n" + 
 			"                  </tr>\r\n" + 
 			"                </table>\r\n" + 
 			"              </td>\r\n" + 
 			"            </tr>\r\n" + 
 			"          </table>\r\n" + 
 			"        </td>\r\n" + 
 			"      </tr>\r\n" + 
 			"    </table>\r\n" + 
 			"  </body>\r\n" + 
 			"</html>";
 	}

 }


