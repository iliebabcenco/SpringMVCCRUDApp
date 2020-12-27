package md.babcenco.springcourse.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//there remain to configure just dispatcher servlet
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    //adding Spring Configuration Class
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    //all request will go to Dispatcher Servlet because of /
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
