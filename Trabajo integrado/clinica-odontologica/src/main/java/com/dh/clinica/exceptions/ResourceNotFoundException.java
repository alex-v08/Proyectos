package com.dh.clinica.exceptions;

import com.dh.clinica.GloabalExceptionHandler;
import org.apache.log4j.Logger;

public class ResourceNotFoundException extends Exception {


    public ResourceNotFoundException(String s) {


        super(s);

    }
}
