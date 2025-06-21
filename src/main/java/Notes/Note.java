package Notes;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.List;


@Entity
@Table(name= "Notes")
public class Note {
    @Id
    @GeneratedValue
    public Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "logId", referencedColumnName = "logId")
    public Log log;

    public String message;

    public Instant created = Instant.now();

    public Instant updated;

    public Note(){}

}
