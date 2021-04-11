**Developer Guide**
===================


## Content Page

1. [Introduction](#1-introduction)
	1. [What is HealthVault?](#11-what-is-healthvault) 
	2. [About the Developer Guide](#12-about-the-developer-guide)
2. [How to use this guide](#2-how-to-use-the-guide)
	1. [Technical Terms](#21-technical-terms)
	2. [Symbols & Icons](#22-symbols-and-icons)
4. [Getting Started](#3-getting-started)
5. [Design](#4-design) 
    1. [Architecture](#41-architecture)
    2. [UI component](#42-ui-component) 
    3. [Logic Component](#43-logic-component)
    4. [Model component](#44-model-component) 
    5. [Storage component](#45-storage-component)
6. [Implementation](#5-implementation)
    1. [Staff](#51-staff) 
    	1. [Staff Menu](#511-staff-menu)
    	2. [Add](#512-add)
    	3. [Delete](#513-delete)
    	4. [List](#514-list)
    	5. [Find](#515-find)
    2. [Patient](#52-patient)
    	1. [Patient Menu](#521-patient-menu)
    	2. [Add](#522-add)
    	3. [Delete](#523-delete)
    	4. [List](#524-list)
    	5. [Find](#525-find)
    3. [Doctor Appointment](#53-doctor-appointment)
    	1. [Doctor Appointment Menu](#531-doctor-appointment-menu)
    	2. [Add](#532-add)
    	3. [Delete](#533-delete)
    	4. [List All](#534-list-all)
    	5. [List by Doctor ID or Appointment ID](#535-list-by-doctor-id-or-appointment-id)
    4. [Nurse Schedule](#54-nurse-schedule)
    	1. [Nurse Schedule Menu](#541-nurse-schedule-menu)
    	2. [Add](#542-add)
    	3. [Delete](#543-delete)
    	4. [List All](#544-list-all)
    	5. [List by Nurse ID](#545-list-by-nurse-id)
    5. [Inventory](#55-inventory)
        1. [Inventory Menu](#551-inventory-menu)
    	2. [Add](#552-add)
    	3. [Delete](#553-delete)
    	4. [List](#554-list)
    6. [Proposed Features](#56-proposed-features)
    	1. [Auto Schedule Generator for Nurses](#561-auto-schedule-generator-for-nurses)
    	2. [Personalized Account Login](#562-personalized-account-login)
    	3. [Inventory Alerts](#563-inventory-alerts)

[Appendix A: Product Scope](#appendix-a-product-scope)

[Appendix B: User Stories](#appendix-b-user-stories)

[Appendix C: Non Functional Requirements](#appendix-c-non-functional-requirements)

[Appendix D: Glossary](#appendix-d-glossary)

[Appendix E: Instructions for Manual Testing](#appendix-e-instructions-for-manual-testing)

## 1. Introduction
### 1.1 What is HealthVault?

In light of the recent COVID-19 pandemic. The weakness of modern healthcare systems has surfaced. 
Many of which are unsatisfactory in coping with the current needs.
HealthVault was thus created to improve the efficiency of hospital and healthcare information management.
<br>
**HealthVault** is a desktop application made for healthcare workers as their one stop application for recording and 
accessing critical patient or staff information.
It is optimized for the Command Line Interface, where an experienced typist will be able to 
make full use of the informative and minimalistic GUI to achieve significant gains in efficiency

### 1.2 About the Developer Guide

The HealthVault Developer guide is made specifically for those who are interested in the specifics of how HealthVault is 
implemented. Such personnel may include: students, technical support staff, web developers, healthcare professionals.

This Developer guide seeks to inform and instruct readers on the architecture and specific implementation of the various
functions within HealthVault. So that if they wish to make any fixes or edits to improve on the code for their own 
usage, they will be well equipped with both the knowledge and expertise to do so. 

The Developer Guide hopes to impart to you the following:
1. Properly set up for HealthVault
2. HealthVault's system architecture
3. The implementation method for HealthVault's various functions and their considerations
4. Instructions for manual testing of the application

We hope you will have a fruitful time learning about HealthVault.

<br>

## 2. How to use the guide
### 2.1 Technical Terms

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Command Line Interface** - Accessing the functionalities of a computer program in the form of lines of text.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **User Input** - Any information or data sent to a computer by the user using the application.

### 2.2 Symbols and Icons

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **<>** - Angles quotation marks for optional user inputs.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **[]** - Square brackets for compulsory user inputs.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :information_source: This icon denotes a important information to note.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; :exclamation: Warning sign to inform user against doing certain actions 

<br>

## 3. Getting Started

:exclamation: Caution: Follow the steps in the following guide precisely. Things will not work out if you deviate in some steps.

First fork this repo, and clone the fork into your computer.

**Setting up the project in your computer**

1. Configuring the JDK to to ensure Intellij is configured to use JDK 11.
2. Import the project as a Gradle project.
3. Run the seedu.duke.HealthVault and try a few commands as stated in the User Guide.
4. Run the tests to ensure they all pass.

**Before writing code**

1. If using IDEA, configuring the code style to set up IDEA’s coding style to match ours.
2. When you are ready to start coding, we recommend that you get some sense of the overall design by reading about HealthVault’s architecture.

<br>


## 4. Design

###  4.1 Architecture

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/Architecture Diagram.png">

**Overview Architecture:**

Our application utilises many layers of abstraction which allows each individual component to be self contained yet able to work with other components. Each component has been abstracted and grouped together based on its function and purpose in the system.

The above diagram shows how each component interacts with the other components. The directed arrows represent the direction in which functions of each component is called and used. For example, the Instance Component utilises the Storage Component.

<br>

**Brief Description of Components:**

**UI Component:** Controls all the User Interface. All input and output is handled by the UI component.


**Logic Component:**

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Instance Component: Represents all Menu Instances.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Parser Component: Parses user input to obtain control flow decisions.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Error Checker Component: Contains functions to check validity of user input.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Commands Component: Command Class Objects which executes specified actions.

**Exceptions Component:** All possible Exceptions identified.

**Model Component:** Consist of the base objects and its collection.

**Storage Component:** Manages all file I/O.

<br>

### 4.2 UI component

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/UML UI.png">

**API :** `UI.java`

The UI of this program can be found under the package named UI. It consists of `UI`, `DoctorAppointmentUI`, `InventoryUI`, `NurseScheduleUI`, `PatientUI` and `StaffUI`.  The main `UI` class as shown in the diagram acts as the parent class with the other classes being its subclasses. Having a main `UI` class allows the program to have a common pool of methods so that each method is reusable in each functionality. Each individual function UI extends the main `UI` and consists of the methods that deals with users unique to their functionality. The UI component interacts with the Logic package and Instance package the most.

**The `UI` component**,

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Executes user commands using the ‘Logic’ component.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Listens to changes to `Instance` data so that the UI can be updated with the modified data.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Is responsible for handling all input and output of the program. 

<br>

### 4.3 Logic Component

The `Logic` component is responsible for the following tasks:

- Run each instance that accepts user inputs in order to access various functionalities.
- Converts user inputs into data that is usable by the HealthVault.
- Executes the Command based on interpreted data.

To accomplish the above, the `Logic` component, follows the following sequence of steps:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Interpreting user input**:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The `Instance` component runs the main super loop to accept user input. It creates a `Parser` to interpret user inputs. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Checking User Input**:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; The `Parser` creates an `ErrorChecker` class and uses it to check the user input for any erroneous and unacceptable inputs. 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Creating Command**:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; After checking the input, the `Parser` component then creates the `Command` that corresponds to the user input.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Executing Command**:

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; With the interpreted `Command` from the `Parser`, the `Instance` component then executes the `Command`.

The following class diagram illustrates the interactions between various logic components

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="diagrams/LogicComponent.png">

The following class diagram illustrates the group of Commands under the `doctorappointment` package. Due to the similar Commands in each of the Command packages, the information in the doctorappointment package should be representative of the other Command packages.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="diagrams/ExampleCommandPackage.png">

>:information_source: Similar classes are represented by abbreviations ie. ABCCommand. The actual class names are written in the notes beside the classes. 
> 
>1. ABCInstance represents the different `Instance` classes.
>2. PQRParser represents the different `Parser` classes.
>3. XYZChecker represents the different `ErrorChecker` classes.
>4. The "XXX"Command in each package under the `Command` package represent the different commands relating to each individual feature.

<br>

### 4.4 Model component

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/UML Model.png">

The Model component consists of classes that represents the collection of objects that a nurse has to interact with.

The `Model`, consists of 5 different types of arraylists.

- AppointmentList stores DoctorAppointment objects. AppointmentList also has methods needed to interact with objects in the arraylist.
- InventoryList stores Inventory objects. InventoryList also has methods needed to interact with objects in the arraylist.
- NurseScheduleList stores NurseSchedule objects. NurseScheduleList also has methods needed to interact with objects in the arraylist.
- PatientList stores Patient objects. PatientList also has methods needed to interact with objects in the arraylist.
- StaffList stores Staff objects. StaffList also has methods needed to interact with objects in the arraylist.

<br>

### 4.5 Storage component
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img src="images/UpdatedStorageUML.png">

The Storage component consists of classes that individually reads data from, and writes data to, 5 different .txt files.

The `Storage`, consists of 5 different types of classes:

- DoctorApointmentStorage implements `writeToFile()` to write information regarding doctorID, name, date, appointmentID, and gender into DoctorAppointment.txt file. `loadFile()`loads the data in the DoctorAppointment.txt file into an array list to be returned. `loadDoctorFile()` loads the doctor information from the staff database.
- InventoryStorage implements `storeInventory()` to write information regarding item name, price, and quantity into Inventory.txt file. `loadInventory()`loads the data in the Inventory.txt file into an array list to be returned.
- NurseScheduleStorage implements `writeToFile()` to write information regarding nurseID, patientID, date into NurseSchedule.txt file. `loadPatientFile()` loads the patient information from the patient database.
- StaffStorage implements `writeToFile()` to write information regarding staffID, name, age, and specialisation into Staff.txt file. `loadFile()`loads the data in the Patients.txt file into an array list to be returned.
- PatientStorage implements `storePatients()` to write information regarding patientID, name, age, gender, illness, and itemsNeeded into Patient.txt file. `loadPatients()`loads the data in the Patient.txt file into an array list to be returned.

<br>

## 5. Implementation

In this section, we will introduce the implementation of the different functions within each feature.

###  5.1 Staff

### 5.1.1 Staff Menu

Similar to the Start Menu, the Staff Menu will repeatedly request user input until the `return` command is given.

Whenever a user input is given to the Staff Menu, the following steps will occur.

**Launching Staff Menu**

1. `ToStaffInstance.execute()` will create and call `StaffInstance.run()`
2. `StaffInstance.run()` will start by loading/creating the Staff data .txt file for Staff database records. It will check for any signs of corrupted file when loading. An Exception will be thrown if any corruption occurs.
3. `StaffInstance.run()` will then repeatedly call `commandHandler()`.

**Getting User Input**

4. `StaffInstance.run()` will repeatedly request for user input and call `StaffParser.commandHandler()`.
5. `commandHandler()` will call the `smartCommandRecognition()` to assess the given user input and determine which command is most similar to the input
6. Based on the recognised command by the system, the relevant commands will be carried out.

<br>

### 5.1.2 Add

**Implementation:**

The function Add takes in 4 compulsory fields (Staff ID, Name, Age, Specialisation) to create the Staff Object and adds it to an aggregation of Staff Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. A StaffAddCommand object is created. StaffAddCommand object will be executed to create the Staff Object which will be added to the aggregation of Staff Objects.

Invalid Input includes:

> 
	- Invalid Staff ID format
	- Duplicated Staff ID
	- Age that < 18 or > 150
	- Blank input (i.e Empty inputs)
	- Illegal Characters

**Format** `add/[Staff ID]/[name]/[age]/[specialisation]`

<img src="diagrams/StaffAddSD.png">

**Check validity of the data input**

1. If the command recognised is the add command, `commandHandler()` calls `staffChecker.checkValidDataForAdd()` to ensure data entered is valid
2. `checkValidDataForAdd()` will call the following function in sequence:

	- checkStaffID()	
	- checkDuplicateStaffID()
	- checkStaffAge()
	- checkBlankInput2()
	- invalidCharactersStaffChecker()

**Creating StaffAddCommand object**

3. If the input data is valid, a StaffAddCommand object is created. Else a relevant error is thrown.
4. The StaffAddCommand object is returned to `StaffInstance.run()`

**Creating Staff Object with User Input**

5. StaffInstance then executes the StaffAddCommand object to begin the process of creating the Staff object

6. `StaffAdd.execute()` will call the function in `StaffList.add()`

7. `StaffList.add()` will instantiate a new Staff object and add it to the ArrayList<Staff> StaffList. which contains all the Staff Objects. 

**Saving Staff Objects into .txt file**

8. `StaffList.add()` then calls `staffStorage.writeToFile()` which starts the process of writing the details of all existing Staff Objects, within the StaffList into a specified .txt file.
9. `staffStorage.writeToFile()` then calls `createFile()` which ensures that the specified .txt file exists.
10. Data is written and saved.
11. Control is then returned to StaffInstance.

<br>

### 5.1.3 Delete

**Implementation:**

The function Delete takes in 1 compulsory field (Staff ID) to identify and delete the Staff Object from the aggregation of Staff Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a StaffDelete Command object is created. StaffDelete command object will be executed to iterate through the aggregation of Staff Objects. If Staff Object exists, it will be removed. Else an error message will be displayed.

Invalid Input includes:

> 
	- Invalid Staff ID format
	- Blank input (i.e Empty inputs)
	- Illegal Characters

**Format** `delete/Staff ID`


**Check validity of the data input**

1. If the command recognised is the delete command, `commandHandler()` calls `staffChecker.checkDeleteCommand()` to ensure that there are valid and sufficient inputs

**Creating StaffDelete command**

2. If the input data is valid, a StaffDelete Command object is created 
3. The StaffDelete Command object is returned to `StaffInstance.run()`

**Deleting Staff Object using User Input**

4. StaffInstance then executes the StaffDelete Command object to begin the process of deleting the referenced Staff object
5. `StaffDelete.execute()` will call the function `StaffList.delete()`
6. `StaffList.delete()` will iterate through the objects in ArrayList<Staff> StaffList. The Staff Object referenced by the input given by the user will be deleted.

**Saving changed Staff Objects into .txt file**

7. `StaffList.delete()` then calls staffStorage.writeToFile() which starts the process of writing the changed details of Staff Objects, within the StaffList into a specified .txt file.

8. `staffStorage.writeToFile()` then calls `createFile()` which ensures that the specified .txt file exists.
9. Data is written and saved.
10. Control is then returned to StaffInstance.

<br>

### 5.1.4 List

**Implementation:**

The function list takes in 1 option field (nurses/doctors) to identity and list the category of Staff Objects required from the aggregation of Staff Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a StaffList Command object is created. StaffList command object will be executed to iterate through the aggregation of Staff Objects. Staff Objects will then be displayed based on the user given input.

Invalid Input includes:

> 
	- Any input apart from Blank Input (i.e Empty input) OR "doctors" OR "nurses"

**Format** `list/<doctors/nurses>`

**Check validity of the data input**

1. If the command recognised is the list command, `commandHandler()` calls `staffChecker.checkListCommand()` to check and verify the validity of inputs accompanied by the list command, if any.

**Creating StaffList command**

2. If the input data is valid, a StaffList Command object is created 
3. The StaffList Command object is returned to `StaffInstance.run()` 

**Viewing Staff Objects**

4. StaffInstance then executes the StaffList Command object to begin the process of displaying all Staff objects.
5. `StaffList.execute()` will call the function `StaffList.list()`
6. `StaffList.list()` will iterate through the objects in ArrayList<Staff> StaffList. 
7. Depending on the input given by the user, the relevant Staff Objects will be displayed.
8. Control is then returned to StaffInstance.

<br>

### 5.1.5 Find

**Implementation:**

The function Add takes in 1 compulsory field (keyword) to find the relvant Staff Objects within the aggregation of Staff Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. The given input is used to match with every single field of the Staff Object. If there is a match, the Staff Object will be displayed. Else, an error message will be displayed.

Invalid Input includes:

> 
	- Blank input (i.e Empty inputs)

**Format** `find/[keyword]`

**Check validity of the data input**

1. If the command recognised is the find command, `commandHandler()` calls `MainChecker.checkNumInput()`. `MainChecker.checkNumInput()` does a simple check to ensure there is an accompanying input given by the user together with the find command.

**Creating StaffFind command**

2. If the input data exist, a StaffFind Command object is created 
3. The StaffFind Command object is returned to `StaffInstance.run()` 

**Finding relevant Staff Objects**

4. StaffInstance then executes the StaffList Command object to begin the process of finding and displaying relevant Staff objects.
5. `StaffFind.execute()` will call the function `StaffList.find()`
6. `StaffList.find()` will iterate through the objects in ArrayList<Staff> StaffList. 
7. `StaffList.find()` will utilise a search function in StaffList to find any Staff Objects that matches the given keyword by the user. 
8. The relevant Staff Objects are then displayed.
9. Control is then returned to StaffInstance.

<br>

###  5.2 Patient

### 5.2.1 Patient Menu

The Patient Menu will repeatedly request user input until the `return` command is given.

Whenever a user input is given to the Patient Menu, the following steps will occur.

**Launching Patient Menu**

1. `ToPatientInstance.execute()` will create and call `PatientInstance.run()`
2. `PatientInstance.run()` will start by loading/creating the Patient data .txt file for Patient database records. It will check for any signs of corrupted file when loading and exception will be thrown if any corruption is detected.
3. `PatientInstance.run()` will then enters its running for loop and repeatedly take in user inputs for data processing.

**Getting User Input**

4. `PatientInstance.run()` will repeatedly request for user input and call `PatientParser.patientParse()`.
5. `patientParse()` will call the `smartCommandRecognition()` to assess the given user input and determine which command is most similar to the input.
6. The most relevant command is then returned to the parser and the parser then scans the input thoroughly based on the command returned. Relevant errors in the input are detected and the appropriate exceptions thrown.
7. Only after scanning the input for errors, will the proper command be returned to `PatientInstance` where it will then be executed.
8. After getting an input, and parsing it into string tokens, a new instance of PatientChecker class `checker` is instantiated to perform error checking.

<br>

### 5.2.2 Add


**Implementation:**

The function Add takes in 6 compulsory fields (Patient ID, Name, Age, Gender, Illness and Medication Required) to create the Patient Object and adds it to a list of Patient Objects.
Data input is first checked to ensure validity. Any invalid input detected will result in an exception thrown and command aborted. If there are no exceptions thrown, a PatientAdd Command object is created.
The PatientAdd command object will be executed to create the Patient Object which will be added to the list of Patient Objects.

Invalid Input includes:

>
	- Invalid Patient ID format
	- Duplicated Patient ID
	- Age that < 0 or > 150
	- Invalid Gender Input
	- Blank input (i.e Empty inputs)
	- Inputs that only consist of spaces
	- Illegal Characters

**Format**
`add/[Patient ID]/[name]/[age]/[gender]/[illness]/[medication required]`

**Check validity of the data input**

1. If the command recognised is the add command, `patientParse()` calls `checker.checkAdd()` to ensure data entered is valid.
2. `checkAdd()` will call the following methods in sequence:

	- emptySpaceCheck();
		- checkLength();
		- checkID();
		- checkAge();
		- illegalCharacterChecker();
		- checkGender();

**Creating PatientAdd command**

3. If the input data is valid, a PatientAdd Command object is created. Else a relevant error is thrown.
4. The StaffAdd Command object is returned to `PatientInstance.run()`

**Creating Patient Object with User Input**

5. PatientInstance then executes the PatientAdd Command object to begin the process of creating the Patient object

6. `PatientAdd.execute()` will call the function in `PatientList.add()`

7. `PatientList.add()` will instantiate a new Staff object and add it to the ArrayList<Patient> PatientList. which contains all the Patient Objects.

**Saving Patient Objects into .txt file**

8. PatientInstance then calls `PatientStorage.storePatients()` which starts the process of writing the details of all existing Patient Objects, within the PatientList into a specified .txt file.
9. `PatientStorage.storePatients()` then calls `fileInit()` which ensures that the specified .txt file exists.
10. Data is written and saved.
11. Control is then returned to PatientInstance.

**Design Considerations**

Using an ArrayList over a List as the main data structure:

Option 1 (Final choice): Using an ArrayList
* Pros: Able to access a patient given the index and allows for more flexibility in the methods used.
* Cons: Slow accessing when storing and loading as an ArrayList takes more resources than a List.

Option 2 : Using a List
* Pros: Able to load and store very fast and also able to perform functions like "list" fast.
* Cons: No random access and thus made certain functions more troublesome code wise.
<br>

### 5.2.3 Delete

**Implementation:**

The function Delete takes in 1 compulsory field (Patient ID) to identity and delete the Patient Object from the list of Patient Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a PatientDelete Command object is created. The PatientDelete command object will be executed to iterate through the list of Patient Objects. If Patient Object exists, it will be removed. Else an error message will be displayed.

Invalid Input includes:

>
	- Invalid Patient ID format
	- Blank input (i.e Empty inputs)
	- Inputs that only consist of spaces

**Format**
`delete/[Patient ID]`

**Check validity of the data input**

1. If the command recognised is the delete command, `patientParse()` calls `checker.checkLength()` and `checker.checkID()` to ensure data entered is valid.

**Creating PatientDelete command**

2. If the input data is valid, a PatientDelete Command object is created
3. The PatientDelete Command object is returned to `PatientInstance.run()`

**Deleting Patient Object using User Input**

4. PatientInstance then executes the PatientDelete Command object to begin the process of deleting the referenced Patient object
5. `PatientDelete.execute()` will call the function `PatientList.deletePatient()`
6. `PatientList.deletePatient()` will iterate through the objects in ArrayList<Patient> PatientList. The Patient Object referenced by the input given by the user will be deleted.

**Saving changed Staff Objects into .txt file**

7. PatientInstance then calls `PatientStorage.storePatients()` which starts the process of writing the details of all existing Patient Objects, within the PatientList into a specified .txt file.
8. `PatientStorage.storePatients()` then calls `fileInit()` which ensures that the specified .txt file exists.
9. Data is written and saved.
10. Control is then returned to PatientInstance.

**Design Considerations**

Using an iterator to store the location of the item being deleted:

Option 1 (Final choice): Not using an iterator
* Pros: Using the inbuilt commands to iterate through to find the item to delete seems more straightforward.
* Cons: The flexibility of the data manipulation may be restrictive and this may result in future functions being harder to implement.

Option 2 : Using an iterator
* Pros: An iterator allows for more flexible data access as it allows for more efficient deletion of a block of data and it helps to keep the location of where data was manipulated.
* Cons: Maintenance of the iterator is very difficult and it may not be worth the effort to implement when solutions exist that only require inbuilt functions.
  <br>
  
### 5.2.4 List

**Implementation:**

The function List does not take in any additional inputs, in order to show the user a list of current Patient objects in the database. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a PatientList Command object is created. PatientList command object will be executed to iterate through the list of Patient Objects. Patient Objects will then be displayed based on the user given input.

Invalid Input includes:

>
	- Any input apart from Blank Input or a single delimiting slash.

**Format**
`list`

**Check validity of the data input**

1. If the command recognised is the list command, `patientParse()` calls `checker.checkLength()` to ensure data entered is valid.

**Creating PatientList command**

2. If the input data is valid, a PatientList Command object is created
3. The PatientList Command object is returned to `PatientInstance.run()`

**Viewing Patient Objects**

4. PatientInstance then executes the PatientList Command object to begin the process of displaying all Patient objects.
5. `PatientList.execute()` will call the function `PatientList.listPatients()`
6. `PatientList.listPatients()` will iterate through the objects in ArrayList<Patient> PatientList.
7. Patient Objects will be displayed.
8. Control is then returned to PatientInstance.

**Design Considerations**

Using pretty print to display the listed objects:

Option 1 (Final choice): Using pretty print
* Pros: Visually appealing and neatly puts patients in rows with columns to display attributes. Better for larger lists.
* Cons: Harder to implement and sometimes causes visual errors when the names or display text become too large.

Option 2 : Printing the patients in blocks with no common rows or columns.
* Pros: Easy to implement and may be easier to show a single patient.
* Cons: Very difficult to view when the list of patients became increasingly large.
  <br>

### 5.2.5 Find

**Implementation:**

The function Find takes in 1 compulsory field (keyword) to find the relvant Patient Objects within the list of Patient Objects. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. The given input is used to match with every single field of the Patient Object. If there is a match, the Patient Object will be displayed. Else, an error message will be displayed.

Invalid Input includes:

>
	- Blank input (i.e Empty inputs)
	- Illegal Characters
	- Inputs that only consist of spaces

**Format**
`find/[keyword]`

<img src="diagrams/PatientFindSD.png">

**sub-diagram to show the ref**

<img src="diagrams/PatientFindParseSD.png">

**Check validity of the data input**

1. If the command recognised is the find command, `patientParse()` calls `checker.checkFind()` to ensure data entered is valid.
2. `checkFind()` will call the following methods in sequence:

	- emptySpaceCheck();
		- checkLength();
		- illegalCharacterChecker();

**Creating PatientFind command**

3. If the input data exist, a PatientFind Command object is created
4. The PatientFind Command object is returned to `PatientInstance.run()`

**Finding relevant Patient Objects**

5. PatientInstance then executes the PatientFind Command object to begin the process of finding and displaying relevant Patient objects.
6. `PatientFind.execute()` will call the function `PatientList.findPatient()`
7. `PatientList.findPatient()` will iterate through the objects in ArrayList<Patient> PatientList.
8. `PatientList.findPatient()` will compare the the patient details of every Patient Object in the current list of Patient Objects with the keywork inputted by the user and discover any matches.
9. The relevant Patient Objects are then displayed.
10. Control is then returned to PatientInstance.

**Design Considerations**

Allowing `find` function to accept case-insensitive inputs:

Option 1 (Final choice): Allowing case-insensitive inputs.
* Pros: Provides the user with greater flexibility when querying the list for specific data.
* Cons: Harder to implement and may result in unwanted data being shown.

Option 2 : Only allowing case-sensitive inputs.
* Pros: Easy to implement and can be more specific.
* Cons: Harder to consistently type and very punishing for users who don't know if what they are searching for has capital letters.
  <br>

###  5.3 Doctor Appointment

### 5.3.1 Doctor Appointment Menu

Similar to the Start Menu, the Doctor Appointment Menu will repeatedly request user input until the `return` command is given.

Whenever a user input is given to the Doctor Appointment Menu, the following steps will occur.

**Launching Doctor Appointment Menu**

1. `ToDoctorAppointmentInstance.execute()` will be created and call upon `DoctorAppointmentInstance.run()`.
2. `DoctorAppointmentInstance.run()` will start by loading/creating the DoctorAppointment data .txt file for database records. It will check for any signs of corrupted file when loading. Exception will be thrown if any corruption occurs.
3. `DoctorAppointmentInstance.run()` will then repeatedly call `DoctorAppointmentParser.parse()`.

**Getting User Input**

4. `DoctorAppointmentInstance.run()` will repeatedly request for user input and call `DoctorAppointmentParser.parse()`.
5. `parse()` will call the `smartCommandRecognition()` to assess the given user input and determine which command is most similar to the input.
6. Based on the recognised command by the system, the relevant commands will be carried out.

<br>

### 5.3.2 Add

**Implementation:**

The function Add takes in 5 compulsory fields (Doctor ID, Appointment ID, Patient's Name, Gender, Date) to create the DoctorAppointment Object to be added. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. A DoctorAppointmentAdd Command object is created and executed to create the DoctorAppointment Object to be added.

Invalid Input includes:

> 
	- Invalid Doctor ID format
	- Non-existent Doctor ID 
	- Invalid Appointment ID format
	- Duplicated Appointment ID
	- Illegal Characters for Names
	- Invalid Gender format
	- Invalid Date format
	- Blank input (i.e Empty inputs)

`add/[Doctor ID]/[Appointment ID]/[Patient's Name]/[Gender]/[Date]`

<img src="diagrams/DG DoctorAppSequencePlantLatest.png">


**Check validity of the data input**

1. If the command recognised is the add command, `DoctorAppointmentParser.parse()` calls `MainChecker.checkNumInput()` and `DoctorAppointmentChecker.checkValidDataForAdd()` to ensure data entered is valid.
2. `checkValidDataForAdd()` will call the following function in sequence:

	- checkDoctorIDFormat()
	- isValidDocId()
	- checkAptIdFormat()	
	- isValidAppointmentID()
	- illegalCharacterChecker()
	- isValidGender()
	- checkValidDate(); 

**Creating DoctorAppointmentAdd command**

3. If the input data is valid, a DoctorAppointment Command object is created. Otherwise a relevant error will be thrown.
4. The Command object is returned to `DoctorAppointmentInstance.run()`

**Creating DoctorAppointment Object with User Input**

5. DoctorAppointmentInstance then executes the DoctorAppointment Add Command object by running `DoctorAppointmentAddCommand.execute()`.
6. `AppointmentList.addAppointment()` will be called in which a DoctorAppointment object will be created and added into the ArrayList<DoctorAppointment> appointmentList, which contains all the DoctorAppointment Objects. 

**Saving DoctorAppointment Objects into .txt file**

7. `AppointmentList.addAppointment()` then calls `DoctorAppointmentStorage.writeToFile()` which all existing DoctorAppointment Objects within the appointmentList is written into a DoctorAppointment.txt file.
8. `staffStorage.writeToFile()` then calls `createFile()` which ensures that the specified .txt file exists.
9. Control is then returned to DoctorAppointmentInstance.

<br>

### 5.3.3 Delete

**Implementation:**

The delete function takes in 1 compulsory field (Doctor ID/ Appointment ID) to identity and delete the corresponding DoctorAppointment Object from ArrayList <DoctorAppointment> appointmentList . Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a DoctorAppointmentDelete Command object is created and executed in which the program will iterate through appointmentList. If the desired DoctorID or Appointment ID exists, it will be removed. Else an error message will be displayed.

Invalid Input includes:

> 
	- Invalid Doctor ID format
	- Non-existent Doctor ID
	- Invalid Appointment ID format
	- Non-existent Appointment ID
	- Blank input (i.e Empty inputs)

`delete/[Doctor ID/ Appointment ID]`


**Check validity of the data input**

1. If the command is recognised as the delete command, `DoctorAppointmentParser.parse()` calls `MainChecker.checkNumInput()` and `DoctorAppointmentChecker.checkValidDataForDelete()` to ensure that the inputs are valid.

2. `checkValidDataForDelete()` will call the following function in sequence:

	- checkIdDuringParse()
	- isValidIdToDelete()

**Creating DoctorAppointmentDelete command**

3. A DoctorAppointmentDelete Command object is created if the inputs are valid. 
4. The Command object is returned to `DoctorAppointmentInstance.run()`.

**Deleting DoctorAppointment Object using User Input**

5. DoctorAppointmentInstance then executes the DoctorAppointmentDelete Command object by running `DoctorAppointmentDeleteCommand.execute()`.
6. `AppointmentList.deleteAppointment()` is called, which iterates through the objects in ArrayList<DoctorAppointment> appointmentList. The DoctorAppointment Object matching the input given by the user will be removed from the array list.

**Saving changed DoctorAppointment Objects into .txt file**

7. `AppointmentList.deleteAppointment()` then calls `DoctorAppointmentStorage.writeToFile()` which rewrites the updated appointmentList into the DoctorAppointment.txt file.
8. Control is then returned to DoctorAppointmentInstance.

<br>

### 5.3.4 List all

**Implementation:**

The function lists all Doctor Appointment Objects currently in ArrayList <DoctorAppointment> appointmentList. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a DoctorAppointmentList Command object is created and executed in which the program will iterate and display all DoctorAppoinment Objects currently within the array list.

Invalid Input includes:

> 
	- Any input apart from Blank Input (i.e Empty input) OR "all" OR "Appointment ID" OR "Doctor ID" 

`list/all`

**Check validity of the data input**

1. If the command recognised is the list command, `DoctorAppointmentParser.parse()` calls `MainChecker.checkNumInput()` and `DoctorAppointmentChecker.checkValidDataForList()` to check and verify the validity of inputs accompanied by the list command, if any.

2. `checkValidDataForList()` will call the following function in sequence:

	- checkIdDuringParse()
	- isValidDocId()
	- isValidListAppointmentID()
	
**Creating DoctorAppointmentList command**

3. A DoctorAppointmentList Command object is created if the inputs are valid.
4. The Command object is returned to `DoctorAppointmentInstance.run()`.

**Viewing DoctorAppointment Objects**

5. DoctorAppointmentInstance then executes the DoctorAppointmentList Command object by running `DoctorAppointmentListCommand.execute()`.
6. `AppointmentList.listAppointment()` is called, and will iterate through the objects in ArrayList<DoctorAppointment> appointmentList.
7. All DoctorAppointment Objects in the array list will be displayed.
8. Control is then returned to DoctorAppointmentInstance.

<br>

### 5.3.5 List by Doctor ID or Appointment ID

**Implementation:**

The function list takes in 1 compulsory field (keyword) to list the relevant DoctorAppoitment Objects currently in ArrayList <DoctorAppointment> appointmentList.Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a DoctorAppointmentList Command object is created and executed in which the program will iterate and display the DoctorAppoinment Objects matching the user input currently within the array list.
Invalid Input includes:

> 
	- Any input apart from Blank Input (i.e Empty input) OR "all" OR "Appointment ID" OR "Doctor ID" 

`list/[Doctor ID/ Appointment ID]`

**Check validity of the data input**

1. If the command recognised is the list command, `DoctorAppointmentParser.parse()` calls `MainChecker.checkNumInput()` and `DoctorAppointmentChecker.checkValidDataForList()` to check and verify the validity of inputs accompanied by the list command, if any.

**Creating DoctorAppointmentList command**

2. A DoctorAppointmentList Command object is created if the inputs are valid.
3. The Command object is returned to `DoctorAppointmentInstance.run()`.

**Viewing DoctorAppointment Objects**

4. DoctorAppointmentInstance then executes the DoctorAppointmentList Command object by running `DoctorAppointmentListCommand.execute()`.
5. `AppointmentList.listAppointment()` is called, and will iterate through the objects in ArrayList<DoctorAppointment> appointmentList.
6. DoctorAppointment Objects matching the user input present in the array list will be displayed.
7. Control is then returned to DoctorAppointmentInstance.

<br>

###  5.4 Nurse Schedule

### 5.4.1 Nurse Schedule Menu

Similar to the start menu, the Nurse Schedule menu will repeatedly request user input until the `return` command is given.

Whenever a user input is given to the Nurse Schedule Menu, the following steps will occur

**Launching Nurse Schedule Menu**

1. `ToNurseScheduleInstance.execute()` will create and call `NurseScheduleInstance.runCommandLoopUntilExit()`.

2. `runCommandLoopUntilExit()` will start by loading/creating the NurseSchedule.txt for database records. It will check for any signs of file corruption when loading. An exception will be thrown if any corruption is present.

3. `runCommandLoopUntilExit()` will then repeatedly call nurseParse().

**Getting User Input**

4. User inputs are repeatedly requested by `runCommandLoopUntilExit`.

5. `nurseParse()` will call `smartCommandRecognition` to assess the given user input and determine which command is the most similar to the input.

6. Based on the recognised command, the relevant execution will be carried out.

### 5.4.2 Add

**Implementation**

The function Add takes in 3 compulsory fields (Nurse ID, Patient ID, Date) to create a new Nurse Schedule object to be added. The Nurse ID, Patient ID and Date inputs will be first checked to ensure validty. Any invalid input detected will result in an Exception thrown and command will be aborted. Else, a NurseScheduleAddCommand object is created and executed which will create a NurseSchedule object to be added.

Invalid Inputs include:

>
	- Invalid Nurse ID or Patient ID format
	- Non-existent Nurse ID or Patient ID
	- Blank input
	- Illegal Characters
	- Illegal date format
	- Duplicate schedules (i.e similar Patient ID and date)
	
**Format**: `add/[Nurse ID]/[Date (DDMMYYYY)]`

**Checking validity of data input**

1. If the command recognised is the add command, the parameters will first be checked for their validity. The following functios will be called in sequence:
	- isValidDate()
	- checkNumInput()
	- illegalCharacterChecker()
	
**Creating NurseScheduleAddCommand object with User Input**

2. If the parameters are valid, a NurseScheduleAddCommand object is created, which will be passed back to `NurseScheduleInstance.runCommandLoopUntilExit()`.

3. The Command objected is then executed and `NurseScheduleList.addSchedule()` will be called which creates a NurseSchedule object an adds it into the array list.

**Saving NurseSchedule objects into .txt file**

4. The command loop then calls `NurseScheduleStorage.writeToFile()` which starts the process of writing detials of all existing Nurse Schedule objects within the Arraylist into a specific .txt file.

5. Control is then returned to NurseScheduleInstance.


### 5.4.3 Delete

**Implementation**

The delete function takes in 2 compulsory field (Nurse ID, Date) to identify and delete the Nurse Schedule object from the arraylist of Nurse Schedule objects. The Nurse ID and date will first be checked for its validity. Any invalid input detected will result in an exception thrown and command will be aborted. Else, a NurseScheduleDeleteCommand object is created and executed.

Invalid Inputs include:

>
	- Invalid Nurse ID format
	- Non-existent Nurse ID
	- Blank input
	- Illegal Characters
	- Illegal date format
	
**Format**: `delete/[Nurse ID]/[Date (DDMMYYYY)]`

**Checking validity of data input**

1. If the command is recognised as a delete command, the parameters provided will first be checked for its validity.

**Creating NurseScheduleDeleteCommand object**

2. If the parameters are valid, a NurseScheduleDeleteCommand object is created, which will be passed back to `NurseScheduleInstance.runCommandLoopUntilExit()`.

3. `NurseScheduleDelete.execute()` will call the function `NurseScheduleList.deleteSchedule()`.

4. `deleteSchedule` iterates through the arraylist and removes the first object that matches the user input given.

**Saving updated NurseSchedule objects into .txt file**

5. `runCommandLoopUntilExit()` will then call `NurseScheduleStorage.writeToFile()` which starts the process of writing detials of all existing Nurse Schedule objects within the Arraylist into a specific .txt file.

6. Control is then returned to NurseScheduleInstance.

### 5.4.4 List all

**Implementation**

This function lists all Nurse Schedule objects, sorted by earliest added Nurse ID, then sorted by earliest date. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a NurseScheduleListCommand object is created. NurseScheduleListCommand object will be executed to iterate through the arraylist of Nurse Schedule objects. Nurse Schedule Objects will then be displayed.

Invalid Inputs include:

>
	- Any input apart from "all" OR "NurseID"

**Format**: `list/all`

<img src="diagrams/NurseScheduleListSD.png">

**Checking validity of data input**

1. If the command recognised is the list command, the number of fields in inputs will first be checked.

**Creating NurseScheduleListCommand object**

2. If the input is valid, a NurseScheduleListCommand object is created.

3. The NurseScheduleListCommand object is returned to `NurseScheduleInstance.runCommandLoopUntilExit()`.

**Viewing Nurse Schedule objects**

4. NurseScheduleInstance then executes the NurseScheduleListCommand object to begin the process of displaying Nurse Schedule objects.

5. `NurseScheduleListCommand.execute()` will call the function `NurseScheduleList.listSchedules()` which calls `listAllSchedules()`.

6. `listAllSchedules()` iterates through the arraylist of Nurse Schedule objects, printing all schedules.


### 5.4.5 List by Nurse ID

**Implementation**

This function lists specified Nurse Schedule objects, sorted by earliest date. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a NurseScheduleListCommand object is created. NurseScheduleListCommand object will be executed to iterate through the arraylist of Nurse Schedule objects. Nurse Schedule objects will then be displayed.

Invalid Inputs include:

>
	- Any input apart from "all" OR "NurseID"

**Format**: `list/[Nurse ID]`

**Checking validity of data input**

1. If the command recognised is the list command, the number of fields in inputs will first be checked.

**Creating NurseScheduleListCommand object**

2. If the input is valid, a NurseScheduleListCommand object is created.

3. The NurseScheduleListCommand object is returned to `NurseScheduleInstance.runCommandLoopUntilExit()`.

**Viewing Nurse Schedule objects**

4. NurseScheduleInstance then executes the NurseScheduleListCommand object to begin the process of displaying Nurse Schedule objects.

5. `NurseScheduleListCommand.execute()` will call the function `NurseScheduleList.listSchedules()` which calls `getSchedulesByID`.

6. `getSchedulesByID` iterates through the arraylist of Nurse Schedule objects, printing schedules of the relevant Nurse ID.

<br>

###  5.5 Inventory
###  5.5.1 Inventory Menu

Similar to the Start Menu, the Inventory Menu will repeatedly request user input until the `return` command is given.

Whenever a user input is given to the Inventory Menu, the following steps will occur.

**Launching Inventory Menu**

1. `ToInventoryInstance.execute()` will create and call `InventoryInstance.run()`
2. `InventoryInstance.run()` will start by loading/creating the Inventory data .txt file for Inventory database records. It will check for any signs of corrupted file when loading. Exception will be thrown if any corruption occurs.
3. `InventoryInstance.run()` will then repeatedly call `InventoryParser()`.

**Getting User Input**

4. `InventoryInstance.run()` will repeatedly request for user input and call `InventoryParser.inventoryParse()`.
5. `inventoryParse()` will call the `smartCommandRecognition()` to assess the given user input and determine which command is most similar to the input
6. Based on the recognised command by the system, the relevant commands will be carried out.

<br>

### 5.5.2 Add

**Implementation:**

The function Add takes in 3 compulsory fields (Item Name, Price, Quantity) to create the Inventory Object to be added.  Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. A InventoryAdd Command object is created. InventoryAdd command object will be executed to create the Inventory Object to be added.

Invalid Input includes:

> 
	- Invalid Price 
	- Invalid Quantity
	- Blank input (i.e Empty inputs)
	- Illegal Characters

`add/[Item Name]/[Price]/[Quantity]`

**Check validity of the data input**

1. If the command recognised is the add command, `InventoryParser.parse()` calls `InventoryChecker.checkAdd()`, `MainChecker.checkNumInput()`, and `MainChecker.checkBlankInput()` to ensure data entered is valid
2. `checkAdd()` will call the following function in sequence:

	- emptySpaceCheck()	
	- checkStorageLength()
	- illegalCharacterChecker()
	- checkPrice()
	- checkQuantity()
	- checkDuplicate()

**Creating InventoryAdd command**

3. If the input data is valid, a InventoryAdd Command object is created. Otherwise a relevant error is thrown.
4. The InventoryAdd Command object is returned to `InventoryInstance.run()`

**Creating Inventory Object with User Input**

5. InventoryInstance then executes the InventoryAdd Command object by running `InventoryAdd.execute()`.

6. `InventoryList.addItems()` will be called in which a Inventory object will be created and added into the ArrayList<Inventory> inventoryList which contains all the Inventory Objects. 

7. If the list already contains data with the same Item Name and Price, the Quantity of the Item will be increased in the list by the value in the user input Quantity field. `InventoryList.addItems()` will call `Inventory.addQuantity`. This will modify the Quantity of that specified Item.
 
**Saving Inventory Objects into .txt file**

7. `InventoryInstance` then calls `InventoryStorage.storeInventory()` which starts the process of writing the details of all existing Inventory Objects, within the InventoryList into a specified .txt file.
8. `InventoryStorage.writeToFile()` then calls `fileInit()` which ensures that the specified .txt file exists.
9. Data is written and saved.
10. Control is then returned to InventoryInstance.

<br>

### 5.5.3 Delete

**Implementation:**

The function Delete takes in 2 compulsory field (Item Name, Quantity) to identify and decrease the Quantity of the Inventory Object from ArrayList<Inventory> list. Data input is first checked to ensure validity. Any invalid input detected will result in an Exception thrown and command aborted. After validation, a InventoryDelete Command object is created. InventoryDelete command object will be executed to iterate through the ArrayList<Inventory> InventoryList. If Inventory Object exists, its Quantity will be decreased by the Quantity indicated in the user input. Else an error message will be displayed.

Invalid Input includes:

> 
	- Invalid Quantity
	- Invalid Name
	- Blank input (i.e Empty inputs)
	- Illegal Characters

`delete/Item Name/Quantity`

<img src="images/deleteSequenceDiagram.png">

**Check validity of the data input**

1. If the command recognised is the delete command, `InventoryParser.parse()` calls `InventoryChecker.checkDelete()`, `MainChecker.checkNumInput()`, and `MainChecker.checkBlankInput()` to ensure that there are valid and sufficient inputs

**Creating StaffDelete command**

2. If the input data is valid, a InventoryDelete Command object is created 
3. The Command object is returned to `InventoryInstance.run()`

**Deleting Quantity from a Inventory Object using User Input**

4. InventoryInstance then executes the InventoryDelete Command object to begin the process of deleting the referenced Quantitiy of the Inventory object
5. `InventoryList.deleteItems()` is called, which iterate through the objects in ArrayList<Inventory> InventoryList. The Inventory Object referenced by the input given by the user, will have its Quanitity reduced by the Quantity indicated in the user input.

**Saving changed Inventory Objects into .txt file**

7. `InventoryInstance` then calls `InventoryStorage.storeInventory()` which starts the process of writing the details of all existing Inventory Objects, within the InventoryList into a specified .txt file.
8. `InventoryStorage.writeToFile()` then calls `fileInit()` which ensures that the specified .txt file exists.
9. Data is written and saved.
10. Control is then returned to InventoryInstance.

<br>

### 5.5.4 List

**Implementation:**

This function lists all the Inventories currently in the ArrayList<Inventory> InventoryList. A InventoryList Command object is created. InventoryList command object will be executed to iterate through the list of Inventory Objects. Inventory Objects will then be displayed based on the user given input.

**Check validity of the data input**

1. If the command recognised is the list command, `InventoryParser.parse()` calls `MainChecker.checkNumInput()` to check and verify the validity of inputs accompanied by the list command, if any.

**Creating InventoryList command**

2. If the input data is valid, a InventoryList Command object is created 
3. The InventoryList Command object is returned to `InventoryInstance.run()` 

**Viewing Inventory Objects**

4. InventoryInstance then executes the InventoryList Command object to begin the process of displaying all Inventory objects.
5. `InventoryList.execute()` will call `InventoryList.listInventory()` and will iterate through the objects in ArrayList<Inventory> InventoryList.
7. Depending on the input given by the user, the relevant Inventory Objects will be displayed.
8. Control is then returned to InventoryInstance.

<br>

### 5.6 Proposed Features

### 5.6.1 Auto Schedule Generator for Nurses

This feature will be able to generate the daily schedule for individual nurses with the schedules in the database. This will allow nurses to have a clear view of their daily tasks, allowing them to plan their day better. Hence this feature has been proposed as one of the goals of HealthVault is to improve the efficiency of hospital and healthcare information management, something we believe this feature will do.

**Brief Implementation**

1. User specifies which Nurse ID a schedule should be generated for.
2. Program will sort all schedules tied to specified Nurse ID.
3. A schedule will be generated based on the earliest schedule.

### 5.6.2 Personalized Account Login

This feature will allow medical personnel to have a personalized account within HealthVault, enabling them to only access relevant functionalities of the app. By cutting down on the unnecessary information one has to deal with, the team believes this will aid medical personnel working in a high-stress environment.

### 5.6.3 Inventory Alerts

This feature will alert nurses whenever an inventory of a item is low. This ensures that essential items will never be unavailable as nurses will always have up to date information on which specific item needs to be restocked.

**Brief Implementation**

1. User adds a threshold stock quantity for when an alert should be raised.
2. Program checks inventory database everytime inventory is accessed.
3. Alert will be raised, reminding the nurses that the item is low on inventory level.

<br>

## Appendix A: Product Scope

**Target user profile:**
<br>
HealtVault primarily targets nurses. Its features optimize it for users seeking:
* Efficiency in recording down new details relating to critical healthcare services like nurse schedules and doctors appointments.
* A cohesive database that records the critical information of everyone in the hospital, staff and patients included.
* A desktop CLI application that has a minimalistic GUI.

**Value Proposition:**
<br>
With its organized and portable database and its features to improve efficiency,
HealthVault aspires to help its users achieve the following results:
* Improve working speed of healthcare staff, as they can store and retrieve critical information quickly and accurately.
* Minimize administrative errors with its inbuilt cross validation.
* Easy implementation within a hospital environment with minimal setup steps and data reusability.

Every second matters in the healthcare industry when patient lives are at stake. We believe that HealthVault can help
its users save those precious seconds.

<br>

## Appendix B: User Stories

| Priority | As a... |                          I want to...                         |                 So that I can...                 |
|:--------:|:--------:|:-------------------------------------------------------------:|:------------------------------------------------:|
|   * * *  |  nurse  |              quickly refer to usage instructions              |      quickly get on track with the workflow      |
|   * * *  |  nurse  |                    add a new staff/patient                    |     record information of staff and patients     |
|   * * *  |  nurse  |                     delete staff/patients                     |          remove entries i no longer need         |
|   * * *  |  nurse  |                         view all staff                        |       quickly get an overview of staff           |
|   * * *  |  nurse  | quickly add schedules for nurses and appointments for doctors |       reduce the waiting time for patients       |
|   * * *  |  nurse  |     quickly look up schedules for both nurses and doctors     |              plan my schedule better             |
|   * * *  |  nurse  |                 delete schedules/appointments                 |        eliminate wasted time and resources       |
|   * * *  |  nurse  |              quickly add/delete inventories                   |           manage our inventories better          |
|   * * *  |  nurse  |                quickly look up inventories                    |  plan what and when to restock our supplies      |
|     *    |  nurse  |       have the program recognize slight errors in typing      | have leeway working in a high-stress environment |
<br>

## Appendix C: Non Functional Requirements

* Should work on any Mainstream OS if it has Java 11 or above installed.

* Database should be able to hold up to 1000 patients, staff, appointments, nurses’ schedules, and inventory without feeling a noticeable lag in the program. 

* A user with above average typing speed should be able to accomplish most of the tasks faster using commands than using the mouse.

* The data retrieval time should return near instant without feeling a pause in between command and output.

* New features for example, auto generation of nurses’ schedules and personalized account login are currently in the works to demonstrate that this program is still being developed to be better and accommodate more of the concerns medical personnel have. 

* Application would be affordable to the general masses.

* The security and accessibility of the system is relatively secure, but authorization and authentication scheme is in consideration to be implemented for greater protection.

* All data process and management is in accordance to Singapore IMDA and MOH policy.

* Healthvault is not accountable for any data lost due to individuals computer failure. 

<br>

## Appendix D: Glossary

* *Illegal Characters* - Non-alphanumeric characters
 
* *Aggregation* - Any collection of objects. In this case, we utilise an ArrayList to store all our objects. 
 
* *Features* - In this case, we refer to the entire interaction with the various types of objects. E.g. any interaction with Staff/Patient/Doctor Appointment/Nurse Schedules/Inventory.
 
* *Functionalities* - Any command that is given to the feature. E.g. `help` command, `list` command.
 
* *Blank Input* - Refers to any whitespace input. E.g. " ", "\t".
 
* *No Input* - Refers to no input given. 

* *Mainstream OS* - Windows/MacOS/Linux

<br>

## Appendix E: Instructions for Manual Testing

Given below are instructions to test HealthVault manually.

* These instructions only provide a starting point for testers to work on; testers are expected to do more *exploratory* testing.
* You can refer to the [User Guide](https://github.com/AY2021S2-CS2113T-F08-2/tp/blob/master/docs/UserGuide.md) for further information regarding the command formats.

### Launching HealthVault

Initial launch of HealthVault
    1. Download the jar file [here](https://github.com/AY2021S2-CS2113T-FO8-2/tp/releases) and copy into an empty folder.
    2. Open up a command window to that folder with the jar file.
    3. Run the command `java -jar tp.jar` 
        
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** HealthVault will be loaded, and a welcome message will be shown. Ensure &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;that the version number in the welcome matches version of the jar file downloaded.

### Start Menu

Choose a directory from the Start Menu

> ℹ️ Ensure that the location that you are trying to access is in the Start Menu or else an error message will pop up.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1. **Test case:** `staff` (where you will be directed to the Staff Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

	
	Welcome to Staff Menu!
	Type "help" for staff menu commands
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2. **Test case:** `patient` (where you will be directed to the Patient Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 
	
	
	Welcome to the patient Commands section!
	Type "help" for patient menu command
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3. **Test case:** `appointments` (where you will be directed to the Appointments' Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	Welcome to the Appointments' Menu!
	Type 'help' for appointment menu commands
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4. **Test case:** `schedules` (where you will be directed to the Schedules' Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 
	
	
	Welcome to Nurse Schedules!
	Type "help" to for nurse schedules commands
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5. **Test case:** `inventory` (where you will be directed to the Inventory Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

	
	Welcome to Inventory Menu!
	Type "help" for Inventory menu commands
	
	

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 6. **Test case:** `help` (where you will be directed to the Help Menu)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	Commands       Description                             Format    
	____________________________________________________________________________________________________
	staff          To go to staff                          -         
	patient        To go to patients                       -         
	appointments   To go to doctors appointments           -         
	schedules      To go to nurse schedules                -         
	inventory      To go to inventory                      -         
	help           To see what commands for Start Menu     -         
	exit           To exit the application                 -         
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 7. **Test case:** `exit` (where you will exit the program)

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Goodbye! Have a nice day!```
	 
<br/><br/>

### Choose which feature you want to use from Staff Menu	 
1. Adding a new staff

>:information_source: Important notes about the input format
>1. Make sure that the inputted user ID starts with a D (for doctor ID) or N (for nurse ID)  and has **exactly** 5 digits in the number following!   
>2. Any input field in HealthVault only accepts space and alphanumeric characters
>3. The age field input should be a positive integer starting from 0 but less than 150
>
>:information_source: Important notes about the input format
>1. Make sure that the inputted user ID starts with a D (for doctor ID) or N (for nurse ID)  and has **exactly** 5 digits in the number following!   
>2. Any input field in HealthVault only accepts space and alphanumeric characters
>3. The age field input should be a positive integer starting from 0 but less than 150
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```add/D12345/MingShun/30/Pediatrician```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Doctor MingShun hired :)```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `add/D1/MingShun/40/Pediatrician`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in Staff ID input
Please input with the following format [D/N][5 digit ID number]
```

<br/>
 
2. Deleting staff

>:information_source: Important notes about the input format
>1. Make sure that the inputted user ID starts with a D (for doctor ID) or N (for nurse ID)  and has **exactly** 5 digits in the number following! 
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```delete/D12345```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```D12345 has been fired :(```

<br/>

3. Listing all doctors and nurses

>:information_source: Important notes about the input format
>1. <> implies that the inputs are optional
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.1 **Test case:** ```list/nurses ```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	ID         | Name       | Age   | Specialisation      
	____________________________________________________________
	N12345     | Sarrah     | 30    | Emergency    
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.2 **Test case:** ```list/doctors ```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	ID         | Name       | Age   | Specialisation      
	____________________________________________________________
	D12345     | MingShun   | 30    | Pediatrician    
	
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.3 **Test case:** ```list ```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
		
	
	ID         | Name       | Age   | Specialisation      
	____________________________________________________________
	N12345     | Sarrah     | 30    | Emergency  
	D12345     | MingShun   | 30    | Pediatrician    
	D12355     | Alex       | 28    | Oncology
			
	
<br/>

4. Finding a staff

>:information_source: Important notes about the input format
>1. Any keyword input will be searched through every field of Staff details. i.e. It can be used to search Staff ID, name, age and specialisation.

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```find/Oncology```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 
	
	
	ID         | Name       | Age   | Specialisation      
	____________________________________________________________
	D12355     | Alex       | 28    | Oncology            

	Staff -->


<br/>

5. Returning to Start Menu

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```return```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Returning to start menu!```

<br/>

6. Directing to help function

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```help```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	Here is a list of Staff commands: 
	
	Commands  Description                                                 Format                                            
	____________________________________________________________________________________________________
	help      Brings up the list of commands for Staff!                   -                                                 
	add       Adds Staff details to the Staff database!                   add/[Staff ID]/[Name]/[Age]/[Specialisation]      
	list      Brings up the list of all current Staff in database!        list/<input>, where input == doctor or nurse      
	delete    Deletes the Staff with the specified ID from the list!      delete/[Staff ID]                                 
	find      Finds a matching Staff using a keyword or phrase!           find/[keyword or phrase]                          
	return    Returns you to the Start Menu!                              -                                 
	

<br/><br/>

### Choose which feature you want to use from Patient Menu	 
1. Adding a new patient

>:information_source: Important notes about the input format
>
>1. Make sure that the inputted user ID starts with a P and has **exactly** 5 digits in the number following! 
>2. Any input field in HealthVault only accepts space and alphanumeric characters
>3. The gender field input should only be "M", "F" or "Others"
>4. The age field input should be a positive integer starting from 0 but less than 150
>
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```add/P55555/Sam/40/M/Fever/Paracetamol```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Sam is now a patient here!```

<br/>
 
2. Deleting a patient

>:information_source: Important notes about the input format
>
>1. Make sure that the inputted user ID starts with a P and has **exactly** 5 digits in the number following! 
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```delete/P55555```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	Noted. I've removed this patient: 
	Sam
	Now you have 0 patients in the list


<br/>

3. Listing all patients

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```list```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	Here are the patients currently in the list!
	ID       | Name                 | Age    | Gender   | Illness              | Medication Required 
	____________________________________________________________________________________________________
	P55555   | Sam                  | 40     | M        | Fever                | Paracetamol    
	P12345   | Amy                  | 35     | F        | Flu                  | Panadol

	
<br/>

4. Finding a patient

>:information_source: Important notes about the input format
>1. Any keyword input will be searched through every field of Patient details. i.e. It can be used to search Patient ID, name, age, illness, medication required.
> The keyword input can be case insensitive and still find matches in the database.
> 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.1 **Test case:** ```find/P55555```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	
	ID       | Name                 | Age    | Gender   | Illness              | Medication Required 
	____________________________________________________________________________________________________
	P55555   | Sam                  | 40     | M        | Fever                | Paracetamol    


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4.2 **Test case:** ```find/Sam```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	

	ID       | Name                 | Age    | Gender   | Illness              | Medication Required 
	____________________________________________________________________________________________________
	P55555   | Sam                  | 40     | M        | Fever                | Paracetamol    
	
<br/>

5. Returning to Start Menu

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```return```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Returning to start menu!```

<br/>

6. Directing to help function

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```help```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 


	Here is a list of Patient commands: 

	Commands  Description                                                 Format                                                                
	__________________________________________________________________________________________________________________________________________
	help      Brings up the list of commands for Patient!                 -                                                                     
	add       Adds Patient details to the Patient database!               add/[Patient ID]/[Name]/[Age]/[Gender]/[Illness]/[Medication Needed]  
	list      Brings up the list of all current Patient in database!      -                                                                     
	delete    Deletes the Patient with the specified ID from the list!    delete/[Patient ID]                                                   
	find      Finds a matching Patient using a keyword or phrase!         find/[keyword or phrase]                                              
	return    Returns you to the Start Menu!                              -                                
	

<br/><br/>

### Choose which feature you want to use from Appointments' Menu

1. Adding a new appointment

>:information_source: Important notes about the input format
>1. Make sure that the inputted doctor/appointment ID starts with a D/A and have **exactly** 5 digits in the number following!  
>2. Any input fields in HealthVault only accepts space and alphanumeric characters.
>3. The gender field input should only be "M", "F".
>4. This function **allows** the adding of past appointments.
     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```add/D12345/A12345/Alex/M/21012021```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Appointment Added```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `add/D3/A12345/Alex/M/21012021`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in Doctor ID input
Please input with the following format [D][5 digit ID number]
```

	
<br/>
 
2. Deleting an appointment

>:information_source: Important notes about the input format
>1. Make sure that the inputted doctor/appointment ID starts with a D/A and have **exactly** 5 digits in the number following! 

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.1 **Positive Test case:** ```delete/D12345```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```DoctorID / Appointment ID: D12345/A12345 has been deleted!```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `delete/D123`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in ID input
Please input with the following format [D/A] followed by [5 digit ID number]
```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2.2 **Positive Test case:** ```delete/A54321```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Appointment ID: A54321 has been deleted!```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `delete/A123`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in ID input
Please input with the following format [D/A] followed by [5 digit ID number]
```

<br/>

3. Listing appointments

>:information_source: Important notes about the input format
>1. Make sure the input `all` is lower caps.
>2. Make sure that the inputted doctor/appointment ID starts with a D/A and have **exactly** 5 digits in the number following! 
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.1 **Positive Test case:** ```list/all```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Doctor ID      | Appointment ID | Name           | Gender         | Date          
	____________________________________________________________
	D11111         | A54321         | Owen           | M              | 01/04/2021
	D12345         | A12345         | Alex           | M              | 21/01/2021  


&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `list/a`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in ID input
Please input with the following format [all/D/A] followed by [5 digit ID number]
```
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.2 **Positive Test case:** ```list/D12345```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Doctor ID      | Appointment ID | Name           | Gender         | Date          
	____________________________________________________________
	D12345         | A12345         | Alex           | M              | 21/01/2021  
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `list/D111`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in ID input
Please input with the following format [all/D/A] followed by [5 digit ID number]
```
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.3 **Positive Test case:** ```list/A12345 ```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Appointment ID | Name           | Gender         | Date          
	____________________________________________________________
	A12345         | Alex           | M              | 21/01/2021  
		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `list/A111`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

``` 
Error in ID input
Please input with the following format [all/D/A] followed by [5 digit ID number]
```
	
<br/>

4. Returning to Start Menu

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```return```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Returning to Start Menu!```

<br/>

5. Directing to help function

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```help```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Here is a list of Doctor Appointments Commands: 
	Commands  Description                                                           Format                                            
	____________________________________________________________________________________________________
	help      Brings up the list of commands for Doctor Appointments!               -                                                 
	add       Adds Doctor Appointment details to the database!                      add/[Doctor ID]/[Appointment ID]/[Name]/[Gender]/[Date (DDMMYYYY)]
	list      Brings up the list of all current Doctors' Appointments in database!  list/[all/DoctorID/AppointmentID]                     
	delete    Deletes the Appointment with the specified ID from the list!          delete/[DoctorID/Appointment ID]                  
	return    Returns you to the Start Menu!                   
	

<br/><br/>


### Choose which feature you want to use from Schedules' Menu	 
1. Adding a new schedule

>:information_source: Important notes about the input format
>1. Make sure Nurse ID exists in Staff and Patient ID exists in Patients before adding.
>2. Make sure that the inputted user ID starts with a N for Nurse, P for Patient and have **exactly** 5 digits in the number following! 
>3. Any input fields in HealthVault only accepts space and alphanumeric characters.
>4. HealhVault currently only allows the adding of **1** schedule per patient per day.
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```add/N12345/P12345/30012020```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Trip to P12345 on 30/01/2020 added!```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `add/N1/P12345/30012020`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

```
OOPS! Looks like your ID value is incorrect! 
Please ensure that the ID includes 5 numbers after "N" or "P" 
eg. N12345 or P67891
```
	
<br/>
 
2. Deleting schedule

>:information_source: Important notes about the input format
>
>1. Make sure that the inputted Nurse ID starts with a N for Nurse, and have **exactly** 5 digits in the number following! 
>2. HealthVault only accepts valid Date inputs.
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```delete/N12345/30012020```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Trip to P12345 on 30/01/2020 has been cancelled!```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `delete/N1/30012020`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** `NurseID does not exist! Please check Staff List and try again!`

<br/>

3. Listing schedules

>:information_source: Important notes about the input format
>
>1. Make sure that the inputted Nurse ID starts with a N for Nurse, and have **exactly** 5 digits in the number following! 
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.1 **Positive Test case:** ```list/N12345 ```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Nurse ID   | Patient ID | Date      
	____________________________________________________________
	N12345     | P12345     | 30/01/2020 
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `list/N1`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** `NurseID does not exist! Please check Staff List and try again!`

<br>
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3.2 **Positive Test case:** ```list/all```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**
	
	Nurse ID   | Patient ID | Date      
	____________________________________________________________
	N12345     | P12345     | 30/01/2020
	N55555     | P55555     | 30/01/2020   
	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** `list`

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

```
OOPS! Please check to see if your command is properly formatted!
Please input with the following format: list/[NurseID/all]
```

<br/>

4. Returning to Start Menu

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```return```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Returning to start menu!```

<br/>

5. Directing to help function

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```help```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** 

	
	Here is a list of Nurse Schedule commands: 
	Commands  Description                                                      Format                                            
	____________________________________________________________________________________________________
	help      Brings up the list of commands for Nurse Schedule!               -                                                 
	add       Adds Nurse Schedule details to the database!                     add/[Nurse ID]/[Patient ID]/[Date (DDMMYYYY)]     
	list      Brings up the list of all current Nurse Schedules in database!   list/[NurseID/all]                                
	delete    Deletes the Schedule with the specified ID from the list!        delete/[Nurse ID]/[Date (DDMMYYYY)]               
	return    Returns you to the Start Menu!                                   -    
	

<br/><br/>

### Choose which feature you want to use from Inventory Menu	 
1. Adding a new item or increasing quantity of current items.

>:information_source: Important notes about the input format
>
>1. Make sure that the inputted price is valid and does not have more than 2 decimal places!   
>2. Any input fields in HealthVault only accepts space and alphanumeric characters!
>3. Avoid using uppercase letters!

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```add/paracetamol/3/90```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```90 paracetamol is added into Inventory!```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** ```add/paracetamol/bc$3*/90```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Please enter a valid price!```

<br/>

2. Decreasing quantity of items.

>:information_source: Important notes about the format
>1. Avoid using uppercase letters
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```delete/paracetamol/20```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Noted. I've removed 20 paracetamol```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** ```delete/paracet/20```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```OOPS! This item does not exist in the Inventory!```

<br/>

3. Listing all items
    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Positive Test case:** ```list```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	ItemName        | Price      | Quantity
	------------------------------------------------------------

	paracetamol     | 3.00       | 70   
	panadol         | 4.80       | 36 
		
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Negative Test case:** ```list/hello/34```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```OOPS! There are too many inputs for this command```

<br/>

4. Returning to Start Menu

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```return```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:** ```Returning to start Menu!```

<br/>

4. Directing to help function

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Test case:** ```help```

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; **Expected:**

	
	Here is a list of Inventory commands: 

	Commands  Description                                                 Format                                            
	____________________________________________________________________________________________________
	help      Brings up the list of commands for Inventory!               -                                                 
	add       Adds Inventory details to the database!                     add/[Item name]/[Price]/[Quantity]                
	list      Brings up the list of all current Inventory in database!    list                                              
	delete    Deletes the Inventory item from the list!                   delete/[Item Name]/[Quantity]                                
	return    Returns you to the Start Menu!                              -            
	

<br/><br/>
