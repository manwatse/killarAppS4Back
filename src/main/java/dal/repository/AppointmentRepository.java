package dal.repository;

import models.Appointment;

public class AppointmentRepository extends AbstractRepository<Appointment, Integer> {
    @Override
    public Class<Appointment> getDomainClass() {
        return Appointment.class;
    }
}
