package org.jeets.model.gtfs;
// Generated 08.11.2017 22:44:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ServicesToday generated by hbm2java
 */
@Entity
@Table(name = "services_today", schema = "public")
public class ServicesToday implements java.io.Serializable {

    private String serviceId;

    public ServicesToday() {
    }

    public ServicesToday(String serviceId) {
        this.serviceId = serviceId;
    }

    @Id

    @Column(name = "service_id")
    public String getServiceId() {
        return this.serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

}
