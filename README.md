[![Build Status](https://travis-ci.org/mvpotter/currency-fair.svg?branch=master)](https://travis-ci.org/mvpotter/currency-fair)

# CurrencyFair Engineering Test

[Task description](https://github.com/mvpotter/currency-fair/blob/master/Task.md)

### Information for reviewer 

- Consumer endpoint has basic authentication: user = currency, password = fair
- Rate limiting is implemented: by default the limit is 300 rps for POST requests (could be changed in application.yml, currency-fair-rest module)

### About

Simple web application for processing currency trading data. It consists of 3 main components:

1. **Consumer** is resposible for storing data posted to REST API endpoit.  For simplicity, data is stored directly to PostgreSQL database. Moreover, **consumer** has rate limit of 300 rps for POST requests. 
2. The main goal of **processor** is retreiving consumed data and pass it to a **view module**. In the current implementation the **processor** just retrieves a page of 100 trades ordered by date and pass them for further displaying without any processing.
3. **View module** retrieves trade data from REST API endpoint and displays it in a table.
