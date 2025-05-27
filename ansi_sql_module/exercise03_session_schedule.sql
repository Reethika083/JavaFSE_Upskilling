SELECT 
  e.title AS event_title,
  s.session_title,
  s.speaker,
  s.start_time
FROM 
  Events e
JOIN 
  Sessions s ON e.event_id = s.event_id
WHERE 
  e.title = 'Your Event Title Here'
ORDER BY 
  s.start_time;
