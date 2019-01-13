package models;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="appointments")
public class Appointment {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   @Column(nullable = false)
   private int userid;
   private String name;
   private Date beginDate;
   private Date endDate;


   public Appointment(int id,int userid, String name, Date beginDate, Date endDate) {
      this.userid= userid;
      this.id = id;
      this.name = name;
      this.beginDate = beginDate;
      this.endDate = endDate;
   }

   public Appointment() {
   }

   public Appointment(int userid, String name, Date beginDate, Date endDate) {
      this.userid= userid;
      this.name = name;
      this.beginDate = beginDate;
      this.endDate = endDate;
   }

   public int getId() {
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public Date getBeginDate() {
      return beginDate;
   }

   public void setBeginDate(Date beginDate) {
      this.beginDate = beginDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   @Override
   public String toString() {
      return name;
   }
}
