package com.wtsintegration.adsi.server;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyEmbeddedServerTest extends TestCase {

	public void setUp() throws Exception {
		super.setUp();

	}

	public void tearDown() throws Exception {
	}
	
	public void testGetConfigurationMap() throws Exception {
        String[] args = {"test=true","argument=second"};
        Map<String, String> config = null;
        
        Class[] argClasses = {String[].class};
        Object[] argObjects = {args};
        Method method = JettyEmbeddedServer.class.getDeclaredMethod("getConfigurationMap", argClasses);
        method.setAccessible(true);
        Object object = method.invoke(null, argObjects);
        config = (HashMap<String,String>) object;
        
        assertNotNull(config);
        assertTrue(config.size() > 0);
        assertTrue(config.get("test").equals("true"));
        assertTrue(config.get("argument").equals("second"));
        
    }
	
	public void testGetConfiguredJettyServletContextHandler() throws Exception {
		Map<String,String> defaultConfig = new HashMap<String,String>();
		defaultConfig.put("port","8080");
		defaultConfig.put("root","/test");
		defaultConfig.put("servlet","org.glassfish.jersey.servlet.ServletContainer");
		defaultConfig.put("jersey.config.server.provider.packages","com.wtsintegration.adsi.resources");
        
		Class[] argClasses = {Map.class};
        Object[] argObjects = {defaultConfig};
        Method method = JettyEmbeddedServer.class.getDeclaredMethod("getConfiguredJettyServletContextHandler", argClasses);
        method.setAccessible(true);
        Object object = method.invoke(null, argObjects);
        
        ServletContextHandler handler = (ServletContextHandler) object;
        assertNotNull(handler);
        assertTrue(handler.getContextPath().equals(defaultConfig.get("root")));
	}
	
	public void testGetConfiguredJettyServer() throws Exception {
		Map<String,String> defaultConfig = new HashMap<String,String>();
		defaultConfig.put("port","8080");
		defaultConfig.put("root","/test");
		defaultConfig.put("servlet","org.glassfish.jersey.servlet.ServletContainer");
		defaultConfig.put("jersey.config.server.provider.packages","com.wtsintegration.adsi.resources");
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath(defaultConfig.get("root"));
        
		Class[] argClasses = {ServletContextHandler.class, Map.class};
        Object[] argObjects = {context, defaultConfig};
        Method method = JettyEmbeddedServer.class.getDeclaredMethod("getConfiguredJettyServer", argClasses);
        method.setAccessible(true);
        Object object = method.invoke(null, argObjects);
        
        Server server = (Server) object;
        assertNotNull(server);
	}
	
	public void testRegisterServlet() throws Exception {
		Map<String,String> defaultConfig = new HashMap<String,String>();
		defaultConfig.put("port","8080");
		defaultConfig.put("root","/test");
		defaultConfig.put("servlet","org.glassfish.jersey.servlet.ServletContainer");
		defaultConfig.put("jersey.config.server.provider.packages","com.wtsintegration.adsi.resources");
		
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath(defaultConfig.get("root"));
        
		Class[] argClasses = {ServletContextHandler.class, Map.class};
        Object[] argObjects = {context, defaultConfig};
        Method method = JettyEmbeddedServer.class.getDeclaredMethod("registerServlet", argClasses);
        method.setAccessible(true);
        Object object = method.invoke(null, argObjects);
        
        assertNotNull(context);
	}
	
}
