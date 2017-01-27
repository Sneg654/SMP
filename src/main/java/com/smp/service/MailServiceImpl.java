package com.smp.service;

import com.smp.model.StateStore;
import com.smp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;

/**
 * Created by Sergey_Stefoglo on 1/18/2017.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    private final String TR = "<TR>";
    private final String TD = "<TD>";
    private final String TR_F = "</TR>";
    private final String TD_F = "</TD>";
    @Autowired
    JavaMailSender mailSender;
    StringBuilder stringBuilder;


    @Autowired
    UserService userService;

    @Override
    public void sendEmail() {


        MimeMessagePreparator preparator = getMessagePreparator();

        try {
            mailSender.send(preparator);
            System.out.println("Message Send...Hurrey");
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void messageBodyFrom(String orgName, List<StateStore> stateStoreList) {
        stringBuilder = new StringBuilder();
        stringBuilder.append("Ситуация на складе: " + orgName).append("<br/>")
                .append("<table border='1'> ").append(TR)
                .append(TD).append("Номенклатура").append(TD_F)
                .append(TD).append("Код").append(TD_F)
                .append(TD).append("Количество").append(TD_F)
                .append(TD).append("Цена").append(TD_F)
                .append(TD).append("Необходимо заказать").append(TD_F)
                .append(TD).append("Поставщик").append(TD_F).append(TR_F);


        for (StateStore store : stateStoreList) {
            stringBuilder.append(TR)
                    .append(TD).append(store.getName()).append(TD_F)
                    .append(TD).append(store.getNomeclatureID()).append(TD_F)
                    .append(TD).append(store.getCount()).append(TD_F)
                    .append(TD).append(store.getCost()).append(TD_F)
                    .append(TD).append(((int) (store.getMax() - store.getCount())) / store.getFold()).append(TD_F)
                    .append(TD).append(store.getProviderId()).append(TD_F).append(TR_F);
        }

        stringBuilder.append("</table>");


    }

    private MimeMessagePreparator getMessagePreparator() {
        User user = userService.findByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        MimeMessagePreparator preparator = new MimeMessagePreparator() {

            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom("customerserivces@yourshop.com");
                mimeMessage.setRecipient(Message.RecipientType.TO,
                        new InternetAddress(user.getEmail()));
                mimeMessage.setText(stringBuilder.toString(), "utf-8", "html");
                mimeMessage.setSubject("Информация по складу");
            }
        };
        return preparator;
    }

}
