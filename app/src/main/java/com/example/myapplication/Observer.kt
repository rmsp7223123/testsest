package com.example.myapplication

class Thermometer { // Subject 온도를 저장하고, 온도가 변경될 때 옵저버들에게 알림을 보내는 역할
    private var temperature: Float = 0f;

    fun setTemperature(temperature: Float) { // 온도를 설정하고 알람보내기
        this.temperature = temperature;
        notifyObservers();
    };

    fun getTemperature(): Float {
        return temperature;
    };

    private val observers = mutableListOf<Observer>();

    fun addObserver(observer: Observer) {
        observers.add(observer);
    };

    fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature);
        };
    };
};

interface Observer { // 옵저버가 구현해야 하는 메서드를 정의
    fun update(temperature: Float);
};

class TemperatureDisplay : Observer { // 구체적인 옵저버 역할
    override fun update(temperature: Float) { // 온도 업데이트에 대한 동작을 정의
        println("Temperature updated: $temperature");
    };
};

fun main() {
    val thermometer = Thermometer(); // Thermometer 객체를 생성
    val display1 = TemperatureDisplay(); // TemperatureDisplay 객체 두 개를 옵저버로 등록
    val display2 = TemperatureDisplay();

    thermometer.addObserver(display1);
    thermometer.addObserver(display2);

    thermometer.setTemperature(25.5f);
    thermometer.setTemperature(30.2f);
};