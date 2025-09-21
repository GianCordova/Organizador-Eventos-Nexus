-- Usuarios
INSERT IGNORE INTO usuarios (nombre, apellido, email, password, rol) VALUES
('Ana', 'Gómez', 'ana.gomez@email.com', 'pass123', 'cliente'),
('Luis', 'Pérez', 'luis.perez@email.com', 'pass123', 'administrador'),
('Carla', 'Ramírez', 'carla.ramirez@email.com', 'pass123', 'cliente');

-- Recursos
INSERT IGNORE INTO recursos (nombreRecurso, categoria, stock, precioAlquiler) VALUES
('sillas_plegables', 'MOBILIARIO', 100, 2.50),
('carpa_5x5', 'COVERSANDSTRUCTURES', 10, 50.00),
('luces_led', 'ILUMINACION', 20, 15.00),
('equipo_de_sonido', 'SOUNDANDMULTIMEDIA', 5, 100.00),
('mesa_redonda', 'ENTRETENIMIENTO', 30, 5.00),
('catering_basico', 'KITCHENANDCATERING', 0, 200.00);

-- Proveedores
INSERT IGNORE INTO proveedores (nombreProveedor, servicio, contacto) VALUES
('sonidopro', 'Sonido y multimedia', 'contacto@sonidopro.com'),
('decor_arte', 'Decoración', 'info@decorarte.com'),
('catering_express', 'Cocina y catering', 'ventas@cateringexpress.com');

-- Eventos
INSERT IGNORE INTO eventos (nombreEvento, descripcion, fecha, lugar, estado, duracion, tipoEvento, costoEvento, idUsuario) VALUES
('boda_ana_y_luis', 'Boda civil en jardín', '2025-10-12', 'Jardín Central', 'pendiente', '05:00:00', 'social', 1500.00, 1),
('conferencia_tech_2025', 'Evento corporativo de tecnología', '2025-11-05', 'Centro de Convenciones', 'ejecutandose', '08:00:00', 'corporativo', 5000.00, 2);

-- Invitados
INSERT IGNORE INTO invitados (nombre, apellido, correo, telefono, estadoAsistencia, idEvento) VALUES
('Carlos', 'Lopez', 'carlos.lopez@email.com', '555-1234', 'confirmado', 1),
('María', 'Fernandez', 'maria.fernandez@email.com', '555-5678', 'pendiente', 1),
('Jorge', 'Martínez', 'jorge.martinez@email.com', '555-8765', 'confirmado', 2);

-- DetalleRecursos
INSERT IGNORE INTO detalleRecursos (idEvento, idRecurso, cantidad) VALUES
(1, 1, 50),
(1, 2, 1),
(1, 4, 1),
(2, 4, 2),
(2, 3, 10);

-- DetalleProveedores
INSERT IGNORE INTO detalleProveedores (idEvento, idProveedor, costo, observaciones) VALUES
(1, 2, 300.00, 'Decoración floral incluida'),
(1, 3, 500.00, 'Catering para 50 personas'),
(2, 1, 1200.00, 'Sonido para auditorio grande');
