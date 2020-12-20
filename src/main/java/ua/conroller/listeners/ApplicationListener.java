package ua.conroller.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Locale;

public class ApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Locale.setDefault(new Locale("en"));
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
