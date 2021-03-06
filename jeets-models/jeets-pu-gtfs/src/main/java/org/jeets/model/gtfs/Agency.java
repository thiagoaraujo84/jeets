package org.jeets.model.gtfs;
// Generated 08.11.2017 22:44:26 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Agency generated by hbm2java
 */
@Entity
@Table(name = "agency", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "agency_id"))
public class Agency implements java.io.Serializable {

    private int id;
    private String agencyId;
    private String agencyName;
    private String agencyUrl;
    private String agencyTimezone;
    private String agencyLang;
    private String agencyPhone;
    private String agencyFareUrl;

    public Agency() {
    }

    public Agency(int id, String agencyName, String agencyUrl, String agencyTimezone) {
        this.id = id;
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
    }

    public Agency(int id, String agencyId, String agencyName, String agencyUrl, String agencyTimezone,
            String agencyLang, String agencyPhone, String agencyFareUrl) {
        this.id = id;
        this.agencyId = agencyId;
        this.agencyName = agencyName;
        this.agencyUrl = agencyUrl;
        this.agencyTimezone = agencyTimezone;
        this.agencyLang = agencyLang;
        this.agencyPhone = agencyPhone;
        this.agencyFareUrl = agencyFareUrl;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "agency_id", unique = true)
    public String getAgencyId() {
        return this.agencyId;
    }

    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    @Column(name = "agency_name", nullable = false)
    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    @Column(name = "agency_url", nullable = false)
    public String getAgencyUrl() {
        return this.agencyUrl;
    }

    public void setAgencyUrl(String agencyUrl) {
        this.agencyUrl = agencyUrl;
    }

    @Column(name = "agency_timezone", nullable = false, length = 50)
    public String getAgencyTimezone() {
        return this.agencyTimezone;
    }

    public void setAgencyTimezone(String agencyTimezone) {
        this.agencyTimezone = agencyTimezone;
    }

    @Column(name = "agency_lang", length = 10)
    public String getAgencyLang() {
        return this.agencyLang;
    }

    public void setAgencyLang(String agencyLang) {
        this.agencyLang = agencyLang;
    }

    @Column(name = "agency_phone", length = 50)
    public String getAgencyPhone() {
        return this.agencyPhone;
    }

    public void setAgencyPhone(String agencyPhone) {
        this.agencyPhone = agencyPhone;
    }

    @Column(name = "agency_fare_url")
    public String getAgencyFareUrl() {
        return this.agencyFareUrl;
    }

    public void setAgencyFareUrl(String agencyFareUrl) {
        this.agencyFareUrl = agencyFareUrl;
    }

}
