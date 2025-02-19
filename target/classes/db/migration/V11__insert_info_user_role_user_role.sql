INSERT INTO users (name, email, password) VALUES ('admin', 'admin@email.com', '$2a$12$nOAjis3tRpWWppc4GorMr.HUrfbRpGEX6m9slH9JrOJjzjNEWEX2S');
INSERT INTO role (name) VALUES ('ADMIN');
INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);