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

    public MedicalFile medicalFile() {
        return medicalFile();
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
            medicalFile().setPatient(null);
            medicalFile = null;
        }
    }
}
