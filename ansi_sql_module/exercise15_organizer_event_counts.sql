SELECT 
  o.organizer_id,
  o.organizer_name,
  COUNT(e.event_id) AS events_organized
FROM 
  Organizers o
LEFT JOIN 
  Events e ON o.organizer_id = e.organizer_id
GROUP BY 
  o.organizer_id, o.organizer_name
ORDER BY 
  events_organized DESC;
