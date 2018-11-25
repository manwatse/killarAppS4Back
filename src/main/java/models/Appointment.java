package models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="appointments")
public class Appointment {

   @Id
   @Column(name="appointmentId",nullable = false)
   @GeneratedValue(generator = "incrementor")
   @GenericGenerator(name = "incrementor", strategy = "increment")
   private int appointmentId;

   @Column(name = "name",nullable = false)
   private String name;
   @Column(name = "description",nullable = true)
   private String description;
   @Column(name = "date",nullable = false)
   private Date date;


   //Constructors

   public Appointment(){}

   public Appointment(String name){this.name=name;}

   public Appointment(String name,String description,Date date){
      this.name=name;
      this.description = description;
      this.date=date;
   }

   public Appointment(int appointmentId,String name,String description,Date date){
      this.appointmentId=appointmentId;
      this.name=name;
      this.description = description;
      this.date=date;
   }

   // Getter Setters

   public int getAppointmentId() {
      return appointmentId;
   }

   public void setAppointmentId(int appointmentId) {
      this.appointmentId = appointmentId;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }


   // Methods


}
