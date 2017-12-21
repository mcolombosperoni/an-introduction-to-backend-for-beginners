package com.mcs.be.course.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by mcolombo on 21/12/17.
 */
@ControllerAdvice
public class JsonpHandler extends AbstractJsonpResponseBodyAdvice {
    public JsonpHandler() {
        super("callback");
    }
}
