package com.cuandorindov2.main.model;

import java.io.Serializable;
import java.util.Collection;

/**
 * Created by tomas.lingotti on 27/05/17.
 */
public class Course implements Serializable {

    private static final long serialVersionUID = -7388739815324351866L;

    private Long studentId;
    private Long establishmentId;
    private Collection<Signature> signatures;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Collection<Signature> getSignatures() {
        return signatures;
    }

    public void setSignatures(Collection<Signature> signatures) {
        this.signatures = signatures;
    }

    public Long getEstablishmentId() {
        return establishmentId;
    }

    public void setEstablishmentId(Long establishmentId) {
        this.establishmentId = establishmentId;
    }
}
