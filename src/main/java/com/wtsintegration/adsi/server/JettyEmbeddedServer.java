package com.wtsintegration.adsi.server;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.Servlet;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyEmbeddedServer {
	
	/*
	 * Starts a simple embedded Jetty HTTP server/servlet engine 
	 * with configurable servlet provider support (i.e. for REST support)
	 * 
	 * Command line arguments:
	 * port=[HTTP listener port] 
	 * root=[context root for listener] 
	 * servlet=[class name of servlet provider] 
	 * [any other key]=[passed to servlet provider as initialization parameters] 
	 * 
	 * Following defaults apply (Jersey JAX-RS REST support):
	 * port=8080 
	 * root=/ 
	 * servlet=org.glassfish.jersey.servlet.ServletContainer
	 * jersey.config.server.provider.packages=com.wtsintegration.adsi.resources
	 */
	public static void main(String[] args) throws Throwable {
		Map<String,String> config = getConfigurationMap(args);
		ServletContextHandler context = getConfiguredJettyServletContextHandler(config);
		registerServlet(context,config);
		Server server = getConfiguredJettyServer(context,config);
		
		try {
			server.start();
			server.join();
		} finally {
			server.destroy();
		}
	}
	
	/*
	 * Parse incoming Jetty server startup arguments, replacing defaults where provided
	 */
	private static Map<String,String> getConfigurationMap(String[] args) {
		Map<String,String> config = new HashMap<String,String>(DEFAULT_CONFIG);
		for(String arg : args) {
			String[] argument = arg.split("=");
			config.put(argument[0],argument[1]);
		}
		return config;
	}
	
	/*
	 * Configure the Jetty servlet context handler
	 */
	private static ServletContextHandler getConfiguredJettyServletContextHandler(Map<String,String> config) {
		ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		context.setContextPath(config.get("root"));
		return context;
	}
	
	/*
	 * Register servlet support with the Jetty servlet context
	 */
	private static void registerServlet(ServletContextHandler context, Map<String,String> config) throws ClassNotFoundException {
		@SuppressWarnings("unchecked")
		Class<? extends Servlet> servletClass = (Class<? extends Servlet>) Class.forName(config.get("servlet"));
		ServletHolder servlet = context.addServlet(servletClass, "/*");
		servlet.setInitOrder(0);
		for(String key : config.keySet()) {
			if(!key.equals("servlet") && !key.equals("port") && !key.equals("root")) {
				servlet.setInitParameter(key, config.get(key));
			}
		}
	}
	
	/*
	 * Create and configure the Jetty server
	 */
	private static Server getConfiguredJettyServer(ServletContextHandler context, Map<String,String> config) {
		String portString = config.get("port");
		Server server = new Server(Integer.parseInt(portString));
		server.setHandler(context);
		return server;
	}
	
	/*
	 * Default values for Jetty server configuration
	 */
	private static final Map<String,String> DEFAULT_CONFIG = new HashMap<String,String>();
	static {
		DEFAULT_CONFIG.put("port","8080");
		DEFAULT_CONFIG.put("root","/");
		DEFAULT_CONFIG.put("servlet","org.glassfish.jersey.servlet.ServletContainer");
		DEFAULT_CONFIG.put("jersey.config.server.provider.packages","com.wtsintegration.adsi.resources");
	}
}