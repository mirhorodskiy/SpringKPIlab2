
--locations
INSERT INTO location(location_id, city, region)
VALUES(1, 'Kyiv', 'Kyivska');

INSERT INTO location(location_id, city, region)
VALUES(2, 'Brovary', 'Kyivska');

INSERT INTO location(location_id, city, region)
VALUES(3, 'Sumy', 'Sumska');

INSERT INTO location(location_id, city, region)
VALUES(4, 'Zhytomyr', 'Zhytomyrska');

INSERT INTO location(location_id, city, region)
VALUES(5, 'Zhmerynka', 'Kyivska');

INSERT INTO location(location_id, city, region)
VALUES(6,'Zhmerynka', 'Vinnytska');


--Date
INSERT INTO date(date_id, day, month, year)
VALUES(1, 01, 'September', 2021);

INSERT INTO date(date_id, day, month, year)
VALUES(2, 02, 'September', 2021);

INSERT INTO date(date_id, day, month, year)
VALUES(3, 03, 'September', 2021);

INSERT INTO date(date_id, day, month, year)
VALUES(4, 04, 'September', 2021);

INSERT INTO date(date_id, day, month, year)
VALUES(5, 01, 'October', 2021);

INSERT INTO date(date_id, day, month, year)
VALUES(6, 02, 'October', 2021);

--Forecast
INSERT INTO forecast(forecast_id, description, rain_chance, temperature, date_date_id, location_location_id)
VALUES(1, 'Sunny', 0.1, 24, 1, 1);

INSERT INTO forecast(forecast_id, description, rain_chance, temperature, date_date_id, location_location_id)
VALUES(2, 'Rainy', 0.9, 19, 2, 1);

INSERT INTO forecast(forecast_id, description, rain_chance, temperature, date_date_id, location_location_id)
VALUES(3, 'Cloudy', 0.2, 20, 3, 1);
