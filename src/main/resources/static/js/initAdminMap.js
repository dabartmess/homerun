let adminMap;
let driverMarkers = {}; // Store markers by ID to update position

function initAdminMap() {
    adminMap = new google.maps.Map(document.getElementById("adminMap"), {
        center: { lat: 37.7749, lng: -122.4194 },
        zoom: 11
    });
    
    // Refresh driver positions every 5 seconds
    setInterval(updateDriverPositions, 5000);
}

async function updateDriverPositions() {
    const response = await fetch('/api/admin/active-drivers');
    const drivers = await response.json();
    
    document.getElementById("driverCount").innerText = drivers.length;

    drivers.forEach(driver => {
        const pos = { lat: driver.latitude, lng: driver.longitude };
        
        if (driverMarkers[driver.id]) {
            // Move existing marker smoothly
            driverMarkers[driver.id].setPosition(pos);
        } else {
            // Create new marker with a car icon
            driverMarkers[driver.id] = new google.maps.Marker({
                position: pos,
                map: adminMap,
                title: driver.name,
                icon: 'https://maps.google.com/mapfiles/kml/pal2/icon47.png'
            });
        }
    });
}
