package com.group.libraryapp.user;

public class User {

    private String name;

    /*
     Integer는 int를 래핑한(wrapper) 클래스로, int의 기능을 그대로 갖고 있습니다.
     또한, Integer는 객체(object)로 취급되기 때문에, 객체 지향 프로그래밍에서 유용하게 사용됩니다.
     예를 들어, List<Integer>와 같이 int를 저장하는 자료구조에 사용됩니다.
     Integer와 int의 또 다른 차이점은 null의 처리입니다. int는 기본 자료형이기 때문에 null 값을 가질 수 없습니다.
     반면에 Integer는 객체이기 때문에 null 값을 가질 수 있습니다. 이를 이용해 값이 없을 때 null을 반환하는 경우에 사용됩니다.
     */

    private Integer age;

    public User(String name, Integer age) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 name(%s)이 들어왔습니다", name));
        }

        this.name = name;
        this.age = age;

    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
