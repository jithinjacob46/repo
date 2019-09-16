package com.sample.aws.aws_sam.function;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sample.aws.aws_sam.model.ServerlessOutput;

/**
 * Lambda function that returns message "Hello World" if the input name is not
 * provided, otherwise, print "Hello " with the provided input name.
 */
public class HelloWorld implements RequestHandler<Map<String, Object>, ServerlessOutput> {

	@Override
	public ServerlessOutput handleRequest(Map<String, Object> input, Context context) {

		String content = "Hello "
				+ (((input != null && input.containsKey("name"))) ? input.get("name").toString() : "World");
		context.getLogger().log(content);

		ServerlessOutput output = new ServerlessOutput();
		output.setStatusCode(200);
		output.setBody(content);
		return output;
	}

}