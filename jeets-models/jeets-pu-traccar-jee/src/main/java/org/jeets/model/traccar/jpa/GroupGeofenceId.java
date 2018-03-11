package org.jeets.model.traccar.jpa;
// Generated 15.09.2017 14:36:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GroupGeofenceId generated by hbm2java
 */
@Embeddable
public class GroupGeofenceId implements java.io.Serializable {

    private int groupid;
    private int geofenceid;

    public GroupGeofenceId() {
    }

    public GroupGeofenceId(int groupid, int geofenceid) {
        this.groupid = groupid;
        this.geofenceid = geofenceid;
    }

    @Column(name = "groupid", nullable = false)
    public int getGroupid() {
        return this.groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Column(name = "geofenceid", nullable = false)
    public int getGeofenceid() {
        return this.geofenceid;
    }

    public void setGeofenceid(int geofenceid) {
        this.geofenceid = geofenceid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof GroupGeofenceId))
            return false;
        GroupGeofenceId castOther = (GroupGeofenceId) other;

        return (this.getGroupid() == castOther.getGroupid()) && (this.getGeofenceid() == castOther.getGeofenceid());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getGroupid();
        result = 37 * result + this.getGeofenceid();
        return result;
    }

}