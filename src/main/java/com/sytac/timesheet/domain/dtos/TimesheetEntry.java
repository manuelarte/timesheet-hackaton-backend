package com.sytac.timesheet.domain.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * com.sytac.timesheet.domain.model.Timesheet
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
public class TimesheetEntry {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("date")
    private LocalDate date;
    @JsonProperty("worked")
    private Integer worked;
    @JsonProperty("internal_hours")
    private Integer internal_hours;
    @JsonProperty("courses")
    private Integer courses;
    @JsonProperty("leave")
    private Integer leave;
    @JsonProperty("special_leave")
    private Integer special_leave;
    @JsonProperty("part_time_leave")
    private Integer part_time_leave;
    @JsonProperty("sick")
    private Integer sick;
    @JsonProperty("doctor")
    private Integer doctor;
    @JsonProperty("standby")
    private Integer standby;

    @JsonProperty("date")
    public LocalDate getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @JsonProperty("worked")
    public Integer getWorked() {
        return worked;
    }

    @JsonProperty("worked")
    public void setWorked(Integer worked) {
        this.worked = worked;
    }

    @JsonProperty("internal_hours")
    public Integer getInternal_hours() {
        return internal_hours;
    }

    @JsonProperty("internal_hours")
    public void setInternal_hours(Integer internal_hours) {
        this.internal_hours = internal_hours;
    }

    @JsonProperty("courses")
    public Integer getCourses() {
        return courses;
    }

    @JsonProperty("courses")
    public void setCourses(Integer courses) {
        this.courses = courses;
    }

    @JsonProperty("leave")
    public Integer getLeave() {
        return leave;
    }

    @JsonProperty("leave")
    public void setLeave(Integer leave) {
        this.leave = leave;
    }

    @JsonProperty("special_leave")
    public Integer getSpecial_leave() {
        return special_leave;
    }

    @JsonProperty("special_leave")
    public void setSpecial_leave(Integer special_leave) {
        this.special_leave = special_leave;
    }

    @JsonProperty("part_time_leave")
    public Integer getPart_time_leave() {
        return part_time_leave;
    }

    @JsonProperty("part_time_leave")
    public void setPart_time_leave(Integer part_time_leave) {
        this.part_time_leave = part_time_leave;
    }

    @JsonProperty("sick")
    public Integer getSick() {
        return sick;
    }

    @JsonProperty("sick")
    public void setSick(Integer sick) {
        this.sick = sick;
    }

    @JsonProperty("doctor")
    public Integer getDoctor() {
        return doctor;
    }

    @JsonProperty("doctor")
    public void setDoctor(Integer doctor) {
        this.doctor = doctor;
    }

    @JsonProperty("standby")
    public Integer getStandby() {
        return standby;
    }

    @JsonProperty("standby")
    public void setStandby(Integer standby) {
        this.standby = standby;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TimesheetEntry.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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
        if ((other instanceof TimesheetEntry) == false) {
            return false;
        }
        TimesheetEntry rhs = ((TimesheetEntry) other);
        return (((((((((((this.date == rhs.date)||((this.date!= null)&&this.date.equals(rhs.date)))&&((this.doctor == rhs.doctor)||((this.doctor!= null)&&this.doctor.equals(rhs.doctor))))&&((this.courses == rhs.courses)||((this.courses!= null)&&this.courses.equals(rhs.courses))))&&((this.worked == rhs.worked)||((this.worked!= null)&&this.worked.equals(rhs.worked))))&&((this.standby == rhs.standby)||((this.standby!= null)&&this.standby.equals(rhs.standby))))&&((this.leave == rhs.leave)||((this.leave!= null)&&this.leave.equals(rhs.leave))))&&((this.special_leave == rhs.special_leave)||((this.special_leave!= null)&&this.special_leave.equals(rhs.special_leave))))&&((this.internal_hours == rhs.internal_hours)||((this.internal_hours!= null)&&this.internal_hours.equals(rhs.internal_hours))))&&((this.part_time_leave == rhs.part_time_leave)||((this.part_time_leave!= null)&&this.part_time_leave.equals(rhs.part_time_leave))))&&((this.sick == rhs.sick)||((this.sick!= null)&&this.sick.equals(rhs.sick))));
    }

}
