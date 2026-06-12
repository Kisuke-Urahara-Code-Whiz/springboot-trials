import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.security.Principal;

@Controller
public class PrivateChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    // Client sends messages to: /app/chat.private.{recipientUsername}
    @MessageMapping("/chat.private.{recipient}")
    public void sendPrivateMessage(@DestinationVariable String recipient, 
                                   @Payload ChatMessage message, 
                                   Principal principal) {
                                       
        // Ensure the sender is securely identified by the server
        message.setSender(principal.getName());
        
        // This dynamically routes the message to the recipient's specific queue
        // It translates to: /user/{recipient}/queue/messages
        messagingTemplate.convertAndSendToUser(recipient, "/queue/messages", message);
    }
}