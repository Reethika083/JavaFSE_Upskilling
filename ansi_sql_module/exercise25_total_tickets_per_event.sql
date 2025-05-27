SELECT 
  e.event_name,
  COALESCE(SUM(r.tickets_sold), 0) AS total_tickets_sold
FROM 
  Events e
LEFT JOIN 
  Registrations r ON e.event_id = r.event_id
GROUP BY 
  e.event_name
ORDER BY 
  total_tickets_sold DESC;
