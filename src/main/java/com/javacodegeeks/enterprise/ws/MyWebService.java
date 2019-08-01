package com.javacodegeeks.enterprise.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import com.javacodegeeks.enterprise.bo.MyBObject;
import org.springframework.beans.factory.annotation.Autowired;

@WebService(serviceName="MyWebService")
@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
public class MyWebService{

    //Dependency Injection (DI) via Spring
    @Autowired
    private MyBObject myBObject;

    @WebMethod(exclude=true)
    public void setMyBObject(MyBObject bObject) {
        this.myBObject = bObject;
    }

    @WebMethod(operationName="printMessage")
    public String printMessage() {
        return myBObject.printMessage();
    }
}