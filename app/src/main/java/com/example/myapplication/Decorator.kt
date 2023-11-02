package com.example.myapplication

// Component interface
interface Coffee { // 기본기능을 정의
    fun cost(): Int;
    fun description(): String;
};

// ConcreteComponent
class SimpleCoffee : Coffee { // 인터페이스를 구현하는 실제 객체
    override fun cost(): Int {
        return 5;
    };

    override fun description(): String {
        return "Simple Coffee";
    };
};

// Decorator
abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee { //  Component 인터페이스를 구현
    override fun cost(): Int {
        return decoratedCoffee.cost();
    };

    override fun description(): String {
        return decoratedCoffee.description();
    };
};

// ConcreteDecorator
class Milk(coffee: Coffee) : CoffeeDecorator(coffee) { //  Decorator를 상속하고, 새로운 동작을 추가하거나 확장하는 구체적인 데코레이터
    override fun cost(): Int {
        return super.cost() + 2;
    };

    override fun description(): String {
        return super.description() + ", Milk";
    };
};

class Sugar(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun cost(): Int {
        return super.cost() + 1;
    };

    override fun description(): String {
        return super.description() + ", Sugar";
    };
};

fun main() {
    // 기본 커피
    val coffee: Coffee = SimpleCoffee();
    println("Cost: ${coffee.cost()}, Ingredients: ${coffee.description()}");

    // 우유 추가한 커피
    val milkCoffee: Coffee = Milk(coffee);
    println("Cost: ${milkCoffee.cost()}, Ingredients: ${milkCoffee.description()}");

    // 설탕 추가한 커피
    val sweetCoffee: Coffee = Sugar(coffee);
    println("Cost: ${sweetCoffee.cost()}, Ingredients: ${sweetCoffee.description()}");
};