INSERT INTO cliente (nombres, apellidos, dni, telefono, email) VALUES ('Bryan', 'Palacios', '75171542', '999124523', 'bpg@gmail.com');

INSERT INTO cliente (nombres, apellidos, dni, telefono, email) VALUES ('Juan', 'Perez', '75152356', '999124523', 'jpg@gmail.com');

INSERT INTO producto (nombre, precio) VALUES ('Cocacola', 12.20);
INSERT INTO producto (nombre, precio) VALUES ('Galleta', 5.10);

INSERT INTO venta (fecha, id_cliente) VALUES ('2023-07-25', 1);
INSERT INTO detalle_venta (id_venta, id_producto, cantidad) VALUES (1,1, 2);

--select * from detalle_venta dv INNER JOIN venta v ON v.id = dv.id_venta WHERE v.fecha = '2023-07-25'