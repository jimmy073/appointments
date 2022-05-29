package appoint.jim.server.entities;

import appoint.jim.server.enums.GenericStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class DoctorSchedule {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    private Doctor doctor;
    private LocalDate scheduleDate;
    @OneToMany(mappedBy = "doctorSchedule")
    private Set<ScheduleTime> scheduleHour;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDate getScheduleDate() {
        return scheduleDate;
    }

    public void setScheduleDate(LocalDate scheduleDate) {
        this.scheduleDate = scheduleDate;
    }

    public Set<ScheduleTime> getScheduleHour() {
        return scheduleHour;
    }

    public void setScheduleHour(Set<ScheduleTime> scheduleHour) {
        this.scheduleHour = scheduleHour;
    }
}
