INSERT IGNORE INTO spring_security_test.user (id, username, password, algorithm)
VALUES (1, 'john', '$2y$04$mgwyld2rjDyH36v554KdyOgG8RGWe7j6tqYqAOozDn2lJEtValV1y', 'BCRYPT');

INSERT IGNORE INTO spring_security_test.authority (id, user, name)
VALUES ('1', 'READ', '1');

INSERT IGNORE INTO spring_security_test.authority (id, user, name)
VALUES ('1', 'WRITE', '1');

INSERT IGNORE INTO spring_security_test.product (id, name, price, currency)
VALUES ('1', 'Chocolate', '10', 'USD');