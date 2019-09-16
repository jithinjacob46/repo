package com.sample.aws.aws_sam.function;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

/**
 * Lambda function that simply prints "Hello World" if the input String is not
 * provided, otherwise, print "Hello " with the provided input String.
 */
public class HelloWorld implements RequestHandler<Map<String, Object>, String> {
	@Override
	public String handleRequest(Map<String, Object> input, Context context) {
		String name = ((input != null && input.containsKey("name"))) ? input.get("name").toString() : null;
		String output = "Hello " + ((name != null && !name.isEmpty()) ? name : "World");
		context.getLogger().log(output);
		return output;
	}
}