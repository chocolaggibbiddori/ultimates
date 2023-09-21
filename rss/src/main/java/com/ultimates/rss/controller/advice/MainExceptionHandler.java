package com.ultimates.rss.controller.advice;

import com.ultimates.rss.exception.IllegalUserException;
import com.ultimates.rss.exception.NonExistChampException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
public class MainExceptionHandler {

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(IllegalUserException.class)
    public String handle(IllegalUserException e, Model model) {
        errorLog(e);
        model.addAttribute("errorMessage", e.getMessage());
        return "error/400";
    }

    @ResponseStatus(BAD_REQUEST)
    @ExceptionHandler(NonExistChampException.class)
    public String handle(NonExistChampException e, Model model) {
        errorLog(e);
        model.addAttribute("errorMessage", e.getMessage());
        return "error/400";
    }

    private void errorLog(Exception e) {
        log.error("[" + e.getClass().getSimpleName() + "] : {}", e.getMessage());
    }
}
