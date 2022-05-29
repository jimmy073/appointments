package appoint.jim.server.entities;

import appoint.jim.server.enums.GenericStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class ScheduleTime {
    @Id
    @GeneratedValue
    private int id;
    private String startFrom;
    private String endFrom;
    @Enumerated(EnumType.STRING)
    private GenericStatus status;
    @ManyToOne
    @JsonIgnore
    private DoctorSchedule doctorSchedule;
    @OneToOne
    private Appointment appointment;

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public DoctorSchedule getDoctorSchedule() {
        return doctorSchedule;
    }

    public void setDoctorSchedule(DoctorSchedule doctorSchedule) {
        this.doctorSchedule = doctorSchedule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartFrom() {
        return startFrom;
    }

    public void setStartFrom(String startFrom) {
        this.startFrom = startFrom;
    }

    public String getEndFrom() {
        return endFrom;
    }

    public void setEndFrom(String endFrom) {
        this.endFrom = endFrom;
    }

    public GenericStatus getStatus() {
        return status;
    }

    public void setStatus(GenericStatus status) {
        this.status = status;
    }
}
