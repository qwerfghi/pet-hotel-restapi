package com.qwerfghi.hotel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner", schema = "hostel")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idowner")
public class Owner {
    private int idowner;
    private String ownerName;
    private String ownerLastName;
    private String ownerPatronymic;
    private String passport;
    private String phoneNum;
    private String email;
    private Discount discount;
    private Address address;
    @JsonBackReference
    private List<Animal> animalList;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "idowner")
    public int getIdowner() {
        return idowner;
    }

    public void setIdowner(int idowner) {
        this.idowner = idowner;
    }

    @Basic
    @Column(name = "owner_name")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Basic
    @Column(name = "owner_last_name")
    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    @Basic
    @Column(name = "owner_patronymic")
    public String getOwnerPatronymic() {
        return ownerPatronymic;
    }

    public void setOwnerPatronymic(String ownerPatronymic) {
        this.ownerPatronymic = ownerPatronymic;
    }

    @Basic
    @Column(name = "passport")
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "phone_num")
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "discount")
    @Convert(converter = DiscountConverter.class)
    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "idaddress", foreignKey = @ForeignKey(name = "fk_address"))
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner that = (Owner) o;

        if (idowner != that.idowner) return false;
        if (ownerName != null ? !ownerName.equals(that.ownerName) : that.ownerName != null) return false;
        if (ownerLastName != null ? !ownerLastName.equals(that.ownerLastName) : that.ownerLastName != null)
            return false;
        if (ownerPatronymic != null ? !ownerPatronymic.equals(that.ownerPatronymic) : that.ownerPatronymic != null)
            return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idowner;
        result = 31 * result + (ownerName != null ? ownerName.hashCode() : 0);
        result = 31 * result + (ownerLastName != null ? ownerLastName.hashCode() : 0);
        result = 31 * result + (ownerPatronymic != null ? ownerPatronymic.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        return result;
    }

    @Converter
    public static class DiscountConverter implements AttributeConverter<Discount, String> {

        @Override
        public String convertToDatabaseColumn(Discount value) {
            if (value == null) {
                return null;
            }
            return value.getDiscount();
        }

        @Override
        public Discount convertToEntityAttribute(String value) {
            if (value == null) {
                return null;
            }
            return Discount.fromCode(value);
        }
    }

    @OneToMany(mappedBy = "owner")
    @Fetch(value = FetchMode.JOIN)
    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }
}