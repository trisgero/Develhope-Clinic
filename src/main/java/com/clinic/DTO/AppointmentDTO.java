package com.clinic.DTO;


import java.time.LocalDate;


public class AppointmentDTO {

    private int appointmentId;
    private int patientId;
    private String patientNameSurname;
    private String doctorName;
    private LocalDate date;

    public AppointmentDTO(){}

    public AppointmentDTO(int appointmentId, int patientId, String patientNameSurname, String doctorName, LocalDate date) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.patientNameSurname = patientNameSurname;
        this.doctorName = doctorName;
        this.date = date;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientNameSurname() {
        return patientNameSurname;
    }

    public void setPatientName(String patientName) {
        this.patientNameSurname = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
