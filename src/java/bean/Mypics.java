/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dinesh
 */
@Entity
@Table(name = "MYPICS")
@NamedQueries({
    @NamedQuery(name = "Mypics.findAll", query = "SELECT m FROM Mypics m"),
    @NamedQuery(name = "Mypics.findByPicid", query = "SELECT m FROM Mypics m WHERE m.picid = :picid"),
    @NamedQuery(name = "Mypics.findByPicname", query = "SELECT m FROM Mypics m WHERE m.picname = :picname"),
    @NamedQuery(name = "Mypics.findByPiclink", query = "SELECT m FROM Mypics m WHERE m.piclink = :piclink"),
    @NamedQuery(name = "Mypics.findByPiccomment", query = "SELECT m FROM Mypics m WHERE m.piccomment = :piccomment")})
public class Mypics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PICID")
    private Integer picid;
    @Column(name = "PICNAME")
    private String picname;
    @Column(name = "PICLINK")
    private String piclink;
    @Column(name = "PICCOMMENT")
    private String piccomment;

    public Mypics() {
    }

    public Mypics(Integer picid) {
        this.picid = picid;
    }

    public Integer getPicid() {
        return picid;
    }

    public void setPicid(Integer picid) {
        this.picid = picid;
    }

    public String getPicname() {
        return picname;
    }

    public void setPicname(String picname) {
        this.picname = picname;
    }

    public String getPiclink() {
        return piclink;
    }

    public void setPiclink(String piclink) {
        this.piclink = piclink;
    }

    public String getPiccomment() {
        return piccomment;
    }

    public void setPiccomment(String piccomment) {
        this.piccomment = piccomment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (picid != null ? picid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mypics)) {
            return false;
        }
        Mypics other = (Mypics) object;
        if ((this.picid == null && other.picid != null) || (this.picid != null && !this.picid.equals(other.picid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bean.Mypics[picid=" + picid + "]";
    }

}
