SELECT 
  u.full_name,
  COUNT(r.event_id) AS registration_count
FROM 
  Users u
JOIN 
  Registrations r ON u.user_id = r.user_id
GROUP BY 
  u.user_id, u.full_name
HAVING 
  COUNT(r.event_id) > 3
ORDER BY 
  registration_count DESC;
