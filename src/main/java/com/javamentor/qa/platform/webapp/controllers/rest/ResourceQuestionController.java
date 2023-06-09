package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.QuestionDto;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.dto.QuestionDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/question/")
@Tag(name = "Контроллер вопросов")
public class ResourceQuestionController {

    private final QuestionDtoService questionDtoService;

    public ResourceQuestionController(QuestionDtoService questionDtoService) {
        this.questionDtoService = questionDtoService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Получение данных о вопросе по его уникальному идентификатору (id)")
    @ApiResponse(responseCode = "200", description = "Запрос успешно выполнен")
    @ApiResponse(responseCode = "404", description = "Вопрос по данному id не найден")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable Long id,
                                                       @AuthenticationPrincipal User user) {

        return questionDtoService.getById(id, user.getId()).map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(new QuestionDto(), HttpStatus.NOT_FOUND));
    }
}

