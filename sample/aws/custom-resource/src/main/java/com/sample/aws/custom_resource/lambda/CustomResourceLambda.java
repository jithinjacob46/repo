package com.sample.aws.custom_resource.lambda;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

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

		ExecutorService service = Executors.newSingleThreadExecutor();
		final JSONObject responseData = new JSONObject();
		try {
			if (requestType == null) {
				throw new RuntimeException();
			}

			Runnable r = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (final InterruptedException e) {
						// empty block
					}

					final Map<String, Object> resourceProperties = (Map<String, Object>) input
							.get("ResourceProperties");
					String inputText = (String) resourceProperties.get("Input");
					logger.log("Input => " + inputText);

					String outputText = inputText != null
							? inputText.chars().mapToObj(e -> switchCase(e)).collect(Collectors.joining())
							: null;
					logger.log("Output => " + outputText);
					String message = null;
					String status = "FAILURE";
					if (requestType.equalsIgnoreCase("Create")) {
						logger.log("CREATE!");
						// Put your custom create logic here
						message = "Resource creation successful!";
						status = "SUCCESS";
					} else if (requestType.equalsIgnoreCase("Update")) {
						logger.log("UDPATE!");
						// Put your custom update logic here
						message = "Resource update successful!";
						status = "SUCCESS";
					} else if (requestType.equalsIgnoreCase("Delete")) {
						logger.log("DELETE!");
						// Put your custom delete logic here
						// message = "Resource deletion successful!";
						status = "SUCCESS";
					} else {
						logger.log("FAILURE!");
					}

					if (message != null) {
						responseData.put("Output", outputText);
						responseData.put("Message", message);
					}
					sendResponse(input, context, status, responseData);
				}

				/**
				 * @param e
				 * @return
				 */
				private String switchCase(int e) {
					if (e >= 65 && e <= 90) {
						e += 32;
					} else if (e >= 97 && e <= 122) {
						e -= 32;
					}
					Character ch = (char) e;
					return ch.toString();
				}
			};
			Future<?> f = service.submit(r);
			f.get(context.getRemainingTimeInMillis() - 1000, TimeUnit.MILLISECONDS);
		} catch (final TimeoutException | InterruptedException | ExecutionException e) {
			logger.log("FAILURE!");
			responseData.put("Message", e.toString() + " - " + e.getMessage());
			sendResponse(input, context, "FAILURE", responseData);
			// Took too long!
		} finally {
			service.shutdown();
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