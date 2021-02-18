Hotel

The client registers in the system and makes an Application, which indicates the number of seats, class of apartments and time of stay.
Similarly, the customer can select a number from the list of available numbers and book it.

An unregistered user cannot leave a request or book a room.

To list numbers, sort:
- by price;
- by number of seats;
- by class;
- by status (free, booked, busy, unavailable).
  The manager reviews the received applications, selects the most favorite of the available ones
  numbers and sends a request to the customer to confirm the reservation. The request is displayed in
  personal account of the user. Once the room is booked, the system exhibits
  customer Invoice to be paid within two days. If the bill is not paid,
  the reservation is automatically removed.

Job Position	Student  
Project Roles	Architect, developer and tester
Customer	External Java Course  
Project	- User can register in the system and make an Application, which indicates the number of seats, class of apartment and time of stay. Similarly, the customer can select a number from the list of available numbers and book it.

- Administrator can view the received applications, select the most favorite of the available numbers and send a request to the customer to confirm the reservation. The request is displayed in the user's personal account. After the room is booked, the system issues an invoice to the customer, which must be paid within two days. If the bill is not paid, the reservation is automatically withdrawn.

- Unregistered user cannot leave a request or book a room.
  Participation
  • database design and creation;

  • a service layer for work with DB is written using a JDBC API;

  • authorization and separation of access for links depending on the role;

  • processing requests (by Servlet) on the backend (Java);

  • displaying response (by views) on the frontend (HTML, JSTL);

  • localization is done only on views (by i18n):

  Team	This projects was single, team consist of only one member - me

  Database	MySql database('hotle')consist of fout tables;

  • 'user' table that stores all user and administrator data;

  • 'request' table in which booking requests are stored;
  • 'bookings' i stored confirmed and unconfirmed reservations;

  • 'room' it stored data on apartments, their status, cost, etc.

  Tools	Apache Tomcat,Intelij IDEA,Maven

  Technologies	Java 11, Collections, JDBC API, JSP, Hibernate Validator,Java Servlet API