package org.doorisopen.myspring.Chat;

import java.util.ArrayList;
import java.util.List;
 
import javax.websocket.server.ServerEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
import javax.websocket.RemoteEndpoint.Basic;

@Controller
@ServerEndpoint(value="/echo.do") // /myspring/echo.do url ��û�� ���� �����Ͽ� �������� �ǹ��ϴ� �ֳ����̼�
public class ChatController {
	
	private static final List<Session> sessionList=new ArrayList<Session>();;
    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);
    public ChatController() {
        // TODO Auto-generated constructor stub
        System.out.println("������(����) ��ü����");
    }
    @RequestMapping(value="/chat.do")
    public ModelAndView getChatViewPage(ModelAndView mav) {
        mav.setViewName("chat");
        return mav;
    }
    
    @OnOpen // Ŭ���̾�Ʈ�� �����Ͽ� ������ ������ �ƹ��� ���� ���� �������� ����
    public void onOpen(Session session) {
        logger.info("Open session id:"+session.getId());
        String message = session.getId()+"���� �����ϼ̽��ϴ�.";
        try {
            final Basic basic=session.getBasicRemote();
            basic.sendText("Connection Established");
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sessionList.add(session);
        sendAllSessionToMessage(session, message);
    }
    /**
     * ��� ����ڿ��� �޽����� �����Ѵ�.
     * @param self
     * @param message
     **/
    // � ���������� �޽����� �Դٸ� �� �޽����� ���� �ڽ��� ������ ����� ����(Ŭ���̾�Ʈ)���� �޽����� ������ �޼ҵ�
    private void sendAllSessionToMessage(Session self, String message) {
        try {
            for(Session session : ChatController.sessionList) {
                if(!self.getId().equals(session.getId())) {
                    session.getBasicRemote().sendText(message);
                }
            }
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    @OnMessage // Ŭ���̾�Ʈ���� �޽����� ������ ��, ����Ǵ� �޼ҵ�
    public void onMessage(String message, Session session) {
        logger.info("Message From "+message.split(":")[0] + ": "+message.split(":")[1]);
        try {
            final Basic basic = session.getBasicRemote();
            basic.sendText(message.split(":")[0]+"(me): "+message.split(":")[1]);
        }catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }
        sendAllSessionToMessage(session, message);
    }
    @OnError
    public void onError(Throwable e, Session session) {
        
    }
    @OnClose // Ŭ���̾�Ʈ�� �����ϰ��� ������ ����� ����Ǵ� �޼ҵ��Դϴ�
    public void onClose(Session session) {
        logger.info("Session "+session.getId()+" has ended");
        String message = session.getId()+"���� �����ϼ̽��ϴ�.";
        sendAllSessionToMessage(session, message);
        sessionList.remove(session);
    }
}