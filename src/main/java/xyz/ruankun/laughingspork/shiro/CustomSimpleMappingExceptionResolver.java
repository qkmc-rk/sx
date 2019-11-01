package xyz.ruankun.laughingspork.shiro;

import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import xyz.ruankun.laughingspork.util.ControllerUtil;
import xyz.ruankun.laughingspork.util.constant.RespCode;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomSimpleMappingExceptionResolver extends SimpleMappingExceptionResolver {
    public static final Logger logger = LoggerFactory.getLogger(CustomSimpleMappingExceptionResolver.class);

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        try {
            PrintWriter writer = response.getWriter();
            if (ex instanceof UnauthorizedException) {
                writer.write(ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_UN_AUTHORIZED).toString());
            } else if (ex instanceof UnauthenticatedException) {
                writer.write(ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_UN_ATHENTICATED).toString());
            } else {
                writer.write(ControllerUtil.getFalseResultMsgBySelf(RespCode.MSG_SERVER_ERROR).toString());
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            logger.error(e.toString());
        }
        return null;
    }
}
