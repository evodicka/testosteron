package org.kuhlins.app.testosteron.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.kuhlins.app.testosteron.ServiceApp;
import org.kuhlins.app.testosteron.model.AppInfo;
import org.kuhlins.app.testosteron.model.EnvInfo;
import org.kuhlins.app.testosteron.model.KeyVal;
import org.kuhlins.app.testosteron.model.RequestInfo;
import org.kuhlins.app.testosteron.model.SystemInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControllerRoot {
	
	private static final String RR = "redirect:/";
	
	@Autowired
	private ServiceApp serviceApp;
	
	@GetMapping("/**")
	public String index(HttpServletRequest req, Model model) {

		model.addAttribute("appInfo", buildAppInfo());
		model.addAttribute("requestInfo", buildRequestInfo(req));
		model.addAttribute("envInfo", buildEnvInfo());
		
		model.addAttribute("systemInfo", buildSystemInfo());

		return "index";
	}

	@PostMapping("/action/shutdown")
	public String shutdown() {
		
		Thread t = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {}
				System.exit(0);
			}
		};
		t.start();
		
		return RR;
	}
	
	private String execCmd(String ... cmd) {
		try {
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command(cmd);
			Process process = processBuilder.start();
			StringBuilder sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			int exitVal = process.waitFor();
			return "Return code: " + exitVal + "\n" + sb;
		} catch (Exception e) {
			return "Failed: " + e.getClass() + " -> " + e.getMessage();
		}
	}
	
	private SystemInfo buildSystemInfo() {
		SystemInfo result = new SystemInfo();
		
		// Network
		StringBuilder sb = new StringBuilder();
		try {
	        for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
	        	sb.append("Interface: " + ni.getIndex() + " - " + ni.getName() + "\n");
	            for (InetAddress addr : Collections.list(ni.getInetAddresses())) {
	            	sb.append("Address: " + addr + "\n");
	            }
	        	sb.append("\n");
	        }
		} catch (Exception e) {
			sb.append("Exception: " + e.getClass() + " -> " + e.getMessage());
		}
		result.setNets(sb.toString());
		
		// Mem
		result.setMem(execCmd("free", "-m"));
		
		// Disk
		result.setDisks(execCmd("df", "-h"));
		
		return result;
	}
	
	
	private AppInfo buildAppInfo() {
		AppInfo result = new AppInfo();
		
		result.addBasic(new KeyVal("Date Start", serviceApp.getDateStart().toString()));
		result.addBasic(new KeyVal("Date Now", new Date().toString()));
		try {
			result.addBasic(new KeyVal("Host Addr", InetAddress.getLocalHost().getHostAddress()));
			result.addBasic(new KeyVal("Host Name", InetAddress.getLocalHost().getHostName()));
		} catch(Exception e) {
			System.out.println("Failed to get localhost addr/name. " + e.getMessage());
		}
		Runtime rt = Runtime.getRuntime();
		
		result.addMem(new KeyVal("CPUs", "" + rt.availableProcessors()));
		result.addMem(new KeyVal("Mem free", (rt.freeMemory() / 1000000) + " mb"));
		result.addMem(new KeyVal("Mem total", (rt.totalMemory() / 1000000) + " mb"));
		result.addMem(new KeyVal("Mem max", (rt.maxMemory() / 1000000) + " mb"));
		
		return result;
	}
	
	private EnvInfo buildEnvInfo() {
		EnvInfo result = new EnvInfo();
		
		Map<String, String> env = System.getenv();
		env.keySet().stream().sorted().map(k -> new KeyVal(k, env.get(k))).forEach(result::addEnv);
		
		Properties props = System.getProperties();
		props.keySet().stream().sorted().map(k -> new KeyVal("" + k, "" + props.get(k))).forEach(result::addProp);
		
		return result;
	}
	
	private RequestInfo buildRequestInfo(HttpServletRequest req) {
		RequestInfo result = new RequestInfo();

		result.addBasic(new KeyVal("Address local", req.getLocalAddr()));
		result.addBasic(new KeyVal("Address remote", req.getRemoteAddr()));
		result.addBasic(new KeyVal("Servlet Path", req.getServletPath()));
		
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			String val = req.getHeader(headerName);
			result.addHeader(new KeyVal(headerName, StringUtils.abbreviate(val, 50)));
		}
		return result;
	}
	
}
