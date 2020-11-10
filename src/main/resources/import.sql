/* Creamos algunos usuarios con sus roles */
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email, cia) VALUES (1, 'andres','$2a$10$C3Uln5uqnzx/GswADURJGOIdBqYrly9731fnwKDaUdBkt/M3qvtLq',1, 'Andres', 'Guzman','profesor@bolsadeideas.com', '01');
INSERT INTO usuarios (id, username, password, enabled, nombre, apellido, email, cia) VALUES (2, 'ADMIN','$2a$10$RmdEsvEfhI7Rcm9f/uZXPebZVCcPC7ZXZwV51efAvMAp1rIaRAfPK',1, 'ADMIN', 'SANTANA LL.','sant4n4.1@gmail.com', '01');

INSERT INTO roles (id, authority) VALUES (3, 'ROLE_USER'); --
INSERT INTO roles (id, authority) VALUES (4, 'ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 3);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 4);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 3);