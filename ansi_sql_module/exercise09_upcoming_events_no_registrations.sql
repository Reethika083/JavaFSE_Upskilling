SELECT 
  e.title AS event_title,
  e.start_date
FROM 
  Events e
LEFT JOIN 
  Registrations r ON e.event_id = r.event_id
WHERE 
  r.registration_id IS NULL
  AND e.status = 'upcoming'
ORDER BY 
  e.start_date;
