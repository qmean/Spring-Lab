insert ignore into users (id, username, password, enabled) values (NULL, 'john', 12345, 1);
insert ignore into authorities (id, username, authority) values (NULL, 'user', 'write');