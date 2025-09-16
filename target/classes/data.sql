-- Usuarios
INSERT IGNORE INTO Usuarios (nombre, apellido, email, password, rol)
VALUES ('Juan', 'Pérez', 'juan.perez@email.com', 'pass123', 'cliente');

INSERT IGNORE INTO Usuarios (nombre, apellido, email, password, rol)
VALUES ('Ana', 'Gómez', 'ana.gomez@email.com', 'pass123', 'administrador');

INSERT IGNORE INTO Usuarios (nombre, apellido, email, password, rol)
VALUES ('Luis', 'Ramírez', 'luis.ramirez@email.com', 'pass123', 'cliente');
-- Eventos
INSERT IGNORE INTO Eventos (nombre_evento, descripcion, fecha, lugar, estado, duracion, tipo_evento, costo_evento, id_usuario)
VALUES ('Boda Martínez', 'Boda de ejemplo', '2025-12-20', 'Salón Principal', 'pendiente', '05:00:00', 'social', 1500.00, 1);

INSERT IGNORE INTO Eventos (nombre_evento, descripcion, fecha, lugar, estado, duracion, tipo_evento, costo_evento, id_usuario)
VALUES ('Conferencia Tech', 'Evento corporativo de tecnología', '2025-11-15', 'Auditorio Central', 'en_progreso', '03:00:00', 'corporativo', 3000.00, 2);

INSERT IGNORE INTO Eventos (nombre_evento, descripcion, fecha, lugar, estado, duracion, tipo_evento, costo_evento, id_usuario)
VALUES ('Festival Cultural', 'Festival de danzas y música', '2025-10-05', 'Plaza Central', 'completada', '06:00:00', 'cultural', 2000.00, 3);
