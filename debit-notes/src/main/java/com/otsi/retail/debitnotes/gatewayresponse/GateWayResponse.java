/**
 * gateway response for controllers and classes
 */
package com.otsi.retail.debitnotes.gatewayresponse;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.validation.FieldError;

/**
 * @author vasavi
 *
 */
public class GateWayResponse<T> {

	private Boolean status;
	private HttpStatus httpStatus;
	private String message;
	private T result;
	private List<String> errors;
	private List<FieldError> fieldErrors;

	/**
	 * @param errors
	 * @param fieldErrors
	 */
	public GateWayResponse(List<String> errors, List<FieldError> fieldErrors) {
		super();
		this.errors = errors;
		this.fieldErrors = fieldErrors;
	}

	/**
	 * @param result
	 * @param status
	 * @param httpStatus
	 */
	public GateWayResponse(boolean status, final HttpStatus httpStatus, final T result) {
		super();
		this.result = result;
		this.status = status;
		this.httpStatus = httpStatus;
	}

	/**
	 * @param result
	 * @param status
	 * @param httpStatus
	 */
	public GateWayResponse(final T result) {
		this.result = result;
		this.status = Boolean.TRUE;
		this.httpStatus = HttpStatus.OK;
	}

	/**
	 * @param result
	 * @param status
	 * @param message
	 * @param errors
	 */
	public GateWayResponse(boolean status, final HttpStatus httpStatus, final String message,
			final List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		this.errors = errors;
	}

	/**
	 * @param status
	 * @param httpStatus
	 * @param message
	 * @param fieldErrors
	 */
	public GateWayResponse(String message, final List<FieldError> fieldErrors) {
		super();
		this.status = Boolean.FALSE;
		this.httpStatus = HttpStatus.BAD_REQUEST;
		this.message = message;
		this.fieldErrors = fieldErrors;
	}

	/**
	 * @param status
	 * @param httpStatus
	 * @param message
	 * @param error
	 */

	public GateWayResponse(boolean status, final HttpStatus httpStatus, final String message, final String error) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		if (!StringUtils.isEmpty(error)) {
			errors = Arrays.asList(error);
		}
	}

	/**
	 * @param status
	 * @param httpStatus
	 * @param message
	 * @param errors
	 */
	public GateWayResponse(Boolean status, HttpStatus httpStatus, String message, List<String> errors) {
		super();
		this.status = status;
		this.httpStatus = httpStatus;
		this.message = message;
		this.errors = errors;
	}

	/**
	 * @param status
	 * @param httpStatus
	 * @param message
	 */
	public GateWayResponse(HttpStatus httpStatus, final String message) {
		super();
		this.status = Boolean.FALSE;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	/**
	 * @param httpStatus
	 * @param result
	 * @param httpStatus
	 * @param message
	 */

	public GateWayResponse(final HttpStatus httpStatus, final T result, String message) {
		super();
		this.status = true;
		this.result = result;
		this.httpStatus = httpStatus;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public Boolean getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Boolean status) {
		this.status = status;
	}

	/**
	 * @return the httpStatus
	 */
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	/**
	 * @param httpStatus the httpStatus to set
	 */
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	/**
	 * @return the fieldErrors
	 */
	public List<FieldError> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * @param fieldErrors the fieldErrors to set
	 */
	public void setFieldErrors(List<FieldError> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

}

