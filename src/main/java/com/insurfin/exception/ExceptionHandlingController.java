package com.insurfin.exception;

import com.insurfin.dto.BaseResponse;
import com.insurfin.util.ApplicationConstants;
import com.insurfin.util.MessageUtils;
import com.insurfin.validation.ErrorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

@ControllerAdvice
public class ExceptionHandlingController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(InsurfinBaseExceptionValidationException.class)
    public ResponseEntity<BaseResponse> handleCustomExceptions(InsurfinBaseExceptionValidationException exception) {
        BaseResponse errorResponse = getBaseExceptionResponse(exception);
        errorResponse.setData(exception.getData());
        return new ResponseEntity<>(errorResponse, HttpStatus.OK);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<BaseResponse> handleInternalServerError(Exception exception, WebRequest request) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setData(null);
        String exceptionMessage = String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR);
        baseResponse.setExceptionCode(exceptionMessage.substring(0, 3));
        baseResponse.setMessage(exception.getMessage());
        baseResponse.setError(true);
        return new ResponseEntity<>(baseResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private BaseResponse getBaseExceptionResponse(InsurfinBaseException ibev) {
        BaseResponse errorResponse = new BaseResponse();
        final String temp = MessageUtils.getMessages(messageSource, ibev.getArgs(), ibev.getExceptionKey());
        if (!StringUtils.hasText(temp) && !StringUtils.hasLength(temp)) {
            errorResponse.setExceptionCode(ApplicationConstants.ERROR);
            errorResponse.setMessage(ApplicationConstants.SOMETHING_WENT_WRONG);
        }
        StringTokenizer s = new StringTokenizer(temp, ApplicationConstants.MESSAGE_PROPERTIES_DELIMITER);
        try {
            errorResponse.setExceptionCode(s.nextToken());
            errorResponse.setMessage(s.nextToken());
            errorResponse.setError(Boolean.parseBoolean(s.nextToken()));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return errorResponse;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<List<ErrorDetails>> handleRequestBodyValidations(MethodArgumentNotValidException exception,
                                                                           WebRequest request) {
        List<ErrorDetails> errorDetailsList = new ArrayList<>();
        List<FieldError> fieldsError = exception.getBindingResult().getFieldErrors();
        for (FieldError error : fieldsError) {
            ErrorDetails errorDetails = new ErrorDetails();
            String shortErrorMessage = error.getDefaultMessage();
            final String temp = MessageUtils.getMessages(messageSource, null, shortErrorMessage);
            if (!StringUtils.hasText(temp) && !StringUtils.hasLength(temp)) {
                errorDetails.setErrorCode(temp);
                errorDetails.setMessage(ApplicationConstants.SOMETHING_WENT_WRONG);
            }
            StringTokenizer s = new StringTokenizer(temp, ApplicationConstants.MESSAGE_PROPERTIES_DELIMITER);
            try {
                errorDetails.setErrorCode(s.nextToken());
                errorDetails.setMessage(s.nextToken());
                errorDetails.setError(Boolean.parseBoolean(s.nextToken()));
                errorDetails.setField(error.getField());
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            errorDetailsList.add(errorDetails);
        }
        return new ResponseEntity<>(errorDetailsList, HttpStatus.BAD_REQUEST);
    }

}