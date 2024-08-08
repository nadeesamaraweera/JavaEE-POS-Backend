# **Thogakade POS System**


## **Overview**

Thogakade POS System is a robust web-based Point of Sale (POS) application designed to streamline retail operations. This system allows users to efficiently manage customers, inventory items, and orders. The frontend utilizes HTML, CSS, JavaScript, and jQuery for a responsive and user-friendly interface, while the backend leverages Java EE with Tomcat for scalable and reliable server-side processing.

## **Features**

### **Customer Management**

* **Add New Customers**: Seamlessly add customer information to the system, including their name, address, and salary details.
* **Search Existing** Customers: Quickly find and retrieve customer data using their unique ID, ensuring fast and accurate customer service.
* **Update Customer Information**: Modify existing customer records to keep information current and accurate.
* **Delete Customers**: Remove customer records that are no longer needed, keeping the database clean and efficient.


### **Item Management**

**Add New Items:** Introduce new products to the inventory, complete with item name, description, and pricing information.
**Search Existing Items:** Locate specific inventory items by their ID to review or edit their details.
**Update Item Information:** Keep your inventory up-to-date by editing item details, ensuring accurate stock levels and pricing.
**Delete Items:** Safely remove obsolete or discontinued items from your inventory list.

### **Order Management**

* **Create New Orders:** Process customer purchases by creating new orders that automatically update inventory levels.
* **Retrieve and View Orders:** Access a comprehensive list of all orders, with detailed information on each transaction for easy tracking and reporting.


## **Technologies Used**

### Frontend: 
* HTML, 
* CSS, 
* JavaScript, 
* jQuery for a dynamic and responsive user experience.

### Backend: 
* Java EE,
* Tomcat for powerful server-side management and processing.
* API Documentation: Comprehensive API endpoints and usage instructions are available in the Postman Documentation.


## **Controllers and Endpoints**


### **Customer Controller**

* **Add Customer:** **POST** /customer - This endpoint allows the addition of a new customer to the system.
* **Search Customer**: **GET** /customer/{id} - Retrieve detailed customer information by providing their unique ID.
* **Update Customer:** **PUT** /customer - Update existing customer records by submitting modified customer data.
* **Delete Customer:** **DELETE** /customer/{id} - Permanently delete a customer from the system using their unique ID.
* **Get Customers:** **GET** /customer - Fetch a list of all customers stored in the system.

### **Item Controller**

* **Add Item:** **POST** /item - Add new inventory items to the system, including all relevant details.
* **Search Item:** **GET** /item/{id} - Retrieve specific item information using the item’s unique ID.
* **Update Item:** **PUT** /item - Update details for existing inventory items.
* **Delete Item:** **DELETE** /item/{id} - Remove items from inventory by their unique ID.
* **Get Items:** **GET** /item - Access a full list of all items in inventory.

### **Order Controller**

* **Add Order:** **POST** /order - Create a new customer order, automatically adjusting inventory levels.
* **Get Orders:** **GET** /order - View all existing orders with complete details for each transaction.

## Getting Started

* **Prerequisites**: Ensure you have a Java EE environment configured with Tomcat installed on your machine.
* **Clone the Repository**: Use the command git clone .... to clone the project repository.
* **Setup Database:** Configure your database connection settings in the application.properties file to match your local setup.
* **Build and Run:** Deploy the generated WAR file to your Tomcat server and start the application.

## API Documentation

Detailed API documentation is available through Postman. You can access it here.



## License
This project is licensed under the MIT License. For more information, see the LICENSE file.