INSERT INTO category(name) VALUES ('Mouse'),('RAM'),('HDD'),('SSD'),('CPU'),('GPU'),('Mother Board'),('Monitor');

INSERT INTO product(description, name, price, product_code, quantity, category) VALUES ('Mouse gaming A+ KuaFu 7200 DPI','Mouse Gaming',236,'kC458631SERG',300,1),
                                                                                       ('Mouse optic Lenovo 300, Negru','Mouse ',136,'kC4111631SERG',100,1),
                                                                                       ('Mouse gaming A+ Mammoth, RGB, 6400DPI','Mouse Gaming',536,'kC4LO0P631SERG',20,1),
                                                                                       ('Memorie Kingston FURY Beast 16GB DDR4 3200MHz CL16 Dual Channel Kit','RAM',2336,'RMKL90LPO0',20,2),
                                                                                       ('Memorie Kingston FURY Beast 8GB DDR4 2666MHz CL16','RAM',6336,'RMKL90LDPO0',20,2),
                                                                                       ('Memorie G.Skill Aegis 8GB DDR4 3200MHz CL16','RAM',1336,'RMKL90LDPODDS0',20,2),
                                                                                       ('Hard disk Seagate BarraCuda 2TB SATA-III 7200RPM 256MB','HDD',336,'ULP45328',55,3),
                                                                                       ('Hard disk WD Blue 1TB SATA-III 7200 RPM 64MB','HDD',536,'ULP45328',120,3),
                                                                                       ('Hard disk Seagate BarraCuda 4TB SATA-III 5400RPM 256MB','HDD',536,'ULP45328',120,3),
                                                                                       ('SSD Samsung 870 EVO 500GB SATA-III 2.5inch','SSD',274,'MZ-77E500B/EU',150,4),
                                                                                       ('SSD Samsung 970 EVO Plus 500GB PCIe 3.0 x4 M.2 NVMe','SSD',322,'mz-v7s500bw',200,4),
                                                                                       ('SSD extern Samsung T7 1TB USB 3.2 Gen 2 Indigo Titan Grey','SSD',594,'mu-pc1t0t/ww',200,4),
                                                                                       ('SSD Samsung 980 PRO 1TB PCI Express 4.0 x4 M.2 2280','SSD',714,'mz-v8p1t0bw',200,4),
                                                                                       ('Intel® Core™ i9-10900F Comet Lake, 2.8GHz, 20MB, Socket 1200','CPU',1929,'mz-v8p1t0bw',200,5),
                                                                                       ('Intel® Core™ i6-10900F Comet Lake, 2.8GHz, 20MB, Socket 1200','CPU',1929,'mz-v8p1t0bw',200,5),
                                                                                       ('Intel® Core™ i8-10900F Comet Lake, 2.8GHz, 20MB, Socket 1200','CPU',1929,'mz-v8p1t0bw',200,5),
                                                                                       ('Intel® Core™ i5-10900F Comet Lake, 2.8GHz, 20MB, Socket 1200','CPU',1929,'mz-v8p1t0bw',200,5),
                                                                                       ('Placa video Gigabyte GeForce® RTX 2060 D6, 6GB GDDR6, 192-bit','GPU',1929,'mz-v8p1t0bw',200,6),
                                                                                       ('Placa video Gigabyte GeForce® RTX 2060 D6, 6GB GDDR6, 192-bit','GPU',1929,'mz-v8p1t0bw',200,6),
                                                                                       ('Placa video Gigabyte GeForce® RTX 2060 D6, 6GB GDDR6, 192-bit','GPU',1929,'mz-v8p1t0bw',200,6),
                                                                                       ('Placa video Gigabyte GeForce® RTX 2060 D6, 6GB GDDR6, 192-bit','GPU',1929,'mz-v8p1t0bw',200,6),
                                                                                       ('Placa video Gigabyte GeForce® RTX 2060 D6, 6GB GDDR6, 192-bit','GPU',1929,'mz-v8p1t0bw',200,6);

INSERT INTO products_sold (quantity, product) VALUES (20,1),(25,2),(25,3),(20,3),(23,1),(20,1),(20,1),(20,1);

INSERT INTO user_rol(rol) VALUES ('ADMIN'),('USER');

INSERT INTO users(address, birthday, email, last_name, mobile, password, user_name, rol) VALUES ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',1),
                                                                                                ('Arinului 20','200-08-01','constantin.gabriel@gmail.com','Constantin','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',2),
                                                                                                ('Ghinea dorinel nr13','1999-08-01','gabriel.stanciulescu@gmail.com','Stanciulescu','0748839324','qmajdyhn','Gabriel',1);











