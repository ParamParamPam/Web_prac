INSERT INTO "admin" VALUES (DEFAULT, 'testAdmin', 'testPsswd');

  
INSERT INTO product VALUES (DEFAULT, '5399.99', '100', 'кондиционер', 'Конд. AirW 45', 'Bosch', 'Германия', 'Обслуживаемая площадь, м2: 28;Тип хладагента: R 410A');
INSERT INTO product VALUES (DEFAULT, '15000', '35', 'посудомоеч. маш.', 'Посуд. маш. White4', 'Smeg', 'Германия', 'вместимость: 12 комплектов;расход воды: 11.7 л');
INSERT INTO product VALUES (DEFAULT, '3999.99', '77', 'сушилка для белья', 'BeClean v2.2', 'AEG', 'Англия','Длина:50 см;Ширина:31 см');
INSERT INTO product VALUES (DEFAULT, '12499.99', '13', 'холодильник', 'Холодильник дв.камеры.', 'Sharp', 'Франция', 'ШхВхГ: 60х203х66 см;общий объем: 419 л;объем холодильной камеры: 280 л');
INSERT INTO product VALUES (DEFAULT, '5799.99', '5', 'кухонная плита', 'Плита Cook 453', 'Samsung', 'Южная Корея', 'Тип:газовая;Материал рабочей поверхности:нерж. сталь');
INSERT INTO product VALUES (DEFAULT, '19000', '1', 'стир-ая маш.', 'Jkle 5', 'Sony', 'Англия', 'ШхГхВ: 60х55х85 см;загрузка: 8 кг');
INSERT INTO product VALUES (DEFAULT, '3799', '320', 'телевизор','TV Syst 23dp', 'Philips', 'Англия', 'разрешение: 4K UHD (3840x2160), HDR;диагональ экрана: 43";частота обновления экрана: 60 Гц');
INSERT INTO product VALUES (DEFAULT, '1999.99', '9', 'DVD-проигрыватель', 'DVD Sony', 'Sony', 'Китай', 'поддержка MPEG4, DivX;выход HDMI');

INSERT INTO customer VALUES (DEFAULT, 'nikiniki', 'kjh56SSEs345', 'Николай', 'Иванов', 'Москва просп.Верадского д.13 кв.1', '89175432276', 'nikola.tesla@mail.ru');
INSERT INTO customer VALUES (DEFAULT, 'testtest', ',kjt&^%dg', 'Петрушка', 'Федоров', 'Москва ул.Пражская д.120 кв.77', '89856592284', 'kartoshka@bk.ru');
INSERT INTO customer VALUES (DEFAULT, 'testCustomer', 'testCustomerPsswd', 'Прокофий', 'Прокофиевич', 'Санк-Петербург Невский просп. д.23 кв.3', '8-999-657-88-32', 'BigProf@mail.ru');
INSERT INTO customer VALUES (DEFAULT, 'blalala', 'fCG4gghgT', 'Акакий', 'Акакиевич', 'Балашиха ул.Семенова д.45 кв.46', '8 988 564 98 00', 'ak.akak@mail.ru');

INSERT INTO "order" VALUES (DEFAULT, 'Москва просп.Верадского д.13 кв.1', '13.01.2021', '18.01.2020', 'Sent', '14000', 2, 1);
INSERT INTO "order" VALUES (DEFAULT, 'Москва Чечерский прд. д.123 кв.188', '05.07.2015', '13.08.2005', 'Delivered', '3400', 4, 2);
INSERT INTO "order" VALUES (DEFAULT, 'Череповец ул.Ленина д.1 кв.14', '18.11.2027', '30.11.2017', 'Assembling', '22000', 1, 3);
INSERT INTO "order" VALUES (DEFAULT, 'Рыбинск просп.Водный д.76 кв.39', '26.04.2030', '13.05.2010', 'Formed', '6700', 3, 4);