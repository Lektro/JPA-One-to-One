package be.vdab.hospital;

import javax.persistence.*;

@Entity
public class Patient {

    private long id;
    private String name;
    private MedicalFile medicalFile;

    @OneToOne(mappedBy = "medicalFile")
    public MedicalFile medicalFile() {
        return medicalFile();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    @Column(name = "NAME")
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
