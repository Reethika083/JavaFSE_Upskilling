SELECT 
  e.event_name,
  ROUND(AVG(p.age), 2) AS average_age
FROM 
  Events e
JOIN 
  Registrations r ON e.event_id = r.event_id
JOIN 
  Participants p ON r.participant_id = p.participant_id
GROUP BY 
  e.event_id, e.event_name
ORDER BY 
  average_age DESC;
