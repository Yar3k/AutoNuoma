package com.example.autonuoma.inter;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedInvocation
public class MethodLogger implements Serializable{
    @AroundInvoke
    public Object logMethodInvocation(InvocationContext context) throws Exception {
        System.out.println("Kviestas metodas: " + context.getMethod().getName());
        return context.proceed();
    }
}