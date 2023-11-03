package com.example.myapplication

interface Command { // 메소드 선언
    fun excute();
};

class LightOnCommand(private val light : Light) : Command{ // Concrete Command
    override fun excute() {
        light.turnOn();
    };
};

class LightOffCommand(private val light : Light) : Command{ // Concrete Command
    override fun excute() {
        light.turnOff();
    };
};

class Light { // Receiver
    fun turnOn() {
        println("Light is ON")
    };

    fun turnOff() {
        println("Light is OFF")
    };
};

class RemoteControl { // Invoker 명령을 실행하는 역할
    private lateinit var command: Command;

    fun setCommand(command: Command) {
        this.command = command;
    };

    fun pressButton() {
        command.excute();
    };
};

fun main() {
    // 수신자와 발신자를 분리하여 불을 끼고 켜는 명령을 캡슐화
    val light = Light();
    val lightOnCommand = LightOnCommand(light);
    val lightOffCommand = LightOffCommand(light);

    val remoteControl = RemoteControl();

    remoteControl.setCommand(lightOnCommand);
    remoteControl.pressButton();

    remoteControl.setCommand(lightOffCommand);
    remoteControl.pressButton();
};