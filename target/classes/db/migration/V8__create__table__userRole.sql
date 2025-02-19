CREATE TABLE user_roles(
    id bigint NOT NULL AUTO_INCREMENT,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(user_id) REFERENCES users(id),
    FOREIGN KEY(role_id) REFERENCES role(id)
);

INSERT INTO user_roles (id, user_id, role_id) VALUES (1, 1, 1);