SELECT 
  p.participant_name,
  COUNT(r.event_id) AS events_attended
FROM 
  Participants p
JOIN 
  Registrations r ON p.participant_id = r.participant_id
GROUP BY 
  p.participant_id, p.participant_name
ORDER BY 
  events_attended DESC
LIMIT 3;
