CREATE TABLE responses (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    message VARCHAR(500) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    solution BOOLEAN NOT NULL,
    author_id BIGINT NOT NULL,
    topic_id BIGINT NOT NULL,
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (topic_id) REFERENCES topics(id)
);