package ${basepackage}.${projectName}.${moduleName}.controller;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller基类
 *
 */
public class BaseController {

    private ServletRequestAttributes getRequestAttributes() {
        RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
        return (ServletRequestAttributes) attributes;
    }

    /**
     * 获取request
     *
     * @return javax.servlet.http.HttpServletRequest
     */
    public HttpServletRequest getRequest() {
        return getRequestAttributes() != null ? getRequestAttributes().getRequest() : null;
    }

    /**
     * 获取response
     *
     * @param
     * @return javax.servlet.http.HttpServletResponse
     */
    public HttpServletResponse getResponse() {
        return getRequestAttributes() != null ? getRequestAttributes().getResponse() : null;
    }

    /**
     * 获取session
     *
     * @return javax.servlet.http.HttpSession
     */
    public HttpSession getSession() {
        return getRequest().getSession();
    }

}