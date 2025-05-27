SELECT 
  s.session_title,
  e.title AS event_title,
  AVG(f.rating) AS average_rating,
  COUNT(f.feedback_id) AS total_feedbacks
FROM 
  Sessions s
JOIN 
  Events e ON s.event_id = e.event_id
LEFT JOIN 
  Feedback f ON s.session_id = f.session_id
GROUP BY 
  s.session_title, e.title
ORDER BY 
  average_rating DESC;
