package org.jeets.model.traccar.jpa;
// Generated 15.09.2017 14:36:40 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserGroupId generated by hbm2java
 */
@Embeddable
public class UserGroupId implements java.io.Serializable {

    private int userid;
    private int groupid;

    public UserGroupId() {
    }

    public UserGroupId(int userid, int groupid) {
        this.userid = userid;
        this.groupid = groupid;
    }

    @Column(name = "userid", nullable = false)
    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Column(name = "groupid", nullable = false)
    public int getGroupid() {
        return this.groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof UserGroupId))
            return false;
        UserGroupId castOther = (UserGroupId) other;

        return (this.getUserid() == castOther.getUserid()) && (this.getGroupid() == castOther.getGroupid());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getUserid();
        result = 37 * result + this.getGroupid();
        return result;
    }

}