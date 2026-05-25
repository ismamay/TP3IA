package ht.ueh.mbds.ismael_romelus.tp3_ismael_romelus.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.request.ResponseFormat;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

import java.io.Serializable;

public class LlmClientForGuideTouristique implements Serializable {

    private final GuideTouristique guideTouristique;

    public LlmClientForGuideTouristique() {
        String cle = System.getenv("GEMINI_KEY");
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-2.5-flash")
                .responseFormat(ResponseFormat.JSON)
                .build();

        this.guideTouristique = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }

    public String donnerInfos(String question) {
        return guideTouristique.donnerInfos(question);
    }
}
