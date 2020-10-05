package be.vdab.hospital;

import javax.persistence.*;

@Entity
public class Patient {

    private long id;
    private String name;

    private MedicalFile medicalFile () {
        return medicalFile();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PATIENT_ID")
    public long getId() {
        return id;
    }




    @Column(name="NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="PATIENT_MEDICAL_FILE")
    public void addMedicalFile(MedicalFile mf) {

        mf.setPatient(this);
    }
    public void removeMedicalFile() {
            medicalFile().setPatient(null);
        }
    }

