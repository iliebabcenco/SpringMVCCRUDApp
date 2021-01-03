package md.babcenco.springcourse.config;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//there remain to configure just dispatcher servlet
public class MySpringMVCDispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //hibernate
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


    //there is the filter for REST (PATCH, DELETE, PUT etc...)
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext); //start first with application
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }

}
