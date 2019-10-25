package com.sytac.timesheet.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Timesheets
 * <p>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"client",
	"status",
	"timesheet"
})
public class Timesheets {

	@JsonProperty("client")
	public String client;
	@JsonProperty("status")
	public Timesheets.Status status;
	@JsonProperty("timesheet")
	public List<Timesheet> timesheet = new ArrayList<>();

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(Timesheets.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("client");
		sb.append('=');
		sb.append(((this.client == null) ? "<null>" : this.client));
		sb.append(',');
		sb.append("status");
		sb.append('=');
		sb.append(((this.status == null) ? "<null>" : this.status));
		sb.append(',');
		sb.append("timesheet");
		sb.append('=');
		sb.append(((this.timesheet == null) ? "<null>" : this.timesheet));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.client == null) ? 0 : this.client.hashCode()));
		result = ((result * 31) + ((this.timesheet == null) ? 0 : this.timesheet.hashCode()));
		result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof Timesheets) == false) {
			return false;
		}
		Timesheets rhs = ((Timesheets) other);
		return ((((this.client == rhs.client) || ((this.client != null) && this.client.equals(rhs.client))) &&
			((this.timesheet == rhs.timesheet) || ((this.timesheet != null) && this.timesheet.equals(rhs.timesheet)))) &&
			((this.status == rhs.status) || ((this.status != null) && this.status.equals(rhs.status))));
	}

	public enum Status {

		DRAFT("DRAFT"),
		SUBMITTED("SUBMITTED");
		private final String value;
		private final static Map<String, Status> CONSTANTS = new HashMap<String, Status>();

		static {
			for (Timesheets.Status c : values()) {
				CONSTANTS.put(c.value, c);
			}
		}

		private Status(String value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return this.value;
		}

		@JsonValue
		public String value() {
			return this.value;
		}

		@JsonCreator
		public static Timesheets.Status fromValue(String value) {
			Timesheets.Status constant = CONSTANTS.get(value);
			if (constant == null) {
				throw new IllegalArgumentException(value);
			} else {
				return constant;
			}
		}

	}

}
