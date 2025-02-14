CREATE TABLE topics (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    message VARCHAR(500) NOT NULL,
    created_date TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    course_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,
    FOREIGN KEY (course_id) REFERENCES courses(id),
    FOREIGN KEY (author_id) REFERENCES users(id)
);

