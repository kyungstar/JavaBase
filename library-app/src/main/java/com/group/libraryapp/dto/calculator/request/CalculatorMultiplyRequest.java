package com.group.libraryapp.dto.calculator.request;

public class CalculatorMultiplyRequest {

    // 멤버 변수 선언
    private final int number1; // 불변성을 위해 final 키워드 사용
    private final int number2; // 불변성을 위해 final 키워드 사용

    // 생성자
    public CalculatorMultiplyRequest(int number1, int number2) {
        this.number1 = number1; // number1 값 할당
        this.number2 = number2; // number2 값 할당
    }

    // number1 멤버 변수의 값을 반환하는 getter 메서드
    public int getNumber1() {
        return number1;
    }

    // number2 멤버 변수의 값을 반환하는 getter 메서드
    public int getNumber2() {
        return number2;
    }

}
