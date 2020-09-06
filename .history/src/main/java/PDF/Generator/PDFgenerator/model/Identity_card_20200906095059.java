package PDF.Generator.PDFgenerator.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;

@Entity
@Table(name = "identity_card")
public class Identity_card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
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
    private String gender;

    @Column(name = "issued_by")
    private String issued_by;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "personal_number")
    private String personal_number;

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
    public void setFirstName(String DateOfBirthday){
        this.date_of_birthday = firstName;
    }







}
