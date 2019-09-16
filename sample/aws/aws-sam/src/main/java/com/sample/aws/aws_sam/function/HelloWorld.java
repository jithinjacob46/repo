package com.sample.aws.aws_sam.function;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sample.aws.aws_sam.model.ServerlessInput;
import com.sample.aws.aws_sam.model.ServerlessOutput;

/**
 * Lambda function that returns 'message' "Hello World" if the input 'name' is
 * not provided, otherwise, print "Hello " with the provided input 'name'.
 */
public class HelloWorld implements RequestHandler<ServerlessInput, ServerlessOutput> {

	@Override
	public ServerlessOutput handleRequest(ServerlessInput input, Context context) {

		Map<String, String> queryStringParameters = input.getQueryStringParameters();
		String content = "Hello " + (((queryStringParameters != null && queryStringParameters.containsKey("name")))
				? queryStringParameters.get("name").toString()
				: "World");
		context.getLogger().log(content);

		ServerlessOutput output = new ServerlessOutput();
		output.setStatusCode(200);
		output.setBody("{ \"message\": \"" + content + "\" }");
		return output;
	}

}