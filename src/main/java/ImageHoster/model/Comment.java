package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;

//@Entity annotation specifies that the corresponding class is a JPA entity
@Entity

//@Table annotation provides more options to customize the mapping.
//Here the name of the table to be created in the database is explicitly mentioned as 'Comment'. Hence the table named 'Comment' will be created in the database with all the columns mapped to all the attributes in 'Comment' class
@Table(name = "Comment")
public class Comment {

    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private Integer id;

    @Column(name = "text")
    private String text;

    @Column(name = "createdDate")
    private Date createdDate;

    //The 'images' table is mapped to 'users' table with Many:One mapping
    //One image can have only one user (owner) but one user can have multiple images
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "user_id")
    private User user;

    //The 'images' table is mapped to 'users' table with Many:One mapping
    //One image can have only one user (owner) but one user can have multiple images
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    //Below annotation indicates that the name of the column in 'images' table referring the primary key in 'users' table will be 'user_id'
    @JoinColumn(name = "Image")
    private Image Image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ImageHoster.model.Image getImage() {
        return Image;
    }

    public void setImage(ImageHoster.model.Image image) {
        Image = image;
    }
}
