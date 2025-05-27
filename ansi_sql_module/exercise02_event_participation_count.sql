SELECT 
  e.title AS event_title,
  COUNT(r.user_id) AS total_registrations
FROM 
  Events e
LEFT JOIN 
  Registrations r ON e.event_id = r.event_id
GROUP BY 
  e.title
ORDER BY 
  total_registrations DESC;
