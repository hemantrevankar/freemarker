package com.hkr.ftl;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class Test {
    private static Configuration cfg;
    
	public static void main(String[] args) throws Exception {

		/* You should do this ONLY ONCE in the whole application life cycle */

		/* Create and Adjuts configuration SINGLETON */
		cfg = new Configuration(Configuration.VERSION_2_3_28);
		cfg.setDirectoryForTemplateLoading(new File("resources\\templates"));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		cfg.setLogTemplateExceptions(true);
		cfg.setWrapUncheckedExceptions(true);

		/* Create a data model */
		Map root = new HashMap();
		root.put("user", "Hemant Revankar");
		Product latest = new Product();
		latest.setName("Amazon Echo");
		latest.setUrl("https://www.amazon.com/all-new-amazon-echo-speaker-with-wifi-alexa-dark-charcoal/dp/B06XCM9LJ4");
		root.put("latestProduct", latest);

		/* Get the TEMPLATE */
		Template template = cfg.getTemplate("testTemplate.ftlh");

		/* Merge data-model with the template */
		Writer out = new OutputStreamWriter(System.out);
		template.process(root, out);

	}
}
