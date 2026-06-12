import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // The endpoint clients will use to connect to the WebSocket server
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")
                .withSockJS(); // Fallback for browsers that don't support WebSockets
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // "/app" is used to route messages from the client TO the server (@MessageMapping)
        registry.setApplicationDestinationPrefixes("/app");
        
        // Enable a simple memory-based broker to route messages back to the client
        // "/topic" is standard for broadcasting (Groups/Rooms)
        // "/queue" is standard for point-to-point (One-to-One)
        registry.enableSimpleBroker("/topic", "/queue");
        
        // Prefix used to identify user-specific destinations
        registry.setUserDestinationPrefix("/user"); 
    }
}