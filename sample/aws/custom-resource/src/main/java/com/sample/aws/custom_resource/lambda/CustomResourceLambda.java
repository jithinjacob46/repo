package com.sample.aws.custom_resource.lambda;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.JSONObject;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CustomResourceLambda implements RequestHandler<Map<String, Object>, Object> {

	@Override
	public Object handleRequest(final Map<String, Object> input, final Context context) {
		final LambdaLogger logger = context.getLogger();
		logger.log("Input: " + input);

		final String requestType = (String) input.get("RequestType");

		final JSONObject responseData = new JSONObject();
		if (requestType == null) {
			throw new RuntimeException();
		}

		if (requestType.equalsIgnoreCase("Create")) {
			logger.log("CREATE!");
			// Put your custom create logic here
			responseData.put("CipherText", "CipherText");
			responseData.put("Message", "Resource creation successful!");
			sendResponse(input, context, "SUCCESS", responseData);
		} else if (requestType.equalsIgnoreCase("Update")) {
			logger.log("UDPATE!");
			// Put your custom update logic here
			responseData.put("CipherText", "CipherText");
			responseData.put("Message", "Resource update successful!");
			sendResponse(input, context, "SUCCESS", responseData);
		} else if (requestType.equalsIgnoreCase("Delete")) {
			logger.log("DELETE!");
			// Put your custom delete logic here
			responseData.put("CipherText", "CipherText");
			responseData.put("Message", "Resource deletion successful!");
			sendResponse(input, context, "SUCCESS", responseData);
		} else {
			logger.log("FAILURE!");
			sendResponse(input, context, "FAILURE", responseData);
		}
		return null;
	}

	/**
	 * Send a response to CloudFormation regarding progress in creating resource.
	 */
	public final Object sendResponse(final Map<String, Object> input, final Context context,
			final String responseStatus, JSONObject responseData) {

		String responseUrl = (String) input.get("ResponseURL");
		context.getLogger().log("ResponseURL: " + responseUrl);

		URL url;
		try {
			url = new URL(responseUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");

			JSONObject responseBody = new JSONObject();
			responseBody.put("Status", responseStatus);
			responseBody.put("PhysicalResourceId", context.getLogStreamName());
			responseBody.put("StackId", input.get("StackId"));
			responseBody.put("RequestId", input.get("RequestId"));
			responseBody.put("LogicalResourceId", input.get("LogicalResourceId"));
			responseBody.put("Data", responseData);

			OutputStreamWriter response = new OutputStreamWriter(connection.getOutputStream());
			String string = responseBody.toString();
			context.getLogger().log("Response string: " + string);
			response.write(string);
			response.close();
			context.getLogger().log("Response Code: " + connection.getResponseCode());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

}