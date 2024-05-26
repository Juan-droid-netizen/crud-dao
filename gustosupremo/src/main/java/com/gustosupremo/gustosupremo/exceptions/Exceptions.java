/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gustosupremo.gustosupremo.exceptions;

/**
 *
 * @author juanj
 */
public class Exceptions extends RuntimeException{
    public Exceptions(String message){
        super(message);
    }
    public Exceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
