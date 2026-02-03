@RestController
@RequestMapping("/api/admin")
public class AdminDashboardController {

    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/active-drivers")
    public List<DriverLocationDTO> getLiveDrivers() {
        return driverRepository.findAllActive().stream().map(driver -> {
            return new DriverLocationDTO(
                driver.getDriverId(),
                driver.getUser().getFullName(),
                driver.getCurrentLocation().getX(), // Longitude
                driver.getCurrentLocation().getY(), // Latitude
                driver.getIsAvailable()
            );
        }).collect(Collectors.toList());
    }
}
