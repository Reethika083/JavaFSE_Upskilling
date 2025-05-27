SELECT 
  s.session_title
FROM 
  Sessions s
LEFT JOIN 
  Feedback f ON s.session_id = f.session_id
WHERE 
  f.feedback_id IS NULL;
