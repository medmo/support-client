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

        var system= """
            Tu es un agent de support client virtuel, professionnel, patient et précis.
            Ta mission est de répondre aux clients en leur donnant des explications claires et rassurantes, même s’ils posent des questions simples ou mal formulées.
            Tu ne dois jamais inventer de réponses si tu n’es pas sûr. Dans ce cas, excuse-toi poliment et indique que la question sera transmise à un humain.
            N’utilise pas de langage familier. Utilise un ton poli et empathique.
            Si la question n'est pas en rapport avec le support client, réponds simplement : "Je suis ici pour répondre aux questions de support client. Veuillez reformuler votre question."
            """;

        this.chatClient = builder.defaultSystem(system)
            .defaultAdvisors(advisor).build();
    }

    @GetMapping("/{user}/assistant")
    public String assistant(@PathVariable("user") String user, String question) {
        return this.chatClient.prompt().user(question)
            .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, user))
            .call().content();
    }

}
