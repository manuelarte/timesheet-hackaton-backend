package com.sytac.timesheet.domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.LocalDate;

/**
 * Timesheet
 * <p>
 * 
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "date",
    "worked",
    "internal_hours",
    "courses",
    "leave",
    "special_leave",
    "part_time_leave",
    "sick",
    "doctor",
    "standby"
})
public class Timesheet {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    public LocalDate date;
    @JsonProperty("worked")
    public Integer worked;
    @JsonProperty("internal_hours")
    public Integer internal_hours;
    @JsonProperty("courses")
    public Integer courses;
    @JsonProperty("leave")
    public Integer leave;
    @JsonProperty("special_leave")
    public Integer special_leave;
    @JsonProperty("part_time_leave")
    public Integer part_time_leave;
    @JsonProperty("sick")
    public Integer sick;
    @JsonProperty("doctor")
    public Integer doctor;
    @JsonProperty("standby")
    public Integer standby;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Timesheet.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("date");
        sb.append('=');
        sb.append(((this.date == null)?"<null>":this.date));
        sb.append(',');
        sb.append("worked");
        sb.append('=');
        sb.append(((this.worked == null)?"<null>":this.worked));
        sb.append(',');
        sb.append("internal_hours");
        sb.append('=');
        sb.append(((this.internal_hours == null)?"<null>":this.internal_hours));
        sb.append(',');
        sb.append("courses");
        sb.append('=');
        sb.append(((this.courses == null)?"<null>":this.courses));
        sb.append(',');
        sb.append("leave");
        sb.append('=');
        sb.append(((this.leave == null)?"<null>":this.leave));
        sb.append(',');
        sb.append("special_leave");
        sb.append('=');
        sb.append(((this.special_leave == null)?"<null>":this.special_leave));
        sb.append(',');
        sb.append("part_time_leave");
        sb.append('=');
        sb.append(((this.part_time_leave == null)?"<null>":this.part_time_leave));
        sb.append(',');
        sb.append("sick");
        sb.append('=');
        sb.append(((this.sick == null)?"<null>":this.sick));
        sb.append(',');
        sb.append("doctor");
        sb.append('=');
        sb.append(((this.doctor == null)?"<null>":this.doctor));
        sb.append(',');
        sb.append("standby");
        sb.append('=');
        sb.append(((this.standby == null)?"<null>":this.standby));
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
        result = ((result* 31)+((this.date == null)? 0 :this.date.hashCode()));
        result = ((result* 31)+((this.doctor == null)? 0 :this.doctor.hashCode()));
        result = ((result* 31)+((this.courses == null)? 0 :this.courses.hashCode()));
        result = ((result* 31)+((this.worked == null)? 0 :this.worked.hashCode()));
        result = ((result* 31)+((this.standby == null)? 0 :this.standby.hashCode()));
        result = ((result* 31)+((this.leave == null)? 0 :this.leave.hashCode()));
        result = ((result* 31)+((this.special_leave == null)? 0 :this.special_leave.hashCode()));
        result = ((result* 31)+((this.internal_hours == null)? 0 :this.internal_hours.hashCode()));
        result = ((result* 31)+((this.part_time_leave == null)? 0 :this.part_time_leave.hashCode()));
        result = ((result* 31)+((this.sick == null)? 0 :this.sick.hashCode()));
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
        return (((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.doctor == rhs.doctor)||((this.doctor!= null)&&this.doctor.equals(rhs.doctor))))&&((this.courses == rhs.courses)||((this.courses!= null)&&this.courses.equals(rhs.courses))))&&((this.worked == rhs.worked)||((this.worked!= null)&&this.worked.equals(rhs.worked))))&&((this.standby == rhs.standby)||((this.standby!= null)&&this.standby.equals(rhs.standby))))&&((this.leave == rhs.leave)||((this.leave!= null)&&this.leave.equals(rhs.leave))))&&((this.special_leave == rhs.special_leave)||((this.special_leave!= null)&&this.special_leave.equals(rhs.special_leave))))&&((this.internal_hours == rhs.internal_hours)||((this.internal_hours!= null)&&this.internal_hours.equals(rhs.internal_hours))))&&((this.part_time_leave == rhs.part_time_leave)||((this.part_time_leave!= null)&&this.part_time_leave.equals(rhs.part_time_leave))))&&((this.sick == rhs.sick)||((this.sick!= null)&&this.sick.equals(rhs.sick))));
    }

}
