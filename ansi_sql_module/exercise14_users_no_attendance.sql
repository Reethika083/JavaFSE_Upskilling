SELECT 
  u.user_id,
  u.full_name,
  u.email
FROM 
  Users u
JOIN 
  Registrations r ON u.user_id = r.user_id
LEFT JOIN 
  Sessions s ON r.event_id = s.event_id
LEFT JOIN 
  Attendance a ON s.session_id = a.session_id AND u.user_id = a.user_id
WHERE 
  a.attendance_id IS NULL
GROUP BY 
  u.user_id, u.full_name, u.email;
