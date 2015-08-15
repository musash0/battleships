package com.example.techhuddle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

public class BattleshipGame {

  public static void main(String[] args) {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    NewPrintClass newPrintClass = (NewPrintClass) applicationContext.getBean("newPrintClass");
    newPrintClass.print();
  }

  public int getOne() {
    return 1;
  }
}
