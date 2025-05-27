SELECT 
  e.event_id,
  e.title
FROM 
  Events e
LEFT JOIN 
  Registrations r ON e.event_id = r.event_id
WHERE 
  r.registration_id IS NULL;
