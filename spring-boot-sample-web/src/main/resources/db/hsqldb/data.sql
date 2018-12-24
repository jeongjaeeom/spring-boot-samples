INSERT INTO account(id, username,password,email) VALUES (1, 'admin', '{bcrypt}$2a$10$4zqGoL3mhT27CyxoXSRHo.XrtcNKDsswhetpVdHnH6qW2zrzo76QG', 'jeongjae.eom@gmail.com');
INSERT INTO account(id, username,password,email) VALUES (2, 'user', '{bcrypt}$2a$10$4zqGoL3mhT27CyxoXSRHo.XrtcNKDsswhetpVdHnH6qW2zrzo76QG', 'jeongjae.eom@gmail.com');
INSERT INTO role (id, name) VALUES (1, 'ADMIN');
INSERT INTO role (id, name) VALUES (2, 'USER');
INSERT INTO account_role (account_id, role_id) VALUES (1, 1);
INSERT INTO account_role (account_id, role_id) VALUES (2, 2);