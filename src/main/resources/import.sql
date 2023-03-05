INSERT INTO public.role(nome_role) VALUES ('ROLE_ADMINISTRADOR');
INSERT INTO public.role(nome_role) VALUES ('ROLE_GERENTE');
INSERT INTO public.role(nome_role) VALUES ('ROLE_COLABORADOR');

INSERT INTO public.usuario( login, nome, senha) VALUES ( 'higorluiz', 'Higor Luiz', '$2a$10$vaoZVjxFEzWtITntwRgnwOeN2VOSIy.1ypiaMGtkpQHQrT8yTXGGW');
INSERT INTO public.usuario( login, nome, senha) VALUES ( 'anapaula', 'Ana Paula', '$2a$10$vaoZVjxFEzWtITntwRgnwOeN2VOSIy.1ypiaMGtkpQHQrT8yTXGGW');
INSERT INTO public.usuario( login, nome, senha) VALUES ( 'mayaralorena', 'Mayara Lorena', '$2a$10$vaoZVjxFEzWtITntwRgnwOeN2VOSIy.1ypiaMGtkpQHQrT8yTXGGW');

INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (1, 1);
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (2, 2);
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (3, 3);