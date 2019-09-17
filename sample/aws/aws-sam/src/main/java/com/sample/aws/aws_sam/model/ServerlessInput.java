package com.sample.aws.aws_sam.model;

import java.util.Map;

public class ServerlessInput {

	private String resource;
	private String path;
	private String httpMethod;
	private Map<String, String> headers;
	private Map<String, String> queryStringParameters;
	private Map<String, String> pathParameters;
	private Map<String, String> stageVariables;
	private String body;
	private RequestContext requestContext;
	private Boolean isBase64Encoded;

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public ServerlessInput withResource(String resource) {
		setResource(resource);
		return this;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ServerlessInput withPath(String path) {
		setPath(path);
		return this;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	public ServerlessInput withHttpMethod(String httpMethod) {
		setHttpMethod(httpMethod);
		return this;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public ServerlessInput withHeaders(Map<String, String> headers) {
		setHeaders(headers);
		return this;
	}

	public Map<String, String> getQueryStringParameters() {
		return queryStringParameters;
	}

	public void setQueryStringParameters(Map<String, String> queryStringParameters) {
		this.queryStringParameters = queryStringParameters;
	}

	public ServerlessInput withQueryStringParameters(Map<String, String> queryStringParameters) {
		setQueryStringParameters(queryStringParameters);
		return this;
	}

	public Map<String, String> getPathParameters() {
		return pathParameters;
	}

	public void setPathParameters(Map<String, String> pathParameters) {
		this.pathParameters = pathParameters;
	}

	public ServerlessInput withPathParameters(Map<String, String> pathParameters) {
		setPathParameters(pathParameters);
		return this;
	}

	public Map<String, String> getStageVariables() {
		return stageVariables;
	}

	public void setStageVariables(Map<String, String> stageVariables) {
		this.stageVariables = stageVariables;
	}

	public ServerlessInput withStageVariables(Map<String, String> stageVariables) {
		setStageVariables(stageVariables);
		return this;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public ServerlessInput withBody(String body) {
		setBody(body);
		return this;
	}

	public RequestContext getRequestContext() {
		return requestContext;
	}

	public void setRequestContext(RequestContext requestContext) {
		this.requestContext = requestContext;
	}

	public Boolean getIsBase64Encoded() {
		return isBase64Encoded;
	}

	public void setIsBase64Encoded(Boolean isBase64Encoded) {
		this.isBase64Encoded = isBase64Encoded;
	}

	public static class RequestContext {

		private String accountId;
		private String resourceId;
		private String stage;
		private String requestId;
		private Map<String, String> identity;
		private String resourcePath;
		private String httpMethod;
		private String apiId;

		public String getAccountId() {
			return accountId;
		}

		public String getResourceId() {
			return resourceId;
		}

		public String getStage() {
			return stage;
		}

		public String getRequestId() {
			return requestId;
		}

		public Map<String, String> getIdentity() {
			return identity;
		}

		public String getResourcePath() {
			return resourcePath;
		}

		public String getHttpMethod() {
			return httpMethod;
		}

		public String getApiId() {
			return apiId;
		}

		public void setAccountId(String accountId) {
			this.accountId = accountId;
		}

		public void setResourceId(String resourceId) {
			this.resourceId = resourceId;
		}

		public void setStage(String stage) {
			this.stage = stage;
		}

		public void setRequestId(String requestId) {
			this.requestId = requestId;
		}

		public void setIdentity(Map<String, String> identity) {
			this.identity = identity;
		}

		public void setResourcePath(String resourcePath) {
			this.resourcePath = resourcePath;
		}

		public void setHttpMethod(String httpMethod) {
			this.httpMethod = httpMethod;
		}

		public void setApiId(String apiId) {
			this.apiId = apiId;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#hashCode()
		 */
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
			result = prime * result + ((apiId == null) ? 0 : apiId.hashCode());
			result = prime * result + ((httpMethod == null) ? 0 : httpMethod.hashCode());
			result = prime * result + ((identity == null) ? 0 : identity.hashCode());
			result = prime * result + ((requestId == null) ? 0 : requestId.hashCode());
			result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
			result = prime * result + ((resourcePath == null) ? 0 : resourcePath.hashCode());
			result = prime * result + ((stage == null) ? 0 : stage.hashCode());
			return result;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			RequestContext other = (RequestContext) obj;
			if (accountId == null) {
				if (other.accountId != null)
					return false;
			} else if (!accountId.equals(other.accountId))
				return false;
			if (apiId == null) {
				if (other.apiId != null)
					return false;
			} else if (!apiId.equals(other.apiId))
				return false;
			if (httpMethod == null) {
				if (other.httpMethod != null)
					return false;
			} else if (!httpMethod.equals(other.httpMethod))
				return false;
			if (identity == null) {
				if (other.identity != null)
					return false;
			} else if (!identity.equals(other.identity))
				return false;
			if (requestId == null) {
				if (other.requestId != null)
					return false;
			} else if (!requestId.equals(other.requestId))
				return false;
			if (resourceId == null) {
				if (other.resourceId != null)
					return false;
			} else if (!resourceId.equals(other.resourceId))
				return false;
			if (resourcePath == null) {
				if (other.resourcePath != null)
					return false;
			} else if (!resourcePath.equals(other.resourcePath))
				return false;
			if (stage == null) {
				if (other.stage != null)
					return false;
			} else if (!stage.equals(other.stage))
				return false;
			return true;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "RequestContext [accountId=" + accountId + ", resourceId=" + resourceId + ", stage=" + stage
					+ ", requestId=" + requestId + ", identity=" + identity + ", resourcePath=" + resourcePath
					+ ", httpMethod=" + httpMethod + ", apiId=" + apiId + "]";
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((headers == null) ? 0 : headers.hashCode());
		result = prime * result + ((httpMethod == null) ? 0 : httpMethod.hashCode());
		result = prime * result + ((isBase64Encoded == null) ? 0 : isBase64Encoded.hashCode());
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((pathParameters == null) ? 0 : pathParameters.hashCode());
		result = prime * result + ((queryStringParameters == null) ? 0 : queryStringParameters.hashCode());
		result = prime * result + ((requestContext == null) ? 0 : requestContext.hashCode());
		result = prime * result + ((resource == null) ? 0 : resource.hashCode());
		result = prime * result + ((stageVariables == null) ? 0 : stageVariables.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServerlessInput other = (ServerlessInput) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		if (headers == null) {
			if (other.headers != null)
				return false;
		} else if (!headers.equals(other.headers))
			return false;
		if (httpMethod == null) {
			if (other.httpMethod != null)
				return false;
		} else if (!httpMethod.equals(other.httpMethod))
			return false;
		if (isBase64Encoded == null) {
			if (other.isBase64Encoded != null)
				return false;
		} else if (!isBase64Encoded.equals(other.isBase64Encoded))
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (pathParameters == null) {
			if (other.pathParameters != null)
				return false;
		} else if (!pathParameters.equals(other.pathParameters))
			return false;
		if (queryStringParameters == null) {
			if (other.queryStringParameters != null)
				return false;
		} else if (!queryStringParameters.equals(other.queryStringParameters))
			return false;
		if (requestContext == null) {
			if (other.requestContext != null)
				return false;
		} else if (!requestContext.equals(other.requestContext))
			return false;
		if (resource == null) {
			if (other.resource != null)
				return false;
		} else if (!resource.equals(other.resource))
			return false;
		if (stageVariables == null) {
			if (other.stageVariables != null)
				return false;
		} else if (!stageVariables.equals(other.stageVariables))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServerlessInput [resource=" + resource + ", path=" + path + ", httpMethod=" + httpMethod + ", headers="
				+ headers + ", queryStringParameters=" + queryStringParameters + ", pathParameters=" + pathParameters
				+ ", stageVariables=" + stageVariables + ", body=" + body + ", requestContext=" + requestContext
				+ ", isBase64Encoded=" + isBase64Encoded + "]";
	}

}