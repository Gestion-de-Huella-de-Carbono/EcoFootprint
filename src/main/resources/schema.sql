CREATE TABLE person (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        last_name VARCHAR(255) NOT NULL,
                        age INT NOT NULL,
                        city VARCHAR(255) NOT NULL,
                        total_carbon_footprint DOUBLE NOT NULL
);

CREATE TABLE carbon_footprint (
                                  id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                  transport DOUBLE NOT NULL,
                                  energy DOUBLE NOT NULL,
                                  food DOUBLE NOT NULL,
                                  other DOUBLE NOT NULL,
                                  person_id BIGINT NOT NULL,
                                  FOREIGN KEY (person_id) REFERENCES person(id)
);
