# SQL Joins


At the top level there are mainly 3 types of joins:

- Inner Join
- Outer Join
- Cross Join

1. **Inner Join** : Fetches data only if present in both tables
2. **Outer Join** : are of 3 types
    
    - Left Outer Join or Left Join
    - Right Outer Join or Right Join
    - Full Outer Join or Full Join
    
3. **Cross Join** : as the name suggests, does [n X m] that joins everything to everything.
                    Similar to scenario where we simply lists the tables for joining (in the FROM clause of the SELECT statement), using commas to separate them.




##


### Table structure for our examples :

 | customer_id | first_name | last_name | email | address | city | state | zipcode | 
 | ----------- | ---------- | --------- | ----- | ------- | ---- | ----- | ------- |
 | 1 | George | Washington | gwashington@usa.gov | 3200 Mt Vernon Hwy | Mount Vernon | VA | 22121 |
 | 2 | John | Adams | jadams@usa.gov | 1250 Hancock St | Quincy | MA | 02169 |
 | 3 | Thomas | Jefferson | tjefferson@usa.gov | 931 Thomas Jefferson Pkwy | Charlottesville | VA | 22902 |
 | 4 | James | Madison | jmadison@usa.gov | 11350 Constitution Hwy | Orange | VA | 22960 |
 | 5 | James | Monroe | jmonroe@usa.gov | 2050 James Monroe Parkway | Charlottesville | VA | 22902|
 
 
 
 order_id | order_date | amount | customer_id
 -------- | ---------- | ------ | -----------
 1 | 07/04/1776 | $234.56 | 1
 2 | 03/14/1760 | $78.50 | 3
 3 | 05/23/1784 | $124.00 | 2
 4 | 09/03/1790 | $65.50 | 3
 5 | 07/21/1795 | $25.50 | 10
 6 | 11/27/1787 | $14.40 | 9
 
 
 
> DDL & DML for table data use [SQL Fiddle](http://sqlfiddle.com):
>
>  create table customers(
   customer_id int,
   first_name varchar (255),
   last_name  varchar (255),
   email varchar (255),
   address varchar (255),
   city varchar (255),
   state varchar (255),
   zipcode varchar (255)
  );
>    
>  create table orders(
   order_id int,
   order_date varchar (255),
   order_amount varchar (255),
   customer_id int
  );
>  
>  
>  Insert into customers values(1,"George","Washington","gwashington@usa.gov","3200 Mt Vernon Hwy","Mount Vernon","VA","22121"),(2,"John","Adams","jadams@usa.gov","1250 Hancock St","Quincy","MA","02169"),(3,"Thomas","Jefferson","tjefferson@usa.gov","931 Thomas Jefferson Pkwy","Charlottesville","VA","22902"),(4,"James","Madison","jmadison@usa.gov","11350 Constitution Hwy","Orange","VA","22960"),(5,"James","Monroe","jmonroe@usa.gov","2050 James Monroe Parkway","Charlottesville","VA","22902");
>   
>   
>  Insert into orders values(1,"07/04/1776","$234.56",1),(2,"03/14/1760","$78.50",3),(3,"05/23/1784","$124.00",2),(4,"09/03/1790","$65.50",3),(5,"07/21/1795","$25.50",10),(6,"11/27/1787","$14.40",9);