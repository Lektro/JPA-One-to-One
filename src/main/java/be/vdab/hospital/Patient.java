package be.vdab.hospital;

import javax.persistence.*;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @OneToOne
    private MedicalFile medicalFile;

    public void setId(long id) {
        this.id = id;
    }

    public MedicalFile getMedicalFile() {
        return medicalFile;
    }

    public void setMedicalFile(MedicalFile medicalFile) {
        this.medicalFile = medicalFile;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMedicalFile(MedicalFile mf) {
        medicalFile = mf;
        mf.setPatient(this);
    }

    public void removeMedicalFile() {
        if (medicalFile != null) {
            medicalFile = null;
        }
    }
}
