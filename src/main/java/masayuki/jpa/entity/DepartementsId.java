package masayuki.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DepartementsId implements Serializable {

    @Column(name = "departements_id")
    private String departemenstId;

    @Column(name = "company_id")
    private String companyId;

    public String getDepartemenstId() {
        return departemenstId;
    }

    public void setDepartemenstId(String departemenstId) {
        this.departemenstId = departemenstId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
