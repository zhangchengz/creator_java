package com.tlf.creatoraccount.exception;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.tlf.creatoraccount.common.JsonResult;
import com.tlf.creatoraccount.constants.Constants;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ExceptionController {

    // 捕捉shiro的异常
 //   @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenErrorException.class)
    public JsonResult handle401(TokenErrorException e) {
        return new JsonResult(Constants.CODE_FAIL, e.getMsg(), null);
    }

    // 捕捉UnauthorizedException
  //  @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(SignatureVerificationException.class)
    public JsonResult handle401() {
        return new JsonResult(Constants.CODE_FAIL, "token校验异常", null);
    }

 //   @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(TokenExpiredException.class)
    public JsonResult tokenExpired() {
        return new JsonResult(Constants.CODE_FAIL, "token已过期", null);
    }

    /**
     * 捕捉自定义异常
     * @param e
     * @return
     */
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(OperatingException.class)
    public JsonResult operatingError(OperatingException e) {
        return new JsonResult(Constants.CODE_FAIL, e.getMsg(), null);
    }
    // 捕捉其他所有异常
    //@ExceptionHandler(Exception.class)
   // @ResponseStatus(HttpStatus.BAD_REQUEST)
   // public JsonResult globalException(HttpServletRequest request, Throwable ex) {
    //    return new JsonResult(getStatus(request).value(), ex.getMessage(), null);
   // }

   /* private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }*/
}
