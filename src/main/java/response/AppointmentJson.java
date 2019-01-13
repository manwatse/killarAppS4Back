package response;

import java.util.Date;

public class AppointmentJson {
    private int id;
    private String name;
    private Date begin;
    private Date end;

    public AppointmentJson(int id, String name, Date begin, Date end) {
        this.id = id;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBegin() {
        return begin;
    }

    public Date getEnd() {
        return end;
    }
}
