package com.example.myapplication

class Factory {
    fun createProduct(type : String) : Product {
        return when(type) {
            "A" -> ConcreteProductA();
            "B" -> ConcreteProductB();
            else -> throw IllegalArgumentException("Invalid product type");
        };
    };
};

interface Product { // 제품 객체들이 구현해야 하는 메서드를 정의
    fun operation();
}



class ConcreteProductA : Product { // operation 메서드를 구현하여 자신의 특정 동작을 정의
    override fun operation() {
        println("Product A operation");
    }
}

class ConcreteProductB : Product {  // operation 메서드를 구현하여 자신의 특정 동작을 정의
    override fun operation() {
        println("Product B operation");
    }
}

fun main() { // Factory 클래스를 사용하여 제품을 생성하고 해당 제품의 operation 메서드를 호출
    val factory = Factory()
    val productA = factory.createProduct("A");
    productA.operation();

    val productB = factory.createProduct("B");
    productB.operation();
}