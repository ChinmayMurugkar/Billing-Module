# Billing-Module

Please read the below description and provide a solution in Java or Groovy.
Please try to approach this as you would a real assignment at a real job.
We'll evaluate the general structure of your code, your approach to testing and the correctness of your results.


A company sells services with recurring monthly charges.
Customers are charged in advance for each month's service. 
Each customer has a set day of the month when their recurring charges are due. This can be any number from 1 to 31.
A bill cycle is from billing day to billing day minus 1
If an customer's billing day falls on a date that does not exist in a month, then the account is billed on the last day of the month.
If a customer purchases new service, a pro-rated amount is charged for the remaining days in the current bill cycle, including the day on which the service was purchased.
Proration is done by day (not by minute, second, week, etc). 
The result must be rounded to the nearest penny.

Code a solution to calculate a pro-rated fee given the following parameters:
Base fee
Bill cycle day
Date of purchase

Include JUnits that verify correct proration is calculated in all cases.
