package com.api.inventory.controllers;

import java.util.Date;

import com.api.inventory.commons.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseController<TService> {

  protected final TService _service;

  public BaseController(TService service) {
    this._service = service;
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException except) {
    var _response = new Response();
    _response.setErrors(except.getBindingResult());
    _response.setDateTime(new Date(System.currentTimeMillis()));
    _response.setCode(400);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(_response);
  }

  protected ResponseEntity<Response> Ok() {
    var _response = new Response();
    _response.setCode(200);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> Ok(String message) {
    var _response = new Response();
    _response.setCode(200);
    _response.setMessage(message);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> Ok(Object value) {
    var _response = new Response();
    _response.setCode(200);
    _response.setData(value);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> Ok(Object value, String message) {
    var _response = new Response();
    _response.setCode(200);
    _response.setData(value);
    _response.setMessage(message);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> Ok(Object value, HttpStatus status) {
    var _response = new Response();
    _response.setCode(status.value());
    _response.setData(value);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> Ok(Object value, String message, HttpStatus status) {
    var _response = new Response();
    _response.setCode(status.value());
    _response.setData(value);
    _response.setMessage(message);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.ok(_response);
  }

  protected ResponseEntity<Response> BadRequest(String message) {
    var _response = new Response();
    _response.setCode(400);
    _response.setMessage(message);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(_response);
  }

  protected ResponseEntity<Response> BadRequest(String message, HttpStatus status) {
    var _response = new Response();
    _response.setCode(status.value());
    _response.setMessage(message);
    _response.setDateTime(new Date(System.currentTimeMillis()));

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(_response);
  }

}
