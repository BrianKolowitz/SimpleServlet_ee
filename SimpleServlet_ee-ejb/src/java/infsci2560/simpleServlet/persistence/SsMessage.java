/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infsci2560.simpleServlet.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kolowitzbj
 */
@Entity
@Table(name = "SS_MESSAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SsMessage.findAll", query = "SELECT s FROM SsMessage s"),
    @NamedQuery(name = "SsMessage.findByMessageid", query = "SELECT s FROM SsMessage s WHERE s.messageid = :messageid"),
    @NamedQuery(name = "SsMessage.findByAuthor", query = "SELECT s FROM SsMessage s WHERE s.author = :author"),
    @NamedQuery(name = "SsMessage.findByTitle", query = "SELECT s FROM SsMessage s WHERE s.title = :title"),
    @NamedQuery(name = "SsMessage.findByPtime", query = "SELECT s FROM SsMessage s WHERE s.ptime = :ptime")})
public class SsMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MESSAGEID")
    private Integer messageid;
    @Size(max = 50)
    @Column(name = "AUTHOR")
    private String author;
    @Size(max = 50)
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ptime;
    @Lob
    @Size(max = 32700)
    @Column(name = "MESSAGE")
    private String message;

    public SsMessage() {
    }

    public SsMessage(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageid != null ? messageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SsMessage)) {
            return false;
        }
        SsMessage other = (SsMessage) object;
        if ((this.messageid == null && other.messageid != null) || (this.messageid != null && !this.messageid.equals(other.messageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "infsci2560.persistence.SsMessage[ messageid=" + messageid + " ]";
    }
    
}
