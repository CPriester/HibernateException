package exceptionexample.hibernate;

import java.io.Serializable;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import gov.ic.geoint.util.datagen.ID;
import org.joda.time.LocalDate;

/**
 * Hello world!
 *
 */
@XmlType(name = "meta")
@XmlAccessorType(XmlAccessType.FIELD)
public class App implements Serializable{

    private final static long serialVersionUID = 1L;
    @XmlID
    @XmlAttribute(name = "id", required = false)
 
    private String id;

    
    @XmlElement(name = "relevanceStart", required = false)
    private LocalDate relevanceStart;
    @XmlElement(name = "relevanceEnd", required = false)
    private LocalDate relevanceEnd;
    
     public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getRelevanceStart() {
        return relevanceStart;
    }

    public void setRelevanceStart(LocalDate relevanceStart) {
        this.relevanceStart = relevanceStart;
    }

    public LocalDate getRelevanceEnd() {
        return relevanceEnd;
    }

    public void setRelevanceEnd(LocalDate relevanceEnd) {
        this.relevanceEnd = relevanceEnd;
    }
 protected void afterUnmarshal(Unmarshaller um) {
        if (id == null) {
            generateId();
        }
    }

    private void generateId() {
        id = ID.xmlId();
    }
}
