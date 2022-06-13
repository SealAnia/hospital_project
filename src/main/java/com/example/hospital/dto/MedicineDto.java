package com.example.hospital.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.hospital.model.entity.Medicine;
import com.example.hospital.model.entity.Patient;

public class MedicineDto {
	
	private Integer id;
	private String name;
	private Double numberPerDay;
	
	private List<Patient> patients;
	private List<PatientDto> patientsDtos;
	
	private Integer patientid;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getNumberPerDay() {
		return numberPerDay;
	}
	public void setNumberPerDay(Double numberPerDay) {
		this.numberPerDay = numberPerDay;
	}
	
	public List<Patient> getPatients() {
		return patients;
	}
	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public Integer getPatientid() {
		return patientid;
	}
	public void setPatientid(Integer patientid) {
		this.patientid = patientid;
	}
	public List<PatientDto> getPatientsDtos() {
		return patientsDtos;
	}
	public void setPatientsDtos(List<PatientDto> patientsDtos) {
		this.patientsDtos = patientsDtos;
	}
	
	public List<MedicineDto> getMedicineDto(List<Medicine> medicines) {
		List<MedicineDto> medicineDtos = new ArrayList<>();
		for (Medicine medicine : medicines){
			patientsDtos = new ArrayList<>();
            MedicineDto medicineDto = new MedicineDto();
            medicineDto.setName(medicine.getName());
            medicineDto.setNumberPerDay(medicine.getNumberPerDay());
            //medicineDto.setPatients(medicine.getPatients());
            for (Patient patient: medicine.getPatients()){
                PatientDto patientDto = new PatientDto();
                patientDto.setName(patient.getName());
                patientDto.setSurname(patient.getSurname());
                patientDto.setDiagnosis(patient.getDiagnosis());
                patientDto.setAdmission(patient.getAdmission());
                patientDto.setRelease(patient.getRelease());
                patientDto.setDepartment(patient.getDepartment());
                patientDto.setComments(patient.getComments());
                patientsDtos.add(patientDto);
            }
            medicineDto.setPatientsDtos(patientsDtos);
            medicineDtos.add(medicineDto);
        }
		return medicineDtos;
	}
	
}
