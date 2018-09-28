package com.hkr.ftl;

import java.util.List;

import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModelException;

@SuppressWarnings("deprecation")
public class MaxMethod implements TemplateMethodModel {

	public Object exec(List args) throws TemplateModelException {
		int number1 = Integer.valueOf(args.get(0).toString());
		int number2 = Integer.valueOf(args.get(1).toString());
		return (number1 >= number2) ? number1 : number2;
	}

}
