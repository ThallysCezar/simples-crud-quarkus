--CREATE SEQUENCE hibernate_sequence start 1;

INSERT INTO fruta(id, nome, quantidade) VALUES (nextval('hibernate_sequence'), 'Banana', 10);
INSERT INTO fruta(id, nome, quantidade) VALUES (nextval('hibernate_sequence'), 'Maca', 5);
INSERT INTO fruta(id, nome, quantidade) VALUES (nextval('hibernate_sequence'), 'Morango', 8);
INSERT INTO fruta(id, nome, quantidade) VALUES (nextval('hibernate_sequence'), 'Pera', 7);
INSERT INTO fruta(id, nome, quantidade) VALUES (nextval('hibernate_sequence'), 'Uva', 12);