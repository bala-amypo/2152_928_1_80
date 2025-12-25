import java.util.ArrayList;
import java.util.List;

@Transient
private List<AcademicEventEntity> events = new ArrayList<>();

public List<AcademicEventEntity> getEvents() {
    return events;
}
