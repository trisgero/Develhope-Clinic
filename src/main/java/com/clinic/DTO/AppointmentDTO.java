package com.clinic.DTO;


import java.util.Date;

public class AppointmentDTO {

    private int appointmentId;
    private int patientId;
    private String patientNameSurname;
    private String doctorName;
    private Date date;


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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
