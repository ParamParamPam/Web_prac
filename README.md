# Web_prac

### Вариант 17: Интернет-магазин бытовой техники

## Схема базы данных:

<p align="center">
<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/db.png">

## Схема взаимодействия страниц:

<p align="center">
<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/pages.png">

С каждой страницы можно попасть на главную страницу.

## Описание страниц:

### 1. Главная страница (main)

Для невошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/main(unregistered).png">

Для вошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/main(customer).png">

Для вошедшего в систему администратора:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/main(admin).png">

### 2. Регистрация (registration)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/registration.png">

### 3. Вход (log in)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/log_in.png">

### 4. Завершение регистрации (registration success)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/reg_success.png">

### 5. Просмотр продукта (product)

Для невошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/product(unregistered).png">

Для вошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/product(customer).png">

Для вошедшего в систему администратора:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/product(admin).png">

### 6. Добавление продукта (adding product)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/product_add.png">

### 7. Просмотр заказов (orders)

Для вошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customer_orders.png">

Для вошедшего в систему администратора:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/orders.png">

### 8. Изменение заказа (edit order) -- только администратор

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/edit_order.png">

### 9. Изменение продукта (edit product) 

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/product_edit.png">

### 10. Изменение заказа (edit order)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/order_edit(customer).png">

### 11. Совершение покупки (buying)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/making_order.png">

### 12. Завершение покупки (ordered successfully)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/order_su_ccess.png">

### 13. Просмотр всех пользователей (customers)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customers.png">

### 14. Просмотр информации о пользователе (customer info)

Для вошедшего в систему пользователя:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customer_info.png">

Для вошедшего в систему администратора:

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customer(admin).png">

### 15. Добавление пользователя (adding customer)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customer_add.png">

### 16. Изменение персональной информации (personal info edit)

<img src="https://github.com/ParamParamPam/Web_prac/blob/master/images/customer_edit.png">

## Usecases:

### UC1:Регистрация

_main_ нажать на <b>Registration</b> <br>
_registration_ заполнить поля для ввода данных - нажать на <b>Register</b> <br>
_registration success_

### UC2:Вход в систему 

_main_ нажать на <b>Log In</b> <br>
_registration_ заполнить поля для ввода данных - нажать на <b>Sign in</b> <br>

### UC3:Просмотр информации о товаре

_main_ нажать на продукт <br>
_product_ 

### UC4:Купить товар (только покупатели)

_main_ нажать на продукт <br>
_product_ нажать на <b>Buy</b> <br>
_buying_ нажать на <b>Buy</b> <br>
_ordered successfully_

### UC5:Изменить параметры заказа (покупателю)

_buying_ нажать на <b>Edit</b> <br>
_edit order_ изменить данные - нажать на <b>Save</b> <br>

### UC6:Изменеть информацию о товаре (только администратор)

_product_ нажать на <b>Edit</b> <br>
_edit order_ изменить данные - нажать на <b>Save</b> <br>

### UC7:Добавление товара (только администратор)

_main_ нажать на <b>Add product</b> <br>
_adding product_ заполнить поля для ввода данных - нажать на <b>Add product</b> <br>

### UC8:Удаление товара (только администратор)

_product_ нажать на <b>Delete</b> <br>

### UC9:Добавление пользователя (только администратор)

_main_ нажать на <b>Customers</b> <br>
_customers_ нажать на <b>Add customer</b> <br>
_adding customer_ заполнить поля для ввода данных - нажать на <b>Add customer</b> <br>

### UC10:Удаление пользователя (только администратор)

_customers_ нажать на покупателя <br>
_customer info_ нажать на <b>Delete</b> <br>

### UC11:Изменение информации о пользователя

_customer info_ нажать на <b>Edit</b> <br>
_personal info edit_ изменить дфнные - нажать на <b>Save</b> <br>

### UC12:Изменить параметры заказа (администратором)

_main_ нажать на <b>Orders</b> <br>
_orders_ нажать на заказ <br>
_edit order_ изменить данные - нажать на <b>Save</b> <br>

### UC12:Сортировка товаров

_main_ заполнить поля сортировки - нажать на <b>Sort</b> <br>
