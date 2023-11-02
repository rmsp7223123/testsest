package com.example.myapplication

class Proxy : Service {
    override fun request() {
        println("aaaaaaaaaa");
    };

};

interface Service {
    fun request();
};

class ProxyService(private val realService: Proxy) : Service {
    override fun request() {
        println("ProxyService: Logging request.");
        realService.request();
        println("ProxyService: Request handled.");
    };
};

fun main() {
    // 실제 서비스 객체 생성
    val proxy = Proxy();

    // 프록시 객체 생성
    val proxyService = ProxyService(proxy);

    // 클라이언트가 프록시를 통해 서비스에 접근
    proxyService.request();
};