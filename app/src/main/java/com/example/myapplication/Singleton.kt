package com.example.myapplication

object Singleton { // 싱글톤 객체를 정의 , 클래스로 선언되지 않고 바로 싱글톤으로 사용

    init{ // 싱글톤 객체가 처음 생성될 때, 초기화 코드를 실행
        println("created");
    };

    fun doSomething() {
        println("doing something");
    };
}

fun main() { // 싱글톤 객체에 두번 접근, 첫번째 접근시 객체가 초기화 되고, 이후 호출에서는 같은 객체에 접근
    Singleton.doSomething();

    Singleton.doSomething();
}