package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



//  GET 메소드는 서버로부터 데이터를 받아와야 하는 조회 요청에 사용되고, POST 메소드는 서버에 데이터를 보내야 하는 등록, 수정, 삭제 요청에 사용됩니다.

// 해당 클래스를 API의 진입점으로 만들어준다.
@RestController
public class CalculatorController {

    /* @RequestParam 1. HTTP 요청 파라미터를 받아오는 데 사용되는 어노테이션입니다.
                     2. 요청 파라미터는 HTTP GET, POST 등의 요청에서 파라미터 이름과 값으로 전송됩니다.
    */
    @GetMapping("/add") // GET /add
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }


    /**
     @RequestBody
      JSON 형식의 데이터를 요청 바디에 담아 서버에 전송하는 경우가 있습니다.
      이 경우 @RequestBody 어노테이션을 사용하여 JSON 형식의 데이터를 Java 객체로 변환할 수 있습니다.
     >> 사용하지 않을 경우, 폼 데이터를 사용합니다
     */
    @PostMapping("/multiply") // Post /multiply
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        return request.getNumber1() * request.getNumber2();
    }



}
