package appoint.jim.server.entities;

import appoint.jim.server.enums.GenericStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Appointment {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate dateRequested;
    @ManyToOne
    private Patient patient;
    @ManyToOne
    private Doctor doctor;
    @OneToOne
    private ScheduleTime scheduledTime;
    @Enumerated(EnumType.STRING)
    private GenericStatus status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateRequested() {
        return dateRequested;
    }

    public void setDateRequested(LocalDate dateRequested) {
        this.dateRequested = dateRequested;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public ScheduleTime getScheduledTime() {
        return scheduledTime;
    }

    public void setScheduledTime(ScheduleTime scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public GenericStatus getStatus() {
        return status;
    }

    public void setStatus(GenericStatus status) {
        this.status = status;
    }
}
