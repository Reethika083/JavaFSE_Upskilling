// Log a welcome message to the console
console.log("Welcome to the Community Portal");

window.addEventListener('load', () => {
  alert("Page is fully loaded. Welcome to the Community Portal!");
});

// ====== Event Class with Methods ======

class Event {
  constructor(name, date, availableSeats, category) {
    this.name = name;
    this.date = date;
    this.availableSeats = availableSeats;
    this.category = category;
  }

  checkAvailability() {
    const today = new Date().toISOString().split('T')[0];
    return this.date >= today && this.availableSeats > 0;
  }

  listDetails() {
    return Object.entries(this)
      .map(([key, value]) => `${key}: ${value}`)
      .join(', ');
  }
}

// ====== Event Instances ======
const events = [
  new Event("Community Music Festival", "2025-06-15", 50, "Music"),
  new Event("Art Workshop", "2024-04-10", 0, "Art"),
  new Event("Farmers Market", "2025-07-01", 10, "Market"),
  new Event("Book Reading", "2023-12-01", 5, "Literature")
];

// Use spread operator to clone event list before filtering
const validEvents = [...events].filter(({ date, availableSeats }) => date >= new Date().toISOString().split('T')[0] && availableSeats > 0);

console.log("Upcoming events with available seats:");
validEvents.forEach(({ name, date, availableSeats }) => {
  console.log(`- ${name} on ${date} (${availableSeats} seats available)`);
});

// Add a new event dynamically
function addEvent(name, date, seats, category) {
  const newEvent = new Event(name, date, seats, category);
  events.push(newEvent);
  console.log(`Event "${name}" added.`);
}

// Closure to track total registrations per category
function createRegistrationTracker() {
  const registrations = {};
  return function(category) {
    if (!registrations[category]) {
      registrations[category] = 0;
    }
    registrations[category]++;
    console.log(`Total registrations for category "${category}": ${registrations[category]}`);
  };
}

const trackRegistration = createRegistrationTracker();

// Register for an event and track category
function registerForEvent(eventName) {
  try {
    const today = new Date().toISOString().split('T')[0];
    const event = events.find(e => e.name === eventName && e.date >= today && e.availableSeats > 0);

    if (!event) throw new Error("Event not found or registration closed.");
    event.availableSeats--;
    console.log(`Successfully registered for ${event.name}. Seats left: ${event.availableSeats}`);
    trackRegistration(event.category);
  } catch (error) {
    console.error("Registration failed:", error.message);
  }
}

// Higher-order filter by dynamic condition
const filterEventsByCategory = (filterCallback = () => true) => [...events].filter(filterCallback);

// ====== Example Usage ======
addEvent("Charity Run", "2025-08-12", 30, "Sports");

registerForEvent("Community Music Festival");
registerForEvent("Art Workshop");
registerForEvent("Charity Run");

// Show only music events
const musicEvents = filterEventsByCategory(({ category }) => category === "Music");
console.log("Music events:");
musicEvents.forEach(event => {
  console.log(event.listDetails()); // prints key-value format
});

// ====== Task 6: Arrays and Methods ======

// 1. Add new events using .push()
const addNewCommunityEvent = (name, date, seats, category) => {
  const newEvent = new Event(name, date, seats, category);
  events.push(newEvent); // Array .push()
  console.log(`New event "${name}" added successfully!`);
};

// Add two example events
addNewCommunityEvent("Music Night", "2025-10-15", 40, "Music");
addNewCommunityEvent("Baking Workshop", "2025-11-05", 25, "Cooking");


// 2. Filter music events using destructuring
const musicOnlyEvents = [...events].filter(({ category }) => category === "Music");

console.log("\n🎵 Music Events:");
musicOnlyEvents.forEach(({ name }) => console.log(`- ${name}`));

// 3. Map to format display cards
const formattedEventCards = [...events].map(({ name, category }) => {
  if (name.toLowerCase().includes("workshop")) {
    // Extract topic if 'Workshop on ...'
    const topic = name.replace(/.*Workshop\s(on)?/i, '').trim() || category;
    return `Workshop on ${topic}`;
  } else {
    return `Event: ${name}`;
  }
});

console.log("\n📝 Formatted Event Cards:");
formattedEventCards.forEach(card => console.log(card));

// ====== DOM Manipulation: Display Events Dynamically ======

// Access the DOM container
const eventListContainer = document.querySelector("#event-list");

// Utility to clear existing event cards
function clearEventCards() {
  eventListContainer.innerHTML = "";
}

// Create and display all events
function displayEvents() {
  clearEventCards();

  events.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.style.border = "1px solid #ccc";
    card.style.padding = "10px";
    card.style.marginBottom = "10px";
    card.style.borderRadius = "5px";

    const title = document.createElement("h3");
    title.textContent = event.name;

    const date = document.createElement("p");
    date.textContent = `Date: ${event.date}`;

    const category = document.createElement("p");
    category.textContent = `Category: ${event.category}`;

    const seats = document.createElement("p");
    seats.textContent = `Available Seats: ${event.availableSeats}`;

    const registerBtn = document.createElement("button");
    registerBtn.textContent = "Register";
    registerBtn.disabled = event.availableSeats <= 0;
    registerBtn.style.marginRight = "10px";
    registerBtn.onclick = () => {
      registerForEvent(event.name);
      displayEvents(); // update UI
    };

    const cancelBtn = document.createElement("button");
    cancelBtn.textContent = "Cancel";
    cancelBtn.onclick = () => {
      event.availableSeats++;
      console.log(`Cancelled: ${event.name}. Seats now: ${event.availableSeats}`);
      displayEvents(); // update UI
    };

    card.appendChild(title);
    card.appendChild(date);
    card.appendChild(category);
    card.appendChild(seats);
    card.appendChild(registerBtn);
    card.appendChild(cancelBtn);

    eventListContainer.appendChild(card);
  });
}

// Call it once on load
displayEvents();


// Access new elements
const categoryFilter = document.querySelector("#categoryFilter");
const searchBox = document.querySelector("#searchBox");

// Current filters
let selectedCategory = "All";
let searchTerm = "";

// Function to filter and display events
function displayEvents() {
  clearEventCards();

  const filtered = events.filter(event => {
    const matchesCategory =
      selectedCategory === "All" || event.category === selectedCategory;
    const matchesSearch = event.name
      .toLowerCase()
      .includes(searchTerm.toLowerCase());

    return matchesCategory && matchesSearch;
  });

  if (filtered.length === 0) {
    const noResult = document.createElement("p");
    noResult.textContent = "No events found.";
    eventListContainer.appendChild(noResult);
    return;
  }

  filtered.forEach(event => {
    const card = document.createElement("div");
    card.className = "event-card";
    card.style.border = "1px solid #ccc";
    card.style.padding = "10px";
    card.style.marginBottom = "10px";
    card.style.borderRadius = "5px";

    const title = document.createElement("h3");
    title.textContent = event.name;

    const date = document.createElement("p");
    date.textContent = `Date: ${event.date}`;

    const category = document.createElement("p");
    category.textContent = `Category: ${event.category}`;

    const seats = document.createElement("p");
    seats.textContent = `Available Seats: ${event.availableSeats}`;

    const registerBtn = document.createElement("button");
    registerBtn.textContent = "Register";
    registerBtn.disabled = event.availableSeats <= 0;

    registerBtn.onclick = () => {
      registerForEvent(event.name);
      displayEvents(); // update UI
    };

    const cancelBtn = document.createElement("button");
    cancelBtn.textContent = "Cancel";
    cancelBtn.onclick = () => {
      event.availableSeats++;
      console.log(`Cancelled: ${event.name}. Seats now: ${event.availableSeats}`);
      displayEvents(); // update UI
    };

    card.appendChild(title);
    card.appendChild(date);
    card.appendChild(category);
    card.appendChild(seats);
    card.appendChild(registerBtn);
    card.appendChild(cancelBtn);

    eventListContainer.appendChild(card);
  });
}

// Category filter onchange
categoryFilter.addEventListener("change", e => {
  selectedCategory = e.target.value;
  displayEvents();
});

// Search keydown (live filtering)
searchBox.addEventListener("keydown", e => {
  // Slight delay to capture input
  setTimeout(() => {
    searchTerm = e.target.value;
    displayEvents();
  }, 0);
});
