package PDF.Generator.PDFgenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


import javax.persistence.GenerationType;

@Entity
@Table(name = "identity_card")
public class Identity_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @NonNull
    @
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "place_of_birthday")
    private String place_of_birthday;

    @Column(name = "date_of_birthday")
    private String date_of_birthday;

    @Column(name = "date_of_expiry")
    private String date_of_expiry;

    @Column(name = "date_of_issue")
    private String date_of_issue;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "issued_by")
    private String issued_by;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "personal_number")
    @NonNull
    private long personal_number;

    @Column(name = "residence")
    private String residence;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }

    public String getFirstName(){
        return first_name;
    }

    public void setFirstName(String firstName){
        this.first_name = firstName;
    }

    public String getLastName(){
        return last_name;
    }

    public void setLastName(String lastName){
        this.last_name = lastName;
    }

    public String getPlaceOfBirthday(){
        return place_of_birthday;
    }

    public void setPlaceOfBirthday(String placeOfBirthday){
        this.place_of_birthday = placeOfBirthday;
    }

    public String getDateOfBirthday(){
        return date_of_birthday;
    }

    public void setDateOfBirthday(String dateOfBirthday){
        this.date_of_birthday = dateOfBirthday;
    }

    public String getDateOfExpiry(){
        return date_of_expiry;
    }

    public void setDateOfExpiry(String dateOfExpiry){
        this.date_of_expiry = dateOfExpiry;
    }

    public String getDateOfIssue(){
        return date_of_issue;
    }

    public void setDateOfIssue(String dateOfIssue){
        this.date_of_issue = dateOfIssue;
    }

    public Character getGender(){
        return gender;
    }

    public void setGender(Character gender){
        this.gender = gender;
    }

    public String getIssuedBy(){
        return issued_by;
    }

    public void setIssuedBy(String issuedBy){
        this.issued_by = issuedBy;
    }

    public String getNationality(){
        return nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    public long getPersonalNumber(){
        return personal_number;
    }
    public void setPersonalNumber(long personalNumber){
        this.personal_number = personalNumber;
    }

    public String getResidence(){
        return residence;
    }

    public void setResidence(String residence){
        this.residence = residence;
    }
}
