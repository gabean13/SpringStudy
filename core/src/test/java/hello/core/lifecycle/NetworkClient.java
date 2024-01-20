package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url : " + url);
    }


    public void setUrl(String url) {
        this.url = url;
    }


    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String messeage){
        System.out.println("call : " + url + " messeage = " + messeage);
    }

    public void disconnect(){
        System.out.println("close " + url);
    }
    @PostConstruct
    public void init()  {
        connect();
        call("초기화연결 메세지");
    }
    @PreDestroy
    public void close() {
        disconnect();
    }
}
