// Dummy event list
const events = [
  {
    name: "Community Cleanup Day",
    date: "2025-04-12",
    location: "Central Park",
    category: "Environment",
    seats: 30,
    image: "https://images.stockcake.com/public/4/4/b/44b753ab-4342-429d-b65a-0ca65b0cddfe_medium/community-cleanup-effort-stockcake.jpg"
  },
  {
    name: "Music Festival",
    date: "2025-06-20",
    location: "City Stadium",
    category: "Entertainment",
    seats: 50,
    image: "https://www.visitmusiccity.com/sites/default/files/styles/featured_promo/public/2025-03/Bonnaroo-MusicFestival_0.png.webp?itok=JLdffUr8"
  },
  {
    name: "Art Workshop for Kids",
    date: "2025-03-25",
    location: "Community Hall",
    category: "Education",
    seats: 20,
    image: "https://static.wixstatic.com/media/0da0bc_1e858878a6084e40b87608192b08434e~mv2.jpeg"
  }
];

function displayEventCards(selectedCategory = "All") {
  const container = document.getElementById("eventCards");
  container.innerHTML = "";

  const filteredEvents = selectedCategory === "All"
    ? events
    : events.filter(event => event.category === selectedCategory);

  filteredEvents.forEach(event => {
    const col = document.createElement("div");
    col.className = "col-md-4 mb-4";

    col.innerHTML = `
      <div class="card h-100 shadow-sm">
        <img src="${event.image}" class="card-img-top" alt="${event.name}" style="height: 200px; object-fit: cover;" />
        <div class="card-body">
          <h5 class="card-title">${event.name}</h5>
          <p class="card-text">
            <strong>Date:</strong> ${event.date}<br>
            <strong>Location:</strong> ${event.location}<br>
            <strong>Category:</strong> ${event.category}<br>
            <strong>Seats:</strong> ${event.seats}
          </p>
          <a href="#register" class="btn btn-primary">Register Now</a>
        </div>
      </div>
    `;

    container.appendChild(col);
  });
}


window.addEventListener("DOMContentLoaded", displayEventCards);

// Bootstrap Form Validation
document.getElementById('bootstrapForm').addEventListener('submit', function (e) {
  e.preventDefault();

  const form = e.target;
  if (!form.checkValidity()) {
    form.classList.add('was-validated');
    return;
  }

  const name = document.getElementById('name').value.trim();
  const email = document.getElementById('email').value.trim();
  const event = document.getElementById('event').value;

  document.getElementById('registerSuccess').classList.remove('d-none');
  document.getElementById('registerSuccess').textContent = `✅ Thank you, ${name}! You've registered for ${event}. Confirmation sent to ${email}.`;

  form.reset();
  form.classList.remove('was-validated');
});


