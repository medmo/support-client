package dev.guava.support_client;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.PromptChatMemoryAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AssistantController {

    private final ChatClient chatClient;


    public AssistantController(ChatClient.Builder builder, PromptChatMemoryAdvisor advisor){
        this.chatClient = builder
            .defaultAdvisors(advisor).build();
    }

    @GetMapping("/{user}/assistant")
    public String assistant(@PathVariable("user") String user, String question) {
        return this.chatClient.prompt().user(question)
            .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, user))
            .call().content();
    }

}
