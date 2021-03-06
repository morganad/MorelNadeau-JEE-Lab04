import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.lab04.core.config.AppConfig;
import yncrea.lab04.core.config.DBConfig;
import yncrea.lab04.web.config.WebConfig;

import java.util.ArrayList;
import java.util.List;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { AppConfig.class, DBConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    protected String[] getServletMappings() {

        return new String[] { "/" };
    }
}
