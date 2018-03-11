package org.jeets.model.traccar.jpa;
// Generated 15.09.2017 14:36:40 by Hibernate Tools 4.3.5.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Devices generated by hbm2java
 */
@Entity
@Table(name = "devices", schema = "public", uniqueConstraints = @UniqueConstraint(columnNames = "uniqueid"))
public class Devices implements java.io.Serializable {

    private int id;
    private Groups groups;
    private String name;
    private String uniqueid;
    private Date lastupdate;
    private Integer positionid;
    private String attributes;
    private String phone;
    private String model;
    private String contact;
    private String category;
    private Set<DeviceDriver> deviceDrivers = new HashSet<DeviceDriver>(0);
    private Set<DeviceAttribute> deviceAttributes = new HashSet<DeviceAttribute>(0);
    private Set<UserDevice> userDevices = new HashSet<UserDevice>(0);
    private Set<DeviceGeofence> deviceGeofences = new HashSet<DeviceGeofence>(0);
    private Set<Events> eventses = new HashSet<Events>(0);
    private Set<Positions> positionses = new HashSet<Positions>(0);

    public Devices() {
    }

    public Devices(int id, String name, String uniqueid) {
        this.id = id;
        this.name = name;
        this.uniqueid = uniqueid;
    }

    public Devices(int id, Groups groups, 
            String name, String uniqueid, Date lastupdate, Integer positionid,
            String attributes, String phone, String model, String contact, String category,
            Set<DeviceDriver> deviceDrivers, Set<DeviceAttribute> deviceAttributes, 
            Set<UserDevice> userDevices,
            Set<DeviceGeofence> deviceGeofences, 
            Set<Events> eventses, Set<Positions> positionses) {
        this.id = id;
        this.groups = groups;
        this.name = name;
        this.uniqueid = uniqueid;
        this.lastupdate = lastupdate;
        this.positionid = positionid;
        this.attributes = attributes;
        this.phone = phone;
        this.model = model;
        this.contact = contact;
        this.category = category;
        this.deviceDrivers = deviceDrivers;
        this.deviceAttributes = deviceAttributes;
        this.userDevices = userDevices;
        this.deviceGeofences = deviceGeofences;
        this.eventses = eventses;
        this.positionses = positionses;
    }

    @Id

    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid")
    public Groups getGroups() {
        return this.groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    @Column(name = "name", nullable = false, length = 128)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "uniqueid", unique = true, nullable = false, length = 128)
    public String getUniqueid() {
        return this.uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "lastupdate", length = 29)
    public Date getLastupdate() {
        return this.lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    @Column(name = "positionid")
    public Integer getPositionid() {
        return this.positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    @Column(name = "attributes", length = 4000)
    public String getAttributes() {
        return this.attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    @Column(name = "phone", length = 128)
    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "model", length = 128)
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "contact", length = 512)
    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Column(name = "category", length = 128)
    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<DeviceDriver> getDeviceDrivers() {
        return this.deviceDrivers;
    }

    public void setDeviceDrivers(Set<DeviceDriver> deviceDrivers) {
        this.deviceDrivers = deviceDrivers;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<DeviceAttribute> getDeviceAttributes() {
        return this.deviceAttributes;
    }

    public void setDeviceAttributes(Set<DeviceAttribute> deviceAttributes) {
        this.deviceAttributes = deviceAttributes;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<UserDevice> getUserDevices() {
        return this.userDevices;
    }

    public void setUserDevices(Set<UserDevice> userDevices) {
        this.userDevices = userDevices;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<DeviceGeofence> getDeviceGeofences() {
        return this.deviceGeofences;
    }

    public void setDeviceGeofences(Set<DeviceGeofence> deviceGeofences) {
        this.deviceGeofences = deviceGeofences;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<Events> getEventses() {
        return this.eventses;
    }

    public void setEventses(Set<Events> eventses) {
        this.eventses = eventses;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "devices")
    public Set<Positions> getPositionses() {
        return this.positionses;
    }

    public void setPositionses(Set<Positions> positionses) {
        this.positionses = positionses;
    }

}