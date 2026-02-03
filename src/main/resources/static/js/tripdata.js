let map, pickupMarker, destMarker;

function initMap() {
    map = new google.maps.Map(document.getElementById("map"), {
        center: { lat: 37.7749, lng: -122.4194 }, // Default center
        zoom: 12,
    });

    // Add Autocomplete to inputs
    const pickupInput = document.getElementById("pickupAddress");
    const destInput = document.getElementById("destAddress");
    
    const autocompletePickup = new google.maps.places.Autocomplete(pickupInput);
    const autocompleteDest = new google.maps.places.Autocomplete(destInput);

    // Update map when pickup address changes
    autocompletePickup.addListener("place_changed", () => {
        const place = autocompletePickup.getPlace();
        if (place.geometry) {
            map.setCenter(place.geometry.location);
            if (pickupMarker) pickupMarker.setMap(null);
            pickupMarker = new google.maps.Marker({ map, position: place.geometry.location, label: "A" });
        }
    });
}

// Handle Form Submission
document.getElementById("riderForm").addEventListener("submit", async (e) => {
    e.preventDefault();
    
    const tripData = {
        riderName: document.getElementById("riderName").value,
        pickupAddress: document.getElementById("pickupAddress").value,
        destinationAddress: document.getElementById("destAddress").value
    };

    const response = await fetch('/api/trips/request', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(tripData)
    });

    if (response.ok) alert("Ride Requested Successfully!");
});

window.onload = initMap;
