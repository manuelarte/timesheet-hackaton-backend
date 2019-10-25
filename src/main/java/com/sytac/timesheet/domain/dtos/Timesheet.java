package com.sytac.timesheet.domain.dtos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;


/**
 * com.sytac.timesheet.domain.model.Timesheets
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "client",
    "status",
    "timesheets"
})
public class Timesheet {

    @JsonProperty("client")
    private String client;
    @JsonProperty("status")
    private Timesheet.Status status;
    @JsonProperty("timesheets")
    private List<TimesheetEntry> timesheets = new ArrayList<>();

    @JsonProperty("client")
    public String getClient() {
        return client;
    }

    @JsonProperty("client")
    public void setClient(String client) {
        this.client = client;
    }

    @JsonProperty("status")
    public Timesheet.Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Timesheet.Status status) {
        this.status = status;
    }

    @JsonProperty("timesheets")
    public List<TimesheetEntry> getTimesheets() {
        return timesheets;
    }

    @JsonProperty("timesheets")
    public void setTimesheets(List<TimesheetEntry> timesheets) {
        this.timesheets = timesheets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Timesheet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("client");
        sb.append('=');
        sb.append(((this.client == null)?"<null>":this.client));
        sb.append(',');
        sb.append("status");
        sb.append('=');
        sb.append(((this.status == null)?"<null>":this.status));
        sb.append(',');
        sb.append("timesheets");
        sb.append('=');
        sb.append(((this.timesheets == null)?"<null>":this.timesheets));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.client == null)? 0 :this.client.hashCode()));
        result = ((result* 31)+((this.timesheets == null)? 0 :this.timesheets.hashCode()));
        result = ((result* 31)+((this.status == null)? 0 :this.status.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Timesheet) == false) {
            return false;
        }
        Timesheet rhs = ((Timesheet) other);
        return ((((this.client == rhs.client)||((this.client!= null)&&this.client.equals(rhs.client)))&&((this.timesheets == rhs.timesheets)||((this.timesheets!= null)&&this.timesheets.equals(rhs.timesheets))))&&((this.status == rhs.status)||((this.status!= null)&&this.status.equals(rhs.status))));
    }

    public enum Status {

        DRAFT("DRAFT"),
        SUBMITTED("SUBMITTED");
        private final String value;
        private final static Map<String, Timesheet.Status> CONSTANTS = new HashMap<String, Timesheet.Status>();

        static {
            for (Timesheet.Status c: values()) {
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
        public static Timesheet.Status fromValue(String value) {
            Timesheet.Status constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
