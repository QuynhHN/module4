package com.example.book.aop;

import com.example.book.controller.BookCodeController;
import com.example.book.model.Book;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("execution(* com.example.book.controller.BookCodeController.borrow(..))")
    public void loggingPerformBorrowPointCut(){}
    @Pointcut("execution(* com.example.book.controller.BookCodeController.returnBook(..))")
    public void loggingPerformGiveBackPointCut() {}
    @Pointcut("execution(* com.example.book.controller.BookCodeController.showList(..))")
    public void loggingShowAllList () {}

    @AfterReturning(pointcut = "loggingPerformBorrowPointCut()")
    public void handleAfterReturningPerformBorrow(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}
