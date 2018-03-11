package org.jeets.model.traccar.jpa;
// Generated 15.09.2017 14:36:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GroupAttributeId generated by hbm2java
 */
@Embeddable
public class GroupAttributeId implements java.io.Serializable {

    private int groupid;
    private int attributeid;

    public GroupAttributeId() {
    }

    public GroupAttributeId(int groupid, int attributeid) {
        this.groupid = groupid;
        this.attributeid = attributeid;
    }

    @Column(name = "groupid", nullable = false)
    public int getGroupid() {
        return this.groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    @Column(name = "attributeid", nullable = false)
    public int getAttributeid() {
        return this.attributeid;
    }

    public void setAttributeid(int attributeid) {
        this.attributeid = attributeid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof GroupAttributeId))
            return false;
        GroupAttributeId castOther = (GroupAttributeId) other;

        return (this.getGroupid() == castOther.getGroupid()) && (this.getAttributeid() == castOther.getAttributeid());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getGroupid();
        result = 37 * result + this.getAttributeid();
        return result;
    }

}
