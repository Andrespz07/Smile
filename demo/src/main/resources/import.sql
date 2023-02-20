
INSERT INTO ciudades (id,ciudad) VALUES (default, "Gijón")

INSERT INTO pacientes (dni,nombre) VALUES ("53677070S", "enol")

INSERT INTO perfiles (id,direccion,edad,telefono,ciudad_id,paciente_id) VALUES (default,"calle uno",24,606060,1,"53677070S")

INSERT INTO tratamientos (id,tratamiento) VALUES (default, "empaste")



-- UPDATE perfiles SET ciudad_id = 1
-- UPDATE perfiles SET paciente_id = 1
