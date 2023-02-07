package com.zinzza.getinline.error;

import com.zinzza.getinline.constant.ErrorCode;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class BaseErrorController implements ErrorController {

    // 에러 표시 페이지 매핑
    @RequestMapping("/error")
    public ModelAndView error(HttpServletResponse res) {
        HttpStatus status = HttpStatus.valueOf(res.getStatus());
        ErrorCode errorCode = status.is4xxClientError() ?
                ErrorCode.BAD_REQUEST : ErrorCode.INTERNAL_ERROR;

        return new ModelAndView("error",
                Map.of(
                        "statusCode", status.value(),
                        "errorCode", errorCode,
                        "message", errorCode.getMessage(status.getReasonPhrase())
                ), status);
    }

}
