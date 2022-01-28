# Employee Management System 

## Description
- System’s purpose is to manage fast food restaurant employee’s profile, inventory, schedule, and evaluate employees. To create a smooth onboarding process, constructive feedback is easy, less paperwork of the employees. 

## Scope
- Restaurant Establishments Only

## Platform 
- Windows Desktop Application 

## Database Structure
### Table
1. Employee
- ID (PK AI)
- Username
- Pass Code
- First name
- Middle Initial
- Last name
- Barangay
- Municipality
- Province
- Postal Code
- Birth date
- Age
- Gender
- Sex
- Job Position
- Minimum wage
- Email Address
- Contact Number
- Image (BLOB)

2. Schedule
- Time
- Monday
- Tuesday
- Wednesday
- Thursday
- Friday
- Saturday
- Sunday

3. Inventory
- ID (AI)
- Name
- Type
- Amount
- Total Cost
- Description

4. FoodMenu
- Name
- Type
- Recipes
- Cost
- Description

## Libraries
```
- JavaFX SDK 17.0.1
- Jfoenix-9.0.10
- Java JDK 17.0.1
- Org.xerial:sqlite-jdbc:3.36.0.3
