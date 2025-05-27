SELECT 
  s.session_title,
  r.resource_name,
  r.resource_type
FROM 
  Sessions s
JOIN 
  Resources r ON s.session_id = r.session_id
ORDER BY 
  s.session_title, r.resource_name;
