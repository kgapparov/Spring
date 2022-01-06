package com.luv2code.aopdemo;

import com.luv2code.aopdemo.dao.AccountDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationDemo.class);
        AccountDao account = context.getBean(AccountDao.class);
        account.addAccount();
        account.setName("Foobar");
        account.getName();
        account.setServiceCode("sivler");
        account.getServiceCode();
        context.close();
    }
}
