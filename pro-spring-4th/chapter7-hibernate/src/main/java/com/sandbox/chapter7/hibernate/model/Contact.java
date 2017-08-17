package com.sandbox.chapter7.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by andrii on 22.04.17.
 */
@Entity
@Table(name = "contact")
@NamedQueries({
        @NamedQuery(name = "Contact.findAll",
                query = "select c " +
                        "from Contact c "),
        @NamedQuery(name = "Contact.findById",
                query = "select distinct c " +
                        "from Contact c " +
                        "left join fetch c.contactTelDetails t " +
                        "left join fetch c.hobbies h where c.id = :id"),
        @NamedQuery(name = "Contact.findAllWithDetail",
                query = "select distinct c " +
                        "from Contact c " +
                        "left join fetch c.contactTelDetails t " +
                        "left join fetch c.hobbies h")
})
@SqlResultSetMapping(name = "contactResult", entities = @EntityResult(entityClass = Contact.class))
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Version
    @Column(name = "VERSION")
    private int version;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTH_DATE")
    private Date birthDate;
    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ContactTelDetail> contactTelDetails = new HashSet<ContactTelDetail>();
    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "CONTACT_ID"),
            inverseJoinColumns = @JoinColumn(name = "HOBBY_ID"))
    private Set<Hobby> hobbies = new HashSet<Hobby>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<ContactTelDetail> getContactTelDetails() {
        return this.contactTelDetails;
    }

    public void setContactTelDetails(Set<ContactTelDetail> contactTelDetails) {
        this.contactTelDetails = contactTelDetails;
    }

    public void addContactTelDetail(ContactTelDetail contactTelDetail) {
        contactTelDetail.setContact(this);
        getContactTelDetails().add(contactTelDetail);
    }

    public void removeContactTelDetail(ContactTelDetail contactTelDetail) {
        getContactTelDetails().remove(contactTelDetail);
    }

    public Set<Hobby> getHobbies() {
        return this.hobbies;
    }

    public void setHobbies(Set<Hobby> hobbies) {
        this.hobbies = hobbies;
    }

    public String toString() {
        return "Contact - Id: " + id + ", First name: " + firstName
                + ", Last name: " + lastName + ", Birthday: " + birthDate;
    }
}
