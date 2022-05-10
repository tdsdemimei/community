package com.tjw.demo;

import com.tjw.community.CommunityApplication;
import com.tjw.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


@SpringBootTest
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTest {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void test(){
        mailClient.sendMail("344380090@qq.com","test","welcome 欢迎");
    }

    @Test
    public void testHtml(){
        Context context = new Context();
        context.setVariable("username","唐唐");
        mailClient.sendMail("1794055180@qq.com","test","welcome 欢迎");
        String content = templateEngine.process("/mail/demo.html",context);
        System.out.println(content);
        mailClient.sendMail("344380090@qq.com","html",content);
    }
}
