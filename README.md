# bdinvader
Final Project for Database Management 2 at University Uniquindio. Implements a student management system using Java for logic, JavaFX for interface, and Oracle SQL for the database. Connected through Oracle JDBC. Documentation is in spanish.

ENGLISH:

Project Description
This project incorporates a multi-level marketing context for educational and study purposes. It is important to note that this context is purely hypothetical and does not endorse or promote real-world multi-level marketing activities.

I do not assume any responsibility for any misuse or misinterpretation of the concepts or functionalities presented in this project. The inclusion of multi-level marketing elements is solely intended for academic exploration and understanding of related concepts.

Any attempt to apply these concepts or functionalities in real-world scenarios should be done with careful consideration of legal and ethical implications. I strongly advise against engaging in any unauthorized or malicious activities related to multi-level marketing.

Please use this project responsibly and within the boundaries of legal and ethical guidelines.

Database Statement
The Invader multi-level marketing company, with its video game distribution platform, allows users to log in to upload all their sales. To do this, they need to provide their email, username, and password. If not registered, users can sign up by entering their personal information, such as email, full name, residential address, identification number, contact number. Additionally, they can affiliate registered users using a code provided by the user being affiliated. There is no maximum limit on the number of users that can be affiliated with a user. For every sale made by the affiliated users, the affiliate earns a 5% commission. The commission percentage varies depending on the user's level. If a user disassociates from the company, their affiliated users are assigned to the user who is considered their affiliate.

The user's level varies depending on the number of sales made and the number of affiliates. If the number of affiliated users is more than 50 and their sales increase to exceed 350 video games, the user will level up. Each time these conditions are met, the commission increases by 2%, but it cannot exceed level 5.

Users who have logged in have the ability to sell video games through the platform. Each video game has a list of codes used for distribution. When a user sells a video game, the corresponding code is also sold. It is necessary to store the quantity of video games sold by the user, the date of sale, commission amount, and information about the video game.

The company offers a wallet feature where users can deposit or withdraw money as needed. This wallet is personal, and only the user can view their balance and use it as needed. For withdrawals, it is necessary to store the user's banking information, including bank, account number, ID number, and billing address.

It is necessary to store the data of the video games, which is convenient for searching on the platform. Therefore, it is important to consider the code, name, categories, game developer company, game price, list of distribution codes, and quantity of units sold. All this data should be properly normalized to maintain data integrity.

Imports and Driver
The code uses the JDBC driver, which can be found on the Oracle official website.

Script
The script DLL of the database is made in OracleDB. Feel free to make any changes you want.

ESPAÑOL:

Descripción del Proyecto
Este proyecto incorpora un contexto de marketing multinivel con fines educativos y de estudio. Es importante destacar que este contexto es puramente hipotético y no respalda ni promueve actividades reales de marketing multinivel.

No asumo ninguna responsabilidad por un mal uso o una interpretación errónea de los conceptos o funcionalidades presentados en este proyecto. La inclusión de elementos de marketing multinivel tiene como único objetivo la exploración académica y comprensión de los conceptos relacionados.

Cualquier intento de aplicar estos conceptos o funcionalidades en escenarios del mundo real debe hacerse con una cuidadosa consideración de las implicaciones legales y éticas. Recomiendo encarecidamente no participar en actividades no autorizadas o maliciosas relacionadas con el marketing multinivel.

Utilice este proyecto de manera responsable y dentro de los límites de las pautas legales y éticas.

Declaración de la Base de Datos
La empresa multinivel Invader, con su plataforma de distribución de videojuegos, permite a los usuarios iniciar sesión para cargar todas sus ventas realizadas. Para ello, es necesario proporcionar su correo electrónico, nombre de usuario y contraseña. En caso de no estar registrado, los usuarios pueden registrarse ingresando su información personal, como correo electrónico, nombre completo, dirección residencial, número de identificación y número de contacto. Además, pueden afiliar a usuarios registrados mediante un código proporcionado por el usuario que desea afiliar. No hay un límite máximo en la cantidad de usuarios que pueden ser afiliados a un usuario. Por cada venta realizada por los usuarios afiliados, el afiliador obtiene una comisión del 5% de la misma. El porcentaje de comisión varía según el nivel del usuario. En caso de que un usuario se desvincule de la empresa, sus usuarios afiliados se asignan al usuario que se considera su afiliado.

El nivel del usuario varía según la cantidad de ventas realizadas y la cantidad de afiliados. Si la cantidad de usuarios afiliados es superior a 50 y sus ventas aumentan superando los 350 videojuegos, el usuario subirá de nivel. Cada vez que se cumplan estas condiciones, la comisión aumentará un 2%, pero no podrá superar el nivel 5.

Los usuarios que han iniciado sesión tienen la posibilidad de vender videojuegos a través de la plataforma. Cada videojuego tiene una lista de códigos utilizados para la distribución. Cuando un usuario vende un videojuego, también se vende el código correspondiente. Es necesario almacenar la cantidad de videojuegos vendidos por el usuario, la fecha de venta, el monto de la comisión y la información del videojuego.

La empresa ofrece una función de billetera donde los usuarios pueden depositar o retirar dinero según sus necesidades. Esta billetera es personal y solo el usuario puede ver su saldo y usarlo según sea necesario. Para los retiros, es necesario almacenar la información bancaria del usuario, incluyendo banco, número de cuenta, número de identificación y dirección de facturación.

Es necesario almacenar los datos de los videojuegos, lo cual es conveniente para la búsqueda en la plataforma. Por lo tanto, es importante tener en cuenta el código, nombre, categorías, empresa desarrolladora del videojuego, precio del videojuego, lista de códigos de distribución y cantidad de unidades vendidas. Todos estos datos deben estar debidamente normalizados para mantener la integridad de la información.

Importaciones y Controlador de la Base de Datos
El código utiliza el controlador JDBC que se puede encontrar en el sitio web oficial de Oracle.

Script
El script DLL de la base de datos está hecho en OracleDB, siéntase libre de realizar los cambios que desee.
