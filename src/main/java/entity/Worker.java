package entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Worker {

    public Worker(String fullName, String externalId) {
        this.fullName = fullName;
        this.externalId = externalId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "external_id")
    private String externalId;

    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER)
    private List<Task> tasks;

}
