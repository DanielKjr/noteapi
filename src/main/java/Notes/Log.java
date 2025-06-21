package Notes;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name= "Logs")
public class Log {

    @Id
    @GeneratedValue
    public Long logId;


    public Long NoteId;

    public String previousMessage;

    public Instant created = Instant.now();

    public Instant updated;

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getLogId() {
        return logId;
    }

    public Log(){}
}
