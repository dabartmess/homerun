import jakarta.persistence.*;
import org.locationtech.jts.geom.Point;
import java.time.LocalDateTime;

@Entity
@Table(name = "drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String licenseNumber;
    
    // Column Definition for PostGIS
    @Column(columnDefinition = "geography(Point, 4326)")
    private Point currentLocation;

    private Boolean isAvailable = true;
    private LocalDateTime lastUpdated = LocalDateTime.now();

    // Getters and Setters...
}
