SELECT 
  e.event_name, 
  e.event_date
FROM 
  Events e
LEFT JOIN 
  Registrations r ON e.event_id = r.event_id
WHERE 
  r.user_id IS NULL
ORDER BY 
  e.event_date;
