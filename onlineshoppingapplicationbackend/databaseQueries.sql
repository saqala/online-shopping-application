CREATE TABLE CATEGORY (
	id IDENTITY primary key,
	name VARCHAR(50),
	description VARCHAR(255),
	image_url VARCHAR(50),
	is_active BOOLEAN





);

INSERT INTO CATEGORY (name, description, image_url, is_active) VALUES('Phone', 'Description of phones here', 'Phone.jpg', true)
INSERT INTO CATEGORY (name, description, image_url, is_active) VALUES('TV', 'Description of TV', 'tvs.jpg', true)
INSERT INTO CATEGORY (name, description, image_url, is_active) VALUES('Laptop', 'Description of Laptops', 'laptop.jpg', true)
