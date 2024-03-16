package hello.login.web.session;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 세션관리
 */
@Component
public class SessionManager {

    /**
     * 세션생성
     * * sessionId 생성
     * * 세션 저장소에 sessionId와 보관할 값 저장
     * * sessionId로 응답 쿠키를 생성해서 클라이언트에 전달
     */
    public void createSession(Object value, HttpServletResponse response) {

    }

    /**
     * 세션 조회
     */
    public Object getSession(HttpServletRequest request) {
        
    }
}
