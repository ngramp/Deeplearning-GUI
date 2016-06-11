package util.hibernatesucks;


import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@TypeDefs({ @TypeDef(name = "IntegerArrayObject", typeClass = IntegerArrayType.class) })
public class UserContact {

    @Id
    @GeneratedValue
    private Long id;

    @Type(type = "IntegerArrayObject")
    private Integer[] contact;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer[] getContact() {
        return contact;
    }

    public void setContact(Integer[] contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "UserContact [id=" + id + ", contact="
                + Arrays.toString(contact) + "]";
    }

}