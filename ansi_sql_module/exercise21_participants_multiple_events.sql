SELECT 
  p.participant_name,
  p.email,
  COUNT(r.event_id) AS event_count
FROM 
  Participants p
JOIN 
  Registrations r ON p.participant_id = r.participant_id
GROUP BY 
  p.participant_id, p.participant_name, p.email
HAVING 
  COUNT(r.event_id) > 3
ORDER BY 
  event_count DESC;
