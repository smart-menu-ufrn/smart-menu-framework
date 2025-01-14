package br.edu.ufrn.smartmenu.llm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import br.edu.ufrn.smartmenu.llm.exceptions.EmptyLLMResponse;
import br.edu.ufrn.smartmenu.llm.exceptions.PromptException;
import br.edu.ufrn.smartmenu.llm.model.PromptRequest;
import br.edu.ufrn.smartmenu.llm.model.PromptResponse;
import br.edu.ufrn.smartmenu.llm.service.LLMService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/llm")
public class LLMController {

    @Autowired
    private LLMService llmService;

    @GetMapping("/prompt")
    public ResponseEntity<String> reorderItems() {
        try {
            String response = this.llmService.processPrompt(prompt);
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (PromptException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (EmptyLLMResponse e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
        }
    }    
}
