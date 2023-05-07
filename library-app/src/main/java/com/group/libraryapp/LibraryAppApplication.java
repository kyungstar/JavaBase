package com.group.libraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// @SpringBootApplication: 이 어노테이션은 스프링 부트 애플리케이션의 메인 클래스에 추가됩니다.
// 이것은 @Configuration, @EnableAutoConfiguration, @ComponentScan 어노테이션을 합친 것입니다.
// @Configuration 어노테이션은 스프링의 설정 파일임을 나타냅니다.
// @EnableAutoConfiguration 어노테이션은 스프링 부트의 자동 설정을 활성화합니다.
// @ComponentScan 어노테이션은 스프링이 애플리케이션에서 @Component 어노테이션이 지정된 클래스를 찾도록 합니다.
@SpringBootApplication
// 이 클래스는 LibraryAppApplication이라는 이름의 public 클래스입니다. 이 클래스는 스프링 부트 애플리케이션의 메인 클래스 역할을 합니다.
public class LibraryAppApplication {

  // 자바 프로그램이 시작될 때 가장 먼저 실행되는 메소드입니다.
  public static void main(String[] args) {


    // 이 메소드는 LibraryAppApplication 클래스를 기반으로 스프링 부트 애플리케이션을 시작합니다.
    // 이 메소드의 두 번째 인자인 args는 프로그램 실행 시 커맨드 라인에서 전달되는 인자를 받습니다.
    SpringApplication.run(LibraryAppApplication.class, args);


  }

}
