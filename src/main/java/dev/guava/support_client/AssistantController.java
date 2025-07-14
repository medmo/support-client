package dev.guava.support_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantController {

    private final ChatClient chatClient;

    public AssistantController(ChatClient.Builder builder){
        this.chatClient = builder.build();
    }

    @GetMapping("/assistant")
    public String assistant(String question) {
        return this.chatClient.prompt().user(question)
            .call().content();
    }

    @GetMapping("/assistant-detailed-response")
    public ChatResponse assistantDetailedResponse(String question) {
        return this.chatClient.prompt().user(question)
            .call().chatResponse();
    }

}
