package com.example.battleships;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
