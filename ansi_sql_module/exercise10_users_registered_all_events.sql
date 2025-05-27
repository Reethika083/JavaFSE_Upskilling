SELECT 
  u.user_id,
  u.full_name
FROM 
  Users u
WHERE 
  NOT EXISTS (
    SELECT 
      e.event_id
    FROM 
      Events e
    WHERE 
      NOT EXISTS (
        SELECT 
          r.registration_id
        FROM 
          Registrations r
        WHERE 
          r.user_id = u.user_id 
          AND r.event_id = e.event_id
      )
  );
