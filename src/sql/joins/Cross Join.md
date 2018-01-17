# Cross Join or Cartesian Product

- This joins "everything to everything" resulting in n x m rows, far more than we have in the original sets.
This is very dangerous to run on large table data.
- This cannot be shown using Venn diagram.

> **We can see this join does not have any on clause.**
>
> select first_name, last_name, order_date, order_amount
    from customers c
    cross join orders o
    
> **If we provide an on clause in this, the result will se same as of inner join.**
>
> select first_name, last_name, order_date, order_amount
  from customers c
  cross join orders o
  on c.customer_id = o.customer_id
    

##### For our example(without on clause) result will be of 30 rows i.e 5(no of records in table A) * 6(no of records in table B) = 30:

first_name | last_name | order_date | order_amount
---------- | --------- | ---------- | ------------
George | Washington | 07/04/1776 | $234.56
John | Adams | 07/04/1776 | $234.56
Thomas | Jefferson | 07/04/1776 | $234.56
James | Madison | 07/04/1776 | $234.56
George | Washington | 03/14/1760 | $78.50
John | Adams | 03/14/1760 | $78.50
Thomas | Jefferson | 03/14/1760 | $78.50
James | Madison | 03/14/1760 | $78.50
George | Washington | 05/23/1784 | $124.00
John | Adams | 05/23/1784 | $124.00
Thomas | Jefferson | 05/23/1784 | $124.00
James | Madison | 05/23/1784 | $124.00
George | Washington | 09/03/1790 | $65.50
John | Adams | 09/03/1790 | $65.50
Thomas | Jefferson | 09/03/1790 | $65.50
James | Madison | 09/03/1790 | $65.50
George | Washington | 07/21/1795 | $25.50
John | Adams | 07/21/1795 | $25.50
Thomas | Jefferson | 07/21/1795 | $25.50
James | Madison | 07/21/1795 | $25.50
George | Washington | 11/27/1787 | $14.40
John | Adams | 11/27/1787 | $14.40
Thomas | Jefferson | 11/27/1787 | $14.40
James | Madison | 11/27/1787 | $14.40
James | Monroe | 07/04/1776 | $234.56
James | Monroe | 03/14/1760 | $78.50
James | Monroe | 05/23/1784 | $124.00
James | Monroe | 09/03/1790 | $65.50
James | Monroe | 07/21/1795 | $25.50
James | Monroe | 11/27/1787 | $14.40