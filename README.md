https://demowebshop.tricentis.com/
--------------What you will need to get started--------
• A text editor or IDE (Required)
• Intelli J
• Chrome/Edge/Firefox
• Git
• Etc.
----------Requirements---------
• Navigate to website.
• Register User.
• Login User.
• Click on computers tab.
• Select desktops option.
• Sort desktops by all options.
• Add all desktop items to cart and validate total price.
• Remove 1 item from cart and validate total price.
• Checkout items from cart and validate checkout.
• Fill in all required information for checkout and complete transaction.
• Navigate to my account and validate order is created successful.



Positive Scenario
1. Test Case - Automate the User Registration process
   Steps to Automate:
2. Open this URL: https://demowebshop.tricentis.com/
3. Click on the Register link.
4. Fill out the registration form: gender, first name, last name, email, password, confirm password.
5. Click on the Register button.
6. Validate that the message "Your registration completed" is displayed.

Negative Scenarios
1. Test Case - Verify invalid email address error on Login
   Steps to Automate:
2. Open this URL: https://demowebshop.tricentis.com/
3. Click on the Login link.
4. Enter an invalid email address in the Email field.
5. Click on the Login button.
6. Validate that an error message appears saying:
"Login was unsuccessful. Please correct the errors and try again."

Invalid Field Input Types
Objective: Ensure validation messages appear for fields filled with incorrect data types.
Steps to Automate:
1. Open the URL: https://demowebshop.tricentis.com/
2. Go to the Register page.
3. Fill in invalid data:
Use numbers in the First Name, Last Name, and City fields (e.g., 1234)
Use letters in Postal Code or Phone Number fields (if present)
4. Click the Register button.
5. Confirm that appropriate error messages are shown:
“Only letters are allowed”
“Enter a valid ZIP/postal code”
(depending on the field validation rules)

Search Product
Steps to Automate:
1. Launch browser and navigate to:
https://demowebshop.tricentis.com/
2. Locate the Search bar (top right of the page).
3. Enter a valid product name (e.g., "computer", "book", or "gift card").
4. Click the Search button or press Enter.
Wait for the search results to load.
Validate that:
5. Search results contain products that match the search query.
6. Product names or descriptions contain the search keyword.

Expected Result:
Products relevant to the keyword are displayed on the results page.

Automate End-to-End Buy Product Flow

Objective  
Ensure that a user can successfully purchase a product from registration/login to order confirmation.
Steps to Automate (End-to-End Flow)
1. Launch the application:
   Open the browser and go to (https://demowebshop.tricentis.com/)
2. Login or Register
    - If new: Click on Register, fill out the form, and submit.
    - If existing: Click on Log in, enter email and password, and log in.
3. Navigate to Product Category
    - Click on Computers > Desktops (or any category).
4. Select a Product
    - Click on a product like “Build your own computer”.
5. Configure Product Options (if any)
    - Choose processor, RAM, HDD, etc.
    - Click Add to Cart.
6. Open the Cart
    - Click on the Shopping cart icon/link in the top-right.
7. Agree to Terms
    - Tick the checkbox “I agree with the terms of service”.
8. Proceed to Checkout
    - Click on the Checkout button.
9. Billing Address
    - Fill in or select billing address.
    - Click Continue.
10. Shipping Address
    - Select shipping address or same as billing.
    - Click Continue.
11. Shipping Method
    - Choose shipping option (e.g., Ground, Next Day Air).
    - Click Continue.
12. Payment Method:
    - Choose “Cash on Delivery” or any available method.
    - Click Continue.
13. Payment Information:
    - If required, enter payment details.
    - Click Continue.
14. Confirm Order:
    - Review order details.
    - Click Confirm.
15. Order Success Page:
    - Validate message:  
      “Your order has been successfully processed!”
    - Optionally, print or capture the order number.
    - 
Technologies Used
Java 11+
Selenium WebDriver
TestNG
Maven
POM Framework
