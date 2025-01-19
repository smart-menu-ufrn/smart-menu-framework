package br.edu.ufrn.smartmenu.llm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufrn.smartmenu.llm.connection.LLMConnector;
import br.edu.ufrn.smartmenu.llm.exceptions.EmptyLLMResponse;
import br.edu.ufrn.smartmenu.llm.exceptions.PromptException;
import br.edu.ufrn.smartmenu.llm.model.PromptResponse;
import br.edu.ufrn.smartmenu.items.models.Item;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public abstract class LLMService {

    @Autowired
    protected LLMConnector llmConnector;

    public abstract String generatePrompt();

    public LLMService(String apiKey) {
        this.llmConnector = new LLMConnector("https://api.groq.com/openai/v1/chat/completions", apiKey);
    }

    public PromptResponse processPrompt() throws PromptException, EmptyLLMResponse {
        try {
            // this.prompt = this.prompt.concat(". Lista dos itens: [");
            // for (Item element: itemList) {
            //     this.prompt = this.prompt.concat("{id: " + element.getId() + ", nome: " + element.getName() + ",descricao: " + element.getDescription() + "}");
            // }
            // this.prompt = this.prompt.concat("].");
            String response = llmConnector.sendPrompt(generatePrompt());
            return new PromptResponse(response);
        } catch (PromptException e) {
            throw e;
        } catch (EmptyLLMResponse e) {
            throw e;
        }
    }



}
