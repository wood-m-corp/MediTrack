import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class VisitNote {
    private String note;
    private LocalDateTime timestamp;

    public VisitNote(String note) {
        this.note = note;
        this.timestamp = LocalDateTime.now();
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "[" + timestamp.format(formatter) + "] " + note;
    }
}
